package prac1;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        Mudanzas mudanza= new Mudanzas();
        double[] pesos= {10.0,15.5,3.75,5.78};
        System.out.println(mudanza.MochilaMudanza(pesos));
        String prob = "solucion optima: ";
        prob = prob + pesos[0];
        System.out.println(prob);




    }
}