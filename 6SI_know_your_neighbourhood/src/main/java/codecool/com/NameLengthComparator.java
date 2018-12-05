package codecool.com;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Community> {
    public int compare(Community item1, Community item2) {
        if (item1.getNameLength() < item2.getNameLength()) {
                return 1;
        } else {
                return -1;
        }
    }
}