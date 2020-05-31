package com.web.temaiken.controllers;

import com.web.temaiken.models.Itinerario;
import com.web.temaiken.repositories.ItinerariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/itinerarios")
public class ItinerariosController {
   @Autowired
   private ItinerariosRepository itinerariosRepository;

   @GetMapping(value = "/add")
   public String addItinerario(Model model) {
      model.addAttribute("itinerario", new Itinerario());
      return "itinerarios/add_itinerario";
   }

   @GetMapping(value = "/show")
   public String showItinerarios(Model model) {
      model.addAttribute("itinerarios", itinerariosRepository.findAll());
      return "itinerarios/see_itinerarios";
   }

   @PostMapping(value = "/delete")
   public String deleteItinerario(@ModelAttribute Itinerario itinerario, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento eliminado")
         .addFlashAttribute("clase", "warning");
      itinerariosRepository.deleteById(itinerario.getId());
      return "redirect:/itinerarios/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editItinerario(@ModelAttribute @Valid Itinerario itinerario, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (itinerario.getId() != null) {
            return "itinerarios/edit_itinerario";
         }
         return "redirect:/itinerarios/show";
      }

      itinerariosRepository.save(itinerario);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento modificado")
         .addFlashAttribute("clase", "success");
      return "redirect:/itinerarios/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("itinerario", itinerariosRepository.findById(id).orElse(null));
      return "itinerarios/edit_itinerario";
   }

   @PostMapping(value = "/add")
   public String saveItinerario(@ModelAttribute @Valid Itinerario itinerario, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "itinerarios/add_itinerario";
      }

      itinerariosRepository.save(itinerario);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento agregado")
         .addFlashAttribute("clase", "success");
      return "redirect:/itinerarios/show";
   }
}
