package com.company;

import java.util.Scanner;//подключаем класс Сканер для ввода значений с клавиатуры

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Создание объекта класса Сканер для пользования его методами
        /*
        ниже мы вводим значения для точек треугольника
         */
        System.out.println("Введите координаты первой точки по порядку");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double z1 = sc.nextDouble();
        System.out.println("Введите координаты второй точки по порядку");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double z2 = sc.nextDouble();
        System.out.println("Введите координаты третьей точки по порядку");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        double z3 = sc.nextDouble();
        /*
        создаём объекты-точки
         */
        Point3d obj1 = new Point3d(x1, y1, z1);
        Point3d obj2 = new Point3d(x2, y2, z2);
        Point3d obj3 = new Point3d(x3, y3, z3);
        /*
        проверяем на совпадения значений
         */
        if ((obj1.comparePoints(x1,y1,z1,x2,y2,z2) == true) | (obj1.comparePoints(x1,y1,z1,x3,y3,z3) == true) | (obj1.comparePoints(x3,y3,z3,x2,y2,z2) == true)){
            System.out.println("Точки совпадают");
            System.exit(0);
        }
        System.out.println(ComputerArea(obj1, obj2, obj3));//Ответ

    }

    public static double ComputerArea(Point3d obj1, Point3d obj2, Point3d obj3){//метод расчёта площади
        /*
        нахождение расстояние между точками
         */
        double a = obj1.distanceTo(obj1, obj2);
        double b = obj2.distanceTo(obj2, obj3);
        double c = obj3.distanceTo(obj3, obj1);
        double p = (a + b + c)/2;//полупериметр
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));//формула Герона
        return s;
    }
}

