
package com.proyectoLenguajes.analizador;

/**
 *
 * @author elvis_agui
 */
public class MatrizEstados {
    private int matriz[][] = new int[9][6];
    
    public MatrizEstados(){
        definicionEstados();
        iniciar();
    }
    
    private void definicionEstados(){
        this.matriz[0][0] = 1;
        this.matriz[0][1] = 3;
        this.matriz[0][2] = 6;
        this.matriz[0][3] = 6;
        this.matriz[0][4] = 7;
        this.matriz[0][5] = 8;
        this.matriz[1][0] = 1;
        this.matriz[1][1] = 2;
        this.matriz[1][2] = -1;
        this.matriz[1][3] = -1;
        this.matriz[1][4] = -1;
        this.matriz[1][5] = -1;
        this.matriz[2][0] = 1;
        this.matriz[2][1] = 2;
        this.matriz[2][2] = -1;
        this.matriz[2][3] = -1;
        this.matriz[2][4] = -1;
        this.matriz[2][5] = -1;
        this.matriz[3][0] = -1;
        this.matriz[3][1] = 3;
        this.matriz[3][2] = 4;
        this.matriz[3][3] = -1;
        this.matriz[3][4] = -1;
        this.matriz[3][5] = -1;
        this.matriz[4][0] = -1;
        this.matriz[4][1] = 5;
        this.matriz[4][2] = -1;
        this.matriz[4][3] = -1;
        this.matriz[4][4] = -1;
        this.matriz[4][5] = -1;
        this.matriz[5][0] = -1;
        this.matriz[5][1] = 5;
        this.matriz[5][2] = -1;
        this.matriz[5][3] = -1;
        this.matriz[5][4] = -1;
        this.matriz[5][5] = -1;
        
    }
    
    private void iniciar(){
        for (int i = 6; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = -1;
            }
            
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
    
}
