package prac3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import java.util.Arrays;


public class practica3 {
    int cap_max=20000;
    int total_peso=59790;
    double solucion = 0;
    int posiciones[];

    private static final Logger logger = LogManager.getLogger(practica3.class);
    public boolean MochilaMudanza(double pesos[], int nivel){
        int n = pesos.length; //numero de niveles
        int posiciones_final[] = new int[pesos.length];
        double local; //peso del camion en el que estamos intentando meter el objeto
        String sol= "SOLUCIÓN: ",camion1="Camión 1:",camion2="Camión 2:",camion3="Camión 3:";
        int pesos1=0,pesos2=0,pesos3=0;
        if (nivel == 1)
        boolean puede = true;
        if(pesos.length == 0) return false;
        else if (nivel == 1)
            posiciones = new int[pesos.length];

        //MOCHILA
        for(int i = 1; i <=3; i++){ //la i son los camiones
            posiciones[nivel] = i;
            local = vivo(posiciones, nivel, pesos);
            if (local != -1){
                if(nivel==n){
                    if(cap_max-local < cap_max-solucion){ //si lo que me sobra ahora es menor a lo que me sobraba antes
                        solucion = local;
                        posiciones_final = Arrays.copyOf(posiciones, posiciones.length) ;
                    }
                }
                else{
                    MochilaMudanza(pesos, nivel+1);
            posiciones[nivel-1] = i;
            local = vivo(posiciones, nivel, pesos);
            if (local != -1){
                if(nivel==n){
                    if(cap_max-local < cap_max-solucion){
                        //si lo que me sobra ahora es menor a lo que me sobraba antes
                        solucion = local;
                        posiciones_final = Arrays.copyOf(posiciones, posiciones.length) ;
                        break;
                    }
                }
                else{
                        MochilaMudanza(pesos, nivel+1);
                }
            }
        }

        //IMPRIMIR SOLUCIÓN
        for(int j=0; j<posiciones_final.length; j++){
            switch (posiciones_final[j]){
                case 0:
                    return false;
                    logger.info("No se puede asignar el objeto a ningún camión.");
                    puede=false;
                    //return false;
                case 1:
                    camion1 = camion1 + " " + pesos[j];
                    pesos1+=pesos[j];
                    break;
                case 2:
                    camion2 = camion2 + " " + pesos[j];
                    pesos2+=pesos[j];
                    break;
                case 3:
                    camion3 = camion3 + " " + pesos[j];
                    pesos3+=pesos[j];
                    break;
            }
        }
        camion1=camion1 +" = "+pesos1;
        camion2=camion2 +" = "+pesos2;
        camion3=camion3 +" = "+pesos3;
        logger.info(sol+"\n"+camion1+"\n"+camion2+"\n"+camion3);
        System.out.println(sol+"\n"+camion1+"\n"+camion2+"\n"+camion3);
        if (puede) {

            camion1 = camion1 + " = " + pesos1;
            camion2 = camion2 + " = " + pesos2;
            camion3 = camion3 + " = " + pesos3;
            logger.info(sol + "\n" + camion1 + "\n" + camion2 + "\n" + camion3);
            System.out.println(sol + "\n" + camion1 + "\n" + camion2 + "\n" + camion3);
        }
        return true;
    }

    public double vivo(int posiciones[], int nivel, double pesos[]){
        double peso_total = 0;
        int camion = posiciones[nivel];
        int camion = posiciones[nivel-1];
        for(int i = 1; i<= nivel; i++){ //recorrer posiciones
            if(posiciones[i-1] == camion){//suma de los pesos del mismo cami
                peso_total = peso_total + pesos[i-1];
            }
        }

        if(peso_total>cap_max){
            return -1;
        }

        return peso_total;
    }


}
