package com.proyectoLenguajes.analizador.funcionesSalida;

import com.proyectoLenguajes.analizador.Sintactico.Producciones;
import com.proyectoLenguajes.analizador.tablaSimbolos.TablaSimbolos;
import com.proyectoLenguajes.reportes.Tokens;

/**
 *
 * @author elvis_agui
 */
public class RecolectorFunciones {

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final FuncionesSalida recolector = new FuncionesSalida();
    
   

    public void recolectorFucionesSalida(Producciones produccion, Tokens token) {
        tabla.recolectarAsignacion(produccion, token);
        this.recolector.recolectar(token.getTipoToken(), token, tabla);
        
    }

    public TablaSimbolos getTabla() {
        return tabla;
    }

    public FuncionesSalida getRecolector() {
        return recolector;
    }
    
    
    

   
}
