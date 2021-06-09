/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: Case study and tutorials
*/

import java.io.*;
import java.util.*;
import java.util.Comparator;

//Implements is used to implement a Interface
public class PremierLeagueManager implements LeagueManager{

    //Array list creation
    private ArrayList<FootballClub> footballClubList = new ArrayList<>();
    private int numberOfFootballClubs;      //initializing variables
    private Scanner scanner;
    //Array list for played match
    private ArrayList<Match> matchPlayedList = new ArrayList<>();


    //Adding a new club
    @Override
    public void addFootballClub(FootballClub fClub) {
        for(FootballClub fclub1: footballClubList) {
            if(fClub.equals(fclub1)) {
                //displaying success message of insertion
                System.out.println(fClub.getNameOfTheSportsClub()+" is already added in the league");
                return;
            }
        }
        if(footballClubList.size() <20 ){
            footballClubList.add(fClub);
            System.out.println(fClub.getNameOfTheSportsClub() +" is successfully added.");
            System.out.println("No of free slots: "+(20 - footballClubList.size()));
        } else{
            //if the list is full system will indicate that there are no more free slots
            System.out.println("No free slots are available to add club");
        }
    }

    //Delete a new club
    @Override
    public void deleteFootballClub(String nameOfTheSportsClub) {
        if(footballClubList.isEmpty()) {
            //if there is no club in the list to delete system will indicate that no club found message
            System.out.println("< < < No club found! > > >");
        }
        else {
            boolean fClubFound = false;
            for (FootballClub fClub : footballClubList) {
                if (fClub.getNameOfTheSportsClub().equals(nameOfTheSportsClub)) {
                    fClubFound = true;
                    footballClubList.remove(fClub);
                   /* if the football club has been removed from the list,
                   system will indicate success message of insertion*/
                    System.out.printf("< < <  has been successfully removed! > > > \n");
                    break;
                }
            }
            //if the club is not found, displaying error message and asking the user to try again
            if (!fClubFound) {
                System.out.println("< < < Invalid selection! Please Check & Try Again! > > >");
            }
        }
    }


    //displaying statistics
    @Override
    public void displayStatistics(String nameOfTheSportsClub) {
        System.out.println("...........................................");
        for (FootballClub ftClub : footballClubList) {
            if(ftClub.getNameOfTheSportsClub().equals(nameOfTheSportsClub)){
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " won matches: " + ftClub.getWinCount());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " draw matches: " + ftClub.getDrawCount());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " lost matches: " + ftClub.getDefeatCount());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " goals scored: " + ftClub.getScoredGoalsCount());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " goals received: " + ftClub.getReceivedGoalsCount());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " points gained: " + ftClub.getPoints());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " played matches: " + ftClub.getNumberOfMatchesPlayed());
                System.out.println("Football Club " + ftClub.getNameOfTheSportsClub()+ " goalDifference: " + ftClub.getGoalDifference());
                return;
            }
        }   //displaying error message if the system can not find the football club
        System.out.println("< < < Invalid Name! can not find such football club in league > > > ");
        System.out.println("--------------------------------------------------------------------");
    }

    //Table for premier league
    @Override
    public void displayPremierLeagueTable() {
        if (footballClubList.isEmpty()){ //method to display table
            System.out.println("< < < No clubs are registered still to display the table > > >");
        }else {
            //getting the right format for table
            System.out.printf("%-20s%-5s%-5s%-5s%-5s%-8s%-5s%-5s%-5s\n", "Club Name", "MP", "W", "L", "T", "Points", "GS", "GC", "GD");

            //Collections.sort() method is used to sort the elements in the list
            Collections.sort(footballClubList, new CustomComparator());//sorting the values according to the points
            for (FootballClub club : footballClubList) {//getting out put
                System.out.printf("%-20s%-5d%-5d%-5d%-5d%-8d%-5d%-5d%-5d\n", club.getNameOfTheSportsClub(), club.getNumberOfMatchesPlayed(), club.getWinCount(), club.getDefeatCount(), club.getDrawCount(), (club.getWinCount()*3+club.getDrawCount()), club.getScoredGoalsCount(), club.getReceivedGoalsCount(), (club.getScoredGoalsCount() - club.getReceivedGoalsCount()));
                System.out.println("--------------------------------------------------------------------");
            }
        }
    }

    //Comparing two teams
    //Comparator is an interface for sorting java objects
    static class CustomComparator implements Comparator<FootballClub> {
        public int compare(FootballClub teamOne, FootballClub teamTwo) {    //comparing team one and team two

            if (teamOne.getPoints() > teamTwo.getPoints())
                return -1;
            else if (teamOne.getPoints() < teamTwo.getPoints())
                return 1;
            else {
                int goalDifference1 = teamOne.getScoredGoalsCount() - teamOne.getReceivedGoalsCount();
                int goalDifference2 = teamTwo.getScoredGoalsCount() - teamTwo.getReceivedGoalsCount();
                if (goalDifference1 > goalDifference2)
                    return -1;
                else if (goalDifference1 < goalDifference2)
                    return 1;
                else return 0;
            }

        }

    }

    //addMatch
    @Override
    public void addPlayedMatch(String home,String away,int homeGoals,int awayGoals, Date date){
        if (footballClubList.isEmpty()) {      //checking the list - empty list or not
            //if the list is empty system will indicate no club is found
            System.out.println("< < < No sports clubs found! empty list  > > >");
        }else {

            FootballClub homeC = null;      //initializing null value
            for (FootballClub club : footballClubList) {
                if (club.getNameOfTheSportsClub().equals(home))
                    homeC = club;
            }
            //checking that is the club is available
            if (homeC == null) {
                System.out.println("< < < No such club is found > > >");
                return;
            }

            FootballClub awayC = null;
            //checking the away teams's name with sports clubs
            for (FootballClub club : footballClubList) {
                if (club.getNameOfTheSportsClub().equals(away))
                    awayC = club;
            }
            if (awayC == null) {
                System.out.println("< < < No such club is found > > >");    //displaying error message
                return;
            }

            //asking the user to enter a valid number(positive number) for goal if the input is less than -1
            if (homeGoals <= -1) {
                System.out.println("< < < please enter a valid positive number for goals > > >");
                return;
            }

            if (awayGoals <= -1) {
                System.out.println("< < < please enter a valid positive number for goals > > >");
                return;
            }

            Match newMatchP = new Match(home,away,homeGoals,awayGoals,date.toString());  //Creating object of class new played match
            newMatchP.setTeam_1(home);
            newMatchP.setTeam_2(away);
            newMatchP.setScoreOfTheTeam_1(awayGoals);
            newMatchP.setScoreOfTheTeam_2(homeGoals);
            //Adding match details to array list
            matchPlayedList.add(newMatchP);
            homeC.setScoredGoalsCount(homeC.getScoredGoalsCount() + homeGoals);
            awayC.setScoredGoalsCount(awayC.getScoredGoalsCount() + awayGoals);
            homeC.setReceivedGoalsCount(homeC.getReceivedGoalsCount() + awayGoals);
            awayC.setReceivedGoalsCount(awayC.getReceivedGoalsCount() + homeGoals);
            homeC.setNumberOfMatchesPlayed(homeC.getNumberOfMatchesPlayed() + 1);
            awayC.setNumberOfMatchesPlayed(awayC.getNumberOfMatchesPlayed() + 1);

            if (homeGoals > awayGoals) {
                homeC.setPoints(homeC.getPoints() + 3);
                homeC.setWinCount(homeC.getWinCount() + 1);
                awayC.setDefeatCount(awayC.getDefeatCount() + 1);
            } else if (homeGoals < awayGoals) {
                awayC.setPoints(awayC.getPoints() + 3);
                awayC.setWinCount(awayC.getWinCount() + 1);
                homeC.setDefeatCount(homeC.getDefeatCount() + 1);
            } else {
                homeC.setPoints(homeC.getPoints() + 1);
                awayC.setPoints(awayC.getPoints() + 1);
                homeC.setDrawCount(homeC.getDrawCount() + 1);
                awayC.setDrawCount(awayC.getDrawCount() + 1);
            }
        }
    }

    //Storing Data
    @Override
    public void save(){
        //FileOutputStream can be used to write data into the file
        //ObjectOutputStream can be used covert an object to outputStream
        try {
            File saveCFile  = new File("FootballDetails.txt");
            FileOutputStream fileOutputS = new FileOutputStream(saveCFile);
            ObjectOutputStream objectOutputS = new ObjectOutputStream(fileOutputS);
            objectOutputS.writeObject(footballClubList);
            objectOutputS.close();
            //displaying success message if the data has been stored successfully
            System.out.println("< < < Saved successfully > > >");
        }catch (IOException e){
            //if there is no data system will ask to try again
            System.out.println("Sorry! There is no data.. please try again");
        }
    }

    //storing data
    public void save2() {
        try{
            File saveMfile = new File("DetailsOfPlayedMatch.txt");
            FileOutputStream fileInSt = new FileOutputStream(saveMfile);
            ObjectOutputStream objectOtSt = new ObjectOutputStream(fileInSt);
            objectOtSt.writeObject(matchPlayedList);
            objectOtSt.close();
            //displaying success message if the data has been stored successfully
            System.out.println("< < < Saved successfully > > >");
        }catch(IOException e){
            //if there is no data system will ask to try again
            System.out.println("Sorry! There is no data.. please try again");
        }
    }

    //Retrieving Data
    public void retrieve(String retrieveFile) throws IOException,ClassNotFoundException{
        FileInputStream fileInputS = new FileInputStream(retrieveFile);
        ObjectInputStream objectInputS = new ObjectInputStream(fileInputS);

        for (;;) {
            try {
                FootballClub addMatch =(FootballClub) objectInputS.readObject();
                footballClubList.add(addMatch);
            } catch (EOFException e) {
                break;
            }
        }
        fileInputS.close();
        objectInputS.close();
        System.out.println("< < < Successfully Loaded > > >");    //displaying success message
    }

    //getting football club
    public List<FootballClub> getFbClubList(){
        File newFile = new File("FootballDetails.txt");
        try{
            FileInputStream fileInSt = new FileInputStream(newFile);
            ObjectInputStream objectInSt = new ObjectInputStream(fileInSt);
            footballClubList = (ArrayList<FootballClub>) objectInSt.readObject();
            objectInSt.close();
            return footballClubList;
        }catch (IOException | ClassNotFoundException e){
            return footballClubList;
        }
    }

    //getting  match club list
    public List<Match> getMatchClubList(){
        File playM = new File("DetailsOfPlayedMatch.txt");
        try{
            FileInputStream fileInSt = new FileInputStream(playM);
            ObjectInputStream objectInSt = new ObjectInputStream(fileInSt);
            matchPlayedList = (ArrayList<Match>) objectInSt.readObject();
            objectInSt.close();
            return matchPlayedList;
        }catch (IOException | ClassNotFoundException e){
            return matchPlayedList;
        }
    }

}

