public class Point {
    double x;
    double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other){
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - y, 2));
    }
}
