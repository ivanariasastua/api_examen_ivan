/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.una.examen.DTO.UnidadDTO;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IUnidadService {
    
    public Optional<List<UnidadDTO>> getByNombre(String nombre);
    
    public Optional<List<UnidadDTO>> getByCodigo(String codigo);
    
    public Optional<List<UnidadDTO>> getByTipo(String tipo);
    
    public Optional<List<UnidadDTO>> getByDistrito(String distrito);
    
    public Optional<UnidadDTO> create(UnidadDTO unidad);
    
    public Optional<UnidadDTO> update(UnidadDTO unidad, Long id);
    
    public void delete(Long id);
}
