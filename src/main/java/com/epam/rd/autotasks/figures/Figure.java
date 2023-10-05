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

    public Point centroid() {
        double sumX = 0, sumY = 0;
        for (Point el : points) {
            sumX += el.getX();
            sumY += el.getY();
        }

        return new Point(sumX / points.length, sumY / points.length);
    }
    public boolean isTheSame(Figure figure) {
        boolean namesIsSame = figure.getClass().getSimpleName().equals(this.getClass().getSimpleName());

        if (namesIsSame) {
            return isPointsTheSame(figure);
        } else return false;
    }

    private boolean isPointsTheSame(Figure figure) {
        //System.out.println(pointsToString());

        double [] [] ownPoints = new double[points.length] [2];
        for (int i = 0; i < points.length; i++) {
            ownPoints[i] [0] = points[i].getX();
            ownPoints[i] [1] = points[i].getY();
        }
        ownPoints = insertionSort(ownPoints);

        System.out.println(figure.pointsToString());
        double [] [] otherPoints = new double[points.length] [2];
        for (int i = 0; i < points.length; i++) {
            otherPoints[i] [0] = figure.points[i].getX();
            otherPoints[i] [1] = figure.points[i].getY();
        }

        otherPoints = insertionSort(otherPoints);

        for (int i = 0; i < otherPoints.length; i++) {//
            for (int j = 0; j < otherPoints[0].length; j++) {
                System.out.print(otherPoints[i] [j] + "    ");
            }
            System.out.println();
        } //
        System.out.println();



        return arrsSame(ownPoints, otherPoints);
    }

    private boolean arrsSame(double[] [] arr1, double[] [] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                //System.out.print(arr1[i][j] + " == " + arr2[i][j] + "\n");
                if ((float) arr1[i][j] != (float) arr2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static double[] [] insertionSort(double[] [] a) {
        /*for (int i = 0; i < a.length; i++) {//
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i] [j] + "    ");
            }
            System.out.println();
        } //
        System.out.println();*/


        for (int i = 1; i < a.length; i++) {
            double value = a[i] [0];
            double y = a[i] [1];
            int j;
            for (j = i - 1; j >= 0 && a[j][0] > value; j--) {
                a[j + 1] [0] = a[j] [0];
                a[j + 1] [1] = a[j] [1];
            }

            a[j + 1][0] = value;
            a[j + 1][1] = y;
        }
        return a;
    }
}



