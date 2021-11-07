package com.proyectoLenguajes.analizador.tablaSimbolos;

/**
 *
 * @author elvis_agui
 */
public class Simbolo {

    private int valor;
    private String nombre;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Simbolo{" + "valor=" + valor + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
