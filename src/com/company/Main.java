package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("/////////****** isEven");
        int x = 0;
        isEven(x);


        System.out.println("\n\n\n\n ///////****** spelledSame!");
        try{
            System.out.println("Test 1 is " + spelledSame("grable", "Grable"));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        try{
            System.out.println("Test 1 is " + spelledSame("grable ", "Grable"));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        try{
            System.out.println("Test 1 is " + spelledSame("1grable", "Grable"));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        try {printExceptW("w");}
        catch(Exception e){System.out.println(e.toString());}


        System.out.println("\n\n\n ////**** randNumPrint");
        int randomNum = randNumPrint();
        System.out.println(randomNum);

        System.out.println("\n\n\n\n //////******* nextDay");
        System.out.println(nextDay(31, 12, 1990));
        System.out.println(nextDay(31, 4, 1990));
        System.out.println(nextDay(31, 55, 1990));
        System.out.println(nextDay(12, 12, 1990));
        System.out.println(nextDay(28, 2, 1990));
        System.out.println(nextDay(29, 2, 1990));
        System.out.println(nextDay(28, 2, 1991));
        System.out.println(nextDay(28, 2, 1992));
        System.out.println(nextDay(29, 2, 1992));

        System.out.println("\n\n\n\n ///////******* chopUp");
        System.out.println(chopUp("abc"));
        System.out.println(chopUp("stuff"));
        System.out.println(chopUp(" asoiaeorigh2oa;l,adv"));


        System.out.println("\n\n\n\n ///////******** printUpTo");
        printUpTo(3);
        printUpTo(5);
        printUpTo(9);
        printUpTo(-2);


        System.out.println("\n\n\n //////***** weirdSum");
        System.out.println(weirdSum(1, 2));
        System.out.println(weirdSum(2, 2));


        System.out.print("\n\n\n\n //////*******    enterCountryDomain ");
        enterCountry();


        System.out.println("\n\n\n\n ///////******** isVowel");
        isVowel();
    }

    public static boolean isEven(int num){
        if (num == 0) {
            return false;
        } else {
            return (num % 2) == 0;
        }
    }

    /*
    public static boolean isValidWord(String s){
        return s.matches("[a-zA-Z]+") && (s != null);
    }
    */

    public static boolean spelledSame(String s1, String s2) throws Exception{
        if(s1 != null || s2 != null) {
            if (!s1.matches("[a-zA-Z]+") || !s2.matches("[a-zA-Z]+")) {
                return false;
            }
            else{
                return s1.toLowerCase().equals(s2.toLowerCase());
            }
        }
        else {
            throw new NullPointerException();
        }
    }

    public static void printExceptW(String s) throws Exception{
        if(s != null) {
            //System.out.println("It's a word");
            if (!s.matches("[a-zA-Z]+")) {
                throw new Exception("Not a Word!");
            }
            else{
                char[] chars = s.toCharArray();
                for(int i=0;i<chars.length;i++){
                    if(chars[i] == 'w' || chars[i] == 'W'){
                        return;
                    }
                    System.out.println(chars[i]);
                }
            }
        }
        else {
            throw new NullPointerException();
        }
    }

    public static int randNumPrint(){
        int num = (int) (Math.random() * 100);
        System.out.println(num);
        if(num > 50)
            return num;
        return -1;
    }

    public static String nextDay(int day, int month, int year){
        String nextDay;
        int newDay, newMonth = month, newYear = year;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (day == 31){
                    newDay = 1;
                    newMonth = month + 1;
                }
                else if (day > 31){
                    return "Not a valid date!";
                }
                else {
                    newDay = day + 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30){
                    newDay = 1;
                    newMonth = month + 1;
                }
                else if (day > 30){
                    return "not a valid date!";
                }
                else {
                    newDay = day + 1;
                }
                break;
            case 2:
                if (isLastDayOfFeb(day, year) == 1){
                    newDay = 1;
                    newMonth = month + 1;
                }
                else if (isLastDayOfFeb(day, year) < 0){
                    return "not a valid date!";
                }
                else {
                    newDay = day + 1;
                }
                break;
            case 12:
                if(day == 31){
                    newDay = 1;
                    newMonth = 1;
                    newYear = year + 1;
                }
                else if (day > 31){
                    return "Not a valid date!";
                }
                else {
                    newDay = day + 1;
                }
                break;
            default:
                return "Not a valid month!";
        }
        nextDay = "day:" + newDay + " month:" + newMonth + " year:" + newYear;
        return nextDay;

    }

    public static int isLastDayOfFeb(int day, int year){
        //return 1 if it's the last day
        if((day == 28 && ((year % 4) != 0)) || (day == 29 && ((year % 4) == 0))) {
            /*System.out.println("final 28: " + (day == 28 && ((year % 4) != 0)));
            System.out.println("Leap Year?: "+ ((year % 4) != 0));
            System.out.println("Year % 4: " + (year % 4));
            System.out.println("final 29: " + (day == 29 && ((year % 4) == 0))); */
            return 1;
        }
        //return -1 if it's not a correct day of the month
        else if((day > 28 && ((year % 4) != 0)) || (day > 29 && ((year % 4) == 0))) {
            /*System.out.println("invalid 28: " + (day > 28 && ((year % 4) != 0)));
            System.out.println("invalid 29: " + (day > 29 && ((year % 4) == 0))); */
            return -1;
        }
        //return 0 if it's not the last day but still a day
        else
            return 0;
    }

    public static String chopUp(String s) {
        String newString = "";
        if(s != null) {
            //System.out.println("It's a word");
            if (!s.matches("[a-zA-Z]+")) {
                return "Not a Word!";
            }
            else{
                char[] chars = s.toCharArray();
                //System.out.println(chars.length);
                for(int i=0;i<chars.length;i++){
                    if(isEven(i) || i == 0){
                        newString += chars[i];
                        //System.out.println(chars[i]);
                    }
                }
                return newString;
            }
        }
        else {
            return "Not a valid String!";
        }
    }

    public static void printUpTo(int num){
        if(num <= 5){
            System.out.println("Not a number greater than 5!");
            return;
        }
        else{
            int i = 1;
            while(i <= num){
                if(i != 4)
                    System.out.println(i);
                i++;
            }
        }
    }

    public static int weirdSum(int num1, int num2){
        if(num1 != num2){
            return num1 + num2 + 2;
        }
        else{
            return num1 + num2 + 4;
        }
    }

    public static void enterCountry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type a country domain below:");
        String line = scanner.nextLine();
        line = line.toLowerCase();
        switch(line){
            case "de":
                System.out.println("Germany");
                break;
            case "us":
                System.out.println("United States");
                break;
            case "hu":
                System.out.println("Hungary");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public static void isVowel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type a letter:");
        String line = scanner.nextLine();
        //System.out.println(line);
        //System.out.println("line exists?: " + (line != null));
        //System.out.println("line is a single character?: " + (line.length() == 1));
        //System.out.println("line length: " + line.length());
        //System.out.println("line is a letter?: " + line.matches("^[a-z]$"));
        if((line != null) && (line.length() == 1) && !line.matches("^[a-z]$")){
            System.out.println("Not a letter!");
            return;
        }
        line = line.toLowerCase();
        if (line.matches("^[aeiou]$")) {
            System.out.println("A vowel!");
            return;
        }
        else if(line.matches("^[y]$")) {
            System.out.println("A vowel! (maybe...)");
            return;
        }
        else {
            System.out.println("A consonant!");
            return;
        }
    }

}
