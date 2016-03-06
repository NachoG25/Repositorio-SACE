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
@Table (name="cuotas")
@NamedQueries({
    @NamedQuery(name = "cuotas.all", query= "Select c From Cuota c"),
    @NamedQuery(name = "cuota.by.becado", query= "Select c From Cuota c Where c.becado.apellido =:apellido")
})
public class Cuota implements Serializable {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private Double monto;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "fecha_de_pago")
    private Date fecha;
    
    @JoinColumn (name="id_becado", referencedColumnName="id")
    @ManyToOne
    Becado becado;

    public Cuota() {
    }

    public Cuota(Double monto, Date fecha, Becado becado) {
        this.monto = monto;
        this.fecha = fecha;
        this.becado = becado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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
