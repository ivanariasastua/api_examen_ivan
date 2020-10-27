/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen.entities.Unidad;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IUnidadRepository extends JpaRepository<Unidad, Long>{
    
    List<Unidad> findByNombreContaining(String nombre);
    
    List<Unidad> findByCodigoContaining(String codigo);
}
