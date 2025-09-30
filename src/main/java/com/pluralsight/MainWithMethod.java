package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainWithMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Known values
        double priceOfBasicRentalPerDay = 29.99;
        float precentOfUnderageDriverSurcharge = 0.30f;
        int userAgeList = 25;


        //Values need from user
        String pickUpDate = promptForString("When do you want the car? ");
        int numberOfDays = promptForInt("How many days do you want it? ");
        boolean optionTollTag = promptYesNo("Do you want a toll tag ");
        boolean optionGPS = promptYesNo("Do you want a GPS ");
        boolean optionRoadIdeAssistance = promptYesNo("Do you want a Road Ide Assistance ");
        int age = promptForInt("Whats your age? ");


        //Calculation
        double basicCarRenalAmount = numberOfDays * priceOfBasicRentalPerDay;
        double optionsAmount = calcOptionAmount (numberOfDays, optionTollTag, optionGPS, optionRoadIdeAssistance);
        double underageSurchange = (age < userAgeList) ? basicCarRenalAmount * precentOfUnderageDriverSurcharge : 0;
        double totalCost = basicCarRenalAmount + optionsAmount + underageSurchange;


        //Result
        System.out.println("Here is the quote for your rental");
        System.out.printf("Basic car rental:         %.2f\n",basicCarRenalAmount);
        System.out.printf("Options:       %.2f\n",optionsAmount);
        System.out.printf("Underage Surchange:       %.2f\n",underageSurchange);
        System.out.printf("Total:       %.2f\n",totalCost);


    }

    private static double calcOptionAmount(int numberOfDays,boolean optionTollTag,boolean optionGPS, boolean optionRoadIdeAssistance){
        double priceOfOptionTollTag = 3.95;
        double priceOfOptionGPS = 2.95;
        double priceOfOptionRoadIdeAssistance = 3.95;

        double dayprice = (optionTollTag) ? priceOfOptionTollTag : 0;
        dayprice += (optionGPS) ? priceOfOptionGPS : 0;
        dayprice += (optionRoadIdeAssistance) ? priceOfOptionRoadIdeAssistance : 0;

        return numberOfDays * dayprice;
    }


    private static boolean promptYesNo(String questionToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.print(questionToAsk + "(y/n): ");
        String result = scanner.nextLine();
        return (result.equalsIgnoreCase("y"))|| result.equalsIgnoreCase("Yes");

    }

    private static int promptForInt (String questionToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.print(questionToAsk + ": ");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;

    }

    private static String promptForString(String questionToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.print(questionToAsk + ": ");
        return scanner.nextLine();

    }



}

