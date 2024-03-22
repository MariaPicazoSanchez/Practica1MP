import org.junit.Test;
import prac1.Mudanzas;

import static org.junit.Assert.*;

public class TestMudanza {
    @Test
    public void MudanzaOK(){
        System.out.println("Test Mudanza OK");
        Mudanzas mudanza= new Mudanzas();
        double[] pesos= {600.0,250.5,375,578.3,478.90,596.6,230,5035.10,899,753,152.78};
        assertEquals(mudanza.MochilaMudanza(pesos),440);
    }

    @Test
    public void MudanzaNOK(){
        System.out.println("Test Mudanza OK");
        Mudanzas mudanza= new Mudanzas();
        double[] pesos= {600.0,250.5,375,578.3,478.90,596.6,230,5035.10,899,753,1200};
        assertEquals(mudanza.MochilaMudanza(pesos),0);

    }
}
