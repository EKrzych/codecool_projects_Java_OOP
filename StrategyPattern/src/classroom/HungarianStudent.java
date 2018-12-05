package classroom;

public class HungarianStudent extends Student {
    HungarianStudent(String name, String eMail) {
        super(name, eMail);
        this.saying = "chuj wie co, ale coś po węgiersku";
    }
}
