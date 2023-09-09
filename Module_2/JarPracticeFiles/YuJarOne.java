public class Team {
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    public Team(String teamName) {
        this.teamName = teamName;
    }
    public void addPlayer(String player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Player list is full.");
        }
    }

    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }

}
