package org.lecture;

import javax.management.InvalidAttributeValueException;
import java.time.DateTimeException;
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
        try {
            if (Integer.parseInt(carId) > 0) {
                this.carId = Integer.parseInt(carId);
            }
        } catch (Exception e) {
            throw new Exception("Invalid car id: " + carId);
        }
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        if (carType.equalsIgnoreCase("PKW")) {
            this.carType = CarType.PASSENGER_CAR;
        } else if (carType.equalsIgnoreCase("TRANSPORTER")) {
            this.carType = CarType.TRANSPORTER;
        } else if (carType.equalsIgnoreCase("MOTORRAD")) {
            this.carType = CarType.MOTORCYCLE;
        } else {
            this.carType = CarType.PASSENGER_CAR;
            System.err.println("Invalid car type: " + carType);
            System.err.println("Default set to " + CarType.PASSENGER_CAR);
        }
    }

    public int getCarManufacturerYear() {
        return carManufacturerYear;
    }

    public void setCarManufacturerYear(String carManufacturerYear) throws Exception{
        try {
            if (Integer.parseInt(carManufacturerYear) > 1900 && Integer.parseInt(carManufacturerYear) <= 2050) {
                this.carManufacturerYear = Integer.parseInt(carManufacturerYear);
            } else {
                throw new DateTimeException("Invalid manufacturer year: " + carManufacturerYear);
            }
        } catch (Exception e) {
            throw new Exception("Invalid car manufacturer year: " + carManufacturerYear);
        }
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(String carMileage) throws Exception {
        try {
            if (Integer.parseInt(carMileage) > 0) {
                this.carMileage = Integer.parseInt(carMileage);
            } else {
                throw new javax.naming.directory.InvalidAttributeValueException("Invalid car mileage: " + carMileage);
            }
        } catch (Exception e) {
            throw new Exception("Invalid car mileage: " + carMileage);
        }
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) throws Exception {
        try {
            if (Double.parseDouble(carPrice) > 0) {
                this.carPrice = Double.parseDouble(carPrice);
            } else {
                throw new InvalidAttributeValueException("Invalid car price - price has to be > 0 - we want to earn money, doh.");
            }
        } catch (Exception e) {
            throw new Exception("Invalid car price: " + carPrice);
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
        return String.format(Locale.US, "%d,%s,%s,%s,%d,%d,%.2f", this.carId, this.carBrand, this.carModel, this.carType, this.carManufacturerYear, this.carMileage, this.carPrice);
    }

}
