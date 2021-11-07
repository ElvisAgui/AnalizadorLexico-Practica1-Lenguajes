package com.proyectoLenguajes.analizador.tablaSimbolos;

import com.proyectoLenguajes.analizador.Sintactico.Producciones;
import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class TablaSimbolos {

    private ArrayList<Simbolo> simbolos = new ArrayList<>();
    private final ArrayList<Tokens> tokens = new ArrayList<>();
    private boolean recolctando = false;

    public void recolectarAsignacion(Producciones produccion, Tokens token) {
        if (produccion.equals(produccion.ASIGNACION) && token.getTipoToken().equalsIgnoreCase("id")) {
            recolctando = true;
        }
        if (recolctando) {
            if (token.getTipoToken().equalsIgnoreCase("FIN")) {
                calcularValorSimbolo();
                recolctando = false;
            } else {
                this.campturarSimbolo(token);
            }
        }
    }

    /**
     * captura el token de una asignacion
     *
     * @param token
     */
    private void campturarSimbolo(Tokens token) {
        this.tokens.add(token);
    }

    /**
     * calcula el valor del simbolo ingresado
     */
    public void calcularValorSimbolo() {
        ArrayList<String> valores = this.lexemasDeTokens();
        valores = this.operacionParentesis(valores);
        Simbolo simbolo = new Simbolo();
        simbolo.setNombre(this.tokens.get(0).getLexema());
        simbolo.setValor(Integer.parseInt(valores.get(0)));
        simbolos.add(simbolo);
        this.tokens.clear();

    }

    private ArrayList<String> operacionParentesis(ArrayList<String> valores) {
        if (valores.contains("(")) {
            while (valores.contains("(")) {
                int temI = 0;
                int temF = 0;
                ArrayList<String> aux = new ArrayList<>();
                for (int i = 0; i < valores.size(); i++) {
                    if (valores.get(i).equalsIgnoreCase("(")) {
                        temI = i;
                    }
                    System.out.println(valores.get(i));
                }
                for (int i = temI; i < valores.size(); i++) {
                    if (valores.get(i).equalsIgnoreCase(")")) {
                        temF = i;
                        break;
                    }
                }
                for (int i = temI + 1; i < temF; i++) {
                    aux.add(valores.get(i));
                }
                aux = operacionLinealMultiplicidad(aux);
                aux = operacionlinealSuma(aux);
                valores.set(temI, aux.get(0));
                valores = this.reasignar(valores, temI, temF);
            }
            valores = this.operacionLinealMultiplicidad(valores);
            valores = this.operacionlinealSuma(valores);
        } else {
            valores = this.operacionLinealMultiplicidad(valores);
            valores = this.operacionlinealSuma(valores);
        }

        return valores;
    }

    private ArrayList<String> reasignar(ArrayList<String> valores, int I, int F) {
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < I + 1; i++) {
            aux.add(valores.get(i));
        }
        for (int i = F + 1; i < valores.size(); i++) {
            aux.add(valores.get(i));
        }

        return aux;
    }

    private ArrayList<String> operacionLinealMultiplicidad(ArrayList<String> valores) {
        int producto = 0;
        while (valores.contains("*")) {
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i).equalsIgnoreCase("*")) {
                    producto = valorEnSimbolo(valores.get(i + 1)) * valorEnSimbolo(valores.get(i - 1));
                    valores.set(i, producto + "");
                    valores.remove(i + 1);
                    valores.remove(i - 1);
                    break;
                }

            }
        }

        return valores;
    }

    /**
     * suma de todos los valores pero linealmente es decir solo suma
     *
     * @param valores
     */
    private ArrayList<String> operacionlinealSuma(ArrayList<String> valores) {
        int suma = 0;
        for (String valore : valores) {
            suma += this.valorEnSimbolo(valore);
        }
        valores.clear();
        valores.add(suma + "");
        return valores;
    }

    public int valorEnSimbolo(String token) {
        int valor = 0;
        try {
            valor = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            for (Simbolo simbolo1 : simbolos) {
                if (simbolo1.getNombre().equals(token)) {
                    valor = simbolo1.getValor();
                    break;
                }
            }
        }

        return valor;
    }

    private ArrayList<String> lexemasDeTokens() {
        int index = 0;
        ArrayList<String> lexemas = new ArrayList<>();
        for (Tokens token : tokens) {
            if (!token.getLexema().equalsIgnoreCase("=") && index != 0) {
                lexemas.add(token.getLexema());
            }
            index++;
        }

        return lexemas;
    }

    public ArrayList<Simbolo> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

}
