package com.proyectoLenguajes.analizador;

import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class Alfabeto {

    ArrayList<Character> agrupacion;
    ArrayList<Character> operador;
    ArrayList<Character> puntuacion;

    public Alfabeto() {
        defAlfabeto();
    }

    private void defAlfabeto() {
        defAgrupacion();
        defOperador();
        defPuntuacion();
    }

    private void defOperador() {
        operador = new ArrayList<>();
        this.operador.add('+');
        this.operador.add('-');
        this.operador.add('*');
        this.operador.add('/');
        this.operador.add('%');
    }

    private void defPuntuacion() {
        puntuacion = new ArrayList<>();
        this.puntuacion.add('.');
        this.puntuacion.add(':');
        this.puntuacion.add(';');
        this.puntuacion.add(',');
    }

    private void defAgrupacion() {
        agrupacion = new ArrayList<>();
        this.agrupacion.add('(');
        this.agrupacion.add(')');
        this.agrupacion.add('{');
        this.agrupacion.add('}');
        this.agrupacion.add('[');
        this.agrupacion.add(']');

    }

    /**
     *
     * @param caracter a evaluar
     * @return -1 si no pretence al alfabeto o el valor correspondiente en la matriz
     */
    public int alfabetoValueOf(char caracter) {
        int valor = -1;
        if (Character.isLetter(caracter)) {
            valor = 0;
        } else if (Character.isDigit(caracter)) {
            valor = 1;
        } else if (Character.compare(caracter, puntuacion.get(0)) == 0) {
            valor = 2;
        } else if (agrupacion.contains(caracter)) {
            valor = 4;
        } else if (operador.contains(caracter)) {
            valor = 5;
        } else if (puntuacion.contains(caracter)) {
            valor = 3;
        }
        return valor;
    }

}
