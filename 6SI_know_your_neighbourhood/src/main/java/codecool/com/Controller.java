package codecool.com;

import java.util.*;
import java.util.stream.Collectors;

class Controller {
    Scanner input = new Scanner(System.in);
    View view = new View();

    District district;


    public Controller(District district) {
        this.district = district;
    }

    public String askUser(String message) {
        view.printLine(message);
        return input.nextLine();
    }

    public void interact() {
        String option;
        do {
            view.printMenu();
            option = this.askUser("Choose option(number):");
            switch(option) {
                case "1":
                    view.displayStatistics(this.district);
                    break;
                case "2":
                    view.displayNamesFromArray(district.getLongestThreeTowns());
                    break;
                case "3":
                    view.printLine(district.getCountyRichest());
                    break;
                case "4":
                    this.district.countNames();
                    view.printArray(district.getPopular());
                    break;
                case "5":
                    String word = this.askUser("Searching for:");
                    view.printLookedWord(district.gatherChosenAdministrativeUnit(word));
                    break;
                case "0":
                    view.printLine("Bye Bye");
                    break;
                default:
                    view.printLine("There's no such option!");
            }
        } while (!option.equals("0"));
    }
}
