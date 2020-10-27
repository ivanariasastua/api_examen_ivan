/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.una.examen.DTO.DistritoDTO;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IDistritoService {
    
    public Optional<List<DistritoDTO>> getByNombre(String nombre);
    
    public Optional<List<DistritoDTO>> getByCodigo(String codigo);
    
    public Optional<DistritoDTO> create(DistritoDTO distrito);
    
    public Optional<DistritoDTO> update(DistritoDTO distrito, Long id);
    
    public void delete(Long id);
}
