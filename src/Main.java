import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[]args) {
        //constructing scanner object
        Scanner reader = new Scanner(System.in);

        //Introduces program
        println("Hello! In this program you can calculate the"
                + " angle or side length\nof an triangle using SINE and COSINE. \n" +
                "If you want to quit the program just type 'stop'. ");

        while(true) {

            print("\nWhat would you like to calculate? The ANGLE or SIDE: ");

            //what user types
            String userInput = "";

            //asks user what they want
            userInput = reader.next();

            //if "stop" is read the program shuts down
            if(userInput.toLowerCase().contains("stop")){
                break;
            }

            //reads if user input was angle
            if(userInput.toLowerCase().contains("angle")) {
                println("\nIn this program you are calculating angle A");

                //used to determine whether the program should keep asking for angles and sides
                boolean loopAgain = true;

                do{
                    //used to determine whether to use SINE or COSINE
                    print("\nDo you want to use SINE or COSINE? ");
                    userInput = reader.next();

                    //if "stop" is read the program shuts down
                    if(userInput.toLowerCase().contains("stop")){
                        break;
                    }

                    //if 3 sides are given use COSINE
                    if(userInput.toLowerCase().contains("cosine")){
                        loopAgain = false;

                        //asks for side lengths
                        double a = ask("Enter the length for SideA: ");
                        double b = ask("Enter the length for SideB: ");
                        double c = ask("Enter the length for SideC: ");

                        println("The angle of AngleA is: " + getCosineAngle(a,b,c) + " degrees");
                    }
                    //if 2 sides and 1 angle is given use SINE
                    else if(userInput.toLowerCase().contains("sine")){
                        loopAgain = false;

                        //asks for sides and angles
                        double a = ask("Enter the length for SideA: ");
                        double b = ask("Enter the length for SideB: ");
                        double c = ask("Enter the angle for AngleB in degrees: ");

                        println("The angle of AngleA is: " + getSineAngle(a,b,c) + " degrees");

                    } else { //input was neither sine nor cosine
                        println("Invalid. Try again. ");
                    }

                } while (loopAgain); //if true ask for sine and cosine again


            } else if (userInput.toLowerCase().contains("side")) {

                println("\nIn this program you are calculating side A");

                //used to determine whether the program should keep asking for sine and cosine
                boolean loopAgain = true;

                do{
                    //used to determine whether to use SINE or COSINE
                    print("\nDo you want to use SINE or COSINE? ");
                    userInput = reader.next();

                    //stops program
                    if(userInput.toLowerCase().contains("stop")){
                        break;
                    }

                    //if 2 sides and 1 angle are given use COSINE
                    if(userInput.toLowerCase().contains("cosine")){
                        loopAgain = false;

                        //asks for givens
                        double a = ask("Enter the angle for AngleA in degrees: ");
                        double b = ask("Enter the length for SideB: ");
                        double c = ask("Enter the length for SideC: ");

                        println("The length of SideA is: " + getCosineSide(a,b,c) );
                    }
                    //if 1 sides and 2 angle is given use SINE
                    else if(userInput.toLowerCase().contains("sine")){
                        loopAgain = false;

                        //asks for givens
                        double a = ask("Enter the angle for AngleA in degrees: ");
                        double b = ask("Enter the length for SideB: ");
                        double c = ask("Enter the angle for AngleB in degrees: ");

                        println("The length of SideA is: " + getSineSide(a,b,c) );
                    }
                    else {
                        println("Invalid. Try again. ");
                    }
                } while (loopAgain); //

            } else {
                print("Invalid answer. Try again. \n ");
            }

            if(userInput.toLowerCase().contains("stop")){
                break;
            }
        }

        println("Thanks for using this program!");

    }

    public static double getCosineSide(double angleA, double sideB, double sideC) {
        //toRadians is used to convert degrees to radians
        double side = (Math.sqrt(Math.pow(sideC, 2) + Math.pow(sideB, 2) - 2 * sideB * sideC * Math.cos(Math.toRadians(angleA))));
        return side;
    }

    public static double getCosineAngle (double sideA, double sideB, double sideC) {
        //because the output is angle toDegrees is used to convert from radian
        double angle = Math.toDegrees(Math.acos(((((Math.pow(sideA , 2) - Math.pow(sideB , 2) - Math.pow(sideC , 2))/-2)/sideB)/sideC)));
        return angle;
    }

    public static double getSineAngle(double sideA, double sideB, double angleB){
        //toDegrees is used to convert angle from radians to degrees
        double angle =  Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angleB))/sideB) * sideA));

        return angle;
    }

    public static double getSineSide(double angleA, double sideB, double angleB){
        //toRadians is used to convert degrees to radians
        double side =  (Math.sin(Math.toRadians(angleA)) * (sideB/Math.sin(Math.toRadians(angleB))));
        return side;
    }


    public static void print(String input) {
        System.out.print(input);
    }

    public static void println(String input) {
        System.out.println(input);
    }

    public static double ask(String prompt){
        //declaring scanner object
        Scanner reader = new Scanner(System.in);

        double value = 0;

        do{

            print(prompt);

            //checks if input was a letter
            boolean letterInput = false;

            try{

                //reads input
                value = reader.nextDouble();

            } catch (InputMismatchException error){ //if it input wasnt a double run this

                reader.next();
                println("\nThat's not a number! Try again with a number.");
                letterInput = true;

            } catch (Exception error ) { //if there was an error run this

                reader.next();
                println("\nSomething went wrong. Try again.");
                letterInput = true;

            }

            if(value <= 0 && !letterInput){

                println("\nThat's a Zero or negative number! Try again with a positive.");

            }


        } while (value <=0);

        return value;

    }


}