public class MyCircle implements Circle {
   private Point center;
   private double radius;
   private static final double ERROR_TOLERANCE = .001;
   
   public MyCircle(Point center, double radius) {
      this.center = center;
      this.radius = radius;
   }
   
   public double area() {
      return Math.PI * radius * radius;
   }
   
   public Point center() {
      return center;
   }
   
   public double circumference() {
      return 2 * Math.PI * radius;
   }
   
   public boolean contains(Point point) {
      return ((center.distanceTo(point) - radius) < ERROR_TOLERANCE);
   }
   
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (!(object instanceof MyCircle)) {
         return false;
      }
      MyCircle other = (MyCircle)object;
      return ((center.distanceTo(other.center) < ERROR_TOLERANCE) && (radius - other.radius < ERROR_TOLERANCE));
   }
   
   public double radius() {
      return radius;
   }
   
   public String toString() {
      return String.format("(x - %.2f)^2 + (y - %.2f)^2 = %.2f", center.xCoordinate(), center.yCoordinate(), radius * radius);
   }
}

class MainMyCircle {
   public static void main(String[] args) {
      MyCircle circle = new MyCircle(new MyPoint(1, 2), 4);
      System.out.println(circle);
   }
}