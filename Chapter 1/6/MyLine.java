public class MyLine implements Line {
   private double slope;
   private double yInt;
   private static final double ERROR_TOLERANCE = .001;
   
   public MyLine(double slope, double yInt) {
      this.slope = slope;
      this.yInt = yInt;
   }
   
   public boolean contains(Point point) {
      double resulting_y = slope * point.xCoordinate() + yInt;
      return (Math.abs(resulting_y - point.yCoordinate()) < ERROR_TOLERANCE);
   }
   
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (!(object instanceof MyLine)) {
         return false;
      }
      MyLine other = (MyLine)object;
      return (slope == other.slope && yInt == other.yInt);
   }
   
   public boolean isHorizontal() {
      return ((slope - 0) < ERROR_TOLERANCE);
   }
   
   public boolean isVertical() {
      return (((1 / slope) - 0) < ERROR_TOLERANCE);
   }
   
   public double slope() {
      return slope;
   }
   
   public String toString() {
      return String.format("y = %fx + %f", slope, yInt);
   }
   
   public double xIntercept() {
      // Solve y = mx + b for x when y == 0
      return -yInt / slope;
   }
   
   public double yIntercept() {
      return yInt;
   }
}

class MainMyLine {
   public static void main(String[] args) {
      MyLine ml = new MyLine(2, 4);
      System.out.println(ml.xIntercept());
   }
}
