/*
*By: Caesar R. Watts-Hall
*Class: JAVA 1
*Instructor: Dr.Primo
*Assignment: OOP Kitchen Interface [EXTRA CREDIT]
*Date: 11/04/2018 [COMPLETED]
*Due: 11/08/2018 @9:30AM
 */
//START
package crwh_kitcheninterface;

import crwh_kitchen.CRWH_Kitchen;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CRWH_KitchenInterface {

    public static CRWH_Kitchen kitchen = new CRWH_Kitchen();

    public static void main(String[] args) throws Exception {
        long sleepTime = 300;
        while (true) {
            System.out.println("==========================================");
            System.out.println("What would you like to do in your kitchen?");
            System.out.println("      Choose from the options below:      ");
            System.out.println("==========================================");
            System.out.println(" [0] : Turn the Lights On                 ");
            System.out.println(" [1] : Turn the Lights Off                ");
            System.out.println(" [2] : Cook a meal with the Stove         ");
            System.out.println(" [3] : Use the Microwave                  ");
            System.out.println(" [4] : Eat the meal you made              ");
            System.out.println(" [5] : Put leftovers in the Fridge        ");
            System.out.println(" [6] : Put the Dishes in the Dishwasher   ");
            System.out.println(" [7] : Print the status about the Kitchen ");
            System.out.println(" [8] : Leave the Kitchen                  ");
            System.out.println("==========================================");

            Scanner lineScannerChoiceofAction = new Scanner(System.in);
            String action = lineScannerChoiceofAction.nextLine();
            Thread.sleep(1000);
            clearScreen();

            if (action.equals("0")) {
                kitchen.turnLightsOn();
            }

            if (action.equals("1")) {
                kitchen.turnLightsOff();
            }

            if (action.equals("2")) {
                kitchen.cookMeal();
                kitchen.crwhStove.turnStoveOn();
            }

            if (action.equals("3")) {
                System.out.print(" > The microwave is now open. What would like to heat up from the fridge: ");
                Scanner aScanner = new Scanner(System.in);
                String fridgeFood = aScanner.nextLine();

                InputStreamReader inStream = new InputStreamReader(System.in);
                BufferedReader stdin = new BufferedReader(inStream);
                String inData, inData2;
                int items, time1;
                double time, time2;
                time2 = 1.25;//assigning values to the variables
                System.out.print(" > How many " + fridgeFood + " are you heating up: ");

                inData = stdin.readLine(); //gets user input as a string
                items = Integer.parseInt(inData);//changes string value to integer
                System.out.print(" > How long should the food be heated? Enter the time (in seconds): ");
                inData2 = stdin.readLine(); //gets user input as a string
                time1 = Integer.parseInt(inData2);//changes string value to integer
                switch (items) {

                    case 1://if number of items is 1
                        time = time1;
                        System.out.println(" > Heat total items for: " + time + " seconds");
                        break;

                    case 2://if number of items is 2
                        time = time1 * time2;
                        System.out.println(" > Heat total items for: " + time + " seconds");
                        break;

                    default: //if number of items is greater than 2
                        System.out.println(" > WARNING: More than two items at once, isn't recommended for heating.");
                        break;
                }
                System.out.println(" > Your " + fridgeFood + " is finished heating up. Please enjoy.");
                kitchen.cookMeal();
            }

            if (action.equals("4")) {
                kitchen.eatMeal();
                kitchen.crwhStove.turnStoveOff();
            }

            if (action.equals("5")) {
                kitchen.crwhFridge.turnFridgeOn();
                System.out.print(" > Would you like to adjust your refrigerator's temperature? Yes or No: ");
                Scanner lineScannerChoiceofLeftovers = new Scanner(System.in);
                String leftovers = lineScannerChoiceofLeftovers.nextLine();

                if (leftovers.equals("Yes")) {
                    Thread.sleep(sleepTime);
                    clearScreen();
                    System.out.print(" > Would you like to Decrease or Increase the fridge's temperature?: ");
                    Scanner lineScannerChoiceOfIncreaseOrDecrease = new Scanner(System.in);
                    String decreaseOrIncrease = lineScannerChoiceOfIncreaseOrDecrease.nextLine();

                    if (decreaseOrIncrease.equals("Decrease")) {
                        System.out.println(" > The fridge is closed, and is set at a colder temperature than before.");
                        kitchen.crwhFridge.makeFridgeColder();
                    }

                    if (decreaseOrIncrease.equals("Increase")) {
                        System.out.println(" > The fridge is closed, and is set at a warmer temperature than before.");
                        kitchen.crwhFridge.makeFridgeWarmer();
                    }

                    if (leftovers.equals("No")) {
                        System.out.println(" > The fridge is now closed, with no change in temperature.");
                    }
                }

            }

            if (action.equals("6")) {
                kitchen.washDishes();
            }

            if (action.equals("7")) {
                kitchen.printInfo();
                kitchen.crwhStove.printInfo();
                kitchen.crwhFridge.printInfo();
            }

            if (action.equals("8")) {
                System.out.println(" > See you soon, Nameless-User.");
                System.exit(0);
                break;
            }
        }
    }

    public static void clearScreen() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
//END   

