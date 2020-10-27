/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.DTO.CantonDTO;
import org.una.examen.entities.Canton;
import org.una.examen.repository.ICantonRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public class CantonServiceImplemetation implements ICantonService{
    
    @Autowired
    private ICantonRepository repository;
    
    @Override
    @Transactional(readOnly = true)       
    public Optional<List<CantonDTO>> getByNombre(String nombre) {
        return ServiceConvertionHelper.findList(repository.findByNombreContaining(nombre), CantonDTO.class);
    }

    @Override
    @Transactional(readOnly = true) 
    public Optional<List<CantonDTO>> getByCodigo(String codigo) {
        return ServiceConvertionHelper.findList(repository.findByCodigoContaining(codigo), CantonDTO.class);
    }

    @Override
    @Transactional
    public Optional<CantonDTO> create(CantonDTO canton) {
        Canton p = MapperUtils.EntityFromDto(canton, Canton.class);
        p = repository.save(p);
        return ServiceConvertionHelper.oneToOptionalDto(p, CantonDTO.class);
    }

    @Override
    @Transactional
    public Optional<CantonDTO> update(CantonDTO canton) {
        if(repository.findById(canton.getId()).isPresent()){
            Canton p = MapperUtils.EntityFromDto(canton, Canton.class);
            p = repository.save(p);
            return ServiceConvertionHelper.oneToOptionalDto(p, CantonDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
