package Question2;


import static org.junit.Assert.*;
import org.junit.Test;

    public class ProductCalculationsTest {

        @Test
        public void GetVat_WithValidData_ReturnsCorrectValue() {
            ProductCalculations calc = new ProductCalculations(3500.0);
            double expectedVat = 525.0;

            assertEquals(expectedVat, calc.GetVat(), 0.01);
        }
    }


