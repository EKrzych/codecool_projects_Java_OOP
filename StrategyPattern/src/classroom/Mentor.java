package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mentor extends Human {
    Scanner scanner = new Scanner(System.in);

    Mentor(String name, String eMail) {
        super(name, eMail);
        this.thingToPlay = new Guitar();
        this.saying = "Wygoogluj sobie";
    }

    private boolean askIfPresent(Student student) {
        System.out.println(student.getName() + "?");
        String answer = scanner.nextLine();

        if(answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public List<Student> checkAttendance(List<Student> listFromRoom) {
        List<Student> presentStudent = new ArrayList<>();
        for(Student student : listFromRoom) {
            if(askIfPresent(student)) {
                presentStudent.add(student);
            }
        }
        return presentStudent;
    }
}
