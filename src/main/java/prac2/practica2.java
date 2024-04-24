package prac2;

import java.util.Arrays;

public class practica2 {
    int cap_max=15000;
    int valor_x_obj=6;

    public int MochilaMudanza(int[] pesos){
        int precio=0;
        int [][]matriz = new int [pesos.length+1][cap_max+1];
        String solOptima= "Solución óptima: ";

        for(int j = 0; j <=cap_max; j++){ //recorre columnas
            for(int i = 0; i <=pesos.length;i++){ //recorre filas
                if(i==0 || j==0){ // fila y columna 0 = 0
                    matriz[i][j]=0;
                }else if(pesos[i-1] <= j){//eso es que cabe
                    matriz[i][j] =  Math.max(matriz[i-1][j], pesos[i-1] * valor_x_obj + matriz[i-1][j-pesos[i-1]]);
                }else{ //Si no cabe
                    matriz[i][j] = matriz[i-1][j];
                }
            }
        }

        int pos= matriz[0].length-1;
        for(int k = pesos.length; k >= 0; k--){ //recorre filas
            if (matriz[k][pos]==0) break;
            if(matriz[k][pos] != matriz[k-1][pos]){
                solOptima = solOptima + pesos[k-1] + " ";
                pos = pos - pesos[k-1];
            }
        }

        System.out.println(solOptima);

        precio = matriz[matriz.length-1][matriz[0].length-1];
        return precio;
    }
}
