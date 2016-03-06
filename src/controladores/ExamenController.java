/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.List;
import modelo.Examen;

/**
 *
 * @author matias
 */
public class ExamenController extends EntityController{
    private static final String QUERY_GET_ALL_EXAMENES = "examen.all";
    private static final String QUERY_GET_EXAMEN_BY_BECADO = "examen.by.becado";
    
    private static ExamenController examenController;
    
    private ExamenController(){}        
    
    public static ExamenController getInstance(){
        if(examenController == null){
            examenController = new ExamenController();
        }
        return examenController;
    }
    
    public void guardar(Examen examen) throws Exception{
        this.persist(examen);
    }
    
    public List<Examen> buscarExamenesPorNombre ( String nombre) throws Exception{
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("nombre", nombre);

        List<Examen> results = this.executeNamedQuery(QUERY_GET_EXAMEN_BY_BECADO,param);
        

        if(results.size()> 0){
            return results;
        }else{
            throw new Exception("No se encontro la examen : " + nombre);
        }
        
    }
    
    public List<Examen> getAllExamens (){
        List<Examen> results = this.executeNamedQuery(QUERY_GET_ALL_EXAMENES);
        return results;
    }
    
}