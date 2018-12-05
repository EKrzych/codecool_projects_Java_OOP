package frompythontojava.onlineshop.part1;

import java .util.ArrayList;

public class Product {
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static ArrayList<Product> productList = new ArrayList<>();

   
    public Product(String name,
            Float defaultPrice,
            ProductCategory productCategory) {
                this.name = name;
                this.defaultPrice = defaultPrice;
                this.productCategory = productCategory;
                this.ID = this.hashCode();
                productList.add(this);


            }
    
    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.productCategory
                + "ID: " + this.ID
                + ", name: " + this.name
                + ", defaultPrice: " + this.defaultPrice;
    }

    public static ArrayList<Product> getAllProduct() {
        return productList;
    }

    public static ArrayList<Product> getAllProductBy(ProductCategory category) {
        ArrayList<Product> toReturn = new ArrayList<>();
        for(Product product : productList
                                    .stream()
                                    .filter(p -> p.productCategory.getName().equals(category.getName()))
                                    .toArray(Product[]::new)) {
                                        toReturn.add(product);
                                    }
        return toReturn;
    }

}