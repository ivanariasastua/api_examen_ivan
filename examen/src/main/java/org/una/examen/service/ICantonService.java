/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.una.examen.DTO.CantonDTO;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface ICantonService {
    
    public Optional<List<CantonDTO>> getByNombre(String nombre);
    
    public Optional<List<CantonDTO>> getByCodigo(String codigo);
    
    public Optional<CantonDTO> create(CantonDTO canton);
    
    public Optional<CantonDTO> update(CantonDTO canton, Long id);
    
    public void delete(Long id);
    
}
