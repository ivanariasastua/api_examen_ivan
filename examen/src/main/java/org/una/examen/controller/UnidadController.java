/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.examen.DTO.UnidadDTO;
import org.una.examen.service.IUnidadService;

/**
 *
 * @author Ivan Josué Arias Astua
 */
@RestController
@RequestMapping("/unidad")
public class UnidadController {
    
    @Autowired
    private IUnidadService service;
    
    @GetMapping("nombre/{nombre}")
    public ResponseEntity<?> getByNombre(@PathVariable("nombre")String nombre){
        try{
            return new ResponseEntity<>(service.getByNombre(nombre), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("codigo/{codigo}")
    public ResponseEntity<?> getByCodigo(@PathVariable("codigo")String codigo){
        try{
            return new ResponseEntity<>(service.getByCodigo(codigo), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("tipo/{tipo}")
    public ResponseEntity<?> getByTipo(@PathVariable("tipo")String tipo){
        try{
            return new ResponseEntity<>(service.getByTipo(tipo), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("distrito/{distrito}")
    public ResponseEntity<?> getByDistrito(@PathVariable("distrito")String distrito){
        try{
            return new ResponseEntity<>(service.getByDistrito(distrito), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UnidadDTO unidad) {
        try {
            return new ResponseEntity<>(service.create(unidad), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody UnidadDTO unidad) {
        try {
            Optional<UnidadDTO> unidadUpdated = service.update(unidad, id);
            if (unidadUpdated.isPresent()) {
                return new ResponseEntity<>(unidadUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
