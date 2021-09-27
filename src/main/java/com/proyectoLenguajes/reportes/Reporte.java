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
                if (this.contador == lengt-1) {
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

    private String nombreToken(int estado) {
        String token = "";
        switch (estado) {
            case 1:
                token = listaToken.get(0);
                break;
            case 2:
                token = listaToken.get(0);
                break;
            case 3:
                token = listaToken.get(1);
                break;
            case 4:
                token = listaToken.get(4);
                break;
            case 5:
                token = listaToken.get(2);
                break;
            case 6:
                token = listaToken.get(4);
                break;
            case 7:
                token = listaToken.get(3);
                break;
            case 8:
                token = listaToken.get(5);
                break;
            default:
                token = "error";
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
    }

}
