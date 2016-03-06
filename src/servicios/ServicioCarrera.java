/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.CarreraController;
import controladores.EstablecimientoController;
import java.util.ArrayList;
import java.util.List;
import modelo.Carrera;
import modelo.Establecimiento;
import ov.CarreraOV;

/**
 *
 * @author matias
 */
public class ServicioCarrera {
    private static ServicioCarrera servicioCarrera;
    
    private ServicioCarrera(){}
    
    public static ServicioCarrera getInstance(){
        if(servicioCarrera == null){
            servicioCarrera = new ServicioCarrera();
        }
        return servicioCarrera;
    }
    
    public void crearCarrera(String nombre, int cantidad_materias, String nombreEstablecimiento,int ponderacion ) throws Exception{
        
        Establecimiento e = ServicioEstablecimiento.getInstance().buscarEstablecimientoPorNombre(nombreEstablecimiento);
        
        Carrera c = new Carrera(nombre, cantidad_materias, e, ponderacion);
        CarreraController.getInstance().guardar(c);
        
    }
    
    public Carrera buscarCarreraPorNombre ( String nombre) throws Exception {
        return CarreraController.getInstance().buscarCarreraPorNombre(nombre);
    }
    
    public List<CarreraOV> buscarCarrerasPorEstablecimiento ( String nombre) throws Exception {
        
        List<Carrera> carreras = new ArrayList<>();
        List<CarreraOV> carrerasOV = new ArrayList<>();
        
        carreras = CarreraController.getInstance().buscarCarrerasPorEstablecimiento(nombre);
        
        for (Carrera carrera : carreras) {
            carrerasOV.add(new CarreraOV (carrera));
        }
        
        return carrerasOV;
    }

    public List<CarreraOV> getAllCarreras() {
        List<Carrera> carreras = new ArrayList<>();
        List<CarreraOV> carrerasOV = new ArrayList<>();
        
        carreras = CarreraController.getInstance().getAllCarreras();
        
        for (Carrera carrera : carreras) {
            carrerasOV.add(new CarreraOV (carrera));
        }
        
        return carrerasOV;
    }
}