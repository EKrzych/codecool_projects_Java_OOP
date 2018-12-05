package frompythontojava.onlineshop.part2;

public class Main {

    public static void main(String[] args) {
	Order test1 = new Order();
    System.out.println(test1.getStatus());
    CheckoutProcess cheko = new CheckoutProcess();
    cheko.process(test1);
    System.out.println(test1.getStatus());
    PaymentProcess pay = new PaymentProcess();
    pay.process(test1);
    System.out.println(test1.getStatus());
    }
}
