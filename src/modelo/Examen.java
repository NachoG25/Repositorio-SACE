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
@Table (name="examenes")
@NamedQueries({
    @NamedQuery(name = "examen.all", query= "Select e From Examen e"),
    @NamedQuery(name = "examen.by.becado", query= "Select e From Examen e Where e.becado.apellido =:apellido")
})
public class Examen implements Serializable {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String materia;
    @Column (name = "final")
    private boolean isFinal;
    private Double nota;
    private boolean aprobo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn (name="id_becado", referencedColumnName="id")
    @ManyToOne
    private Becado becado;

    public Examen() {
    }

    public Examen(String materia, boolean isFinal, Double nota, boolean aprobo, Date fecha, Becado becado) {
        this.materia = materia;
        this.isFinal = isFinal;
        this.nota = nota;
        this.aprobo = aprobo;
        this.fecha = fecha;
        this.becado = becado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public boolean isIsFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public boolean isAprobo() {
        return aprobo;
    }

    public void setAprobo(boolean aprobo) {
        this.aprobo = aprobo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Becado getBecado() {
        return becado;
    }

    public void setBecado(Becado becado) {
        this.becado = becado;
    }
    
    
    
}
