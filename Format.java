import java.util.*;

public class Format {
    public static void main (String[] args) {
        System.out.println(String.format("My number %,15.1f crazy.", 476578.09876));
        System.out.println(String.format("My number %,15d crazy.", 476578));
        System.out.println(String.format("%tc", new Date()));
        System.out.println(String.format("%tr", new Date()));
        System.out.println(String.format("%tA, %td %tB", new Date(), new Date(), new Date()));
        System.out.println(String.format("%tA, %<td %<tB", new Date()));
    }
}