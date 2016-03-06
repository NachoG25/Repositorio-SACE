/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.List;
import modelo.Carrera;

/**
 *
 * @author matias
 */
public class CarreraController extends EntityController {
    
    private static final String QUERY_GET_ALL_CARRERAS = "carrera.all";
    private static final String QUERY_GET_CARRERA_BY_NAME = "carrera.by.name";
    private static final String QUERY_GET_CARRERA_BY_ESTABLECIMIENTO = "carrera.by.establecimiento";
    
    private static CarreraController carreraController;
    
    private CarreraController(){}
    
    public static CarreraController getInstance(){
        if(carreraController == null){
            carreraController = new CarreraController();
        }
        return carreraController;
    }
    
    public void guardar(Carrera carrera) throws Exception{
        this.persist(carrera);
    }
    
    public Carrera buscarCarreraPorNombre ( String nombre) throws Exception{
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("nombre", nombre);

        List<Carrera> results = this.executeNamedQuery(QUERY_GET_CARRERA_BY_NAME,param);
        
        if(results.size()> 0){
            return results.get(0);
        }else{
            throw new Exception("No se encontro la carrera : " + nombre);
        }
        
    }

    public List<Carrera> getAllCarreras() {
        return this.executeNamedQuery(QUERY_GET_ALL_CARRERAS);
    }

    public List<Carrera> buscarCarrerasPorEstablecimiento(String nombre) throws Exception {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("nombre", nombre);

        List<Carrera> results = this.executeNamedQuery(QUERY_GET_CARRERA_BY_ESTABLECIMIENTO,param);
        
        if(results.size()> 0){
            return results;
        }else{
            throw new Exception("No se encontro la carrera : " + nombre);
        }
        
    }
    
    
}
