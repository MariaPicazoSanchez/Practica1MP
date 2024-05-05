package prac3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import prac2.practica2;


public class practica3 {
    int cap_max=20000;
    int total_peso=59790;

    private static final Logger logger = LogManager.getLogger(practica2.class);
    public void MochilaMudanza(double pesos[], int nivel){
        int n = pesos.length; //numero de niveles
        int posiciones[] = new int[pesos.length];
        int posiciones_final[] = new int[pesos.length];
        double local;
        double solucion = 0;
        String solOptima= "Solución óptima: ";

        for(int j = 0; j<3; j++){ //esto es para los tres camiones (provisional)
            for(int i = 0; i <=1; i++){
                posiciones[nivel] = i;
                local = vivo(posiciones, nivel, pesos);
                if (local != -1){
                    if(nivel==n){
                        if(cap_max-local < cap_max-solucion){
                            solucion = local;
                            posiciones_final = posiciones; //esto es como pseudo codigo
                        }
                    }
                }
            }
            //nueva funcion que quite pesos elegidos en el otro camion
        }
        logger.info(solOptima);
        //System.out.println(solOptima);//sacarlo con el logger
    }
    public double vivo(int posiciones[], int nivel, double pesos[]){
        double peso_total = 0;
        for(int i = 1; i<= nivel; i++){
            if(posiciones[i-1] == 1){
                peso_total = peso_total + pesos[nivel-1];
            }
        }

        if(peso_total>cap_max){
            return -1;
        }

        return peso_total;
    }


}
