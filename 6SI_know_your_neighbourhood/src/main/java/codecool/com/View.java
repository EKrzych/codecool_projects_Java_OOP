package codecool.com;

import java.util.*;


class View {
    String[] menu = {"List statistics",
            "Display 3 cities with longest names",
            "Display county's name with the largest number of communities",
            "Display locations, that belong to more than one category",
            "Advanced search",
            };

    public void printMenu() {
        for(int i=0; i < this.menu.length; i++) {
            System.out.println("(" + (i+1) + ") " + this.menu[i]);
        }
        this.printLine("(0) Exit program");
    }


    public void displayStatistics(District district) {
        this.printLine("/-----+--------------------------\\");
        this.printLine(String.format("|        %-24s|", district.getName().toUpperCase()));
        this.printLine("|-----+--------------------------|");

        Iterator iterator = district.getStatistic().entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            this.printLine(String.format("|%5d| %25s|", pair.getValue(), pair.getKey()));
            if(iterator.hasNext()) {
                this.printLine("|-----+--------------------------|");
            }
        }
        this.printLine("\\-----+--------------------------/");
    }

    public void printArray(ArrayList<String> list) {
        for(String s : list) {
            printLine(s);
        }
    }

    public void displayNamesFromArray(ArrayList<Community> sortedList) {
        for(Community c : sortedList) {
            printLine(c.getName());
        }
    }

    public void printLookedWord(ArrayList <AdministrativeUnit> administrativeUnitList) {
        this.printLine(String.format("Found %d location(s).", administrativeUnitList.size()));

        this.printLine("/----------------------------------------------------\\");
        this.printLine(String.format("|%-25s| %25s|", "LOCATION", "TYPE"));
        this.printLine("|----------------------------------------------------|");
        for(AdministrativeUnit c : administrativeUnitList) {
            this.printLine(String.format("|%-25s| %25s|", c.getName(), c.getType()));
        }
        this.printLine("\\----------------------------------------------------/");
    }

    public void printLine(String message) {
        System.out.println(message);
    }
}
