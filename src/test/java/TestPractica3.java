import org.junit.Test;
import prac2.practica2;
import prac3.practica3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestPractica3 {

    // Caso de prueba con pesos que no exceden la capacidad máxima de ningún camión
    @Test
    public void Prac3OK1(){
        System.out.println("Test 1 Práctica 3 OK");
        practica3 prueba = new practica3();
        double[] pesos1 = {10000, 5000, 4000, 3000, 2000, 1000};
        assertTrue(prueba.MochilaMudanza(pesos1, 1));
    }

    // Caso de prueba con pesos que exceden la capacidad máxima de los camiones
    @Test
    public void Prac3NOK2(){
        System.out.println("Test 2 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos2 = {15000, 10000, 8000, 6000, 5000, 3000};
        assertTrue(prueba.MochilaMudanza(pesos2, 1));
    }

    // Caso de prueba con un solo peso
    @Test
    public void Prac3OK3(){
        System.out.println("Test 3 Práctica 3 OK");
        practica3 prueba = new practica3();
        double[] pesos3 = {7000};
        assertTrue(prueba.MochilaMudanza(pesos3, 1));
    }

    // Caso de prueba con ningún peso
    @Test
    public void Prac3NOK4(){
        System.out.println("Test 4 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos4 = {};
        assertFalse(prueba.MochilaMudanza(pesos4, 1));
    }

}