package com.web.temaiken.controllers;

import com.web.temaiken.models.Especie;
import com.web.temaiken.repositories.EspeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/especies")
public class EspeciesController {
   @Autowired
   private EspeciesRepository especiesRepository;

   @GetMapping(value = "/add")
   public String addEspecie(Model model) {
      model.addAttribute("especie", new Especie());
      return "especies/add_especie";
   }

   @GetMapping(value = "/show")
   public String showEspecies(Model model) {
      model.addAttribute("especies", especiesRepository.findAll());
      return "especies/see_especies";
   }

   @PostMapping(value = "/delete")
   public String deleteEspecie(@ModelAttribute Especie especie, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento eliminado")
         .addFlashAttribute("clase", "warning");
      especiesRepository.deleteById(especie.getId());
      return "redirect:/especies/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editEspecie(@ModelAttribute @Valid Especie especie, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (especie.getId() != null) {
            return "especies/edit_especie";
         }
         return "redirect:/especies/show";
      }

      especiesRepository.save(especie);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento modificado")
         .addFlashAttribute("clase", "success");
      return "redirect:/especies/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("especie", especiesRepository.findById(id).orElse(null));
      return "especies/edit_especie";
   }

   @PostMapping(value = "/add")
   public String saveEspecie(@ModelAttribute @Valid Especie especie, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "especies/add_especie";
      }

      especiesRepository.save(especie);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento agregado")
         .addFlashAttribute("clase", "success");
      return "redirect:/especies/show";
   }
}
