package prac1;

import java.util.Arrays;

public class Mudanzas {
    int cap_max =10000;
    int valor_x_obj=40;

    public int MochilaMudanza(double[] pesos){
        int totalPaq=0;
        double totalPeso=0;
        double[] pesosSol = new double[1];
        String pesosString;

        ordenar(pesos);

        for (int i=0;i<pesos.length;i++){
            if(pesos[i] <= cap_max - totalPeso){
                if (i==0){
                    pesosSol[0]=pesos[i];

                    totalPeso += pesos[i];
                    totalPaq++;
                }
                else{
                    pesosSol = anadirPesos(pesosSol, pesos[i]);

                    totalPeso += pesos[i];
                    totalPaq++;
                }
            }
        }

        if(totalPaq == 0) return 0;

        pesosString = arrayToString(pesosSol);
        System.out.println("Pesos: "+pesosString);
        return totalPaq*valor_x_obj;
    }

    public String arrayToString(double[] pesosOrd) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pesosOrd.length; i++) {
            builder.append(pesosOrd[i]);
            if (i < pesosOrd.length - 1) {
                builder.append(", "); // Agregar coma y espacio si no es el último elemento
            }
        }
        return builder.toString();
    }

    public double[] anadirPesos(double[] pesos, double aAnadir){
        double[] pesosConNuevo = Arrays.copyOf(pesos, pesos.length + 1);
        pesosConNuevo[pesos.length] = aAnadir;

        return pesosConNuevo;
    }

    public void ordenar(double[] pesos){
        double x;

        for(int i = 0; i < pesos.length-1; i++){
            for(int j = i+1; j < pesos.length; j++){
                if(pesos[j] < pesos[i]){
                    x = pesos[j];
                    pesos[j] = pesos[i];
                    pesos[i] = x;
                }
            }
        }
    }
}
