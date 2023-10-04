package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final double radius;

    public Circle(Point center, double radius) {
        this.radius = radius;
        points = new Point[1];
        points[0] = center;
    }

    @Override
    public double area() {
        // Formula for the area of a circle: π * r^2
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        double x = points[0].getX() - radius;
        double y = points[0].getY();

        return new Point(x, y);
    }

    @Override
    public Point centroid() {
        return null;
    }

    /*@Override
    public boolean isTheSame(Figure figure) {
        boolean namesIsSame = figure.getClass().getSimpleName().equals(this.getClass().getSimpleName());

        *//*if (namesIsSame) {
            return true;
        } else return false;*//*

        return namesIsSame &&
    }*/
}