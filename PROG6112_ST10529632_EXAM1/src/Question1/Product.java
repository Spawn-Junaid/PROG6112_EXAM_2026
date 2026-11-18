package Question1;

public class Product implements IProduct {
    private String productName;
    private int[] monthlySales;

    public Product(String productName, int[] monthlySales) {
        this.productName = productName;
        this.monthlySales = monthlySales;
    }

    @Override
    public int GetTotalProductSold() {
        return 0;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int sales : monthlySales) {
            total += sales;
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        if (monthlySales.length == 0) return 0.0;
        return (double) GetTotalProductsSold() / monthlySales.length;
    }

    @Override
    public String GetMostPopularProduct() {
        return productName;
    }
}
