package crwh_kitchen;

import java.util.Scanner;

public class CRWH_Stove {
public boolean crwhStoveOn = false;

    public void turnStoveOn() {
        if (crwhStoveOn == false) {
            System.out.println(" > The stove is now on.");
            System.out.print(" > What would you like to make: ");
            Scanner cScanner = new Scanner (System.in);
            String heatablefood = cScanner.nextLine();
            System.out.println(" > Your " + heatablefood + " is now prepared. Please enjoy.");
            crwhStoveOn = true;
        } else {
            System.out.println(" > The stove was already on. Thats rather dangerous you know... ");
        }
    }

    public void turnStoveOff() {
        if (crwhStoveOn) {
            System.out.println(" > The stove is now off.");
            crwhStoveOn = false;
        } else {
            System.out.println("");
        }
    }

    public void printInfo() {
        if (!crwhStoveOn) {
            System.out.println(" > The stove is off.");
        } else {
            System.out.println(" > The stove is on.");
        }
    }   
}
