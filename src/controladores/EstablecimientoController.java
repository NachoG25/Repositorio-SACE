/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.List;
import modelo.Establecimiento;

/**
 *
 * @author matias
 */
public class EstablecimientoController extends EntityController {
    private static final String QUERY_GET_ALL_ESTABLECIMIENTOS = "establecimiento.all";
    private static final String QUERY_GET_ESTABLECIMIENTO_BY_NAME = "establecimiento.by.name";
    
    private static EstablecimientoController establecimientoController;
    
    private EstablecimientoController(){}
    
    public static EstablecimientoController getInstance(){
        if(establecimientoController == null){
            establecimientoController = new EstablecimientoController();
        }
        return establecimientoController;
    }
    
    public void guardar(Establecimiento establecimiento) throws Exception{
        this.persist(establecimiento);
    }
    
    public Establecimiento buscarEstablecimientoPorNombre ( String nombre) throws Exception{
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("nombre", nombre);

        List<Establecimiento> results = this.executeNamedQuery(QUERY_GET_ESTABLECIMIENTO_BY_NAME,param);
        
        if(results.size()> 0){
            return results.get(0);
        }else{
            throw new Exception("No se encontro el establecimiento : " + nombre);
        }
        
    }

    public List<Establecimiento> getAllEstablecimientos() {
        return this.executeNamedQuery(QUERY_GET_ALL_ESTABLECIMIENTOS);
    }
    
}
