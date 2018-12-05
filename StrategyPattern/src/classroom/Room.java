package classroom;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Student> roomListStudent = new ArrayList<>();
    private List<Mentor> roomListMentor = new ArrayList<>();

    public void addStudent(Student student) {
        roomListStudent.add(student);
    }

    public void addMentor(Mentor mentor) {
        roomListMentor.add(mentor);
    }

    public List<Student> getRoomListStudent() {
        return roomListStudent;
    }
}
