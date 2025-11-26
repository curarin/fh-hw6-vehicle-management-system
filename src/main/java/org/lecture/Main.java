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
        boolean isRunning = true;

        inputHandler.printWelcomeScreen();

        do {
            int mainMenuChoice = inputHandler.getMainInput();
            switch (mainMenuChoice) {
                case 1 -> {
                    int filterChoice = inputHandler.getFilterInput();
                    switch (filterChoice) {
                        case 1 -> {
                            carHandler.printCarsByType(CarType.PASSENGER_CAR);
                        }
                        case 2 -> {
                            int choice = 3;
                            carHandler.printCarsByPrice(choice);
                        }
                        case 3 -> {
                            int wantedYear = 2018;
                            carHandler.printCarsByManufacturerYear(wantedYear);
                        }
                        case 4 -> {
                            int maximumMileage = 50000;
                            carHandler.printCarsByMileage(maximumMileage);
                        }
                    }
                }
                case 2 -> {
                    double changeOfPrice = 0.1;
                    carHandler.changePriceByType(CarType.MOTORCYCLE, changeOfPrice);
                }
                case 3 -> {
                    file.writeCarDataToCsv(allCars);
                }
                case 0 -> isRunning = false;
            }
        } while (isRunning);
    }
}
