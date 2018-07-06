package ru.codecrafts;

public class Rectangle {
    private final double mLength;
    private final double mWidth;

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
    public double calculateArea() {        
        return mLength * mWidth;
    }
}
