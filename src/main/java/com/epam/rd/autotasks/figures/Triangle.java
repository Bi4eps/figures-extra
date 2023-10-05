package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    public Triangle(Point point1, Point point2, Point point3) {
        points = new Point[3];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;

        checkPoints();
    }

    @Override
    public double area() {
        double x1 = points[0].getX();
        double y1 = points[0].getY();
        double x2 = points[1].getX();
        double y2 = points[1].getY();
        double x3 = points[2].getX();
        double y3 = points[2].getY();

        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
        return area;
    }
}
