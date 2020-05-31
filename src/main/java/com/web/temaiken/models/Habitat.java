package com.web.temaiken.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Habitat {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Campo obligatorio")
   private String nombre;

   @NotNull(message = "Campo obligatorio")
   private String clima;

   @NotNull(message = "Campo obligatorio")
   private String vegetacion;

   @NotNull(message = "Campo obligatorio")
   private String continente;

   public Habitat(String nombre, String clima, String vegetacion, String continente, Integer id) {
      this.nombre = nombre;
      this.clima = clima;
      this.vegetacion = vegetacion;
      this.continente = continente;
      this.id = id;
   }

   public Habitat(String nombre, String clima, String vegetacion, String continente) {
      this.nombre = nombre;
      this.clima = clima;
      this.vegetacion = vegetacion;
      this.continente = continente;
   }

   public Habitat(String nombre) {
      this.nombre = nombre;
   }

   public Habitat() {
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getClima() {
      return clima;
   }

   public void setClima(String clima) {
      this.clima = clima;
   }

   public String getVegetacion() {
      return vegetacion;
   }

   public void setVegetacion(String vegetacion) {
      this.vegetacion = vegetacion;
   }

   public String getContinente() {
      return continente;
   }

   public void setContinente(String continente) {
      this.continente = continente;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
