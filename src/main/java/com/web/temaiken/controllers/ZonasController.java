package com.web.temaiken.controllers;

import com.web.temaiken.models.Zona;
import com.web.temaiken.repositories.ZonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/zonas")
public class ZonasController {
   @Autowired
   private ZonasRepository zonasRepository;

   @GetMapping(value = "/add")
   public String addZona(Model model) {
      model.addAttribute("zona", new Zona());
      return "zonas/add_zona";
   }

   @GetMapping(value = "/show")
   public String showZonas(Model model) {
      model.addAttribute("zonas", zonasRepository.findAll());
      return "zonas/see_zonas";
   }

   @PostMapping(value = "/delete")
   public String deleteZona(@ModelAttribute Zona zona, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento eliminado")
         .addFlashAttribute("clase", "warning");
      zonasRepository.deleteById(zona.getId());
      return "redirect:/zonas/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editZona(@ModelAttribute @Valid Zona zona, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (zona.getId() != null) {
            return "zonas/edit_zona";
         }
         return "redirect:/zonas/show";
      }

      zonasRepository.save(zona);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento modificado")
         .addFlashAttribute("clase", "success");
      return "redirect:/zonas/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("zona", zonasRepository.findById(id).orElse(null));
      return "zonas/edit_zona";
   }

   @PostMapping(value = "/add")
   public String saveZona(@ModelAttribute @Valid Zona zona, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "zonas/add_zona";
      }

      zonasRepository.save(zona);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento agregado")
         .addFlashAttribute("clase", "success");
      return "redirect:/zonas/show";
   }
}
