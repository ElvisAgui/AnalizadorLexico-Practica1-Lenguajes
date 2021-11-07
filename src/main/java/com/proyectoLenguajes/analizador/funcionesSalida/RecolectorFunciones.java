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
    private final FuncionEscribir escribir = new FuncionEscribir();
    public static String textoSalida = "";
    private boolean esRepetir = false;
    private Integer numRepticiones = null;
    private boolean esCondicion = false;
    private boolean valordeCondicion = false;

    public void recolectorFucionesSalida(Producciones produccion, Tokens token) {
        tabla.recolectarAsignacion(produccion, token);
        if (produccion.equals(Producciones.REPETIR) && token.getTipoToken().equalsIgnoreCase("REPETIR")) {
            numRepticiones = null;
            esRepetir = true;
        } else if (esRepetir && produccion.equals(Producciones.REPETIR) && !token.getTipoToken().equalsIgnoreCase("REPETIR")) {
            esRepetir = false;
        }
        if (esRepetir && numRepticiones == null && (token.getTipoToken().equalsIgnoreCase("id") || token.getTipoToken().equalsIgnoreCase("Numero"))) {
            numRepticiones = tabla.valorEnSimbolo(token.getLexema());
        }
        if (esRepetir && numRepticiones != null && 0 < numRepticiones) {
            int iterador = 0;
            while (iterador < numRepticiones) {
                escribir.recolectarEscribir(token, produccion, tabla, numRepticiones);
                iterador++;
            }
        }
        if (produccion.equals(Producciones.CONDICINAL) && token.getTipoToken().equalsIgnoreCase("SI")) {
            esCondicion = true;
        } else if (produccion.equals(Producciones.CONDICINAL) && !token.getTipoToken().equalsIgnoreCase("SI")) {
            esRepetir = false;
        }
        if (esCondicion && (token.getTipoToken().equalsIgnoreCase("VERDADERO"))) {
            valordeCondicion = true;
        }
        if (esCondicion && valordeCondicion) {
            escribir.recolectarEscribir(token, produccion, tabla, numRepticiones);
        }
        if (!esRepetir && !esCondicion) {
            escribir.recolectarEscribir(token, produccion, tabla, 1);
        }
    }

   
}
