package frompythontojava.onlineshop.part1;

public class ProductCategory {
    private String name;
    Integer ID;

    public ProductCategory(String name) {
        this.name = name;
        this.ID = this.hashCode();
    }

    public String toString() {
        return this.name + ": ";
    }

    public String getName() {
        return this.name;
    }

}