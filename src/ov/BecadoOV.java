/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ov;

import java.util.Date;
import modelo.Becado;
import modelo.Carrera;

/**
 *
 * @author matias
 */
public class BecadoOV {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private Date fechaDeNacimiento;
    private Carrera carrera;

    public BecadoOV() {
    }

    public BecadoOV(Becado becado) {
        this.nombre = becado.getNombre();
        this.apellido = becado.getApellido();
        this.dni = becado.getDni();
        this.email = becado.getEmail();
        this.fechaDeNacimiento = becado.getFechaDeNacimiento();
        this.carrera = becado.getCarrera();
        this.telefono = becado.getTelefono();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
