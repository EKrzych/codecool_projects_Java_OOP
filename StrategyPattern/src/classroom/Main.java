package classroom;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Module moduleAdvanced = new Module();
        Room brickRoom = new Room();
        Mentor marek = new Mentor("Marek", "marek@cc.com");
        Student ela = new PolishStudent("Ela", "Ela@wp.pl");
        Student magda = new PolishStudent("Magda", "Magdaa@wp.pl");
        Student wiki = new HungarianStudent("wiki", "wiki@wp.pl");

        moduleAdvanced.addRoom(brickRoom);
        brickRoom.addMentor(marek);
        brickRoom.addStudent(ela);
        brickRoom.addStudent(magda);
        brickRoom.addStudent(wiki);

        List<Student> presentThisTime = marek.checkAttendance(brickRoom.getRoomListStudent());

        for(Student student : presentThisTime) {
            student.thingToPlay.play();
            student.say();
        }

        marek.thingToPlay.play();
        marek.say();
    }

}
