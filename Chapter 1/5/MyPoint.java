public class MyPoint implements Point {
   private double x, y;
   private static final Point ORIGIN = new MyPoint();
   
   private MyPoint() {
      this(0, 0);
   }
   
   public MyPoint(double x, double y) {
      this.x = x;
      this.y = y;
   }
   
   public double amplitude() {
      return Math.atan(y / x);
   }
   
   public double distanceTo(Point point) {
      MyPoint p = (MyPoint)point;
      double delta_x = this.x - p.x;
      double delta_y = this.y - p.y;
      return Math.sqrt(delta_x * delta_x + delta_y * delta_y);
   }
   
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (!(object instanceof MyPoint)) {
         return false;
      }
      MyPoint other = (MyPoint)object;
      return (this.x == other.x && this.y == other.y);
   }
   
   public double magnitude() {
      return distanceTo(ORIGIN);
   }
   
   public String toString() {
      return String.format("(%.2f, %.2f)", x, y);
   }
   
   public double xCoordinate() {
      return x;
   }
   
   public double yCoordinate() {
      return y;
   }
}

class MainMyPoint {
   public static void main(String[] args) {
      MyPoint p = new MyPoint(4, 4);
      MyPoint p2 = new MyPoint(4, 4);
      System.out.println(p.xCoordinate());
   }
}

