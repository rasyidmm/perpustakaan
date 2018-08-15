package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Penerbit;
import com.example.perpustakaan.service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class PenerbitController {
    @Autowired
    PenerbitService penerbitService;
    @RequestMapping(value = "/penerbit")
    public ModelAndView masterPenernit(){
        return new ModelAndView("bukuview/HalamanPenerbit","listpenerbit",penerbitService.getAllPenerbit());
    }
    @RequestMapping(value = "/tambahpenerbit")
    public String formpenerbit(){
        return "bukuview/HalamanFormPenerbit";
    }
    @RequestMapping(value = "/tambahpenerbit",method = RequestMethod.POST)
    public String tambahpenerbit(@ModelAttribute("Penerbit")Penerbit penerbit){
        penerbit.setCreateDate(new Date());
        penerbitService.SaveOrUpdate(penerbit);
        return "redirect:penerbit";
    }
    @RequestMapping(value = "/updatepenerbit",method = RequestMethod.GET)
    public ModelAndView updatePenerbit(@RequestParam("id")long id){
        return new ModelAndView("bukuview/HalamanUpdatePenerbit","penerbit",penerbitService.getById(id));
    }
    @RequestMapping(value = "/hapuspenerbit")
    public String deletepenerbit(@RequestParam("id")long id){
        penerbitService.deletePenerbit(id);
        return "redirect:penerbit";
    }
}
