/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "exa_iaa_distritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Distrito implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50)
    private String nombre;
    
    @Column(length = 15)
    private String codigo;
    
    @ManyToOne 
    @JoinColumn(name="canton")
    private Canton canton;
    
    @Column
    private Integer poblacion;
    
    @Column
    private Double area;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "distrito")
    private List<Unidad> unidades;
}
