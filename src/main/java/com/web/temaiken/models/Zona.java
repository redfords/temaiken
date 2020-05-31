package com.web.temaiken.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Zona {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Campo obligatorio")
   private String nombre;

   @NotNull(message = "Campo obligatorio")
   private Integer extension;

   public Zona(String nombre, Integer extension, Integer id) {
      this.nombre = nombre;
      this.extension = extension;
      this.id = id;
   }

   public Zona(String nombre, Integer extension) {
         this.nombre = nombre;
         this.extension = extension;
      }

   public Zona(String nombre) {
      this.nombre = nombre;
   }

   public Zona() {
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Integer getExtension() {
      return extension;
   }

   public void setExtension(Integer extension) {
      this.extension = extension;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
