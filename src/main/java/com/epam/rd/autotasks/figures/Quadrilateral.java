package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        points = new Point[4];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        points[3] = point4;
    }

    @Override
    public double area() {
        // Formula for the area of a general quadrilateral (Shoelace formula)
        double x1 = points[0].getX();
        double y1 = points[0].getY();
        double x2 = points[1].getX();
        double y2 = points[1].getY();
        double x3 = points[2].getX();
        double y3 = points[2].getY();
        double x4 = points[3].getX();
        double y4 = points[3].getY();

        double area = 0.5 * Math.abs((x1 * y2 + x2 * y3 + x3 * y4 + x4 * y1)
                - (y1 * x2 + y2 * x3 + y3 * x4 + y4 * x1));
        return area;
    }

    @Override
    public Point centroid() {
        return null;
    }
}