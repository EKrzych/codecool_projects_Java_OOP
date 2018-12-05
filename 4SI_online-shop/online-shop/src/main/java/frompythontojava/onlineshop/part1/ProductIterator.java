package frompythontojava.onlineshop.part1;

import java.util.*;

public class ProductIterator implements Iterator {
    private ArrayList<Product> productList;
    int index = 0;

    ProductIterator(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public boolean hasNext() {
        if(index < productList.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Product next() {
        if(this.hasNext()) {
            return productList.get(index++);
        } else {
            return null;
        }
    }

    public void remove() {
        productList.remove(--index);
        }
}