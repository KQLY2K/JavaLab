package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){ //переборка аргументов командной строки
            String s = args[i];
            System.out.println(isPalindrome(s));//вывод результата
        }
    }

    public static String reverseStr(String s){//метод, переворачивающий строку
        String a = "";
        for (int i = s.length() - 1; i>=0;i--){
            a += s.charAt(i);
        }
        return a;
    }

    public static boolean isPalindrome(String s){//метод, сравнивающий строки
        String s1 = reverseStr(s);
        return s.equals(s1);
    }
}