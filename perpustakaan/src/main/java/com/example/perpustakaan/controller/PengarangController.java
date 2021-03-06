package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
@Controller
public class PengarangController {
    @Autowired
    PengarangService pengarangService;
    @RequestMapping("/pengarang")
    public ModelAndView masterPengarang(){
        return new ModelAndView("pengarangview/HalamanPengarang","listpengara",pengarangService.getAllPengarang());
    }
    @RequestMapping(value = "/tambahpengarang")
    public String formpengarang(){
        return "pengarangview/HalamanPengarangForm";
    }
    @RequestMapping(value = "/tambahpengarang",method = RequestMethod.POST)
    public String tambahPengarang(@ModelAttribute("Pengarang")Pengarang pengarang){
        pengarang.setCreateDate(new Date());
        pengarang.setStatus("Active");
        pengarangService.SaveOrUpdate(pengarang);
        return "redirect:pengarang";
    }
    @RequestMapping(value = "/updatepengarang",method = RequestMethod.GET)
    public ModelAndView updatePengarang(@RequestParam("id")long id){
        return new ModelAndView("pengarangview/HalamanPengarangUpdate","pengarang",pengarangService.getById(id));
    }
    @RequestMapping(value = "/updatepengarang",method = RequestMethod.POST)
    public String updatePengarang(@ModelAttribute("Pengarang")Pengarang pengarang){
        pengarang.setUpdateDate(new Date());
        pengarang.setStatus("Active");
        pengarangService.SaveOrUpdate(pengarang);
        return "redirect:pengarang";
    }
    @RequestMapping(value = "/hapuspengarang")
    public String deletePengarang(@RequestParam("id")long id){
        pengarangService.deletePengarang(id);
        return "redirect:pengarang";
    }
    @RequestMapping(value = "/hapuspengarangnon")
    public String deletePengarangnon(@RequestParam("id")long id){
        Pengarang pengarang = pengarangService.getById(id);
        pengarang.setStatus("Disable");
        pengarangService.SaveOrUpdate(pengarang);
        return "redirect:pengarang";
    }
}
