/*
       Student Name: Aarany Sivanathan
       Student ID: 2019693
       UoW ID: w1789958
*/

import java.io.Serializable;

//Serializable used to mark java classes
public class Match implements Serializable {

    private String team_1;    //initializing variables
    private String team_2;
    private int scoreOfTheTeam_1;
    private int scoreOfTheTeam_2;
    private String date;

    //constructor
    public Match(String team_1, String team_2, int scoreOfTheTeam_1, int scoreOfTheTeam_2, String date) {
        this.team_1 = team_1;
        this.team_2 = team_2;
        this.scoreOfTheTeam_1 = scoreOfTheTeam_1;
        this.scoreOfTheTeam_2 = scoreOfTheTeam_2;
        this.date = date;
    }

    /*
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable
    */

    //Getters and setters
    public String getTeam_1() {
        return team_1;
    }

    public void setTeam_1(String team_1) {
        this.team_1 = team_1;
    }

    public String getTeam_2() {
        return team_2;
    }

    public void setTeam_2(String team_2) {
        this.team_2 = team_2;
    }

    public int getScoreOfTheTeam_1() {
        return scoreOfTheTeam_1;
    }

    public void setScoreOfTheTeam_1(int scoreOfTheTeam_1) {
        this.scoreOfTheTeam_1 = scoreOfTheTeam_1;
    }

    public int getScoreOfTheTeam_2() {
        return scoreOfTheTeam_2;
    }

    public void setScoreOfTheTeam_2(int scoreOfTheTeam_2) {
        this.scoreOfTheTeam_2 = scoreOfTheTeam_2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

