package com.proyectoLenguajes.reportes;

/**
 *
 * @author elvis_agui
 */
public enum Token {

    IDENTIFICADOR("Identificador", 0),
    ENTERO("Numero Entero", 0),
    DECIMAL("Numero Decimal", 0),
    PUNTUACION("Signo Puntuacion", 0),
    AGRUPACION("Signo Agrupacion", 0),
    OPERADOR("Operador", 0);

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad == 0) {
            this.cantidad = 0;
        } else {
            this.cantidad += cantidad;
        }
    }
    private String token;
    private int cantidad;

    private Token(String token, int cantidad) {
        this.token = token;
        this.cantidad = cantidad;

    }

}
