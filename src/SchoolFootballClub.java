

/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: https://www.baeldung.com/java-pojo-class
                https://www.tutorialspoint.com/pojo-vs-java-beans
*/

public class SchoolFootballClub extends SportsClub{
    private String schoolName;  //initializing variables

    //constructors Declaration
    private SchoolFootballClub(){}

    public SchoolFootballClub(String nameOfTheSportsClub, String locationOfTheClub, String schoolName) {
        super(nameOfTheSportsClub, locationOfTheClub);
        this.schoolName = schoolName;
    }
    /* Getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable
    */

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override   //this toString() returns string representation of the object
    public String toString() {
        return "SchoolFootballClub{" +
                "school Name='" + schoolName + '\'' +
                '}';
    }
}
