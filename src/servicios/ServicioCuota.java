/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.CuotaController;
import java.util.Date;
import java.util.List;
import modelo.Becado;
import modelo.Cuota;

/**
 *
 * @author matias
 */
public class ServicioCuota {
    
    private static ServicioCuota servicioCuota;
    
    private ServicioCuota(){}
    
    public static ServicioCuota getInstance(){
        if(servicioCuota == null){
            servicioCuota = new ServicioCuota();
        }
        return servicioCuota;
    }
    
    public void crearCuota(Double monto, Date fecha, String apellido) throws Exception{
        
        Becado b = ServicioBecado.getInstance().buscarBecadoPorNombre(apellido);
        Cuota c = new Cuota(monto, fecha, b);
        CuotaController.getInstance().guardar(c);
        
    }
    
    public List<Cuota> buscarCuotaPorNombre ( String apellido) throws Exception {
        return CuotaController.getInstance().buscarCuotasPorNombre(apellido);
    }
}