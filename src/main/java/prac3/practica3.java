package prac3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class practica3 {
    int cap_max=20000;
    int total_peso=59790;
    double solucion = 0;
    int posiciones[];
    int nodos_vivos = 0;

    private static final Logger logger = LogManager.getLogger(practica3.class);
    public boolean MochilaMudanza(double pesos[], int nivel){
        int n = pesos.length; //numero de niveles
        int posiciones_final[] = new int[pesos.length];
        double local = 0; //peso del camion en el que estamos intentando meter el objeto o peso total
        String sol= "SOLUCIÓN: ",camion1="Camión 1:",camion2="Camión 2:",camion3="Camión 3:";
        double pesos1=0,pesos2=0,pesos3=0;
        boolean puede = true;

        //COMPROBACIONES INICIALES
        for(int k = 0; k < pesos.length; k++){
            if(pesos[k]>cap_max){
                //logger.info("Hay algún peso que supera las 20 toneladas");
                System.out.println("Hay algún peso que supera las 20 toneladas");
                return false;
            }
            local = local + pesos[k];
        }

        if(local > total_peso){
            //logger.info("Se ha excedido el peso a transportar por los camiones");
            System.out.println("Se ha excedido el peso a transportar por los camiones");
            return false;
        }
        else if(local == 0){ //si no hemos metido ningún peso
            //logger.info("No hay pesos a colocar");
            System.out.println("No hay pesos a colocar");
            return false;
        }
        else if (nivel == 1) //reset del vector posiciones
            posiciones = new int[pesos.length];

        //MOCHILA
        for(int i = 1; i <=3; i++){ //la i son los camiones
            posiciones[nivel-1] = i;
            local = vivo(posiciones, nivel, pesos);
            if (local != -1){
                if(nivel==n){
                    if(cap_max-local < cap_max-solucion){
                        //si lo que me sobra ahora es menor a lo que me sobraba antes
                        solucion = local;
                        posiciones_final = Arrays.copyOf(posiciones, posiciones.length) ;
                        nodos_vivos++;
                        break;
                    }
                }
                else{
                    MochilaMudanza(pesos, nivel+1);
                }
            }
        }

        if(nodos_vivos == 0 && nivel == 1) {
            //logger.info("Faltan camiones para poder transportar los pesos");
            System.out.println("Faltan camiones para poder transportar los pesos");
            return false;
        }

        //IMPRIMIR SOLUCIÓN
        for(int j=0; j<posiciones_final.length; j++){
            switch (posiciones_final[j]){
                case 0: //para no imprimir todos los casos
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
        if (puede) {
            camion1 = camion1 + " = " + pesos1;
            camion2 = camion2 + " = " + pesos2;
            camion3 = camion3 + " = " + pesos3;
            //logger.info(sol + "\n" + camion1 + "\n" + camion2 + "\n" + camion3);
            System.out.println(sol + "\n" + camion1 + "\n" + camion2 + "\n" + camion3);
        }
        return true;
    }

    public double vivo(int posiciones[], int nivel, double pesos[]){
        double peso_total = 0;
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


