package com.web.temaiken.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Especie {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Campo obligatorio")
   private String nombre;

   @NotNull(message = "Campo obligatorio")
   private String nombreCientifico;

   @NotNull(message = "Campo obligatorio")
   private String descripcion;

   public Especie(String nombre, String nombreCientifico, String descripcion, Integer id) {
      this.nombre = nombre;
      this.nombreCientifico = nombreCientifico;
      this.descripcion = descripcion;
      this.id = id;
   }

   public Especie(String nombre, String nombreCientifico, String descripcion) {
      this.nombre = nombre;
      this.nombreCientifico = nombreCientifico;
      this.descripcion = descripcion;
   }

   public Especie(String nombre) {
      this.nombre = nombre;
   }

   public Especie() {
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getNombreCientifico() {
      return nombreCientifico;
   }

   public void setNombreCientifico(String nombreCientifico) {
      this.nombreCientifico = nombreCientifico;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
