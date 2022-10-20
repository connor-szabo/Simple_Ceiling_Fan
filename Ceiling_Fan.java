//Connor Szabo Ceiling Fan Program
//October 19 2022
import java.io.*;
import java.util.*;


class Fan{
    //Holds the fan speed
    int speed;
    //Holds the direction of the fan
    boolean clockwise;
    
    //Default constructor
    Fan(){
        speed = 0;
        clockwise = true;
    }

    //Increment the speed by 1. If speed is at 3, increment turns off fan
    public void addSpeed(){
        if(speed == 3){
            speed = 0;
        }
        else{
            speed++;
        }
    }

    //Change the direction of the fans rotation
    public void changeDirection(){
        if(clockwise){
            clockwise = false;
        }
        else{
            clockwise = true;
        }
    }

    //Overridden print method for printing data
    @Override
    public String toString(){
        if(speed == 0){
            return "The fan is currently off";
        }
        //If fan speed isn't 0
        if(clockwise){
            return "The fan is set to speed " + speed + " and is rotating clockwise";
        }
        else{
            return "The fan is set to speed " + speed + " and is rotating counter-clockwise";
         }
    }//close toString

}//close Fan class


public class Ceiling_Fan {
    public static void main(String[] args) {
        //Holds the fan data
        Fan userFan = new Fan();
        //Stores the user's menu selection
        int menuOption = 1;
        Scanner sc = new Scanner(System.in);

        //Display menu items to user
        System.out.println("1 - Pull cord 1 to change speed");
        System.out.println("2 - Pull cord 2 to change fan direction");
        System.out.println("3 - Exit Program");

        while(menuOption != 3){
            try{
                //Get the menu option from the user
                menuOption = sc.nextInt();
                //Execute whatever user's menu selection is
                menuChoice(userFan, menuOption);

            }catch(Exception e){
                //If the user enters invalid data, catch error and report to user
                System.out.println("Invalid Option");
                sc.next();
            }
        }//close While loop

    }//close main

    //reads and executes the user's menu option
    private static void menuChoice(Fan userFan, int option) {
        switch(option){
            case 1:
                System.out.println("You pulled the first cord");
                userFan.addSpeed();
                 //Show fan data
                 System.out.println(userFan);
                break;
            case 2:
                System.out.println("You pulled the second cord");
                userFan.changeDirection();
                 //Show fan data
                 System.out.println(userFan);
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid Option");
        }//end Switch
    }//close menuChoice

}//close Fan
