package prac1;

import java.util.Arrays;

public class Mudanzas {
    int cap_max =10000;
    int valor_x_obj=40;

    public int MochilaMudanza(double[] pesos){
        int totalPaq=0, totalPeso=0;
        double[] pesosOrd = new double[1];
        String pesosString;
        for (int i=0;i<pesos.length;i++){
            totalPaq++;
            totalPeso+= (int) pesos[i];
            if(totalPeso>cap_max)
                return 0;
            if (i==0)
                pesosOrd[0]=pesos[i];
            else
                pesosOrd=recolocarPesos(pesosOrd,pesos[i]);
        }

        pesosString = arrayToString(pesosOrd);
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

    public double[] recolocarPesos(double[] pesos, double aAnadir){
        double[] pesosConNuevo = Arrays.copyOf(pesos, pesos.length + 1);
        pesosConNuevo[pesos.length] = aAnadir;
        Arrays.sort(pesosConNuevo);

        return pesosConNuevo;
    }
}
