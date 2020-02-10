//import java.util.Date;
import java.util.Calendar;

public class Date {
    public static void main (String[] args) {
        //Старая библиотека java.util.Date
        //Date today = new Date();
        //System.out.println(String.format("%tc", today));
        //System.out.println(String.format("%tr", today));
        //System.out.println(String.format("%tA, %td %tB", today, today, today));
        //System.out.println(String.format("%tA, %<td %<tB", today));

        //Новая библиотека java.util.Calendar
        Calendar c = Calendar.getInstance();
        c.set(2020,1,1,16,40);
        System.out.println("Adding 0 days " + c.getTime());
        long day1 = c.getTimeInMillis();
        System.out.println("New hour " + c.get(c.HOUR_OF_DAY));
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("New hour " + c.get(c.HOUR_OF_DAY));
        c.add(c.DATE, 35);
        System.out.println("Adding 35 days " + c.getTime());
        c.roll(c.DATE, 35);
        System.out.println("Rolling 35 days " + c.getTime());
        c.set(c.DATE, 5);
        System.out.println("Seting date in 1 " + c.getTime());
        c.set(c.YEAR, 2025);
        System.out.println("Seting year 2025 " + c.getTime());
        c.set(c.MONTH, 10);
        System.out.println("Seting month 10 " + c.getTime());
    }
}