
package com.proyectoLenguajes.analizador.funcionesSalida;

import com.proyectoLenguajes.analizador.Sintactico.Producciones;
import com.proyectoLenguajes.analizador.tablaSimbolos.TablaSimbolos;
import com.proyectoLenguajes.reportes.Tokens;

/**
 *
 * @author elvis_agui
 */
public class FuncionEscribir {
    
    private boolean recolectando = false;
    
    public void recolectarEscribir(Tokens token, Producciones produccion, TablaSimbolos tabla, Integer repiticiones){
        if (produccion.equals(Producciones.ESCRITURA) && token.getTipoToken().equalsIgnoreCase("ESCRIBIR")) {
            recolectando = true;
        }
        if (recolectando && (token.getTipoToken().equalsIgnoreCase("id") || token.getTipoToken().equalsIgnoreCase("Literal") || token.getTipoToken().equalsIgnoreCase("Numero"))) {
            switch(token.getTipoToken()){
                case "id":
                    RecolectorFunciones.textoSalida += tabla.valorEnSimbolo(token.getLexema());
                    break;
                case "Literal":
                    RecolectorFunciones.textoSalida += token.getLexema().replace("\"", "");
                    break;  
                default:
                    RecolectorFunciones.textoSalida += token.getLexema();
                    break;
            }
            RecolectorFunciones.textoSalida += "\n";
            recolectando = false;
        }
        
      
    }

    public boolean isRecolectando() {
        return recolectando;
    }

    public void setRecolectando(boolean recolectando) {
        this.recolectando = recolectando;
    }
    
    
   
    
    
    
    
    
    
    
}
