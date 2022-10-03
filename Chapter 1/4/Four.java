public interface Polynomial {
    public int degree();
    public Polynomial derivative();
    public boolean equals(Object object);
    public Polynomial sum(Polynomial other);
    public String toString();
    public double valueAt(double x);
}
