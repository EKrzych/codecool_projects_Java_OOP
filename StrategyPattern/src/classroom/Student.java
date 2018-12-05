package classroom;

public class Student extends Human {
    Student(String name, String eMail) {
        super(name, eMail);
        this.thingToPlay = new Nerws();
    }


}
