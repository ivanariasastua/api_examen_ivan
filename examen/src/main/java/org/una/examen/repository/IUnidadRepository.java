/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.entities.Unidad;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IUnidadRepository extends JpaRepository<Unidad, Long>{
    
    List<Unidad> findByNombreContaining(String nombre);
    
    List<Unidad> findByCodigoContaining(String codigo);
    
    List<Unidad> findByTipo(String tipo);
    
    @Query("SELECT u FROM Unidad u WHERE UPPER(u.distrito.nombre) LIKE CONCAT('%', :distrito, '%')")
    List<Unidad> findByDistrito(@Param("distrito")String distrito);
    
    @Query("SELECT u FROM Unidad u WHERE u.poblacion >= :poblacion")
    List<Unidad> findByPoblacion(@Param("poblacion")Integer poblacion);
    
    @Query("SELECT u FROM Unidad u WHERE u.area >= :area")
    List<Unidad> findByArea(@Param("area")Double area);
}
