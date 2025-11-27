package org.lecture;

public enum CarType {
    PASSENGER_CAR("Pkw"),
    TRANSPORTER("Transporter"),
    MOTORCYCLE("Motorrad");

    private final String germanName;

    private CarType(String germanName) {
        this.germanName = germanName;
    }

    public String getGermanName() {
        return this.germanName;
    }

}
