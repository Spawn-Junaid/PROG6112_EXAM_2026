package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {

    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        int[] sales = {25, 18, 20};
        IProduct product = new Product("Cozy Nights Monarch", sales);

        int expected = 63;
        assertEquals(expected, product.GetTotalProductSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        int[] sales = {25, 18, 20};
        IProduct product = new Product("Cozy Nights Monarch", sales);

        double expected = 21.0;
        assertEquals(expected, product.GetAverageProductSold(), 0.01);
    }
}