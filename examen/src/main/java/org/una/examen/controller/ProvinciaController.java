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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.una.examen.DTO.ProvinciaDTO;
import org.una.examen.service.ICantonService;
import org.una.examen.service.IProvinciaService;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public class ProvinciaController {
 
    @Autowired
    private IProvinciaService service;
    
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{nombre}")
    public ResponseEntity<?> getByNombre(@PathVariable("nombre")String nombre){
        try{
            return new ResponseEntity<>(service.getByNombre(nombre), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<?> getByCodigo(@PathVariable("codigo")String codigo){
        try{
            return new ResponseEntity<>(service.getByCodigo(codigo), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ProvinciaDTO provincia) {
        try {
            return new ResponseEntity<>(service.create(provincia), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Integer id, @RequestBody ProvinciaDTO provincia) {
        try {
            Optional<ProvinciaDTO> provinciaUpdated = service.update(provincia, id);
            if (provinciaUpdated.isPresent()) {
                return new ResponseEntity<>(provinciaUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
