/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.una.examen.DTO.ProvinciaDTO;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IProvinciaService {
    
    public Optional<List<ProvinciaDTO>> getAll();
    
    public Optional<List<ProvinciaDTO>> getByNombre(String nombre);
    
    public Optional<List<ProvinciaDTO>> getByCodigo(String codigo);
    
    public Optional<ProvinciaDTO> create(ProvinciaDTO provincia);
    
    public Optional<ProvinciaDTO> update(ProvinciaDTO provincia, Integer id);
    
    public void delete(Integer id);
}
