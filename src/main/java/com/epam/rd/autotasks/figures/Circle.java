package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final double radius;

    public Circle(Point center, double radius) {
        IllegalArgumentException exception = new IllegalArgumentException();

        if (radius <= 0) throw exception;
        else this.radius = radius;

        if (center == null) throw exception;
        else {
            points = new Point[1];
            points[0] = center;
        }
    }

    @Override
    public double area() {
        return Math.PI * Math.pow((float) radius, 2);
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
        return points[0];
    }

    @Override
    public boolean isTheSame(Figure figure) {
        boolean namesIsSame = figure.getClass().getSimpleName().equals(this.getClass().getSimpleName());
        boolean centerIsSame = (float) figure.points[0].getX() == (float) points[0].getX() &&
                (float) figure.points[0].getY() == (float) points[0].getY();

        return namesIsSame && centerIsSame && area() == figure.area();
    }
}