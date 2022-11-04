package ui.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDetails {


    public List<String> getPostCodeFromInputTxtFile() {
        // This method gets the car reg nummber from car_input.txt files
        BufferedReader reader;
        List<String> regnumber = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/car_input.txt"));
            String line = reader.readLine();

            while (line != null) {
                Pattern pattern1 = Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z]{3}");
                Pattern pattern2 = Pattern.compile("[A-Z]{2}[0-9]{2} [A-Z]{3}");
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);
                line = reader.readLine();
                if (matcher1.find()) {
                    regnumber.add(matcher1.group());
                }
                if (matcher2.find()) {
                    regnumber.add(matcher2.group());
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return regnumber;
    }

    public List<Car> getExpectedFromOutputFile() throws IOException {
        // This method gets the car expcted details from car_output.txt files

        File f = new File("src/main/resources/car_output.txt");
        Scanner sc = new Scanner(f);

        ArrayList<Car> carDetails = new ArrayList<Car>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] details = line.split(",");
            String reg = details[0];
            String make = details[1];
            String model = details[2];
            String colour = details[3];
            String year = details[4];
            Car p = new Car(reg, make, model, colour, year);
            carDetails.add(p);
        }
        return carDetails;
    }
}
