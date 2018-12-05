package codecool.com;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileReader {
    public District readFromFile(String filename) {
        District district = new District();
        County county;
        Community community;

        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(filename).getFile());

        try (Scanner reader = new Scanner(filePath)) {
            while(reader.hasNextLine()) {
                String[] line = reader.nextLine().split("\t");
                if (line[1].isEmpty()) {
                    district = new District(line[4], Integer.valueOf(line[0]), line[5]);
                } else if (line[2].isEmpty()) {
                    county = new County(line[4], Integer.valueOf(line[1]), line[5]);
                    district.addCounty(county);
                } else if (!(line[0].equals("woj"))) {
                    community = new Community(line[4], Integer.valueOf(line[2]), line[5].trim());

                    for (County c : district.getCountys()) {
                        if (c.getNumber().equals(Integer.valueOf(line[1]))) {
                            c.addCommunity(community);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return district;
    }
}

