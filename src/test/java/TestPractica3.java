import org.junit.Test;
import prac2.practica2;
import prac3.practica3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestPractica3 {

    // Caso de prueba con pesos que caben entre los tres camiones
    @Test
    public void Prac3OK1(){
        System.out.println("Test 1 Práctica 3 OK");
        practica3 prueba = new practica3();
        double[] pesos = {10000, 5000, 4000, 3000.1, 2000.75, 1000};
        assertTrue(prueba.MochilaMudanza(pesos, 1));
    }

    // Caso de prueba con pesos que caben entre los tres camiones pero con varias soluciones
    @Test
    public void Prac3OK2(){
        System.out.println("Test 2 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {15000, 10000.9, 8000.05, 6000, 5000, 3000};
        assertTrue(prueba.MochilaMudanza(pesos, 1));
    }

    // Caso de prueba con un solo peso
    @Test
    public void Prac3OK3(){
        System.out.println("Test 3 Práctica 3 OK");
        practica3 prueba = new practica3();
        double[] pesos = {7000.47};
        assertTrue(prueba.MochilaMudanza(pesos, 1));
    }

    // Caso de prueba con ningún peso
    @Test
    public void Prac3NOK4(){
        System.out.println("Test 4 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {};
        assertFalse(prueba.MochilaMudanza(pesos, 1));
    }

    //Caso de prueba en el que falta un camión
    @Test
    public void Prac3NOK5(){
        System.out.println("Test 5 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {17000,19000,19000,2000,2000};
        assertFalse(prueba.MochilaMudanza(pesos, 1));
    }

    //Caso de prueba con ningún peso
    @Test
    public void Prac3NOK6(){
        System.out.println("Test 6 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {0};
        assertFalse(prueba.MochilaMudanza(pesos, 1));
    }

    //Caso de prueba en el que se excede el peso total que hay que mover (59790kg)
    @Test
    public void Prac3NOK7(){
        System.out.println("Test 7 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {20000, 20000, 20000};
        assertFalse(prueba.MochilaMudanza(pesos, 1));
    }

    @Test
    public void Prac3NOK8(){
        System.out.println("Test 8 Práctica 3 NOK");
        practica3 prueba = new practica3();
        double[] pesos = {21000};
        assertFalse(prueba.MochilaMudanza(pesos, 1));
    }

}
