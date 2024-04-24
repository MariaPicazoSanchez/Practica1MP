import org.junit.Test;
import prac2.practica2;

import static org.junit.Assert.assertEquals;

public class TestPractica2 {
    @Test
    public void Prac2OK1(){
        System.out.println("Test 1 Práctica 2 OK");
        practica2 mudanza= new practica2();
        int[] pesos= {1000,3000,4000,5000,7000};
        assertEquals(mudanza.MochilaMudanza(pesos),90000);
    }

    @Test
    public void Prac2OK2(){
        System.out.println("Test 2 Práctica 2 OK");
        practica2 mudanza= new practica2();
        int[] pesos= {1000,5000,4000,3000,7000};
        assertEquals(mudanza.MochilaMudanza(pesos),90000);
    }

    @Test
    public void Prac2OK3(){
        System.out.println("Test 3 Práctica 2 OK");
        practica2 mudanza= new practica2();
        int[] pesos= {16000,113000,94000,17000,19000};
        assertEquals(mudanza.MochilaMudanza(pesos),0);
    }

    @Test
    public void Prac2OK4(){
        System.out.println("Test 4 Práctica 3 OK");
        practica2 mudanza= new practica2();
        int[] pesos= {16000,113000,94000,3000,19000};
        assertEquals(mudanza.MochilaMudanza(pesos),18000);
    }

    @Test
    public void Prac2OK5(){
        System.out.println("Test 5 Práctica 3 OK");
        practica2 mudanza= new practica2();
        int[] pesos= {0,0,0,0,0};
        assertEquals(mudanza.MochilaMudanza(pesos),0);
    }
}
