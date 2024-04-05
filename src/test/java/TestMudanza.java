import org.junit.Test;
import prac1.Mudanzas;

import static org.junit.Assert.*;

public class TestMudanza {
    @Test
    public void MudanzaOK(){
        System.out.println("Test Mudanza OK");
        Mudanzas mudanza= new Mudanzas();
        double[] pesos= {600.0,250.5,375,578.3,1478.90,596.6,230,5035.10,899,2753,152.78};
        assertEquals(mudanza.MochilaMudanza(pesos),400);
    }

    @Test
    public void MudanzaNOK(){
        System.out.println("Test Mudanza OK");
        Mudanzas mudanza= new Mudanzas();
        double[] pesos= {11600.0,10250.5,10375,11578.3,12478.90,11596.6,14230,115035.10,13899,11753,101200};
        assertEquals(mudanza.MochilaMudanza(pesos),0);

    }
}
