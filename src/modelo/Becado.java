/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author matias
 */
@Entity 
@Table (name="becados")
@NamedQueries({
    @NamedQuery(name = "becado.all", query= "Select b From Becado b"),
    @NamedQuery(name = "becado.by.name", query= "Select b From Becado b Where b.apellido=:apellido")
})
public class Becado implements Serializable {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "dni")
    private String dni;
    @Column (name = "email")
    private String email;
    @Column (name = "telefono")
    private String telefono;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "fecha_de_nacimiento")
    private Date fechaDeNacimiento;
    
    @JoinColumn (name="id_carrera", referencedColumnName="id")
    @ManyToOne
    private Carrera carrera;

    public Becado() {
    }

    public Becado(String nombre, String apellido, String dni, String email, String telefono, Date fechaDeNacimiento, Carrera carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.carrera = carrera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
