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
import org.una.examen.DTO.DistritoDTO;
import org.una.examen.entities.Distrito;
import org.una.examen.repository.IDistritoRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;

/**
 *
 * @author Ivan Josué Arias Astua
 */
@Service
public class DistritoServiceImplementation implements IDistritoService{
    
    @Autowired
    private IDistritoRepository repository;
    
    @Override
    @Transactional(readOnly = true)       
    public Optional<List<DistritoDTO>> getByNombre(String nombre) {
        return ServiceConvertionHelper.findList(repository.findByNombreContaining(nombre), DistritoDTO.class);
    }

    @Override
    @Transactional(readOnly = true) 
    public Optional<List<DistritoDTO>> getByCodigo(String codigo) {
        return ServiceConvertionHelper.findList(repository.findByCodigoContaining(codigo), DistritoDTO.class);
    }

    @Override
    @Transactional
    public Optional<DistritoDTO> create(DistritoDTO distrito) {
        Distrito p = MapperUtils.EntityFromDto(distrito, Distrito.class);
        p = repository.save(p);
        return ServiceConvertionHelper.oneToOptionalDto(p, DistritoDTO.class);
    }

    @Override
    @Transactional
    public Optional<DistritoDTO> update(DistritoDTO distrito, Long id) {
        if(repository.findById(id).isPresent()){
            Distrito p = MapperUtils.EntityFromDto(distrito, Distrito.class);
            p = repository.save(p);
            return ServiceConvertionHelper.oneToOptionalDto(p, DistritoDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
