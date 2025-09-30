package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Known values
        double priceOfBasicRentalPerDay = 29.99;
        double priceOfOptionTollTag = 3.95;
        double priceOfOptionGPS = 2.95;
        double priceOfOptionRoadIdeAssistance = 3.95;
        float precentOfUnderageDriverSurcharge = 0.03f;
        int userAgeList = 25;


        //Values need from user
        System.out.print("When do you want the car? ");
        String pickUpDate = scanner.nextLine();

        System.out.print("How many days do you want it? ");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want a toll tag (y/n)? ");
        boolean optionTollTag = scanner.nextLine().equalsIgnoreCase("y");


        System.out.print("Do you want a GPS (y/n)? ");
        boolean optionGPS = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you want a Road Ide Assistance (y/n) ");
        boolean optionRoadIdeAssistance = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Whats your age? ");
        int age = scanner.nextInt();
        scanner.nextLine();


        //Calculation
        double basicCarRenalAmount = numberOfDays * priceOfBasicRentalPerDay;
        double optionPerDayCumulative =(optionTollTag) ? priceOfOptionTollTag : 0;
        optionPerDayCumulative += (optionGPS) ? priceOfOptionGPS: 0;
        optionPerDayCumulative += (optionRoadIdeAssistance) ? priceOfOptionRoadIdeAssistance : 0;
        double optionsAmount = optionPerDayCumulative * numberOfDays;
        double underageSurchange = 0;

        if (age < userAgeList){
            underageSurchange = basicCarRenalAmount * precentOfUnderageDriverSurcharge;
        }
        double totalCost = basicCarRenalAmount + optionsAmount + underageSurchange;


        //Result
        System.out.println("Here is the quote for your rental");
        System.out.printf("Basic car rental:         %.2f\n",basicCarRenalAmount);
        System.out.printf("Options:       %.2f\n",optionsAmount);
        System.out.printf("Underage Surchange:       %.2f\n",underageSurchange);
        System.out.printf("Total:       %.2f\n",totalCost);


    }
}