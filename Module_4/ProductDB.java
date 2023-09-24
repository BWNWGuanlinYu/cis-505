public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<Product>();

        if (code.equalsIgnoreCase("b")) {
            Ball ball1 = new Ball();
            ball1.setCode("B500");
            ball1.setDescription("Phaze III");
            ball1.setPrice(154.99);
            ball1.setColor("Purple and Green");
            products.enqueue(ball1);

            Ball ball2 = new Ball();
            ball2.setCode("B400");
            ball2.setDescription("Force Unleashed");
            ball2.setPrice(139.99);
            ball2.setColor("Red and White");
            products.enqueue(ball2);

            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Proton Physix");
            ball3.setPrice(174.95);
            ball3.setColor("Pink and Purple");
            products.enqueue(ball3);

            Ball ball4 = new Ball();
            ball4.setCode("B200");
            ball4.setDescription("Axiom Pearl");
            ball4.setPrice(154.95);
            ball4.setColor("Blue and Red");
            products.enqueue(ball4);

            Ball ball5 = new Ball();
            ball5.setCode("B100");
            ball5.setDescription("Black Widow 2.0");
            ball5.setPrice(144.95);
            ball5.setColor("Black and Red");
            products.enqueue(ball5);
        } else if (code.equalsIgnoreCase("a")) {
            Bag bag1 = new Bag();
            bag1.setCode("A300");
            bag1.setDescription("Silver/Royal Blue");
            bag1.setPrice(74.99);
            bag1.setType("Triple");
            products.enqueue(bag1);

            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");
            products.enqueue(bag2);

            Bag bag3 = new Bag();
            bag3.setCode("A100");
            bag3.setDescription("Path Pro Deluxe");
            bag3.setPrice(34.99);
            bag3.setType("Single");
            products.enqueue(bag3);
        } else if (code.equalsIgnoreCase("s")) {
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S500");
            shoe1.setDescription("Youth Skull Green/Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(3.0);
            products.enqueue(shoe1);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S400");
            shoe2.setDescription("Men's Tribal White");
            shoe2.setPrice(26.99);
            shoe2.setSize(8.5);
            products.enqueue(shoe2);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6.0);
            products.enqueue(shoe3);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S100");
            shoe4.setDescription("Men's Ram Black");
            shoe4.setPrice(39.99);
            shoe4.setSize(10.5);
            products.enqueue(shoe4);
        }

        return products;
    }
}
