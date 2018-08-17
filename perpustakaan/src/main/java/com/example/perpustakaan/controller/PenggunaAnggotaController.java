package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Anggota;
import com.example.perpustakaan.service.AnggotaService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PenggunaAnggotaController {
    String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    @Autowired
    AnggotaService anggotaService;
    @RequestMapping(value = "/anggota",method = RequestMethod.GET)
    public ModelAndView MasterAnggota(){
        return new ModelAndView("anggotaview/HalamanAnggota","listanggota",anggotaService.getAllAnggota());
    }
    @RequestMapping(value = "/anggotaview",method = RequestMethod.GET)
    public ModelAndView viewAnggota(@RequestParam("id")long id){
        return new ModelAndView("anggotaview/HalamanAnggotaView","anggota",anggotaService.getById(id));
    }
    @RequestMapping(value = "/tambahanggota")
    public String formAnggota(){
        return "anggotaview/HalamanAnggotaForm";
    }
    public final String SaveDirectory= "E:/projekmu/perpustakaangit/perpustakaan/target/classes/static/image/anggota/";
    @RequestMapping(value = "/tambahanggota",method = RequestMethod.POST)
    public String tambahAnggota(@ModelAttribute("Anggtota")Anggota anggota,@RequestParam("fotok_anggota")MultipartFile fotoanggota,RedirectAttributes redirectAttributes) {
        try {
            byte[] bytes = fotoanggota.getBytes();
            String match= String.valueOf(Math.random());
            String random =  match.replace(".","");
            String nama= fotoanggota.getOriginalFilename().replace(fotoanggota.getOriginalFilename(), FilenameUtils.getBaseName(fotoanggota.getOriginalFilename()).concat(currentDate+random) + "." + FilenameUtils.getExtension(fotoanggota.getOriginalFilename())).toLowerCase();
            anggota.setFoto_anggota(nama);
            Path path = Paths.get(SaveDirectory +nama);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        anggotaService.SaveOrUpdate(anggota);
        return "redirect:anggota";
    }
}
