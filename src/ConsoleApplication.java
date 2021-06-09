
/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: https://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out

*/
import javafx.application.Application;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplication {
    private static int count;
    private int numberOfClubs;  //initializing variables
    private final static LeagueManager premierLeagueM = new PremierLeagueManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        try {
            premierLeagueM.retrieve("FootballDetails.txt");

        }catch (Exception e){
        }
        premierLeagueM.getFbClubList();
        Scanner scanner = new Scanner(System.in);   //creating scanner

        while(true) {
            System.out.println("............................................................................");
            System.out.println("\n------------------- Welcome to Football Management System ------------------");
            System.out.println("............................................................................");
            System.out.println("A for Add (insert) Football club "); //Adding club
            System.out.println("B for Delete Football club"); //deleting club
            System.out.println("C for Displaying Statistics"); //listing club
            System.out.println("D for Display premier League Table");  //display table
            System.out.println("E for Add played match");// Adding played match
            System.out.println("F for Save club");  //storing
            System.out.println("G for View in GUI");  //storing
            System.out.println("Q for Quiting ");   //by clicking this user can quit the program
            System.out.println("Please choose your choice: ");  //asking the user to enter his/her choice
            String choice = scanner.nextLine();

            /*switch statement allows a variable to be tested for equality against a list of value */
            switch (choice.toLowerCase()) {
                case "a":   //case 1 - Add (insert) Football club
                    addFootballClub();
                    break;
                case "b":   //case 2 - Delete Football club
                    deleteFootballClub();
                    break;
                case "c":   //case 3 - Displaying Statistics
                    displayStatistics();
                    break;
                case "d":   //case 4 - Display premier League Table
                    premierLeagueM.displayPremierLeagueTable();
                    break;
                case "e":   //case 5 - Add played match
                    addPlayedMatch();
                    break;
                case "f":   //case 7 - Save club
                    premierLeagueM.save();
                    premierLeagueM.save2();
                    break;
                case "g":   //case 8 - Table in GUI
                    Application.launch(Table.class);
                    break;
                case "q":   //case 9 - Quit
                    System.out.println("Programming ended!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");//displaying error message when the user choose invalid choice
            }
        }
    }

    //insertion of a football club
    private static void addFootballClub() {
        FootballClub fClub ;
        Scanner input = new Scanner(System.in);//creating scanner input
        System.out.println("Please enter the name of the football club: ");
        String name = input.nextLine();
        /* validating name of the football club if the user enters any value other than string system
            will display error message and ask the user to enter the correct input value */
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Input! Enter correct Input");//displaying error message
            System.out.print("Please enter the name of the football club: ");
            name = input.next();
        }
        System.out.println("Please enter the location: ");
        String location = input.nextLine();
        /* validating location of the football club if the user enters any value other than string system
            will display error message and ask the user to enter the correct input value */
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Input! Enter correct Input");
            System.out.print("Please enter the location: ");
            location = input.next();
        }
        fClub = new FootballClub(name,location,0,0,0,0,0,0,0,0);
        premierLeagueM.addFootballClub(fClub);
        premierLeagueM.save();
    }



    //removing a football club
    private static void deleteFootballClub() {  //creating scanner and asking user input
        System.out.println("Please enter the name of the football club you want to remove: ");
        Scanner scan =  new Scanner(System.in);
        String nameOfTheClub = scan.nextLine();
        premierLeagueM.deleteFootballClub(nameOfTheClub);
    }

    //displaying club's statistics
    private static void displayStatistics() {   //creating scanner and asking user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the football club which you wanted to displayStatistics:  ");
        String name = scan.nextLine();
        premierLeagueM.displayStatistics(name);

    }

    //Adding a played match
    private static void addPlayedMatch() {  //creating scanner and asking user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of home team: ");
        String home = scan.nextLine();
        /* validating name of the home club if the user enters any value other than string system
             will display error message and ask the user to enter the correct input value */
        while (!home.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Input! Enter correct Input");
            System.out.print("Enter the name of home team: ");
            home = scan.nextLine();
        }

        System.out.println("Enter the name of away team: ");
        String away = scan.nextLine();
        /* validating name of the away club if the user enters any value other than string system
             will display error message and ask the user to enter the correct input value */
        while (!away.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Input! Enter correct Input");//displaying error message
            System.out.print("Enter the name of away team:");
            away = scan.nextLine();
        }

        int homeGoals = 0;
        boolean homeGoalsValid = false;
        /*validation -If the user entered homeGoals less than 1..
        system will display an error message and ask for a valid input from the user */
        while(!homeGoalsValid){
            System.out.println("Enter home goals: ");
            try{
                homeGoals = scan.nextInt();
                if (homeGoals >= 1){
                    homeGoalsValid = true;
                }else {
                    //if the user input does not match, displaying invalid input and asking to try again
                    System.out.println("Invalid input! try again!");
                }
            }catch (InputMismatchException e){
                System.out.println("sorry! Not a valid input");//error message
                scan.next();
            }
        }

        int awayGoals = 0;
        boolean awayGoalsValid = false;
        /*validation - If the user entered awayGoals less than 1..
        system will display an error message and ask for a valid input from the user */
        while(!awayGoalsValid){
            System.out.println("Enter away goals: ");
            try{
                awayGoals = scan.nextInt();
                if (awayGoals >= 1){
                    awayGoalsValid = true;
                }else {
                    //if the user input does not match, displaying invalid input and asking to try again
                    System.out.println("Invalid input! try again");
                }
            }catch (InputMismatchException e) {
                System.out.println("sorry! Not a valid input");//error message
                scan.next();
            }
        }

        int day = 0 ;
        boolean validDay = false;
        //validation for date - date should bbe more than 1 and less than 31
        while(! validDay ) {
            System.out.print("Please enter day between 1-31: ");
            try {
                day = scan.nextInt();
                if(day >= 1 && day <= 31){
                    validDay = true;
                } else {
                    //if the user input does not match, displaying invalid input and asking to try again
                    System.out.println("Invalid input! please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry! you have entered invalid day!");//error message
                scan.next();
            }
        }

        int month = 0;
        boolean validMonth = false;
        //validation for month
        while (!validMonth){
            System.out.println("...................................................................");
            //set up for month in console
            System.out.println("|| [1] for Jan || [2] for Feb   || [3] for Mar   || [4] for Apr  ||\n|| [5] for May || [6] for Jun   || [7] for Jul   || [8] for Aug  ||\n|| [9] for Sep || [10] for Oct  || [11] for Nov  || [12] for Dec || \n\nPlease enter month according to the above mention (with digits only): ");
            try {
                month = scan.nextInt();
                if (month < 12){
                    validMonth = true;
                }else {
                    //if the user input does not match, displaying invalid input and asking to try again
                    System.out.println("Invalid Input! Enter correct Input (with digits only): ");
                }
            }catch (InputMismatchException e){
                System.out.println("Sorry! You have entered invalid month");//error message
                scan.nextInt();
            }
        }


        //Asking the user to input year
        int year = 0;
        boolean validYear = false;
        //validation for year
        while(! validYear ) {
            System.out.println("------------Football management system is built for 10 years(2016-2026)------------");
            System.out.print("Please enter the year (digits only): ");
            try {
                year = scan.nextInt();
                if(year >= 2016){
                    validYear = true;
                } else {
                    //if the user input does not match, displaying invalid input and asking to try again
                    System.out.println("Invalid input! please try again (with digits only): ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry! you have entered invalid year!");//error message
                scan.next();
            }
        }

    }

}

