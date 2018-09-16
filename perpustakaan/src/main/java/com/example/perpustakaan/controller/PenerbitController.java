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
        return new ModelAndView("penerbitview/HalamanPenerbit","listpenerbit",penerbitService.getAllPenerbit());
    }
    @RequestMapping(value = "/tambahpenerbit")
    public String formpenerbit(){
        return "penerbitview/HalamanPenerbitForm";
    }
    @RequestMapping(value = "/tambahpenerbit",method = RequestMethod.POST)
    public String tambahpenerbit(@ModelAttribute("Penerbit")Penerbit penerbit){
        penerbit.setCreateDate(new Date());
        penerbit.setStatus("Active");
        penerbitService.SaveOrUpdate(penerbit);
        return "redirect:penerbit";
    }
    @RequestMapping(value = "/updatepenerbit",method = RequestMethod.GET)
    public ModelAndView updatePenerbit(@RequestParam("id")long id){
        return new ModelAndView("penerbitview/HalamanPenerbitUpdate","penerbit",penerbitService.getById(id));
    }
    @RequestMapping(value = "/updatepenerbit",method = RequestMethod.POST)
    public String updatepenerbit(@ModelAttribute("Penerbit")Penerbit penerbit){
        penerbit.setUpdateDate(new Date());
        penerbit.setStatus("Active");
        penerbitService.SaveOrUpdate(penerbit);
        return "redirect:penerbit";
    }
    @RequestMapping(value = "/hapuspenerbit")
    public String deletepenerbit(@RequestParam("id")long id){
        penerbitService.deletePenerbit(id);
        return "redirect:penerbit";
    }
    @RequestMapping(value = "/hapuspenerbitnon")
    public String deletepenerbitnon(@RequestParam("id")long id){
        Penerbit penerbit = penerbitService.getById(id);
        penerbit.setStatus("Disable");
        penerbitService.SaveOrUpdate(penerbit);
        return "redirect:penerbit";
    }
}
