package com.web.temaiken.controllers;

import com.web.temaiken.models.Habitat;
import com.web.temaiken.repositories.HabitatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/habitats")
public class HabitatsController {
   @Autowired
   private HabitatsRepository habitatsRepository;

   @GetMapping(value = "/add")
   public String addHabitat(Model model) {
      model.addAttribute("habitat", new Habitat());
      return "habitats/add_habitat";
   }

   @GetMapping(value = "/show")
   public String showHabitats(Model model) {
      model.addAttribute("habitats", habitatsRepository.findAll());
      return "habitats/see_habitats";
   }

   @PostMapping(value = "/delete")
   public String deleteHabitat(@ModelAttribute Habitat habitat, RedirectAttributes redirectAttrs) {
      redirectAttrs
              .addFlashAttribute("mensaje", "Elemento eliminado")
              .addFlashAttribute("clase", "warning");
      habitatsRepository.deleteById(habitat.getId());
      return "redirect:/habitats/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editHabitat(@ModelAttribute @Valid Habitat habitat, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (habitat.getId() != null) {
            return "habitats/edit_habitat";
         }
         return "redirect:/habitats/show";
      }

      habitatsRepository.save(habitat);
      redirectAttrs
              .addFlashAttribute("mensaje", "Elemento modificado")
              .addFlashAttribute("clase", "success");
      return "redirect:/habitats/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("habitat", habitatsRepository.findById(id).orElse(null));
      return "habitats/edit_habitat";
   }

   @PostMapping(value = "/add")
   public String saveHabitat(@ModelAttribute @Valid Habitat habitat, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "habitats/add_habitat";
      }

      habitatsRepository.save(habitat);
      redirectAttrs
              .addFlashAttribute("mensaje", "Elemento agregado")
              .addFlashAttribute("clase", "success");
      return "redirect:/habitats/show";
   }
}
