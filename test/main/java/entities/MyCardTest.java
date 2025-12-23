package main.java.entities;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static main.java.entities.ExistingCards.*;
import static org.junit.Assert.*;

public class MyCardTest {

    @Test
    public void constructor_throws_exception() throws IOException {
        Clans[] allClans = Clans.values();
        for(Clans a : allClans){
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Card("Mudkip", a, a)
            );
        }
    }

    @Test
    public void equals_true() throws IOException {
        Card a = BANDIT.card();
        Card b = BANDIT.card();

        Card c = ELECTRO_GIANT.card();
        Card d = ELECTRO_GIANT.card();
        assertEquals(a,b);
        assertEquals(b,a);
        assertEquals(a.equals(b), true);
        assertEquals(b.equals(a), true);
        assertEquals(c.equals(d), true);
        assertEquals(d.equals(c), true);
        assertEquals(a,a);
        assertEquals(b,b);
        assertEquals(c,c);
        assertEquals(d,d);
        assertEquals(a.equals(a), true);
        assertEquals(b.equals(b), true);
        assertEquals(c.equals(c), true);
        assertEquals(d.equals(d), true);

        List<Card> allCards = ExistingCards.allCards();
        for(Card card : allCards){
            assertEquals(card, card);
            assertEquals(card.equals(card), true);
        }
    }

    @Test
    public void equals_false() throws IOException {
        Card a = BANDIT.card();
        Card b = BANDIT.card();
        Card c = ELECTRO_GIANT.card();
        Card d = ELECTRO_GIANT.card();

        assertNotEquals(a,c);
        assertNotEquals(c,a);
        assertNotEquals(a,d);
        assertNotEquals(d,a);
        assertNotEquals(b,c);
        assertNotEquals(c,b);
        assertNotEquals(b,d);
        assertNotEquals(d,b);
        assertEquals(a.equals(c),false);
        assertEquals(b.equals(d),false);
    }
}
