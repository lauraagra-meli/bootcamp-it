package praticaIntegradora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distributor {
    public static void main(String[] args) {
        Product product = new Product();
        NonPerishable nonPerishable = new NonPerishable();
        Perishable perishable = new Perishable();
        int productQuantity = 0;
        double total = 0;

        Scanner sc = new Scanner(System.in);

//        List<Product> prod = new ArrayList<Product>();
//        NonPerishable p = new NonPerishable("a", 1, "a");
//        prod.add(p);
//
//        for (Product p1 : prod) {
//            System.out.println(p1);
//        }


        //List<Product> productList = new ArrayList<Product>();
        List<Perishable> productListP = new ArrayList<Perishable>();
        List<NonPerishable> productListNP = new ArrayList<NonPerishable>();

        productListP.add(new Perishable("bread", 10, 2));
        productListP.add(new Perishable("butter", 4, 1));
        productListP.add(new Perishable("milk", 5, 3));
        productListP.add(new Perishable("meat", 10.89, 4));

        productListNP.add(new NonPerishable("rice", 10.99, "food"));
        productListNP.add(new NonPerishable("beans", 12.99, "food"));
        productListNP.add(new NonPerishable("pasta", 5.99, "food"));
        productListNP.add(new NonPerishable("floor", 2.89, "food"));

        for (int i = 0; i < productListP.size() && i < productListNP.size(); i++) {
            double totalProductP = 0;
            double totalProductNP = 0;

            System.out.println("Insert the products quantity of item? ");
            productQuantity = Integer.parseInt(sc.nextLine());
            totalProductP += productListP.get(i).calculate(productQuantity);
            System.out.println(productListP.toString() + totalProductP);
            total += totalProductP;

            System.out.println("Insert the products quantity of item? ");
            productQuantity = Integer.parseInt(sc.nextLine());
            totalProductNP += productListNP.get(i).calculate(productQuantity);
            System.out.println(productListNP.get(i).getName() + " - unit value - R$" + productListNP.get(i).getPrice() + ", total value - R$" + totalProductNP);
            total += totalProductNP;

//            if (productList.get(i) == perishable) {
//                perishable.calculate(productQuantity);
//                System.out.println(productQuantity);
//            }
//            if (productList.get(i) == perishable) {
//                nonPerishable.calculate(productQuantity);
//                System.out.println(productQuantity);
//            }
        }

        System.out.println("The purchase total: " + total);
    }
}
