package praticaIntegradora;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        Product product = new Product();
        NonPerishable nonPerishable = new NonPerishable();
        Perishable perishable = new Perishable();

        List<Product> productList = new ArrayList<Product>();

        productList.add(new Perishable("bread", 2, 2));
        productList.add(new Perishable("butter", 4.23, 10));
        productList.add(new Perishable("milk", 3.99, 22));
        productList.add(new Perishable("meat", 10.89, 4));

//        productList.add(new NonPerishable("rice", 10.99, "food"));
//        productList.add(new NonPerishable("beans", 12.99, "food"));
//        productList.add(new NonPerishable("pasta", 5.99, "food"));
//        productList.add(new NonPerishable("floor", 2.89, "food"));

        for (int i = 0; i < productList.size(); i++) {
            double total = 0;
            total += perishable.getPrice();
            
            System.out.println(total);

            System.out.print(productList.get(i).getName() + " - R$");
            System.out.println(productList.get(i).getPrice());
        }
    }
}
