package com.example.perpustakaan.controller;

import com.example.perpustakaan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PenggunaAnggotaController {
    @Autowired
    AnggotaService anggotaService;
    @RequestMapping("/anggota")
    public ModelAndView MasterAnggota(){
        return new ModelAndView("anggotaview/HalamanAnggota","listanggota",anggotaService.getAllAnggota());
    }
    @RequestMapping("/anggotaciew")
    public ModelAndView viewAnggota(@RequestParam("id")long id){
        return new ModelAndView("HalamanAnggotaView","anggota",anggotaService.getById(id));
    }
}
