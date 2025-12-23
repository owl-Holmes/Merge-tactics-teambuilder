package main.java.entities;

import org.junit.Test;

import java.io.IOException;

import static main.java.entities.ExistingCards.*;
import static org.junit.Assert.*;

public class MyTeamTest {

    @Test
    public void constructor_throws_exception() throws IOException {
        for(Card a : ExistingCards.allCards()){
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Team(a,a,a,a,a,a)
            );
        }
        for(Card a : ExistingCards.allCards()){
            for(Card b : ExistingCards.allCards()){
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Team(a,b,b,b,b,b)
                );
            }
        }

        for(Card a : ExistingCards.allCards()){
            for(Card b : ExistingCards.allCards()){
                for(Card c : ExistingCards.allCards()){
                    for(Card d : ExistingCards.allCards()){
                        for(Card e : ExistingCards.allCards()){
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(a,b,c,d,e,b)
                            );
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(a,a,c,d,e,b)
                            );
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(a,b,c,d,e,b)
                            );
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(e,e,c,d,e,b)
                            );
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(a,b,b,d,e,b)
                            );
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () -> new Team(a,e,d,c,a,b)
                            );
                        }
                    }
                }
            }
        }
    }

    @Test
    public void equals_true() throws IOException {
        Team a = new Team(
                BANDIT.card(),
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card()
        );
        Team b = new Team(
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card()
        );
        Team c = new Team(
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card(),
                EXECUTIONER.card(),
                ELECTRO_GIANT.card()
        );
        Team d = new Team(
                ELECTRO_GIANT.card(),
                SKELETON_KING.card(),
                EXECUTIONER.card(),
                SKELETON_DRAGON.card(),
                WITCH.card(),
                BANDIT.card()
        );

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
        assertEquals(a.equals(c), true);
        assertEquals(c.equals(d), true);
        assertEquals(b.equals(d), true);
        assertEquals(d.equals(d), true);
        assertEquals(a.equals(a), true);
        assertEquals(a.equals(d), true);
        assertEquals(c.equals(c), true);
        assertEquals(d.equals(c), true);
    }

    @Test
    public void equals_false() throws IOException {
        Team a = new Team(
                BANDIT.card(),
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card()
        );
        Team b = new Team(
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                GOBLIN_CARD.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card()
        );
        Team c = new Team(
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card(),
                DART_GOBLIN.card(),
                ELECTRO_GIANT.card()
        );
        Team d = new Team(
                SPEAR_GOBLIN.card(),
                MUSKETEER.card(),
                EXECUTIONER.card(),
                SKELETON_DRAGON.card(),
                WITCH.card(),
                BANDIT.card()
        );

        assertNotEquals(a,b);
        assertNotEquals(b,a);
        assertNotEquals(a.equals(b), true);
        assertNotEquals(b.equals(a), true);
        assertNotEquals(c.equals(d), true);
        assertNotEquals(d.equals(c), true);
        assertNotEquals(a.equals(c), true);
        assertNotEquals(c.equals(d), true);
        assertNotEquals(b.equals(d), true);
        assertNotEquals(a.equals(d), true);
        assertNotEquals(d.equals(c), true);
    }


    @Test
    public void contains_tests() throws IOException {
        Team a = new Team(
                BANDIT.card(),
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card()
        );
        Team b = new Team(
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                GOBLIN_CARD.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card()
        );
        Team c = new Team(
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card(),
                BANDIT.card(),
                DART_GOBLIN.card(),
                ELECTRO_GIANT.card()
        );
        Team d = new Team(
                SPEAR_GOBLIN.card(),
                MUSKETEER.card(),
                EXECUTIONER.card(),
                SKELETON_DRAGON.card(),
                WITCH.card(),
                BANDIT.card()
        );

        for(Card card : a.getCardsOfTheTeam()){
            assertTrue(a.contains(card));
        }
        for(Card card : b.getCardsOfTheTeam()){
            assertTrue(b.contains(card));
        }
        for(Card card : c.getCardsOfTheTeam()){
            assertTrue(c.contains(card));
        }
        for(Card card : d.getCardsOfTheTeam()){
            assertTrue(d.contains(card));
        }

        assertFalse(a.contains(DART_GOBLIN.card()));
        assertFalse(b.contains(MUSKETEER.card()));
    }

    @Test
    public void isBuffed_tests() throws IOException {
        Team a = new Team(
                BANDIT.card(),
                EXECUTIONER.card(),
                ELECTRO_GIANT.card(),
                SKELETON_DRAGON.card(),
                SKELETON_KING.card(),
                WITCH.card()
        );
        Team b = new Team(
                BARBARIAN.card(),
                VALKYRIE.card(),
                SPEAR_GOBLIN.card(),
                GOBLIN_MACHINE.card(),
                PRINCE.card(),
                PRINCESS.card()
        );
        assertFalse(a.isBuffed());
        assertTrue(b.isBuffed());
    }

}
