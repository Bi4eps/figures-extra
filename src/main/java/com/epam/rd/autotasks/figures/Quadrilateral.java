package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        points = new Point[4];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        points[3] = point4;

        checkPoints();
        //new Triangle(point1, point2, this.centroid()).checkPoints();
        //new Triangle(point3, point4, this.centroid()).checkPoints();
        checkConvexity();
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

    private void checkConvexity() {
        IllegalArgumentException exception = new IllegalArgumentException();

        int n = points.length;
        int sign = 0;

        for (int i = 0; i < n; i++) {
            int dx1 = (int) (points[(i + 1) % n].getX() - points[i].getX());
            int dy1 = (int) (points[(i + 1) % n].getY() - points[i].getY());
            int dx2 = (int) (points[(i + 2) % n].getX() - points[(i + 1) % n].getX());
            int dy2 = (int) (points[(i + 2) % n].getY() - points[(i + 1) % n].getY());

            int crossProduct = dx1 * dy2 - dx2 * dy1;

            if (sign == 0) {
                sign = Integer.signum(crossProduct);
            } else if (sign != Integer.signum(crossProduct)) throw exception;
        }
    }
}