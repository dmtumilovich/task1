package by.epam.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AppliancesHelper {
    private final String filename;

    public AppliancesHelper(String filename) {
        this.filename = filename;
    }

    public List<String> getAppliancesList(String searchString) {
        List<String> matchList = new ArrayList<>();

        String[] searchOptions = searchString.split(" ");
        Pattern[] patterns = new Pattern[searchOptions.length];
        for(int i = 0; i < searchOptions.length; i++) {
            patterns[i] = Pattern.compile(searchOptions[i]);
        }


        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                int numberOfMatches = 0;
                for(Pattern pattern : patterns) {
                    if (pattern.matcher(line).find())
                        numberOfMatches++;
                }
                if(numberOfMatches == patterns.length)
                    matchList.add(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchList;
    }
}
