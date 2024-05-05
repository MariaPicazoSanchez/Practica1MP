import org.junit.Test;
import prac3.practica3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

    public class TestPractica3 {

        @Test
        void testMochilaMudanza() {
            practica3 prueba = new practica3();

            // Caso de prueba con pesos que no exceden la capacidad máxima de ningún camión
            double[] pesos1 = {10000, 5000, 4000, 3000, 2000, 1000};
            assertTrue(prueba.MochilaMudanza(pesos1, 1));

            // Caso de prueba con pesos que exceden la capacidad máxima de los camiones
            double[] pesos2 = {15000, 10000, 8000, 6000, 5000, 3000};
            assertFalse(prueba.MochilaMudanza(pesos2, 1));

            // Caso de prueba con un solo peso
            double[] pesos3 = {7000};
            assertTrue(prueba.MochilaMudanza(pesos3, 1));

            // Caso de prueba con ningún peso
            double[] pesos4 = {};
            assertFalse(prueba.MochilaMudanza(pesos4, 1));
        }
    }
