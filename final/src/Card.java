public class Card {
    private String rank;
    private String suit;

    public static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getCardName() {
        return rank + " of " + suit; // Ensure correct format
    }

    public String toString() {
        return getCardName();
    }
}