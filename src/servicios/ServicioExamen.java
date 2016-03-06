/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.ExamenController;
import java.util.Date;
import java.util.List;
import modelo.Becado;
import modelo.Examen;

/**
 *
 * @author matias
 */
public class ServicioExamen {
    private static ServicioExamen servicioExamen;
    
    private ServicioExamen(){}
    
    public static ServicioExamen getInstance(){
        if(servicioExamen == null){
            servicioExamen = new ServicioExamen();
        }
        return servicioExamen;
    }
    
    public void crearExamen(String materia, boolean isFinal, Double nota, boolean aprobo, Date fecha, String apellido) throws Exception{
        
        Becado b = ServicioBecado.getInstance().buscarBecadoPorNombre(apellido);
        Examen e = new Examen(materia, isFinal, nota, aprobo, fecha, b);
        ExamenController.getInstance().guardar(e);
        
    }
    
    public List<Examen> buscarExamenPorNombre ( String nombre) throws Exception {
        return ExamenController.getInstance().buscarExamenesPorNombre(nombre);
    }
}

