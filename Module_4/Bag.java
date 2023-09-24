public class Bag extends Product {
    private String type = "";

    // Constructor
    public Bag() {
    }

    // Getter and Setter method for type

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override toString method to include type information
    @Override
    public String toString() {
        return super.toString() + "\nType: " + type;
    }
}
