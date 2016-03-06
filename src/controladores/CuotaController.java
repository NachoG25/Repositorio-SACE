/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.List;
import modelo.Cuota;

/**
 *
 * @author matias
 */
public class CuotaController extends EntityController{
    
private static final String QUERY_GET_ALL_CUOTAS = "cuotas.all";
    private static final String QUERY_GET_CUOTAS_BY_BECADO = "cuota.by.becado";
    
    private static CuotaController cuotaController;
    
    private CuotaController(){}        
    
    public static CuotaController getInstance(){
        if(cuotaController == null){
            cuotaController = new CuotaController();
        }
        return cuotaController;
    }
    
    public void guardar(Cuota cuota) throws Exception{
        this.persist(cuota);
    }
    
    public List<Cuota> buscarCuotasPorNombre ( String apellido) throws Exception{
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("apellido", apellido);

        List<Cuota> results = this.executeNamedQuery(QUERY_GET_CUOTAS_BY_BECADO,param);
        

        if(results.size()> 0){
            return results;
        }else{
            throw new Exception("No se encontraron cuotas para : " + apellido);
        }
        
    }
    
    public List<Cuota> getAllCuotas (){
        List<Cuota> results = this.executeNamedQuery(QUERY_GET_ALL_CUOTAS);
        return results;
    }
    
}
