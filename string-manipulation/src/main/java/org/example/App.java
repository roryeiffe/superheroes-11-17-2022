package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    // https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#
    public static void main( String[] args )
    {
        String s = "The quick    brown    fox    jumps over    the lazy dog";
        String [] splitString = s.split(" ");
        printArray(splitString);

        String s2 = "     \t\t\n  Decemeber 9th     ";

        String s3 = "cat      dog";

        System.out.println(s2.trim());
        System.out.println(s3.trim());

        // let's combine these and trim the white space in the first sentence:
        // 1. Split on the individual space and just ignore/remove all empty strings
        // 2. Split by word, keeping in mind that each word could have more spaces, regex //s*
        // 3.
        // https://regexr.com/ Good Regex cheatsheet/tester
        // split this string on 1 or more white-spaces
        printArray(s.split("\\s+"));

        System.out.println(s);
        System.out.println(s2);

        // use valueOf to convert primitives to a String
        String s4 = String.valueOf(34);
        System.out.println(s4.charAt(0));

    }

    public static void printArray(Object [] arr) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.println("[" + arr[i] + "]");
        }
    }
}
