package com.web.temaiken.controllers;

import com.web.temaiken.models.Usuario;
import com.web.temaiken.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuariosController {
   @Autowired
   private UsuariosRepository usuariosRepository;

   @GetMapping(value = "/add")
   public String addUsuario(Model model) {
      model.addAttribute("usuario", new Usuario());
      return "usuarios/add_usuario";
   }

   @GetMapping(value = "/show")
   public String showUsuarios(Model model) {
      model.addAttribute("usuarios", usuariosRepository.findAll());
      return "usuarios/see_usuarios";
   }

   @PostMapping(value = "/delete")
   public String deleteUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento eliminado")
         .addFlashAttribute("clase", "warning");
      usuariosRepository.deleteById(usuario.getId());
      return "redirect:/usuarios/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editUsuario(@ModelAttribute @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (usuario.getId() != null) {
            return "usuarios/edit_usuario";
         }
         return "redirect:/usuarios/show";
      }

      usuariosRepository.save(usuario);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento modificado")
         .addFlashAttribute("clase", "success");
      return "redirect:/usuarios/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("usuario", usuariosRepository.findById(id).orElse(null));
      return "usuarios/edit_usuario";
   }

   @PostMapping(value = "/add")
   public String saveUsuario(@ModelAttribute @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "usuarios/add_usuario";
      }

      usuariosRepository.save(usuario);
      redirectAttrs
         .addFlashAttribute("mensaje", "Elemento agregado")
         .addFlashAttribute("clase", "success");
      return "redirect:/usuarios/show";
   }
}
