package ru.codecrafts;

public class Rectangle {
    private double mLength;
    private double mWidth;

    public Rectangle(double length, double width) {
        mLength = length;
        mWidth = width;
    }
    public double getLength() {
        return mLength;
    }
    public double getWidth() {
        return mWidth;
    }
    public double area(){
        return mLength * mWidth;
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle(2.78, 3.45);
        System.out.println("The length of the rectangle is " + rec.getLength());
        System.out.println("The breadth of the rectangle is " + rec.getWidth());
        System.out.println("The area is equal to " + rec.area());
    }
}
