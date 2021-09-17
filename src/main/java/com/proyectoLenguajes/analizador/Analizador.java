package com.proyectoLenguajes.analizador;

import com.proyectoLenguajes.reportes.Errores;
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
    private final String Salto = "\n";
    private int posicion = 0;
    private int estadoActual;
    private Errores reporteErrores = new Errores();

    public Analizador(JTextArea cadena) {
        this.cadena = cadena;
    }

    public void anlaizar() {
        limpirText(this.cadena.getText());
        this.estadoActual = 0;
        char temporal;
        while (posicion < texto.length()) {
            temporal = texto.charAt(posicion);
            int estadoTemporal = getSiguienteEstado(estadoActual, alfabeto.alfabetoValueOf(temporal));
            System.out.println(estadoTemporal);
            reporteErrores.recopilador(temporal, estadoTemporal);
            this.estadoActual = estadoTemporal;
            if (!siguinteToken(temporal) || reiniciar(estadoActual)) {
                estadoActual = 0;
            }
            posicion++;
        }
        this.cadena.setText(this.cadena.getText());
    }

    private boolean reiniciar(int estadoActual) {
        boolean reiniciar = false;
        if (estadoActual == -1 || estadoActual == -2) {
            reiniciar = true;
        }
        return reiniciar;
    }

    private int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 5) {
            resultado = estados.getMatriz()[estadoActual][caracter];
        } else if (caracter == -2) {
            resultado = -2;
        } else if (caracter == -3) {
            resultado = -3;
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
            if (!salto) {
                texto += caracter;
            }
            if (salto && Character.isSpaceChar(caracter)) {
                salto = false;
            }

        }
        System.out.println(texto);
    }

    public Errores getReporteErrores() {
        return reporteErrores;
    } 
    

}
