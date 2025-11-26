package org.lecture;

import java.util.ArrayList;

public class CarHandler {
    ArrayList<Car> allCars;

    public CarHandler(ArrayList<Car> allCars) {
        this.allCars = allCars;
    }

    public void changePriceByType(CarType wantedCarTypeFilter, double wantedPriceReductionInPercent) throws Exception {
        for (Car car : allCars) {
            if (car.getCarType().equals(wantedCarTypeFilter)) {
                double carPriceReduction = car.getCarPrice() * wantedPriceReductionInPercent;
                String newCarPrice = String.valueOf(car.getCarPrice() - carPriceReduction);
                car.setCarPrice(newCarPrice);
            }
        }
    }

    public void printCarsByType(CarType wantedCarTypeFilter) {
        for (Car car : this.allCars) {
            if (car.getCarType().equals(wantedCarTypeFilter)) {
                System.out.printf("%d | %s | %s | %s\n", car.getCarId(), car.getCarType(), car.getCarBrand(), car.getCarModel());
            }
        }
    }

    public void printCarsByPrice(int wantedPriceBucketFilter) {
        int lowerBoundPrice;
        int upperBoundPrice;
        switch (wantedPriceBucketFilter) {
            case 1 -> {
                lowerBoundPrice = 1;
                upperBoundPrice = 9999;
            }
            case 2 -> {
                lowerBoundPrice = 10000;
                upperBoundPrice = 14999;
            }
            case 3 -> {
                lowerBoundPrice = 15000;
                upperBoundPrice = 19999;
            }
            case 4 -> {
                lowerBoundPrice = 20000;
                upperBoundPrice = 29999;
            }
            default -> {
                lowerBoundPrice = 30000;
                upperBoundPrice = 1000000000;
            }
        }
        for (Car car : this.allCars) {
            if (car.getCarPrice() >= lowerBoundPrice && car.getCarPrice() <= upperBoundPrice) {
                System.out.printf("%d | %.2f,- EUR | %s | %s\n", car.getCarId(), car.getCarPrice(), car.getCarBrand(), car.getCarModel());
            }
        }

    }

    public void printCarsByManufacturerYear(int wantedManufactureryearFilter) {
        for (Car car : this.allCars) {
            if (car.getCarManufacturerYear() >= wantedManufactureryearFilter) {
                System.out.printf("%d | %d | %s | %s\n", car.getCarId(), car.getCarManufacturerYear(), car.getCarBrand(), car.getCarModel());
            }
        }

    }

    public void printCarsByMileage(int wantedMileageFilter) {
        for (Car car : this.allCars) {
            if (car.getCarMileage() <= wantedMileageFilter) {
                System.out.printf("%d | %d | %s | %s\n", car.getCarId(), car.getCarMileage(), car.getCarBrand(), car.getCarModel());
            }
        }
    }


}
