/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Ivan Josué Arias Astua
 */
@Entity
@Table(name = "exa_iaa_unidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Unidad {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50)
    private String nombre;
    
    @Column(length = 15)
    private String codigo;
    
    @Column(length = 15)
    private String tipo;
    
    @Column
    private Integer poblacion;
    
    @Column
    private Double area;
    
    @ManyToOne 
    @JoinColumn(name="distrito")
    private Distrito distrito;
}
