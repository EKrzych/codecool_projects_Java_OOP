package classroom;

public class Human {
    String name;
    String eMail;
    String saying;
    Playable thingToPlay;

    Human(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void say() {
        System.out.println(saying);
    }
}
