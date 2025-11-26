package org.lecture;

import java.util.ArrayList;

public class DataAnalysis {
    ArrayList<Car> allCars = new ArrayList<>();

    public DataAnalysis(ArrayList<Car> allCars) {
        this.allCars = allCars;
    }

    public void calculateMeanPriceAllCars() {
        double meanPrice = 0;
        double sumPrice = 0;
        double carArrayLength = this.allCars.size();

        for (Car car : this.allCars) {
            sumPrice += car.getCarPrice();
        }
        meanPrice = sumPrice / carArrayLength;
        System.out.printf("Mean price of all cars is %.2f,- EUR\n", meanPrice);
    }

    public void calculateMeanPricePerCarType(CarType wantedCarType) {
        double meanPrice = 0;
        double sumPrice = 0;
        double carArrayLength = this.allCars.size();

        for (Car car : this.allCars) {
            if (car.getCarType().equals(wantedCarType)) {
                sumPrice += car.getCarPrice();
            }
        }
        meanPrice = sumPrice / carArrayLength;
        System.out.printf("Mean price of all cars (of type %s) is %.2f,- EUR\n", wantedCarType, meanPrice);
    }

    public void calculateCarCountPerType() {
        int countPassengerCars = 0;
        int countTransporterCars = 0;
        int countMotorcycles = 0;

        for (Car car : this.allCars) {
            if (car.getCarType() == CarType.PASSENGER_CAR) {
                countPassengerCars++;
            } else if (car.getCarType() == CarType.TRANSPORTER) {
                countTransporterCars++;
            } else if (car.getCarType() == CarType.MOTORCYCLE) {
                countMotorcycles++;
            }
        }

        System.out.println("Total Count of all car types");
        System.out.printf("Passenger Car Count: %d\n", countPassengerCars);
        System.out.printf("Transporter Car Count: %d\n", countTransporterCars);
        System.out.printf("Motorcycle Car Count: %d\n", countMotorcycles);

    }
}
