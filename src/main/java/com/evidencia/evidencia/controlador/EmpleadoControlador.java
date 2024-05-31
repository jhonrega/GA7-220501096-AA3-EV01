package com.evidencia.evidencia.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evidencia.evidencia.empleado.DatosEmpleado;
import com.evidencia.evidencia.servicio.EmpleadoServicio;

// Solicitudes HTTP y devolvera datos en formato Json 
@RestController
// Definición de la ruta para las solicitudes de este controlador 
@RequestMapping("/Empleados")
public class EmpleadoControlador {

    // Inyección de dependencias
    @Autowired
    private EmpleadoServicio empleadoServicio; 

    // Devuelve una lista de todas las personas por medio del get 
    @GetMapping 
    public List<DatosEmpleado> getAlDatosEmpleados(){
        return empleadoServicio.findAll();
    }

    // maneja las solicitudes GET a la ruta /empleados/{id} y
    // devuelve un empleado por su ID.
    @GetMapping("/{id}")
    public ResponseEntity<DatosEmpleado> getDatosEmpleadoById(@PathVariable Long id){
        Optional<DatosEmpleado> datosEmpleado = empleadoServicio.findById(id); 
        return datosEmpleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  solicitudes POST a la ruta /Empleados y 
    //crea un nuevo empleado los datos proporcionados 
    // en el cuerpo de la solicitud.
    @PostMapping
    public DatosEmpleado createDatosEmpleado(@RequestBody DatosEmpleado datosEmpleado){ 
        return empleadoServicio.save(datosEmpleado); 
    }

    // maneja las solicitudes PUT a la ruta /Empleados/{id} y 
    // actualiza una persona existente con los datos proporcionados 
    // en el cuerpo de la solicitud.

    @PutMapping("/{id}")
    public ResponseEntity<DatosEmpleado> updateDatosEmpleado (@PathVariable Long id, @RequestBody DatosEmpleado datosEmpleadoDetails){
        Optional<DatosEmpleado> datosEmpleado = empleadoServicio.findById(id); 
        if (datosEmpleado.isPresent()){
            DatosEmpleado updateDatosEmpleado = datosEmpleado.get();
            updateDatosEmpleado.setNombreDelEmpleado(datosEmpleadoDetails.getNombreDelEmpleado());
            updateDatosEmpleado.setApellidoDelEmpleado(datosEmpleadoDetails.getApellidoDelEmpleado());
            updateDatosEmpleado.setEmail(datosEmpleadoDetails.getEmail());
            empleadoServicio.save(updateDatosEmpleado);
            return ResponseEntity.ok(updateDatosEmpleado); 
        }
        else { 
            return ResponseEntity.notFound().build(); 
        }
    }
    
    // maneja las solicitudes DELETE a la ruta /Empelados/{id} y 
    //elimina un empleado por su ID. Utiliza ResponseEntity 
    // para devolver 204 No Content si
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatosEmpleado (@PathVariable Long id){
        if (empleadoServicio.findById(id).isPresent()){
            empleadoServicio.deleteById(id);
            return ResponseEntity.noContent().build(); 
        }
        else {
            return ResponseEntity.notFound().build(); 
        }
    }


}
