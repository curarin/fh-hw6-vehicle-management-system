package org.lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
    Path filePath;
    String csvColumnNames;
    int csvColumnCount = 0;
    String delimiter;
    Helper helperFunction = new Helper();

    public FileHandler(Path filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    public ArrayList<String> readFile(boolean csvHasHeader) {
        ArrayList<String> csvLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(this.filePath)) {
            String line;

            // Wir skippen Header Line parsing wenn wir ein False übergeben
            int csvLineCounter = 0;
            if (!csvHasHeader) {
                csvLineCounter = 1;
            }
            while ((line = reader.readLine()) != null) {
                if (csvLineCounter == 0) {
                    String[] fields = line.split(this.delimiter);

                    this.csvColumnNames = line;
                    this.csvColumnCount = fields.length;
                    csvLineCounter++;
                } else if (csvLineCounter > 0) {
                    // Überprüfen, ob der korrekte Delimiter vorhanden ist als auch alle Werte befüllt sind
                    // Mittels helper Functions
                    if (helperFunction.hasCorrectDelimiter(line, this.delimiter) && !helperFunction.hasNullValues(line, this.delimiter)) {
                        String[] fields = line.split(this.delimiter);
                        csvLines.addAll(Arrays.asList(fields));
                        csvLineCounter++;
                    } else {
                        int errorFoundInLineNumber = csvLineCounter + 1;
                        System.err.println("Error reading csv line " + errorFoundInLineNumber);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvLines;
    }

    public ArrayList<Car> parseFile(ArrayList<String> csvValues) {
        ArrayList<Car> cars = new ArrayList<>();
        Car currentCar = new Car();
        int i = 0;
        try {
            for (int counter = 0 ; counter < csvValues.size(); counter++) {
                if (i % csvColumnCount == 0) {
                    currentCar = new Car();
                } else {
                    switch (i % csvColumnCount) {
                        case 1 -> currentCar.setCarId(csvValues.get(i - 1));
                        case 2 -> currentCar.setCarBrand(csvValues.get(i - 1));
                        case 3 -> currentCar.setCarModel(csvValues.get(i - 1));
                        case 4 -> currentCar.setCarType(csvValues.get(i - 1));
                        case 5 -> currentCar.setCarManufacturerYear(csvValues.get(i - 1));
                        case 6 -> {
                            currentCar.setCarMileage(csvValues.get(i - 1));
                            currentCar.setCarPrice(csvValues.get(i));
                            cars.add(currentCar);
                        }
                    }
                }
                i++;
            }
            System.out.println("Data from .csv fully loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void writeCarDataToCsv(ArrayList<Car> allCars) {
        Path path = Paths.get("src", "main", "resources", "fahrzeuge_updated.csv");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            bufferedWriter.write(this.csvColumnNames);
            bufferedWriter.newLine();
            for(Car car : allCars) {
                bufferedWriter.write(car.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
