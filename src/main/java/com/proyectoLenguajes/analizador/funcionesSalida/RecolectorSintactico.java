/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoLenguajes.analizador.funcionesSalida;

import com.proyectoLenguajes.analizador.tablaSimbolos.TablaSimbolos;
import com.proyectoLenguajes.reportes.Tokens;

import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class RecolectorSintactico {

    private String tokenGuia;
    private String cadea;
    private String documento;
    private boolean error = false;
    private ArrayList<String> cadenas = new ArrayList<>();
    private int ciclo;
    private String iniciarR;
    private String tokenSubGUIA;
    private String tokenACCION;

    public void recolectar(String tipoToken, Tokens token, TablaSimbolos tabla) {
        if (!tipoToken.equals("ERROR")) {
            if (tokenGuia == null) {
                if (tipoToken.equals("ESCRIBIR")) {
                    tokenGuia = tipoToken;
                } else if (tipoToken.equals("REPETIR")) {
                    tokenGuia = tipoToken;
                } else if (tipoToken.equals("SI")) {
                    tokenGuia = tipoToken;
                }

            } else {
                if (tokenGuia.equals("ESCRIBIR")) {
                    if (tipoToken.equals("FIN")) {
                        documento += "\n" + cadea;
                        tokenGuia = null;
                        cadea = null;
                    } else {
                        cadea = quitarComillas(token, tabla);
                    }
                } else if (tokenGuia.equals("REPETIR")) {
                    if (tipoToken.equals("Numero") || tipoToken.equals("id")) {
                        ciclo = tabla.valorEnSimbolo(token.getLexema());
                    }
                    if (tipoToken.equals("INICIAR")) {
                        iniciarR = "INICIAR";
                    }

                    if (iniciarR != null && tipoToken.equals("ESCRIBIR")) {
                        tokenACCION = "ESCRIBIR";
                    }

                    if (tipoToken.equals("Literal")) {
                        //  cadea = token.getLexema();
                        cadenas.add(quitarComillas(token, tabla));
                    }
                    //X
                    if (tipoToken.equals("FIN") && tokenACCION != null) {
                        tokenACCION = null;
                    } else if (tipoToken.equals("FIN") && tokenACCION == null) {

                        impirmirCiclo();
                        // System.out.println("CONDICION : " + cadea);
                        //documento += cadea;
                        cadenas.clear();
                        cadea = null;
                        tokenGuia = null;
                        tokenACCION = null;
                        tokenSubGUIA = null;
                    }

                } else if (tokenGuia.equals("SI")) {
                    if (tipoToken.equals("VERDADERO")) {
                        tokenSubGUIA = "VERDADERO";
                    }
                    if (tipoToken.equals("FALSO")) {
                        tokenSubGUIA = "FALSO";
                    }
                    if (tipoToken.equals("ESCRIBIR")) {
                        tokenACCION = "ESCRIBIR";
                    }
                    if (tipoToken.equals("Numero") || tipoToken.equals("Literal")) {
                        cadea = quitarComillas(token, tabla);
                    }
                    if (tipoToken.equals("FIN") && tokenACCION != null) {
                        tokenACCION = null;
                    } else if (tipoToken.equals("FIN") && tokenACCION == null) {
                        if (tokenSubGUIA.equals("VERDADERO")) {
                            documento += "\n" + cadea;
                        } 

                        cadea = null;
                        tokenGuia = null;
                        tokenACCION = null;
                        tokenSubGUIA = null;
                    }

                }

            }

        } else {
            error = true;
        }

//        if (tipoToken.equals("FINALIZAR")) {
//            if (error == false) {
//                System.out.println("ENTRO  A FINALIZAR");
//                archivoSalida();
//            }
//        }
    }

    public void impirmirCiclo() {
        for (int i = 0; i < ciclo; i++) {

            for (int j = 0; j < cadenas.size(); j++) {
                documento += "\n" + cadenas.get(j);
                System.out.println("REPETIR: " + cadenas.get(j));

            }

        }

    }

    public String quitarComillas(Tokens token, TablaSimbolos tabla) {
        String salida = "";
        switch (token.getTipoToken()) {
            case "id":
                salida += tabla.valorEnSimbolo(token.getLexema());
                break;
            case "Literal":
                salida += token.getLexema().replace("\"", "");
                break;
            default:
                salida += token.getLexema();
                break;
        }

        return salida;
    }

    public String getDocumento() {
        return documento;
    }

}
