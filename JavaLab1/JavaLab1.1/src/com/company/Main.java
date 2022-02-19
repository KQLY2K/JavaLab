package com.company;

import java.util.Scanner; //подключаем класс Сканер, чтобы вводить число с клавиатуры

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner sc = new Scanner(System.in); //создаём объект этого класса, чтобы пользоваться его методами

        int n = sc.nextInt();//метод вввода числа с клавиатуры
        System.out.println(isPrime(n));//выводим результат
    }

    public static  boolean isPrime(int n){//метод определения простоты числа
        int count = 0;
        for (int i = 1; i <= n; i++){//перебираем делители
            if (n % i == 0){
                count++;
            }
        }
        if (count == 2){// сохраняем результат
            return true;
        }
        else {
            return false;
        }
    }
}
