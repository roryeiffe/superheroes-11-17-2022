package org.example;

public class Reverse {
    public static void main(String[] args) {
        String s = "racecar";
        // try to reverse the string without the built-in String Buffer method:
        char[] arr = s.toCharArray();
        char[] result = new char[arr.length];
        // counter for result
        int incr = 0;
        for(int decr = arr.length - 1; decr >= 0; decr--) {
            result[incr] = arr[decr];
            incr ++;
        }
        // convert the array back to string:
        String resultString = new String(result);
        System.out.println(resultString);

        // concise way:
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb.toString());

        // even more concise way:
        System.out.println(new StringBuilder(s).reverse());
    }
}
