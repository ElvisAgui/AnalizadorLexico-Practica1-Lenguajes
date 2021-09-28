package com.proyectoLenguajes.analizador;

import com.proyectoLenguajes.reportes.Errores;
import com.proyectoLenguajes.reportes.Reporte;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class Analizador {

    private final MatrizEstados estados = new MatrizEstados();
    private ArrayList<String> movimientos = new ArrayList<>();
    private ArrayList<String> lexemas = new ArrayList<>();
    private final Alfabeto alfabeto = new Alfabeto();
    private final JTextArea cadena;
    private String texto;
    private final String Salto = "\n";
    private int posicion = 0;
    private int estadoActual;
    private String palabra = "";
    private Errores reporteErrores = new Errores();
    private Reporte reporte = new Reporte();

    public Analizador(JTextArea cadena) {
        this.cadena = cadena;
    }

    public void anlaizar() {
        this.lexemas.clear();
        this.movimientos.clear();
        this.reporte.limpiar();
        texto = cadena.getText();
        this.estadoActual = 0;
        char temporal;
        while (posicion < texto.length()) {
            temporal = texto.charAt(posicion);
            int estadoTemporal = getSiguienteEstado(estadoActual, alfabeto.alfabetoValueOf(temporal));
            reporteErrores.recopilador(temporal, estadoTemporal);
            this.reporte.recopilarReporte(temporal, estadoTemporal, texto.length());
            movimientos(estadoActual, estadoTemporal, temporal);
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
        if (estadoActual == -1 || estadoActual == -2 || estadoActual == -3) {
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

    private void movimientos(int estadoAnterio, int estadoActual, char caracter) {
        String movimiento = "Me movi del estado " + estadoAnterio + " al estado " + estadoActual + " con el caracter " + caracter;
        if (estadoActual >= 0 && estadoAnterio >= 0) {
            this.palabra += caracter;
            this.movimientos.add(movimiento);
        } else {
            if (estadoActual == -2 || estadoActual == -3 || posicion == texto.length() - 1) {
                if (!"".equals(palabra)) {
                    this.lexemas.add(palabra);
                    this.lexemas.add("salto");
                }
            }
            this.palabra = "";
        }

    }

    public void listarMovimientos(JTextArea area) {
        int index = 0;
        for (String lexema : lexemas) {
            if (!lexema.equals("salto")) {
                area.append(lexema+"\n");
                for (int i = 0; i < lexema.length(); i++) {
                    area.append(movimientos.get(index)+"\n");
                    index++;
                }
                area.append("\n");
            }
        }
    }

    public Errores getReporteErrores() {
        return reporteErrores;
    }

    public Reporte getReporte() {
        return reporte;
    }

}
