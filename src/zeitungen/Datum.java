package zeitungen;

public class Datum {
    public final int day;
    public final int month;
    public final int year;

    public Datum(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
}
