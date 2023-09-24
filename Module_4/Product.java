public class Product {
    private String code = "";
    private String description = "";
    private double price = 0;

    // Constructor
    public Product() {
    }

    // Getter and Setter methods for code, description, and price

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to format product information
    @Override
    public String toString() {
        return "Product code: " + code + "\nDescription: " + description + "\nPrice: $" + String.format("$%,6.2f", price);
    }
}
