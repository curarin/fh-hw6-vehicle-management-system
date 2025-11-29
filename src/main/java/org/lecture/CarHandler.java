package org.lecture;

import java.util.ArrayList;

public class CarHandler {
    ArrayList<Car> allCars;

    public CarHandler(ArrayList<Car> allCars) {
        this.allCars = allCars;
    }

    public void changePriceByType(CarType wantedCarTypeFilter, double wantedPriceReductionInPercent) {
        try {
            for (Car car : allCars) {
                if (car.getCarType().equals(wantedCarTypeFilter)) {
                    double carPriceReduction = car.getCarPrice() * wantedPriceReductionInPercent / 100;
                    String newCarPrice = String.valueOf(car.getCarPrice() - carPriceReduction);
                    car.setCarPrice(newCarPrice);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCarsByType(CarType wantedCarTypeFilter) {
        for (Car car : this.allCars) {
            if (car.getCarType().equals(wantedCarTypeFilter)) {
                System.out.printf("%d \t| %s \t| %s \t| %s\n", car.getCarId(), car.getCarType().getGermanName(), car.getCarBrand(), car.getCarModel());
            }
        }
    }

    public void printCarsByPrice(int[] wantedPriceBucketFilter) {
        int lowerBoundPrice = wantedPriceBucketFilter[0];
        int upperBoundPrice = wantedPriceBucketFilter[1];
        for (Car car : this.allCars) {
            if (car.getCarPrice() >= lowerBoundPrice && car.getCarPrice() <= upperBoundPrice) {
                System.out.printf("%d \t| %.2f,- EUR \t| %s \t| %s\n", car.getCarId(), car.getCarPrice(), car.getCarBrand(), car.getCarModel());
            }
        }

    }

    public void printCarsByManufacturerYear(int wantedManufactureryearFilter) {
        for (Car car : this.allCars) {
            if (car.getCarManufacturerYear() >= wantedManufactureryearFilter) {
                System.out.printf("%d \t| %d \t| %s \t| %s\n", car.getCarId(), car.getCarManufacturerYear(), car.getCarBrand(), car.getCarModel());
            }
        }

    }

    public void printCarsByMileage(int wantedMileageFilter) {
        for (Car car : this.allCars) {
            if (car.getCarMileage() <= wantedMileageFilter) {
                System.out.printf("%d \t| %d \t| %s \t| %s\n", car.getCarId(), car.getCarMileage(), car.getCarBrand(), car.getCarModel());
            }
        }
    }
}
