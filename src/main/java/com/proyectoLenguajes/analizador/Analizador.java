package com.proyectoLenguajes.analizador;

import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class Analizador {

    private final MatrizEstados estados = new MatrizEstados();
    private final Alfabeto alfabeto = new Alfabeto();
    private final JTextArea cadena;
    private String texto;
    private String Salto = "\n";
    private int posicion = 0;
    private int estadoActual;

    public Analizador(JTextArea cadena) {
        this.cadena = cadena;
    }

    public void anlaizar() {
        limpirText(this.cadena.getText());
        this.estadoActual = 0;
        char temporal;
        while (posicion < texto.length()) {
            temporal = texto.charAt(posicion);
            if (!siguinteToken(temporal) || reiniciar(estadoActual)) {
                estadoActual = 0;
            } else {
                int estadoTemporal = getSiguienteEstado(estadoActual, alfabeto.alfabetoValueOf(temporal));
                //proceso de reporte de error o de tokens 
                this.estadoActual = estadoTemporal;
            }
            posicion++;
        }
        this.cadena.setText(this.cadena.getText());
    }
    
    

    private boolean reiniciar(int estadoActual) {
        boolean reiniciar = false;
        if (estadoActual == -1) {
            reiniciar = true;
        }
        return reiniciar;
    }

    private int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 5) {
            resultado = estados.getMatriz()[estadoActual][caracter];
        }
        return resultado;
    }

    private boolean siguinteToken(char caracter) {
        boolean seguir = true;
        if (Character.isSpaceChar(caracter) || Character.compare(caracter, this.Salto.charAt(0)) == 0) {
            seguir = false;
        }
        return seguir;
    }

    /**
     * limpia el texto del JtextArea le quiera el numeral de linea y el punto
     *
     * @param cadena
     */
    private void limpirText(String cadena) {
        texto = "";
        boolean salto = false;
        for (char caracter : cadena.toCharArray()) {
            if (Character.compare(caracter, this.Salto.charAt(0)) == 0) {
                salto = true;
                texto += caracter;
            }
            if (salto && !Character.isDigit(caracter)) {
                if (!(Character.compare(caracter, '.') == 0)) {
                    texto += caracter;
                }
                salto = false;
            } else {
                if (!salto) {
                    texto += caracter;
                }
            }
        }
        System.out.println(texto);
    }

}
