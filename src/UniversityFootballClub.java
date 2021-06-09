
/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: https://www.baeldung.com/java-pojo-class
                https://www.tutorialspoint.com/pojo-vs-java-beans
*/

public class UniversityFootballClub extends SportsClub{

    //constructors Declaration
    public UniversityFootballClub(String nameOfTheSportsClub, String locationOfTheClub, String universityName) {
        super(nameOfTheSportsClub, locationOfTheClub);
        this.universityName = universityName;
    }

   /* Getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable
    */
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    private String universityName;  //initializing variables

    @Override   //this toString() returns string representation of the object
    public String toString() {
        return "UniversityFootballClub{" +
                "university Name='" + universityName + '\'' +
                '}';
    }
}

