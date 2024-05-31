package com.evidencia.evidencia.servicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evidencia.evidencia.empleado.DatosEmpleado;
import com.evidencia.evidencia.repositorio.PersonaRepositorio;


// Esta anotación nos indica que la clase es un servicio de Spring
@Service
public class EmpleadoServicio {

    // inyección de dependencias por parte del contenedor Spring
    @Autowired
    private PersonaRepositorio personaRepositorio; 

    // Obtener todos los empleados
    public List<DatosEmpleado> findAll(){
        return personaRepositorio.findAll(); 
    }

    // Obtener un empleado por su ID 
    public Optional<DatosEmpleado> findById(Long id){
        return personaRepositorio.findById(id); 
    }

    // Guardar un nuevo empleado o actualizar uno 
    public DatosEmpleado save(DatosEmpleado datosEmpleado){
        return personaRepositorio.save(datosEmpleado); 
    }

    //Eliminar un empleado por su ID 
    public void deleteById(Long id) {
        personaRepositorio.deleteById(id);
    }

}
