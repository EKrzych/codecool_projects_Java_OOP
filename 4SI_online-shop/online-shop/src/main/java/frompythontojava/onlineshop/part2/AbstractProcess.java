package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {
    public void process(Orderable item) {
        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        System.out.println("I'm just about to do sth.");

    }

    public void stepAfter() {
        System.out.println("I've done it.");
        
    }
    public abstract void action(Orderable item);
}   