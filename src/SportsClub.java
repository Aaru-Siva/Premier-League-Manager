
/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: https://www.baeldung.com/java-pojo-class
                https://www.tutorialspoint.com/pojo-vs-java-beans
*/

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private String nameOfTheSportsClub;
    private String locationOfTheClub;       //initializing variables

    //constructor
    public SportsClub(){}
    public SportsClub(String nameOfTheSportsClub, String locationOfTheClub) {
        this.nameOfTheSportsClub = nameOfTheSportsClub;
        this.locationOfTheClub = locationOfTheClub;
    }

     /* Getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable
    */

    //Getters and setters
    public String getNameOfTheSportsClub() {
        return nameOfTheSportsClub;
    }

    public void setNameOfTheSportsClub(String nameOfTheSportsClub) {
        this.nameOfTheSportsClub = nameOfTheSportsClub;
    }

    public String getLocationOfTheClub() {
        return locationOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {
        this.locationOfTheClub = locationOfTheClub;
    }

    @Override   //this method is used to check equality between two boolean object
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(nameOfTheSportsClub, that.nameOfTheSportsClub) ;
    }

    @Override   //hashCode() will return integer value
    public int hashCode() {
        return Objects.hash(nameOfTheSportsClub, locationOfTheClub);
    }

    @Override   //this toString() returns string representation of the object
    public String toString() {
        return "SportsClub{" +
                "nameOfTheSportsClub='" + nameOfTheSportsClub + '\'' +
                ", locationOfTheClub='" + locationOfTheClub + '\'' +
                '}';
    }
}
