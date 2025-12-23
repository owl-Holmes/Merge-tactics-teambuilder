package main.java.entities;

import java.util.Set;

/**
 * Represents a Merge Tactics card.
 *
 * @param name The name of the considered Card.
 * @param firstTrait Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
 * @param secondTrait Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
 * @throws IllegalArgumentException if we try to create a Card with two same traits.
 * @author owl
 */
public record Card(String name, Clans firstTrait, Clans secondTrait) {

    /**
     * Constructor of a Merge Tactics card.
     *
     * @param name The name of the considered Card.
     * @param firstTrait Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
     * @param secondTrait Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
     * @throws IllegalArgumentException if we try to create a Card with two same traits.
     */
    public Card {
        if(firstTrait.equals(secondTrait))
            throw new IllegalArgumentException("Given traits cannot be the same.");
    }

    /**
     * Equals overrided method defines how two cards are equal.
     *
     * @param obj the reference object with which to compare.
     * @return true if the two cards are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card other)) return false;
        return name.equals(other.name) &&
                Set.of(firstTrait, secondTrait).equals(Set.of(other.firstTrait, other.secondTrait));
    }

    /**
     * Gives a String representation of a {@code Card}.
     *
     * @return a String representation of a {@code Card}.
     */
    @Override
    public String toString(){
        return name;
    }
}