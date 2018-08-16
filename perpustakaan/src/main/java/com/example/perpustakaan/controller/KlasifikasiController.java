package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Klasifikasi;
import com.example.perpustakaan.service.KlasifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class KlasifikasiController {
    @Autowired
    KlasifikasiService klasifikasiService;
    @RequestMapping("/klasifikasi")
    public ModelAndView masterPengarang(){
        return new ModelAndView("klasifikasiview/Halamanklasifikasi","listklasifikasi",klasifikasiService.getAllKlasifikasi());
    }
    @RequestMapping(value = "/tambahklasifikasi")
    public String formpengarang(){
        return "klasifikasiview/HalamanFormklasifikasi";
    }
    @RequestMapping(value = "/tambahklasifikasi",method = RequestMethod.POST)
    public String tambahPengarang(@ModelAttribute("Klasifikasi")Klasifikasi klasifikasi){
        klasifikasi.setCreateDate(new Date());
        klasifikasiService.SaveOrUpdate(klasifikasi);
        return "redirect:klasifikasi";
    }
    @RequestMapping(value = "/updateklasifikasi",method = RequestMethod.GET)
    public ModelAndView updatePengarang(@RequestParam("id")long id){
        return new ModelAndView("klasifikasiview/HalamanUpdateklasifikasi","klasifikasi",klasifikasiService.getById(id));
    }
    @RequestMapping(value = "/hapusklasifikasi")
    public String deletePengarang(@RequestParam("id")long id){
        klasifikasiService.deleteKlasifikasi(id);
        return "redirect:klasifikasi";
    }
}
