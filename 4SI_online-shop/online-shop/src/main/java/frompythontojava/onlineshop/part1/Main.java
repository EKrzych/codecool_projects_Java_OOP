package frompythontojava.onlineshop.part1;

import java.util.*;
import java.text.ParseException;

public class Main {
    

    public static void main(String[] args) throws ParseException {        
        Basket basket1 = new Basket();
        ProductCategory alcohol = new ProductCategory("alcohol");
        FeaturedProductCategory fruits = new FeaturedProductCategory("fruits", "2018.12.10");
        ProductCategory cars = new ProductCategory("cars");     
        Product jablko = new Product("jablko", 3f, fruits);
        Product bmw = new Product("BMW", 500f, cars);
        Product bmw1 = new Product("BMW1", 1500f, cars);
        Product bmw2 = new Product("BMW2", 2500f, cars);
        Product bmw3 = new Product("BMW3", 3500f, cars);
        Product bmw4 = new Product("BMW4", 4500f, cars);
        Product beer = new Product("beer", 4f, alcohol);
        basket1.addProduct(jablko);
        basket1.addProduct(bmw);
        basket1.addProduct(bmw1);
        basket1.addProduct(bmw2);
        basket1.addProduct(bmw3);
        basket1.addProduct(beer);
        for(Product p : basket1.getProductList()) {
            System.out.println(p);
        }
        basket1.removeProduct(jablko);
        basket1.addProduct(bmw4);
        System.out.println();
        for(Product p : new Product().getAllProductBy(fruits)) {
            System.out.println(p);
        }
        System.out.println();
        for(Product p : basket1.getProductList()) {
            System.out.println(p);
        }
    }
}
