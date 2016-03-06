/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.BecadoController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Becado;
import modelo.Carrera;
import ov.BecadoOV;

/**
 *
 * @author matias
 */
public class ServicioBecado {
    
    private static ServicioBecado servicioBecado;
    
    private ServicioBecado(){}
    
    public static ServicioBecado getInstance(){
        if(servicioBecado == null){
            servicioBecado = new ServicioBecado();
        }
        return servicioBecado;
    }
    
    public void crearBecado(String nombre, String apellido, String dni, String email, String telefono, Date fechaDeNacimiento, String carrera) throws Exception{
        
        Carrera c = ServicioCarrera.getInstance().buscarCarreraPorNombre(carrera);
        
        Becado b = new Becado(nombre, apellido, dni, email, telefono, fechaDeNacimiento, c);
        BecadoController.getInstance().guardar(b);
        
    }
    
    public Becado buscarBecadoPorNombre ( String nombre) throws Exception {
        return BecadoController.getInstance().buscarBecadoPorNombre(nombre);
    }
    
    public List<BecadoOV> getAllBecados(){
        List<Becado> becados = new ArrayList<>();
        List<BecadoOV> becadosOV = new ArrayList<>();
        
        becados = BecadoController.getInstance().getAllBecados();
        
        for (Becado becado : becados) {
            becadosOV.add(new BecadoOV(becado));
        }
        return becadosOV;
    }
}

