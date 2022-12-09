package org.example;

public class CamelCase {
    public static void main(String[] args) {
        String s1 = "mechanic shop";
        String s2 = "Mechanic Shop";
        String s3 = "       ";
        //
        System.out.println(camelCase(s1));
        System.out.println(camelCase(s2));
        System.out.println(camelCase(s3));
    }

    public static String camelCase(String s) {
        String [] arr = s.split("\\s+");
        // edge case, if we get all white space:
        if(arr.length < 1) return "";
        // MAke a string builder to hold our result,
        // starting with the lower case version of the first word:
        StringBuilder sb = new StringBuilder(arr[0].toLowerCase());
        for(int i = 1; i < arr.length; i ++) {
            String currentWord = arr[i];
            // manipulate currentWord so that it has a capital letter?
            sb.append(Character.toUpperCase(currentWord.charAt(0)));
            sb.append(currentWord.substring(1));
        }
        return sb.toString();
    }

    public static void printArray(Object [] arr) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.println("[" + arr[i] + "]");
        }
    }
}
