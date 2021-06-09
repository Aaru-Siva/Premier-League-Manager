/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: Case study and tutorials
    https://stackoverflow.com/questions/226910/how-to-sanity-check-a-date-in-java
*/
import java.io.Serializable;

public class Date implements Serializable {
    // Months: 12 months , Days: Based on 31 days , Year: Any years
    private int month;
    private int day;    //initializing variables
    private int year;

    //constructor
    public Date(int day, int month, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //getters and setters for month
    public int getMonth(int month){     //getting month
        return month;
    }

    public int setMonth(int testMonth){     //setting month
        if (testMonth>0 && testMonth<=12)
            return testMonth;
        else{
            //if the user enters wrong input system will indicate it
            System.out.printf("Sorry invalid month (%d)set to 1.",testMonth);
            return 1;
        }
    }

    //getters and setters for day
    public int getDay(int testDay){     //getting day
        return day;
    }

    public int setDay(int testDay) {       //setting day
        int daysPerMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (testDay > 0 && testDay <= daysPerMonth[month])
            return testDay;
        if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            return testDay;
        //if the user enters wrong input system will indicate it
        System.out.printf("Sorry invalid day (%d)set to 1.",testDay);
        return 1;
    }

    //getters and setters for year
    public int getYear(){       //getting year
        return year;
    }

    public void setYear(int year){      //setting year
        this.year = year;
    }

    //toString() is used to get a String object representing the value of the Number Object
    public String toString(){
        return String.format("%d-%d-%d",day,month,year);
    }
}
