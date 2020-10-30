/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.DTO.UnidadDTO;
import org.una.examen.entities.Unidad;
import org.una.examen.repository.IUnidadRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;

/**
 *
 * @author Ivan Josué Arias Astua
 */
@Service
public class UnidadServiceImplementation implements IUnidadService{
    
    @Autowired
    private IUnidadRepository repository;
    
    @Override
    @Transactional(readOnly = true)       
    public Optional<List<UnidadDTO>> getByNombre(String nombre) {
        return ServiceConvertionHelper.findList(repository.findByNombreContaining(nombre), UnidadDTO.class);
    }

    @Override
    @Transactional(readOnly = true) 
    public Optional<List<UnidadDTO>> getByCodigo(String codigo) {
        return ServiceConvertionHelper.findList(repository.findByCodigoContaining(codigo), UnidadDTO.class);
    }

    @Override
    @Transactional
    public Optional<UnidadDTO> create(UnidadDTO unidad) {
        Unidad p = MapperUtils.EntityFromDto(unidad, Unidad.class);
        p = repository.save(p);
        return ServiceConvertionHelper.oneToOptionalDto(p, UnidadDTO.class);
    }

    @Override
    @Transactional
    public Optional<UnidadDTO> update(UnidadDTO unidad, Long id) {
        if(repository.findById(id).isPresent()){
            Unidad p = MapperUtils.EntityFromDto(unidad, Unidad.class);
            p = repository.save(p);
            return ServiceConvertionHelper.oneToOptionalDto(p, UnidadDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true) 
    public Optional<List<UnidadDTO>> getByDistrito(String distrito) {
        return ServiceConvertionHelper.findList(repository.findByDistrito(distrito), UnidadDTO.class);
    }

    @Override
    public Optional<List<UnidadDTO>> getByTipo(String tipo) {
        return ServiceConvertionHelper.findList(repository.findByTipo(tipo), UnidadDTO.class);
    }
}
