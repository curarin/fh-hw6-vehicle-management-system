package org.lecture;

import javax.management.InvalidAttributeValueException;
import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.time.Year;
import java.util.Locale;

public class Car {
    private String carBrand;
    private String carModel;
    private CarType carType;
    private int carManufacturerYear;
    private int carMileage;
    private double carPrice;
    private int carId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(String carId) throws Exception {
        if (Integer.parseInt(carId) > 0) {
            this.carId = Integer.parseInt(carId);
        } else {
            throw new Exception("Invalid car id set: " + carId);
        }
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(String carType) throws Exception {
        if (carType.equalsIgnoreCase("PKW")) {
            this.carType = CarType.PASSENGER_CAR;
        } else if (carType.equalsIgnoreCase("TRANSPORTER")) {
            this.carType = CarType.TRANSPORTER;
        } else if (carType.equalsIgnoreCase("MOTORRAD")) {
            this.carType = CarType.MOTORCYCLE;
        } else {
            this.carType = CarType.PASSENGER_CAR;
            throw new Exception("Invalid car type: " + carType + " | Default set: " + this.carType);
        }
    }

    public int getCarManufacturerYear() {
        return carManufacturerYear;
    }

    public void setCarManufacturerYear(String carManufacturerYear) throws Exception{
        // Source für aktuelles Jahr: https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
        if (Integer.parseInt(carManufacturerYear) > 1900 && Integer.parseInt(carManufacturerYear) <= Year.now().getValue()) {
                this.carManufacturerYear = Integer.parseInt(carManufacturerYear);
        } else {
                throw new Exception("Invalid manufacturer year: " + carManufacturerYear);
        }
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(String carMileage) throws Exception {
        if (Integer.parseInt(carMileage) > 0) {
            this.carMileage = Integer.parseInt(carMileage);
        } else {
            throw new Exception("Invalid car mileage: " + carMileage);
        }
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) throws Exception {
        if (Double.parseDouble(carPrice) > 0) {
            this.carPrice = Double.parseDouble(carPrice);
        } else {
            throw new Exception("Invalid car price - price has to be > 0 - we want to earn money, doh.");
        }
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%d;%s;%s;%s;%d;%d;%.2f", this.carId, this.carBrand, this.carModel, this.carType.getGermanName(), this.carManufacturerYear, this.carMileage, this.carPrice);
    }

}
