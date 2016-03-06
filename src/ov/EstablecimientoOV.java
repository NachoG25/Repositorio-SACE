/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ov;

import modelo.Establecimiento;

/**
 *
 * @author matias
 */
public class EstablecimientoOV {
    private String nombre;
    private String direccion;

    public EstablecimientoOV() {
    }

    public EstablecimientoOV(Establecimiento establecimiento) {
        this.nombre = establecimiento.getNombre();
        this.direccion = establecimiento.getDireccion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

}
