import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the team name:");
            String teamName = scanner.nextLine();

            System.out.println("Enter player names separated by commas:");
            String playerNamesStr = scanner.nextLine();
            String[] playerNames = playerNamesStr.split(",");

            Team team = new Team(teamName);
            for (String playerName : playerNames) {
                team.addPlayer(playerName.trim());
            }

            System.out.println("  Number of players in team: " + team.getPlayerCount());
            System.out.print("  Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            System.out.println("Do you want to enter another team? (y/n)");
            String response = scanner.nextLine();
            
            if (response.trim().equalsIgnoreCase("n")) {
                break;
            }
        }

    


        scanner.close();
    }
}
