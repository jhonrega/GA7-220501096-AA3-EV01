package com.evidencia.evidencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.evidencia.evidencia.empleado.DatosEmpleado;
import com.evidencia.evidencia.repositorio.PersonaRepositorio;

@RestController

@SpringBootApplication
public class EvidenciaApplication implements CommandLineRunner{

	@Autowired
	private PersonaRepositorio personaRepositorio; 


	public static void main(String[] args) {
		SpringApplication.run(EvidenciaApplication.class, args);
	}

	// Añadir datos
	public void run(String... args) throws Exception {
		personaRepositorio.save(new DatosEmpleado("Jhon","Reyes", "reyesjhonj@gmail.com")); 
		personaRepositorio.save(new DatosEmpleado("James","Rodriguez", "jamesrodriguez@gmail.com")); 
	}
}