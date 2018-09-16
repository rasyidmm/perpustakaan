package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Anggota;
import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.service.AnggotaService;
import com.example.perpustakaan.service.PeminjamanService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    PeminjamanService peminjamanService;
    @RequestMapping(value = "/anggota",method = RequestMethod.GET)
    public ModelAndView MasterAnggota(){
        return new ModelAndView("anggotaview/HalamanAnggota","listanggota",anggotaService.getAllAnggota());
    }
    @RequestMapping(value = "/anggotaview",method = RequestMethod.GET)
    public ModelAndView viewAnggota(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("history",peminjamanService.findPeminjamenByAnggotaid(id));
        mav.addObject("anggota",anggotaService.getById(id));
        mav.setViewName("anggotaview/HalamanAnggotaView");
        return mav;
//        return new ModelAndView("anggotaview/HalamanAnggotaView","anggota",anggotaService.getById(id));
    }
    @RequestMapping(value = "/tambahanggota")
    public String formAnggota(){
        return "anggotaview/HalamanAnggotaForm";
    }
    public final String SaveDirectory= "/home/rasyid/projekgit/perpustakaan/perpustakaan/target/classes/static/image/anggota/";
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
    @RequestMapping(value = "/updateanggota",method = RequestMethod.GET)
    public ModelAndView formUpdateanggota(@RequestParam("id")long id){
        return new ModelAndView("anggotaview/HalamanAnggotaUpdate","anggotaid",anggotaService.getById(id));
    }
    @RequestMapping(value = "/updateanggota",method = RequestMethod.POST)
    public String updateanggota(@RequestParam("id")long id,@ModelAttribute("Anggtota")Anggota anggota,@RequestParam("fotok_anggota")MultipartFile fotoanggota,RedirectAttributes redirectAttributes){
        Anggota ang = anggotaService.getById(id);
        String namafotos = ang.getFoto_anggota();
        File file = new File(SaveDirectory.concat(namafotos));
        if (fotoanggota.isEmpty()==true){
            anggota.setFoto_anggota(ang.getFoto_anggota());
        }else {
            try {
                file.delete();
                byte[] bytes = fotoanggota.getBytes();
                String match= String.valueOf(Math.random());
                String random =  match.replace(".","");
                String nama= fotoanggota.getOriginalFilename().replace(fotoanggota.getOriginalFilename(), FilenameUtils.getBaseName(fotoanggota.getOriginalFilename()).concat(currentDate+"_"+random+"_"+ang.getId()) + "." + FilenameUtils.getExtension(fotoanggota.getOriginalFilename())).toLowerCase();
                anggota.setFoto_anggota(nama);
                Path path = Paths.get(SaveDirectory +nama);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        anggota.setPassword(ang.getPassword());
        anggotaService.SaveOrUpdate(anggota);
        return "redirect:anggota";
    }
    @RequestMapping(value = "/deleteanggota")
    public String hapusAnggota(@RequestParam("id")long id){
        Anggota ang = anggotaService.getById(id);
        String namafotos = ang.getFoto_anggota();
        File file = new File(SaveDirectory.concat(namafotos));
        file.delete();
        anggotaService.deleteAnggota(id);
        return "redirect:anggota";
    }
}
