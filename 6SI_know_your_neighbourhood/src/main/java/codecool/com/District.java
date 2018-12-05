package codecool.com;

import java.util.*;
import java.util.stream.Collectors;

class District extends AdministrativeUnit {
    private List <County> countys = new ArrayList<>();
    private Map<String, Integer> nameCounter = new HashMap<>();

    public District(String districtName, Integer districtNumber, String districtType) {
        this.Name = districtName;
        this.Number = districtNumber;
        this.Type = districtType;
    }

    public District() {}

    public List<County> getCountys() {
        return countys;
    }

    public void addCounty(County county) {
        this.countys.add(county);
    }

    private Integer getCountyCount(String string) {
        Integer count;
        List<County> matches = this.countys.stream()
                                            .filter(c -> c.getType().equals(string))
                                            .collect(Collectors.toList());
        count = matches.size();
        return count;
    }

    public Map<String, Integer> getStatistic() {
        Map<String, Integer> statistic = new LinkedHashMap<>();
        statistic.put(this.Type, 1);
        statistic.put("powiaty", getCountyCount("powiat"));
        statistic.put("miasto na prawach powiatu", getCountyCount("miasto na prawach powiatu"));
        for(County c : this.countys) {
            for(Community x : c.getCommunities()) {
                statistic.put(x.getType(), (statistic.getOrDefault(x.getType(), 0))+1);
            }
        }
        return statistic;
    }

    public String getCountyRichest() {
        return Collections.max(countys, new CommunityCountComparator()).getName();
    }

    public void countNames() {
        for(County c : this.getCountys()) {
            nameCounter.put(c.getName(), nameCounter.getOrDefault(c.getName(), 0)+1);
            for(Community com : c.getCommunities()) {
                nameCounter.put(com.getName(), nameCounter.getOrDefault(com.getName(), 0)+1);
            }
        }
    }

    public ArrayList<String> getPopular() {
        ArrayList<String> mostPopular = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : nameCounter.entrySet()) {
            if(entry.getValue() > 1) {
                mostPopular.add(entry.getKey());
            }
        }
        return mostPopular;
    }

    public List<Community> gatherCommunities() {
        ArrayList<Community> gatheredCommunities = new ArrayList<>();
        for(County c : this.getCountys()) {
            gatheredCommunities.addAll(c.getCommunities());
        }
        return gatheredCommunities;
    }

    public ArrayList<Community> getLongestThreeTowns() {

        List<Community> matches = this.gatherCommunities().stream()
                .filter(c -> c.getType().equals("miasto"))
                .collect(Collectors.toList());
        sortCommunity(matches);
        ArrayList<Community> three = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            three.add(matches.get(i));
        }
        return three;
    }

    public void sortCommunity(List<Community> list) {
        Collections.sort(list, new NameLengthComparator());
    }


    public ArrayList<Community> lookInCommunity(String word) {
        ArrayList<Community> foundCommunities = new ArrayList<>();
        for(County c : countys) {
            for(Community com : c.getCommunities()) {
                if(com.getName().toLowerCase().contains(word.toLowerCase())) {
                    foundCommunities.add(com);
                }
            }
        }
        return foundCommunities;
    }

    public ArrayList<County> lookInCounty(String word) {
        ArrayList<County> foundCountys = new ArrayList<>();
        for(County c : countys) {
            if(c.getName().toLowerCase().contains(word.toLowerCase())) {
                foundCountys.add(c);
            }
        }
        return foundCountys;
    }

    public ArrayList<AdministrativeUnit> gatherChosenAdministrativeUnit(String word) {
        ArrayList<AdministrativeUnit> gatheredUnit = new ArrayList<>();
        gatheredUnit.addAll(this.lookInCounty(word));
        gatheredUnit.addAll(this.lookInCommunity(word));

        gatheredUnit.sort(Comparator.comparing(AdministrativeUnit::getName)
                        .thenComparing(AdministrativeUnit::getType));
        return gatheredUnit;
    }
}
