package com.epam.rd.autotasks.figures;

abstract class Figure{
    protected Point[] points;

    public abstract double area();

    public String pointsToString() {
        String output = "";
        for (Point el : points) {
            output += "(" + el.getX() + "," + el.getY() + ")";
        }

        return output;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public Point leftmostPoint() {
        Point leftmostPoint = points[0];
        for (Point el : points) {
            if (el.getX() < leftmostPoint.getX()) leftmostPoint = el;
        }
        return leftmostPoint;
    }

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}



