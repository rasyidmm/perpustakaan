package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Rak_buku;
import com.example.perpustakaan.service.Rak_bukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
@Controller
public class RakBukuController {
    @Autowired
    Rak_bukuService rak_bukuService;
    @RequestMapping(value = "/rakbuku")
    public ModelAndView masterrakbuku(){
        return new ModelAndView("bukuview/HalamanPenerbit","listpenerbit",rak_bukuService.getAllRak_buku());
    }
    @RequestMapping(value = "/tambahrakbuku")
    public String formrakbuku(){
        return "bukuview/HalamanFormPenerbit";
    }
    @RequestMapping(value = "/tambahpenerbit",method = RequestMethod.POST)
    public String tambahrakbuku(@ModelAttribute("rakbuku")Rak_buku rakbuku){
        rakbuku.setCreateDate(new Date());
        rak_bukuService.SaveOrUpdate(rakbuku);
        return "redirect:penerbit";
    }
    @RequestMapping(value = "/updatepenerbit",method = RequestMethod.GET)
    public ModelAndView updaterakbuku(@RequestParam("id")long id){
        return new ModelAndView("bukuview/HalamanUpdatePenerbit","penerbit",rak_bukuService.getById(id));
    }
    @RequestMapping(value = "/hapuspenerbit")
    public String deleterakbuku(@RequestParam("id")long id){
        rak_bukuService.deleteRak_buku(id);
        return "redirect:penerbit";
    }
}
