public class Ball extends Product {
    private String color = "";

    // Constructor
    public Ball() {
    }

    // Getter and Setter method for color

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override toString method to include color information
    @Override
    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}
