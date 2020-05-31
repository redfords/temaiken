package com.web.temaiken.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Itinerario {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Campo obligatorio")
   private Integer duracion;

   @NotNull(message = "Campo obligatorio")
   private Integer longitud;

   @NotNull(message = "Campo obligatorio")
   private Integer numMaxVisitantes;

   public Itinerario(Integer duracion, Integer longitud, Integer NumMaxVisitantes, Integer id) {
      this.duracion = duracion;
      this.longitud = longitud;
      this.numMaxVisitantes = numMaxVisitantes;
      this.id = id;
   }

   public Itinerario(Integer duracion, Integer longitud, Integer numMaxVisitantes) {
         this.duracion = duracion;
         this.longitud = longitud;
         this.numMaxVisitantes = numMaxVisitantes;
      }

   public Itinerario() {
   }

   public Integer getDuracion() {
      return duracion;
   }

   public void setDuracion(Integer duracion) {
      this.duracion = duracion;
   }

   public Integer getLongitud() {
      return longitud;
   }

   public void setLongitud(Integer longitud) {
      this.longitud = longitud;
   }

   public Integer getNumMaxVisitantes() {
      return numMaxVisitantes;
   }

   public void setNumMaxVisitantes(Integer numMaxVisitantes) {
      this.numMaxVisitantes = numMaxVisitantes;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}