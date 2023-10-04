import java.util.Scanner;
import java.util.List;
//@author Guanlin Yu



public class TestComposerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComposerDao composerDao = new MemComposerDao();

        while (true) {
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Composers");
            System.out.println("2. Find Composer");
            System.out.println("3. Add Composer");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    List<Composer> composers = composerDao.findAll();
                    System.out.println("-DISPLAYING COMPOSERS--");
                    for (Composer composer : composers) {
                        System.out.println(composer);
                    }
                    break;
                case 2:
                    System.out.print("Enter an id: ");
                    int idToFind = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Composer foundComposer = composerDao.findBy(idToFind);
                    if (foundComposer != null) {
                        System.out.println("-DISPLAYING COMPOSER--");
                        System.out.println(foundComposer);
                    } else {
                        System.out.println("Composer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter an id: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter a name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter a genre: ");
                    String newGenre = scanner.nextLine();

                    Composer newComposer = new Composer(newId, newName, newGenre);
                    composerDao.insert(newComposer);
                    System.out.println("Composer added successfully.");
                    break;
                case 4:
                    System.out.println("Exiting the Composer App.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
