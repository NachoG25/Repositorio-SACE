/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author matias
 */
@Entity 
@Table (name="carreras")
@NamedQueries({
    @NamedQuery(name = "carrera.all", query= "Select c From Carrera c"),
    @NamedQuery(name = "carrera.by.name", query= "Select c From Carrera c Where c.nombre=:nombre"),
    @NamedQuery(name = "carrera.by.establecimiento", query= "Select c From Carrera c Where c.establecimiento.nombre=:nombre")
})

public class Carrera implements Serializable{
    @Id @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column(name="cantidad_materias")
    private int cantidadMaterias;
    
    @JoinColumn (name="id_establecimiento", referencedColumnName="id")
    @ManyToOne
    private Establecimiento establecimiento;
    
    @Column (name = "ponderacion")
    private int ponderacion;

    public Carrera() {
    }

    public Carrera(String nombre, int cantidadMaterias, Establecimiento establecimiento, int ponderacion) {
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.establecimiento = establecimiento;
        this.ponderacion = ponderacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    } 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
    
    
}
