// Name: Guanlin Yu
// Class: CIS505
public class CustomerDB {

    public static Customer getCustomer(Integer id) {
        if(id == 1007) {
            return new Customer("Alice", "123 Main St", "Springfield", "12345");
        } else if(id == 1008) {
            return new Customer("Bob", "456 Elm St", "Shelbyville", "67890");
        } else if(id == 1009) {
            return new Customer("Charlie", "789 Oak St", "Capital City", "11223");
        } else {
            return new Customer(); // Default customer
        }
    }
}
