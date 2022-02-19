package com.company;

public class Point3d {
    private double x;
    private  double y;
    private double z;

    public Point3d(){ //конструктор без значений
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public  Point3d(double x, double y, double z){ //конструктор, если значения задаются
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean comparePoints(double x1, double y1, double z1, double x2, double y2, double z2){ //метод сравнения значений двух объектов
        if ((x1 == x2) && (y1 == y2) && (z1 == z2)){
            return true;
        }
        else return false;
    }

    public double distanceTo(Point3d obj1, Point3d obj2){ //метод для нахождения расстояния между точками
        double d = Math.sqrt(Math.pow(obj1.x - obj2.x, 2) + Math.pow(obj1.y - obj2.y,2) + Math.pow(obj1.z - obj2.z, 2));
        return d;
    }

    /*
    Ниже присутствуеют аксессоры, для обращения к закрытым полям класса.
    */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
