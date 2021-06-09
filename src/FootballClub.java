
/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: https://www.baeldung.com/java-pojo-class
                https://www.tutorialspoint.com/pojo-vs-java-beans
*/

public class FootballClub extends SportsClub {

    private int winCount;
    private int drawCount;
    private int defeatCount;        //initializing variables
    private int scoredGoalsCount;
    private int receivedGoalsCount;
    private int points;
    private int numberOfMatchesPlayed;
    private int goalDifference;


    //Constructor
    //private FootballClub(){}
    public FootballClub(String nameOfTheSportsClub, String locationOfTheClub, int winCount, int drawCount, int defeatCount, int scoredGoalsCount, int receivedGoalsCount, int points, int numberOfMatchesPlayed, int goalDifference) {
        super(nameOfTheSportsClub, locationOfTheClub);
        this.winCount = winCount;
        this.drawCount = drawCount;
        this.defeatCount = defeatCount;
        this.scoredGoalsCount = scoredGoalsCount;
        this.receivedGoalsCount = receivedGoalsCount;
        this.points = points;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.goalDifference = scoredGoalsCount-receivedGoalsCount;
    }

    public FootballClub(String name, String location) {
        super(name,location);
    }

    /* Getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable
    */

    //Getters and setters
    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

    public int getGoalDifference() { return goalDifference; }

    public void setGoalDifference(int goalDifference) { this.goalDifference = goalDifference; }

    public int getScoredGoalsCount() {
        return scoredGoalsCount;
    }

    public void setScoredGoalsCount(int scoredGoalsCount) {
        this.scoredGoalsCount = scoredGoalsCount;
    }

    public int getReceivedGoalsCount() {
        return receivedGoalsCount;
    }

    public void setReceivedGoalsCount(int receivedGoalsCount) {
        this.receivedGoalsCount = receivedGoalsCount;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed; }

    @Override   //this toString() returns string representation of the object
    public String toString() {
        return "FootballClub{" +
                "winCount=" + winCount +
                ", drawCount=" + drawCount +
                ", defeatCount=" + defeatCount +
                ", scoredGoalsCount=" + scoredGoalsCount +
                ", receivedGoalsCount=" + receivedGoalsCount +
                ", points=" + points +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                ", goalDifference=" + goalDifference +
                '}';
    }
}
