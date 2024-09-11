import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
private List<Card> cards;


public Deck() { 
	cards=new ArrayList<>();
	createDeck(); }
private void createDeck() {
	String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
	

for (String suit : suits) {
	for (String rank: Card.RANKS) {cards.add(new Card (rank, suit));

	}
}
}
public void shuffle () {
	Collections.shuffle(cards);

}
// the above code is basically one massive collection of methods,
//is gonna go through and create a card of every rank,and add it to the "card" list.
//i chose to use a list here, since, ultimately, a list is mutable
//so imma just take away a card from the list every time its drawn, 
public Card drawCard () {
	if (!cards.isEmpty()) {return cards.remove(0);
	}
	else {System.out.println("game finished");
	return null;
	}
}

public int deckSize() {
	return cards.size(); 
} 
}

