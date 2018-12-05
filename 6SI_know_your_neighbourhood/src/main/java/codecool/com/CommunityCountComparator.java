package codecool.com;

import java.util.Comparator;

public class CommunityCountComparator implements Comparator<County> {
    public int compare(County item1, County item2) {
        if (item1.getCommunitiesLength() > item2.getCommunitiesLength()) {
            return 1;
        } else {
            return -1;
        }
    }
}