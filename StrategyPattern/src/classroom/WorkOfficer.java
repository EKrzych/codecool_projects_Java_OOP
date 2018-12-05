package classroom;

public class WorkOfficer extends Human {
    WorkOfficer(String name, String eMail) {
        super(name, eMail);
        this.thingToPlay = new trumpet();
        this.saying = "Nie mam czasu";
    }
}
