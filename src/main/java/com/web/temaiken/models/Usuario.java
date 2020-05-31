package com.web.temaiken.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Campo obligatorio")
   private String nombre;

   @NotNull(message = "Campo obligatorio")
   private String direccion;

   @NotNull(message = "Campo obligatorio")
   private Integer telefono;

   @NotNull(message = "Campo obligatorio")
   private Date fechaIngreso;

   @NotNull(message = "Campo obligatorio")
   private String username;

   @NotNull(message = "Campo obligatorio")
   private String password;

   @NotNull(message = "Campo obligatorio")
   private String tipo;

   public Usuario(String nombre, String direccion, Integer telefono, Date fechaIngreso, String username, String password, String tipo, Integer id) {
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      this.fechaIngreso = fechaIngreso;
      this.username = username;
      this.password = password;
      this.tipo = tipo;
      this.id = id;
   }

   public Usuario(String nombre, String direccion, Integer telefono, Date fechaIngreso, String username, String password, String tipo) {
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      this.fechaIngreso = fechaIngreso;
      this.username = username;
      this.password = password;
      this.tipo = tipo;
   }

   public Usuario(String nombre) {
      this.nombre = nombre;
   }

   public Usuario() {
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   public Integer getTelefono() {
      return telefono;
   }

   public void setTelefono(Integer telefono) {
      this.telefono = telefono;
   }

   public Date getFechaIngreso() {
      return fechaIngreso;
   }

   public void setFechaIngreso(Date fechaIngreso) {
      this.fechaIngreso = fechaIngreso;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
