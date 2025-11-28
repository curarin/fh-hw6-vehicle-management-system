package org.lecture;

import java.util.Scanner;

public class InputHandler {

    public void printWelcomeScreen() {
        // Wollt mal was neues machen -> https://patorjk.com/software/taag/#p=display&f=3D+Diagonal&t=Wroooooom&x=none&v=4&h=4&w=80&we=false
        String message = """
                
                
                           .---.                                                                               ____  \s
                          /. ./|                                                                             ,'  , `.\s
                      .--'.  ' ;  __  ,-.   ,---.     ,---.     ,---.     ,---.     ,---.     ,---.       ,-+-,.' _ |\s
                     /__./ \\ : |,' ,'/ /|  '   ,'\\   '   ,'\\   '   ,'\\   '   ,'\\   '   ,'\\   '   ,'\\   ,-+-. ;   , ||\s
                 .--'.  '   \\' .'  | |' | /   /   | /   /   | /   /   | /   /   | /   /   | /   /   | ,--.'|'   |  ||\s
                /___/ \\ |    ' '|  |   ,'.   ; ,. :.   ; ,. :.   ; ,. :.   ; ,. :.   ; ,. :.   ; ,. :|   |  ,', |  |,\s
                ;   \\  \\;      :'  :  /  '   | |: :'   | |: :'   | |: :'   | |: :'   | |: :'   | |: :|   | /  | |--' \s
                 \\   ;  `      ||  | '   '   | .; :'   | .; :'   | .; :'   | .; :'   | .; :'   | .; :|   : |  | ,    \s
                  .   \\    .\\  ;;  : |   |   :    ||   :    ||   :    ||   :    ||   :    ||   :    ||   : |  |/     \s
                   \\   \\   ' \\ ||  , ;    \\   \\  /  \\   \\  /  \\   \\  /  \\   \\  /  \\   \\  /  \\   \\  / |   | |`-'      \s
                    :   '  |--"  ---'      `----'    `----'    `----'    `----'    `----'    `----'  |   ;/          \s
                     \\   \\ ;                                                                         '---'           \s
                      '---"                                                                                          \s
                ^
                """;
        System.out.println(message);
    }

    public int getMainInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                What do you want to do?
                
                (1) Filter & Print data to console
                (2) Change data
                (3) Export data
                (4) Data Analysis
                (0) Exit
                """;
        System.out.println(message);
        return scanner.nextInt();
    }

    public int getAnalysisInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                What kind of analysis is needed?

                (1) Mean Price of all cars
                (2) Mean Price of specific car type
                (3) Count of Car Types
                """;
        System.out.println(message);
        return scanner.nextInt();
    }
    public int getFilterInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Enter filter option below
                
                (1) Filter by Car Type
                (2) Filter by Car Price Bucket
                (3) Filter by Car Manufacturer Year
                (4) Filter by Car Mileage
                """;
        System.out.println(message);
        return scanner.nextInt();
    }

    public CarType getCarTypeInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Which Car Type do you want?
                (1) PKW
                (2) Transporter
                (3) Motorcycle
                """;
        System.out.println(message);
        int carTypeChoice = scanner.nextInt();
        switch (carTypeChoice) {
            case 1 -> {
                return CarType.PASSENGER_CAR;
            }
            case 2 -> {
                return CarType.TRANSPORTER;
            }
            case 3 -> {
                return CarType.MOTORCYCLE;
            }
            default ->  throw new IllegalArgumentException("Invalid car type");

        }
    }

    public int getCarPriceBucketInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Which Car Price Bucket do you want?
                
                (1) 1 - 9,9k
                (2) 10k - 14,9k
                (3) 15k - 19,9k
                (4) 20k - 29,9k
                """;
        System.out.println(message);
        return scanner.nextInt();
    }

    public int getCarManufacturerYearInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Which Car Manufacturer Year do you want? Please enter a year (e.g. 2025).
                """;
        System.out.println(message);
        return scanner.nextInt();
    }

    public int getCarMileageInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Which Car Mileage do you want? Please enter a number.
                """;
        System.out.println(message);
        return scanner.nextInt();
    }

    public double getPriceChangeInput() {
        Scanner scanner = new Scanner(System.in);
        String message = """
                Amount of discount to apply (e.g. 0.15 for 15%) -> Please enter a number between 1 and 100.
                """;
        System.out.println(message);
        return scanner.nextDouble();
    }
}
