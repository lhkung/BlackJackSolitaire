import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> shuffledDeck = new ArrayList<Card>();
    public Deck(){
        for (int i = 2; i < 13; i ++){
            shuffledDeck.add(new Card("S", i));
        }
        for (int i = 2; i < 13; i ++){
            shuffledDeck.add(new Card("H", i));
        }
        for (int i = 2; i < 13; i ++){
            shuffledDeck.add(new Card("D", i));
        }
        for (int i = 2; i < 13; i ++){
            shuffledDeck.add(new Card("C", i));
        }
    }
    public void shuffle(){
        Collections.shuffle(shuffledDeck);
    }
    public Card deal(){
        Card out = shuffledDeck.get(0);
        shuffledDeck.remove(0);
        return out;
    }
}
