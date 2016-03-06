/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.EntityController;
import controladores.EstablecimientoController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.Establecimiento;
import ov.EstablecimientoOV;

/**
 *
 * @author matias
 */
public class ServicioEstablecimiento extends EntityController{
    
     
    
    private static ServicioEstablecimiento servicioEstablecimiento;
    
    private ServicioEstablecimiento(){}
    
    public static ServicioEstablecimiento getInstance(){
        if(servicioEstablecimiento == null){
            servicioEstablecimiento = new ServicioEstablecimiento();
        }
        return servicioEstablecimiento;
    }
    
    public void crearEstablecimiento(String nombre, String direccion) throws Exception{
        
        Establecimiento e = new Establecimiento(nombre, direccion);
        EstablecimientoController.getInstance().guardar(e);
        
    }
    
    public Establecimiento buscarEstablecimientoPorNombre ( String nombre) throws Exception {
        return EstablecimientoController.getInstance().buscarEstablecimientoPorNombre(nombre);
    }
    
    public List<EstablecimientoOV> getAllEstablecimientos(){
        List<Establecimiento> establecimientos = new ArrayList<>();
        List<EstablecimientoOV> establecimientosOV = new ArrayList<>();
        
        establecimientos = EstablecimientoController.getInstance().getAllEstablecimientos();
        
        for (Establecimiento establecimiento : establecimientos) {
            establecimientosOV.add(new EstablecimientoOV(establecimiento));
        }
        
        return establecimientosOV;
    }
}