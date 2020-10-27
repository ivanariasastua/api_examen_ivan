/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Ivan Josué Arias Astua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CantonDTO {
    
    private Integer id;
    private String nombre;
    private String codigo;
    @JsonBackReference
    private ProvinciaDTO provincia;
    @JsonManagedReference
    private List<DistritoDTO> distritos;
}
