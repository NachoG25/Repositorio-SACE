/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;


import java.util.Date;
import java.util.List;
import modelo.Establecimiento;
import servicios.ServicioBecado;
import servicios.ServicioCarrera;
import servicios.ServicioCuota;
import servicios.ServicioEstablecimiento;
import servicios.ServicioExamen;

/**
 *
 * @author matias
 */
public class SACE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
 //           ServicioBecado.getInstance().crearBecado("Matias", "Pruyas", "36259274", "matiaspruyas@outlook.com", "2342-571181", new Date(), "Analista en sistemas");
//            Establecimiento e =  ServicioEstablecimiento.getInstance().buscarEstablecimientoPorNombre("UNNOBA");
        ServicioCarrera.getInstance().crearCarrera("Licenciatura en administracion", 33, "UNNOBA", 20);
//        ServicioExamen.getInstance().crearExamen("Matematica discreta", true, 4.0, true, new Date(), "Matias");
//        ServicioCuota.getInstance().crearCuota(150D, new Date(), "Pruyas");
        } catch (Exception e){
            System.err.println(e.getStackTrace());
            System.err.println(e.getMessage());
        }
    }
    
}
