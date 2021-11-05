package com.proyectoLenguajes.analizador.erroresSintacticos;

import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class ErroresSintacticos {

    private final ArrayList<Tokens> Tokens = new ArrayList<>();

    
    public void camputrarErrorSintactico(Tokens token, String descipcion){
        token.setDescripcion(descipcion);
        this.Tokens.add(token);
        
    }
    
    public void enlistarErrores(JTextArea area){
        area.setText("");
        for (Tokens Token : Tokens) {
            area.append("ERROR SINTACTICO LEXEMA: "+ Token.getLexema());
            area.append("  POSICION Fila , Columna "+ Token.getFila()+", "+ Token.getColumna()+"\n");
            area.append("DESCRIPCION "+ Token.getDescripcion()+"\n\n");
        }
    }
    
}
