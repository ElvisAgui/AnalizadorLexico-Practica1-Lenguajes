package com.proyectoLenguajes.reportes;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elvis_agui
 */
public class Reporte {

    private ArrayList<String> listaToken = new ArrayList<>();
    private ArrayList<String> Tokens = new ArrayList<>();
    private ArrayList<String> listaLexema = new ArrayList<>();
    private ArrayList<Integer> listaColumna = new ArrayList<>();
    private ArrayList<Integer> listaFila = new ArrayList<>();
    private ArrayList<Token> listaContadorToken = new ArrayList<>();
    private String lexema = "";
    private int fila = 1;
    private int columna = 0;
    private JTable tabla;
    private int estadoAnterio = 0;
    private int contador = 0;

    public Reporte() {
        this.listarTokens();
    }

    public void enlistarReporte(JTable tabla) {
        this.tabla = tabla;
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        modelo.addColumn("NOMBRE TOKEN");
        modelo.addColumn("LEXEMA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");
        for (String cadena : this.listaLexema) {
            modelo.addRow(new Object[]{this.Tokens.get(index), cadena, this.listaFila.get(index), this.listaColumna.get(index)});
            index++;
        }
    }

    public void recopilarReporte(char caracter, int estado, int lengt) {
        switch (estado) {
            case -3:
                if (!"".equals(lexema)) {
                    this.listaLexema.add(lexema);
                    this.Tokens.add(nombreToken(estado));
                    this.listaColumna.add(columna);
                    this.listaFila.add(fila);
                }
                this.fila++;
                this.columna = 0;
                this.lexema = "";
                break;
            case -2:
                if (!"".equals(lexema)) {
                    this.listaLexema.add(lexema);
                    this.Tokens.add(nombreToken(this.estadoAnterio));
                    this.listaColumna.add(columna);
                    this.listaFila.add(fila);
                }
                this.columna++;
                this.lexema = "";
                break;
            default:
                this.columna++;
                this.lexema += "" + caracter;
                if (this.contador == lengt - 1) {
                    this.listaLexema.add(lexema);
                    this.Tokens.add(nombreToken(estado));
                    this.listaColumna.add(columna);
                    this.listaFila.add(fila);
                }

                break;
        }
        this.contador++;
        this.estadoAnterio = estado;
    }

    public void recuento(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("NOMBRE TOKEN");
        modelo.addColumn("CANTIDAD");
        for (Token token : listaContadorToken) {
            modelo.addRow(new Object[]{token.getToken(), token.getCantidad()});
        }
    }

    public void recuentoLexena(JTable tabla) {
        ArrayList<Integer> listaCantidad = new ArrayList<>();
        ArrayList<String> lexemasx = new ArrayList<>();
        for (String lexema : listaLexema) {
            if (!lexemasx.contains(lexema)) {
                for (String aux : listaLexema) {
                    if (lexema.equals(aux)) {
                        if (lexemasx.contains(lexema)) {
                            int index = lexemasx.indexOf(lexema);
                            int tem = listaCantidad.get(index)+1;
                            listaCantidad.add(index,tem);
                        } else {
                            lexemasx.add(lexema);
                            listaCantidad.add(1);
                        }
                    }
                }
            }

        }
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("LEXEMA");
        modelo.addColumn("CANTIDAD");
        for (String lexema : lexemasx) {
            modelo.addRow(new Object[]{lexema, listaCantidad.get(index)});
            index++;
        }

    }

    public void limpiar() {
        for (Token token : listaContadorToken) {
            token.setCantidad(0);
        }
    }

    private String nombreToken(int estado) {
        String token = "";
        switch (estado) {
            case 1:
                token = listaToken.get(0);
                this.listaContadorToken.get(0).setCantidad(1);
                break;
            case 2:
                token = listaToken.get(0);
                this.listaContadorToken.get(0).setCantidad(1);
                break;
            case 3:
                token = listaToken.get(1);
                this.listaContadorToken.get(1).setCantidad(1);
                break;
            case 4:
                token = listaToken.get(4);
                this.listaContadorToken.get(4).setCantidad(1);
                break;
            case 5:
                token = listaToken.get(2);
                this.listaContadorToken.get(2).setCantidad(1);
                break;
            case 6:
                token = listaToken.get(4);
                this.listaContadorToken.get(4).setCantidad(1);
                break;
            case 7:
                token = listaToken.get(3);
                this.listaContadorToken.get(3).setCantidad(1);
                break;
            case 8:
                token = listaToken.get(5);
                this.listaContadorToken.get(5).setCantidad(1);
                break;
            default:
                token = listaToken.get(0);
                break;
        }

        return token;
    }

    /**
     * nombre de los token a identificar
     */
    private void listarTokens() {
        this.listaToken.add("Identificador");
        this.listaToken.add("Numero Entero");
        this.listaToken.add("Numero Decimal");
        this.listaToken.add("Signo Agrupacion");
        this.listaToken.add("Signo Puntuacion");
        this.listaToken.add("Operador");
        this.listaContadorToken.add(Token.IDENTIFICADOR);
        this.listaContadorToken.add(Token.ENTERO);
        this.listaContadorToken.add(Token.DECIMAL);
        this.listaContadorToken.add(Token.AGRUPACION);
        this.listaContadorToken.add(Token.PUNTUACION);
        this.listaContadorToken.add(Token.OPERADOR);

    }

}
