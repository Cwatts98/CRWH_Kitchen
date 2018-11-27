package crwh_kitchen;

import java.util.Scanner;

public class CRWH_Kitchen {

    public CRWH_Fridge crwhFridge = new CRWH_Fridge();
    public int crwhDishCount = 0;
    public CRWH_Stove crwhStove = new CRWH_Stove();
    public int crwhlengthInFeet;
    public int crwhwidthInFeet;
    public boolean crwhWashDishes = true;
    public boolean crwhMicrowaveFood = true;
    public boolean crwhStoveFood = false;
    public boolean crwhLightsOn = false;

    public void turnLightsOn() {
        if (crwhLightsOn) {
            System.out.println(" > The lights were already on.");
        } else {
            crwhLightsOn = true;
            System.out.println(" > The lights are now on.");
        }
    }

    public void turnLightsOff() {
        if (crwhLightsOn) {
            System.out.println(" > The lights are now off.");
            crwhLightsOn = false;
        } else {
            System.out.println(" > The lights were already off.");
        }
    }

    public void washDishes() {
        if (crwhWashDishes == false && (crwhDishCount > 0)) {
            System.out.println(" > Your dishwasher is now on, and the dishes will be clean in a short while.");
            crwhWashDishes = true;
            crwhDishCount = 0;
        } else {
            System.out.println("");
        }
    }

    public void cookMeal() {
        if (crwhStoveFood) {
            System.out.println(" > The stove is now on, and is hot & ready.");
            System.out.print(" > What would you like to make: ");
            Scanner bScanner = new Scanner(System.in);
            String food = bScanner.nextLine();

            System.out.println(" > Your " + food + " is finished cooking. Please enjoy.");
        } else {
            crwhDishCount = crwhDishCount + 3;
            crwhStoveFood = true;
            crwhWashDishes = false;
        }
    }

    public void eatMeal() {
        if (crwhStoveFood || crwhMicrowaveFood) {
            System.out.println(" > Your food has been consumed.");
        } 
        crwhStoveFood = false;
        crwhDishCount = crwhDishCount + 3;
        crwhWashDishes = false;
}

public void printInfo() {
        if (crwhLightsOn) {
            System.out.println(" > The lights are on.");
        } else {
            System.out.println(" > The lights are off.");
        }

        if (crwhWashDishes == false && (crwhDishCount > 0)) {
            System.out.println(" > The Dishwasher is on.");
            System.out.println(" > I have " + crwhDishCount + " dirty dishes to put in the dishwasher.");
        } else {
            System.out.println(" > The Dishwasher is off.");
        }
    }
}
