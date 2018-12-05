package frompythontojava.onlineshop.part1;

import java.util.*;

public class Basket {
    private Iterator productIterator;
    private ArrayList <Product> productList = new ArrayList<>();

    public Iterator getIterator() {
        return new ProductIterator(this.productList);
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public Boolean removeProduct(Product product) {
        this.productIterator = this.getIterator();
        while(this.productIterator.hasNext()) {
            if(this.productIterator.next().equals(product)){
                this.productIterator.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void clearProductList() {
        this.productList.clear();
    }


}