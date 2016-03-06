/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ov;

import modelo.Carrera;
import modelo.Establecimiento;

/**
 *
 * @author matias
 */
public class CarreraOV {
    
    private String nombre;
    private int cantidadMaterias;
    private EstablecimientoOV establecimiento;
    private int ponderacion;

    public CarreraOV() {
    }

    public CarreraOV(Carrera carrera) {
        this.nombre = carrera.getNombre();
        this.cantidadMaterias = carrera.getCantidadMaterias();
        this.establecimiento = new EstablecimientoOV(carrera.getEstablecimiento());
        this.ponderacion = carrera.getPonderacion();
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

    public EstablecimientoOV getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoOV establecimiento) {
        this.establecimiento = establecimiento;
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
