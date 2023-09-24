public class Shoe extends Product {
    private double size = 0;

    // Constructor
    public Shoe() {
    }

    // Getter and Setter method for size

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    // Override toString method to include size information
    @Override
    public String toString() {
        return super.toString() + "\nSize: " + size;
    }
}
