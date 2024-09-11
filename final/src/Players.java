public class Players {
    private String name;
    private int score;

    // Constructor to initialize player's name and starting score (0)
    public Players(String name) {
        this.name = name;
        this.score = 0;
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Increase player's score by 1
    public void increaseScore() {
        score++;
    }

    // Get the player's current score (returns int)
    public int getScore() {
        return score;
    }

    // Get the player's name and score as a formatted string
    public String getPlayerInfo() {
        return name + " (score: " + score + ")";
    }
}