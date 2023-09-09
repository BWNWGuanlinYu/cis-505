// TestFanApp.java
public class TestFanApp {

    public static void main(String[] args) {
        // Creating fan using default constructor
        Fan defaultFan = new Fan();
        System.out.println(defaultFan);

        // Creating fan using argument constructor
        Fan customFan = new Fan(Fan.MEDIUM, true, 8, "blue");
        System.out.println(customFan);
    }
}
