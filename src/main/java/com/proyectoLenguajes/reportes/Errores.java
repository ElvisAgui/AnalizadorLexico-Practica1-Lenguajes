package com.proyectoLenguajes.reportes;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elvis_agui
 */
public class Errores {

    private ArrayList<String> cadena = new ArrayList<>();
    private ArrayList<Character> caracter = new ArrayList<>();
    private ArrayList<Integer> fila = new ArrayList<>();
    private ArrayList<Integer> columna = new ArrayList<>();
    private int filaActual = 0;
    private int columnaActual = 0;
    private JTable tabla;
    private String cadenaActual = "";

    public void enlistarErrores(JTable tabla) {
        this.tabla = tabla;
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        modelo.addColumn("SIMBOLO");
        modelo.addColumn("CADENA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");
        for (String cadena : cadena) {
            modelo.addRow(new Object[]{this.caracter.get(index), cadena, this.fila.get(index), this.columna.get(index)});
            index++;
        }
    }

    public void recopilador(char Caracter, int estado) {
        if (estado == -3) {
            this.filaActual++;
            this.columnaActual = 0;
        } else {
            if (estado == -1) {
                this.columnaActual++;
                this.cadenaActual += Caracter;
                this.caracter.add(Caracter);
                this.cadena.add(cadenaActual);
                this.fila.add(this.filaActual);
                this.columna.add(this.columnaActual);
                this.cadenaActual = "";
            } else {
                this.columnaActual++;
                if (estado == -2) {
                    this.cadenaActual = "";
                } else {
                    this.cadenaActual += Caracter;
                }

            }
        }

    }

    public ArrayList<String> getCadena() {
        return cadena;
    }

    public void setCadena(ArrayList<String> cadena) {
        this.cadena = cadena;
    }

    public ArrayList<Character> getCaracter() {
        return caracter;
    }

    public void setCaracter(ArrayList<Character> caracter) {
        this.caracter = caracter;
    }

    public ArrayList<Integer> getFila() {
        return fila;
    }

    public void setFila(ArrayList<Integer> fila) {
        this.fila = fila;
    }

    public ArrayList<Integer> getColumna() {
        return columna;
    }

    public void setColumna(ArrayList<Integer> columna) {
        this.columna = columna;
    }

    public int getFilaActual() {
        return filaActual;
    }

    public void setFilaActual(int filaActual) {
        this.filaActual = filaActual;
    }

    public int getColumnaActual() {
        return columnaActual;
    }

    public void setColumnaActual(int columnaActual) {
        this.columnaActual = columnaActual;
    }

}
