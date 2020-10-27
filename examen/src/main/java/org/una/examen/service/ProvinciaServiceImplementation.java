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
import org.una.examen.DTO.ProvinciaDTO;
import org.una.examen.entities.Provincia;
import org.una.examen.repository.IProvinciaRepository;
import org.una.examen.utils.ServiceConvertionHelper;
import org.una.examen.utils.MapperUtils;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ivan Josué Arias Astua
 */
@Service
public class ProvinciaServiceImplementation implements IProvinciaService{

    @Autowired
    private IProvinciaRepository repository;
    
    @Override
    @Transactional(readOnly = true)       
    public Optional<List<ProvinciaDTO>> getByNombre(String nombre) {
        return ServiceConvertionHelper.findList(repository.findByNombreContaining(nombre), ProvinciaDTO.class);
    }

    @Override
    @Transactional(readOnly = true) 
    public Optional<List<ProvinciaDTO>> getByCodigo(String codigo) {
        return ServiceConvertionHelper.findList(repository.findByCodigoContaining(codigo), ProvinciaDTO.class);
    }

    @Override
    @Transactional
    public Optional<ProvinciaDTO> create(ProvinciaDTO provincia) {
        Provincia p = MapperUtils.EntityFromDto(provincia, Provincia.class);
        p = repository.save(p);
        return ServiceConvertionHelper.oneToOptionalDto(p, ProvinciaDTO.class);
    }

    @Override
    @Transactional
    public Optional<ProvinciaDTO> update(ProvinciaDTO provincia) {
        if(repository.findById(provincia.getId()).isPresent()){
            Provincia p = MapperUtils.EntityFromDto(provincia, Provincia.class);
            p = repository.save(p);
            return ServiceConvertionHelper.oneToOptionalDto(p, ProvinciaDTO.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
