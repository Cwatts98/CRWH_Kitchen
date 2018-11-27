package crwh_kitchen;
public class CRWH_Fridge {
    public int crwhTemperature = 25;
    public int crwhItemCount = 0;
    public int crwhFood;
    public boolean crwhFridgeOn = false;
    public boolean crwhOpenOrNot = false;
    String fridgefoods;

    public void inTheFridge(){
        if(crwhOpenOrNot == true && (crwhFridgeOn == false)){
          System.out.println(" > The fridge door is open.");  
        }else{
            System.out.println(" > The fridge door is closed.");
        }

    }
    
    public void turnFridgeOn() {
        if (crwhFridgeOn == false) {
            System.out.println(" > The fridge is open, and completely functional.");
            crwhFridgeOn = true;
        } else {
            System.out.println(" > The fridge is already operational.");
        }
    }

    public void makeFridgeColder() {
        crwhTemperature = crwhTemperature - 10;
        if (crwhTemperature < 10) {
            System.out.println(" > The food is completely frozen.");
            crwhFridgeOn = false;
        }
    }

    public void makeFridgeWarmer() {
        crwhTemperature = crwhTemperature + 10;
        if (crwhTemperature > 50) {
            System.out.println(" > The food inside is now spoiled... The fridge is WAY too warm.");
            crwhFridgeOn = false;
        }
    }
    
    public void printInfo() {
        if (crwhFridgeOn) {            
            System.out.println(" > The fridge is on. It's current remperature is: " + crwhTemperature + " degrees.");
        } else {
            System.out.println(" > The fridge is off, with no change in its temperature.");
        }
    }
}
