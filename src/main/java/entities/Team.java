package main.java.entities;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class representing a Merge Tactics team.
 *
 * @author owl
 */
public class Team {
    /**
     * Contains all the cards of this Team.
     */
    private final List<Card> cardsOfTheTeam;

    /**
     * Maps all the {@link Clans} to their occurencies in this {@code Team}.
     */
    private final Map<Clans, Integer> clanOccurencies = new EnumMap<>(Clans.class);

    /**
     * Constructor of a {@code Team}.
     *
     * @param a is a {@link Card} from this {@code Team}.
     * @param b is a {@link Card} from this {@code Team}.
     * @param c is a {@link Card} from this {@code Team}.
     * @param d is a {@link Card} from this {@code Team}.
     * @param e is a {@link Card} from this {@code Team}.
     * @param f is a {@link Card} from this {@code Team}.
     * @throws IllegalArgumentException if two equal cards are given as a parameter.
     */
    public Team(Card a, Card b, Card c, Card d, Card e, Card f) {

        Card[] cards = {a, b, c, d, e, f};
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].equals(cards[j])) {
                    throw new IllegalArgumentException("A Team can't have two identical cards.");
                }
            }
        }

        for (Clans clan : EnumSet.allOf(Clans.class)) {
            clanOccurencies.put(clan, 0);
        }

        Set.of(a,b,c,d,e,f).forEach(x -> {
            clanOccurencies.computeIfPresent(x.firstTrait(), (k, v) -> v + 1);
            clanOccurencies.computeIfPresent(x.secondTrait(), (k, v) -> v + 1);
        });

        this.cardsOfTheTeam = List.of(a, b, c, d, e, f);
    }

    /**
     * Gives a String representation of a {@code Team}.
     *
     * @return a String representation of a {@code Team}.
     */
    @Override
    public String toString(){
        return cardsOfTheTeam.toString();
    }

    /**
     * Equals overrided method defines how two teams are equal.
     *
     * @param obj the reference object with which to compare.
     * @return true if the two teams are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Team other)) return false;
        AtomicBoolean a = new AtomicBoolean(true);
        cardsOfTheTeam.forEach(x -> {
            if(!other.getCardsOfTheTeam().contains(x)){
                a.set(false);
            }
        });
        return a.get();
    }

    /**
     * Gives the cards of this {@code Team}.
     *
     * @return the cards of this {@code Team}.
     */
    public List<Card> getCardsOfTheTeam() {
        return cardsOfTheTeam;
    }

    /**
     * Returns {@code true} if this {@code Team} contains the specified {@link Card}.
     * More formally, returns {@code true} if and only if this {@code Team} contains
     * at least one element {@code e} such that
     * {@code card.equals(e)}.
     *
     * @param card element whose presence in this {@code Team} is to be tested.
     * @return {@code true} if this {@code Team} contains the specified {@link Card}.
     */
    public boolean contains(Card card) {
        return cardsOfTheTeam.contains(card);
    }

    /**
     * The buffed method is here the center of this implementation to construct "optimised" teams of cards for
     * Merge Tactics. A {@code Team} is considered "buffed" if we are exploiting all the potential of the bonuses
     * that can be given by the Clans/traits combos.
     * Consequently, a {@code Team} is buffed if all Clans/traits that have at least one representative in the
     * {@code Team} have exactly the number of representatives to activate a buff. So, due to Merge Tactics rules;
     * 0, 2, 4 or 6 representatives.
     *
     * @return is this {@code Team} is buffed or not.
     */
    public boolean isBuffed() {
        return clanOccurencies.values().stream().allMatch(x -> x % 2 == 0);
    }
}