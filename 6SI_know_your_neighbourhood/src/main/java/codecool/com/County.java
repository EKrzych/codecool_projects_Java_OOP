package codecool.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class County extends AdministrativeUnit {
    private List<Community> communities = new ArrayList<>();

    public County(String countyName, Integer countyNumber, String countyType) {
        this.Name = countyName;
        this.Number = countyNumber;
        this.Type = countyType;
    }

    public void addCommunity(Community community) {
        this.communities.add(community);
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public int getCommunitiesLength() {
        return communities.size();
    }
}
