/**
 * Created by tomer on 9/4/15.
 */
public class Date {
    private int day, month, year;

    public Date(int year,int month,int day) {
        this.day = day;this.month = month;this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static int getDatesDifference(Date first, Date second) {
        return (first.getYear() - second.getYear()) * 365 + (first.getMonth() - second.getMonth()) * 30 + (first.getDay() - second.getDay());
    }

}
