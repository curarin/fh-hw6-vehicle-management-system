package org.lecture;

import java.util.Scanner;

public class InputHandler {

    public void printWelcomeScreen() {
        // Wollt mal was neues machen -> https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Wroom+Wroom+Wroom&x=none&v=4&h=4&w=80&we=false
        String message = """
                 __      __                                 __      __                                 __      __                              \s
                /  \\    /  \\_______  ____   ____   _____   /  \\    /  \\_______  ____   ____   _____   /  \\    /  \\_______  ____   ____   _____ \s
                \\   \\/\\/   /\\_  __ \\/  _ \\ /  _ \\ /     \\  \\   \\/\\/   /\\_  __ \\/  _ \\ /  _ \\ /     \\  \\   \\/\\/   /\\_  __ \\/  _ \\ /  _ \\ /     \\\s
                 \\        /  |  | \\(  <_> |  <_> )  Y Y  \\  \\        /  |  | \\(  <_> |  <_> )  Y Y  \\  \\        /  |  | \\(  <_> |  <_> )  Y Y  \\
                  \\__/\\  /   |__|   \\____/ \\____/|__|_|  /   \\__/\\  /   |__|   \\____/ \\____/|__|_|  /   \\__/\\  /   |__|   \\____/ \\____/|__|_|  /
                       \\/                              \\/         \\/                              \\/         \\/                              \\/\s
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
                (0) Exit
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
                
                --> ...
                """;
        System.out.println(message);
        return scanner.nextInt();
    }
}
