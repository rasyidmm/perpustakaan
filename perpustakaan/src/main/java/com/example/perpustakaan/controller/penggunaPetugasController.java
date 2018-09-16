package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Petugas;
import com.example.perpustakaan.service.PetugasService;
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
public class penggunaPetugasController {
    String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    @Autowired
    PetugasService petugasService;
    @RequestMapping(value = "/petugas",method = RequestMethod.GET)
    public ModelAndView MasterPetugas(){
        return new ModelAndView("petugasview/HalamanPetugas","listpetugas",petugasService.getAllPetugas());
    }
    @RequestMapping(value = "/petugasview",method = RequestMethod.GET)
    public ModelAndView viewPetugas(@RequestParam("id")long id){
        return new ModelAndView("petugasview/HalamanPetugasView","petugas",petugasService.getById(id));
    }
    @RequestMapping(value = "/tambahpetugas")
    public String formPetugas(){
        return "petugasview/HalamanPetugasForm";
    }
    public final String SaveDirectory= "/home/rasyid/projekgit/perpustakaan/perpustakaan/target/classes/static/image/petugas/";
    @RequestMapping(value = "/tambahpetugas",method = RequestMethod.POST)
    public String tambahPetugas(@ModelAttribute("Petugas")Petugas petugas, @RequestParam("fotok_petugas")MultipartFile fotopetugas, RedirectAttributes redirectAttributes) {
        try {
            byte[] bytes = fotopetugas.getBytes();
            String match= String.valueOf(Math.random());
            String random =  match.replace(".","");
            String nama= fotopetugas.getOriginalFilename().replace(fotopetugas.getOriginalFilename(), FilenameUtils.getBaseName(fotopetugas.getOriginalFilename()).concat(currentDate+random) + "." + FilenameUtils.getExtension(fotopetugas.getOriginalFilename())).toLowerCase();
            petugas.setFoto_petugas(nama);
            Path path = Paths.get(SaveDirectory +nama);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        petugasService.SaveOrUpdate(petugas);
        return "redirect:petugas";
    }
    @RequestMapping(value = "/updatepetugas",method = RequestMethod.GET)
    public ModelAndView formUpdatePetugas(@RequestParam("id")long id){
        return new ModelAndView("petugasview/HalamanPetugasUpdate","petugasid",petugasService.getById(id));
    }
    @RequestMapping(value = "/updatepetugas",method = RequestMethod.POST)
    public String updatePetugas(@RequestParam("id")long id,@ModelAttribute("Petugas")Petugas petugas,@RequestParam("fotok_petugas")MultipartFile fotopetugas,RedirectAttributes redirectAttributes){
       Petugas peg = petugasService.getById(id);
        String namafotos = peg.getFoto_petugas();
        File file = new File(SaveDirectory.concat(namafotos));
        if (fotopetugas.isEmpty()==true){
            petugas.setFoto_petugas(peg.getFoto_petugas());
        }else {
            try {
                file.delete();
                byte[] bytes = fotopetugas.getBytes();
                String match= String.valueOf(Math.random());
                String random =  match.replace(".","");
                String nama= fotopetugas.getOriginalFilename().replace(fotopetugas.getOriginalFilename(), FilenameUtils.getBaseName(fotopetugas.getOriginalFilename()).concat(currentDate+"_"+random+"_"+peg.getId()) + "." + FilenameUtils.getExtension(fotopetugas.getOriginalFilename())).toLowerCase();
                petugas.setFoto_petugas(nama);
                Path path = Paths.get(SaveDirectory +nama);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        petugas.setPassword(peg.getPassword());
        petugasService.SaveOrUpdate(petugas);
        return "redirect:petugas";
    }
    @RequestMapping(value = "/deletepetugas")
    public String hapusPetugas(@RequestParam("id")long id){
        Petugas peg = petugasService.getById(id);
        String namafotos = peg.getFoto_petugas();
        File file = new File(SaveDirectory.concat(namafotos));
        file.delete();
        petugasService.deletePetugas(id);
        return "redirect:petugas";
    }
}
