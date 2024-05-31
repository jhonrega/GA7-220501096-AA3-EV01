package com.evidencia.evidencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evidencia.evidencia.empleado.DatosEmpleado;

public interface PersonaRepositorio  extends JpaRepository <DatosEmpleado, Long>{

}
