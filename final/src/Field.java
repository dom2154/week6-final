public class Field {
    private Deck deck;
    private Players player1;
    private Players player2;

    // Constructor initializes the deck, players, and shuffles the deck
    public Field(String player1Name, String player2Name) {
        deck = new Deck();
        deck.shuffle();

        // Initialize two players
        player1 = new Players(player1Name);
        player2 = new Players(player2Name);
    }

    // game rules
    public void playGame() {
        // Play until the deck is empty
        while (deck.deckSize() > 0) {
            // Each player draws a card
            Card card1 = deck.drawCard();
            Card card2 = deck.drawCard();

            // Check if both cards were drawn (just for sake of error checking)
            if (card1 != null && card2 != null) {
                System.out.println(player1.getName() + " drew: " + card1.getCardName());
                System.out.println(player2.getName() + " drew: " + card2.getCardName());

                // Compare the two cards and update the score
                int comparison = compareCards(card1, card2);
                if (comparison > 0) {
                    System.out.println(player1.getName() + " wins this round.");
                    player1.increaseScore();
                } else if (comparison < 0) {
                    System.out.println(player2.getName() + " wins this round.");
                    player2.increaseScore();
                } else {
                    System.out.println("It's a tie! No points awarded.");
                }

                // Display current scores after each round
                displayScores();

                // Pause for a second each rounds (cause otherwise it looks bad to get a massive terminal print all at once
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("The sleep was interrupted: " + e.getMessage());
                }
            }
        }

        // Game over, declare the winner
        declareWinner();
    }

    // Compare two cards based on their rank
    private int compareCards(Card card1, Card card2) {
        // Get the index of the rank in the RANKS array to determine its value
        int rank1Value = getCardRankValue(card1);
        int rank2Value = getCardRankValue(card2);

        return Integer.compare(rank1Value, rank2Value);
    }

    // Helper method to get the rank value of a card
    private int getCardRankValue(Card card) {
        String cardName = card.getCardName();
        // Extract rank part before " of " substring
        String rank = cardName.split(" of ")[0].trim();  
        System.out.println("Card: " + cardName + ", Extracted Rank: " + rank);  // Debug print

        for (int i = 0; i < Card.RANKS.length; i++) {
            if (Card.RANKS[i].equalsIgnoreCase(rank)) {
                return i;
            }
        }
        return -1;  // In case something goes wrong
    }

    // Display the current scores of both players
    private void displayScores() {
        System.out.println(player1.getPlayerInfo());
        System.out.println(player2.getPlayerInfo());
        System.out.println();
    }

    // Declare the winner at the end of the game
    private void declareWinner() {
        System.out.println("Game over!");
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game with a score of " + player1.getScore() + "!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins the game with a score of " + player2.getScore() + "!");
        } else {
            System.out.println("It's a tie! Both players scored " + player1.getScore() + ".");
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        // Create a field with two players
        Field field = new Field("Player 1", "Player 2");

        // Start the game
        field.playGame();
    }
}