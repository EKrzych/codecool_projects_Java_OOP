package frompythontojava.onlineshop.part2;

public class Order implements Orderable {
    private int ID;
    private String status;

    public Order() {
        this.ID = this.hashCode();
        this.status = "new";
    }
    public String getStatus() {
        return this.status;
    }

    public boolean checkout() {
        this.status = "checked";
        return true;
    }
    public boolean pay() {
        this.status = "payed";
        return true;
    }



}