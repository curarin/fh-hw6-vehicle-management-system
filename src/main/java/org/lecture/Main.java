package org.lecture;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src", "main", "resources", "fahrzeuge.csv");
        FileHandler file = new FileHandler(path);
        ArrayList<String> fileList = file.readFile();
        ArrayList<Car> allCars = file.parseFile(fileList);
        CarHandler carHandler = new CarHandler(allCars);
        InputHandler inputHandler = new InputHandler();
        DataAnalysis analyticsHandler = new DataAnalysis(allCars);
        boolean isRunning = true;

        inputHandler.printWelcomeScreen();

        do {
            System.out.println("---------------------------------------------------");
            int mainMenuChoice = inputHandler.getMainInput();
            switch (mainMenuChoice) {
                case 1 -> {
                    int filterChoice = inputHandler.getFilterInput();
                    switch (filterChoice) {
                        case 1 -> {
                            CarType wantedCarType = inputHandler.getCarTypeInput();
                            System.out.println("List of all cars with Car Type " + wantedCarType);
                            carHandler.printCarsByType(wantedCarType);
                        }
                        case 2 -> {
                            int choice = inputHandler.getCarPriceBucketInput();
                            System.out.println("List of all cars with chosen Price Bucket");
                            carHandler.printCarsByPrice(choice);
                        }
                        case 3 -> {
                            int wantedYear = inputHandler.getCarManufacturerYearInput();
                            carHandler.printCarsByManufacturerYear(wantedYear);
                        }
                        case 4 -> {
                            int maximumMileage = inputHandler.getCarMileageInput();
                            carHandler.printCarsByMileage(maximumMileage);
                        }
                    }
                }
                case 2 -> {
                    double changeOfPrice = inputHandler.getPriceChangeInput();
                    CarType wantedCarType = inputHandler.getCarTypeInput();
                    carHandler.changePriceByType(wantedCarType, changeOfPrice);
                }
                case 3 -> {
                    file.writeCarDataToCsv(allCars);
                    isRunning = false;
                }
                case 4 -> {
                    int analysisInput = inputHandler.getAnalysisInput();

                    switch (analysisInput) {
                        case 1 -> analyticsHandler.calculateMeanPriceAllCars();
                        case 2 -> analyticsHandler.calculateCarCountPerType();
                    }
                }
                case 0 -> isRunning = false;
            }
        } while (isRunning);
    }
}
