package Question1;

public class PrintProduct { public void printReport(IProduct[] products){
    int totalProductSales =0;
    double totalAverageSales = 0;
    String mostPopularProduct = " ";
    int maxSales = -1;
    System. out.println("PRODUCT SALES REPORT - 2026");
    System. out.println("******************************************************");
    for (IProduct p : products) {
        int prodTotal = p.GetTotalProductSold();
        totalProductSales += prodTotal;
        totalAverageSales += p.GetAverageProductSold();

        if (prodTotal > maxSales) {
            maxSales = prodTotal;
            mostPopularProduct = p.GetMostPopularProduct() + " (" + prodTotal + ")";
        }
    }

    System.out.println("TOTAL PRODUCT SALES: " + totalProductSales);
    System.out.println("AVERAGE PRODUCT SALES: " + (int)(totalAverageSales / products.length));
    System.out.println("MOST POPULAR PRODUCT: " + mostPopularProduct);
}
}

