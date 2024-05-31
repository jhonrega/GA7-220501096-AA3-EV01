package com.evidencia.evidencia.empleado; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DatosEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; 

    private String NombreDelEmpleado; 
    private String ApellidoDelEmpleado; 
    private String Email;

    
    public DatosEmpleado(String nombreDelEmpleado, String apellidoDelEmpleado, String email) {
        NombreDelEmpleado = nombreDelEmpleado;
        ApellidoDelEmpleado = apellidoDelEmpleado;
        Email = email;
    }

    

    public DatosEmpleado() {
    }

    public String getNombreDelEmpleado() {
        return NombreDelEmpleado;
    }

    public Long getId() {
        return id;
    }

    public String getApellidoDelEmpleado() {
        return ApellidoDelEmpleado;
    }

    public String getEmail() {
        return Email;
    }

    public void setNombreDelEmpleado(String nombreDelAprendiz) {
        NombreDelEmpleado = nombreDelAprendiz;
    }

    public void setApellidoDelEmpleado(String apellidoDelAprendiz) {
        ApellidoDelEmpleado = apellidoDelAprendiz;
    }

    public void setEmail(String ficha) {
        Email = ficha;
    } 
    
    public void setId(Long id) {
        this.id = id;
    }

}
