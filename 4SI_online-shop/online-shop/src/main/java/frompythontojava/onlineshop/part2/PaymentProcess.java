package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess {
    public void action(Orderable item) {
        item.pay();
    }
}