package com.proyectoLenguajes.analizador.Sintactico;

import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class AnalizadorSintactico {

    private final Pila pila = new Pila();
    private MatrizProducciones matriz = new MatrizProducciones();
    private Producciones produccion;
    private AlfabetoTerminal alfabeto = new AlfabetoTerminal();
    private Tokens token;
    private ArrayList<Tokens> Tokens = new ArrayList<>();

    ;

    public void analizar(ArrayList<Tokens> Tokens) {
        this.Tokens = Tokens;
        int index = 0;
        while (!this.pila.getPila().empty() && index < this.Tokens.size()) {
            System.out.println("entre a anlizar");
            if (this.token == null) {
                this.token = this.Tokens.get(index);
                System.out.println("Asignando nuevo token "+this.token.getTipoToken());
                index++;
            }
            while (comprobar(this.pila.getPila().peek())) {
                System.out.println("valor de pila en producciones "+this.pila.getPila().peek());
                this.produccion = (Producciones) this.pila.getPila().peek();
                String valorMatriz = this.matriz.getMatriz()[this.alfabeto.getEstado(produccion)][this.alfabeto.getValorTernminal(this.token.getTipoToken())];
                System.out.println("valor de matriz a apilar "+valorMatriz);
                this.pila.Apilar(valorMatriz, this.token.getTipoToken());

            }
            if (!comprobar(this.pila.getPila().peek())) {
                System.out.println("valor de pila en terminal "+this.pila.getPila().peek());
                if (token.getTipoToken().equalsIgnoreCase((String) this.pila.getPila().peek())) {
                    this.pila.getPila().pop();
                    this.token = null;
                }
            }

        }

        System.out.println("todo termino xd");
    }

    public ArrayList<Tokens> getTokens() {
        return Tokens;
    }

    public void setTokens(ArrayList<Tokens> Tokens) {
        this.Tokens = Tokens;
    }

    private boolean comprobar(Object ob) {
        boolean esEnum = false;
        Producciones[] pro = Producciones.values();
        for (Producciones producciones : pro) {
            esEnum = producciones.equals(ob);
            if (esEnum) {
                break;
            }
        }

        return esEnum;
    }

}
