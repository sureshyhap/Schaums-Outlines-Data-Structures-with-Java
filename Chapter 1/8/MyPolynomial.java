public class MyPolynomial implements Polynomial {
   private double[] coefficients;
   
   public MyPolynomial(double[] a) {
      coefficients = new double[a.length];
      System.arraycopy(a, 0, coefficients, 0, a.length);
   }
   
   public int degree() {
      return coefficients.length - 1;
   }
   
   public Polynomial derivative() {
      double[] result = new double[coefficients.length - 1];
      System.arraycopy(coefficients, 0, result, 0, coefficients.length - 1);
      for (int i = 0, j = coefficients.length - 1; i < coefficients.length - 1; ++i, --j) {
         result[i] *= j;
      }
      return new MyPolynomial(result);
   }
   
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (!(object instanceof MyPolynomial)) {
         return false;
      }
      MyPolynomial poly = (MyPolynomial)object;
      return java.util.Arrays.equals(coefficients, poly.coefficients);
   }
   
   public Polynomial sum(Polynomial otherPoly) {
      MyPolynomial other = (MyPolynomial)otherPoly;
      boolean thisIsLonger = coefficients.length > other.coefficients.length; 
      double[] result = new double[Math.max(coefficients.length, other.coefficients.length)];
      if (thisIsLonger) {
         System.arraycopy(coefficients, 0, result, 0, result.length);
         for (int i = 0; i < other.coefficients.length; ++i) {
            result[i + 1] += other.coefficients[i];
         }
      }
      else {
         System.arraycopy(other.coefficients, 0, result, 0, result.length);
         for (int i = 0; i < coefficients.length; ++i) {
            result[i + 1] += coefficients.length;
        }
      }
      return new MyPolynomial(result);
   }
   
   public String toString() {
      StringBuffer sb = new StringBuffer();
      for (int i = 0, j = coefficients.length - 1; i < coefficients.length; ++i, --j) {
         sb.append(coefficients[i]);
         sb.append("x^");
         sb.append(j);
         sb.append(" + ");
      }
      // Removes the last "x^0 + "
      return new String(sb.substring(0, sb.length() - 6));
   }
   
   public double valueAt(double x) {
      double value = 0;
      for (int i = 0, j = coefficients.length - 1; i < coefficients.length; ++i, --j) {
         value += (coefficients[i] * Math.pow(x, j));
      }
      return value;
   }
}

class MainMyPolynomial {
   public static void main(String[] args) {
      MyPolynomial myPoly = new MyPolynomial(new double[]{3, 4, 1});
      MyPolynomial myPoly2 = new MyPolynomial(new double[]{8, 3});
      System.out.println(myPoly.sum(myPoly2));
   }
}
