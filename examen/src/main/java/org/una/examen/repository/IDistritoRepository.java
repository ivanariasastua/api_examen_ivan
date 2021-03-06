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
import org.una.examen.entities.Distrito;

/**
 *
 * @author Ivan Josué Arias Astua
 */
public interface IDistritoRepository extends JpaRepository<Distrito, Long>{
 
    List<Distrito> findByNombreContaining(String nombre);
    
    List<Distrito> findByCodigoContaining(String codigo);
    
    @Query("SELECT d FROM Distrito d WHERE UPPER(d.canton.nombre) LIKE CONCAT('%', :canton, '%')")
    List<Distrito> findByCanton(@Param("canton")String canton);
    
    @Query("SELECT u FROM Distrito u WHERE u.poblacion >= :poblacion")
    List<Distrito> findByPoblacion(@Param("poblacion")Integer poblacion);
    
    @Query("SELECT u FROM Distrito u WHERE u.area >= :area")
    List<Distrito> findByArea(@Param("area")Double area);
}
