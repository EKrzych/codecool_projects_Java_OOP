package classroom;

import java.util.ArrayList;
import java.util.List;

public class Module {
    List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
