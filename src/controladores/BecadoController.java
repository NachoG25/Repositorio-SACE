/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.List;
import modelo.Becado;

/**
 *
 * @author matias
 */
public class BecadoController extends EntityController {
    
    private static final String QUERY_GET_ALL_BECADOS = "becado.all";
    private static final String QUERY_GET_BECADO_BY_NAME = "becado.by.name";
    private static BecadoController becadoController;
    
    private BecadoController(){}
    
    public static BecadoController getInstance(){
        if(becadoController == null){
            becadoController = new BecadoController();
        }
        return becadoController;
    }
    
    public void guardar(Becado becado) throws Exception{
        this.persist(becado);
    }
    
    public Becado buscarBecadoPorNombre ( String apellido) throws Exception{
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("apellido", apellido);

        List<Becado> results = this.executeNamedQuery(QUERY_GET_BECADO_BY_NAME,param);
        
        if(results.size()> 0){
            return results.get(0);
        }else{
            throw new Exception("No se encontro la becado : " + apellido);
        }
        
    }
    
    public List<Becado> getAllBecados (){
        List<Becado> results = this.executeNamedQuery(QUERY_GET_ALL_BECADOS);
        return results;
    }
    
}