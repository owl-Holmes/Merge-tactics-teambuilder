package main.java;

import main.java.entities.Card;
import main.java.entities.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility methods related to {@link Team} creation from a List helping in the {@link Main} & {@link TeamAdvisor}.
 *
 * @author owl
 */
public interface Utilities {

    /**
     * Creates a {@link Team} from a list of {@link Card}.
     * The provided List must contain exactly six cards and must not include duplicate card instances.
     *
     * @param list the List of cards used to create the {@link Team}.
     * @return a new {@link Team} composed of the given cards in the {@code list}.
     * @throws IllegalArgumentException if the List does not contain exactly six cards.
     * @throws IllegalArgumentException if the List contains duplicate cards.
     */
    static Team listToTeam(List<Card> list){
        if (list.size() != 6)
            throw new IllegalArgumentException("The number of card is not valid to create a Team.");
        Set<Card> set = new HashSet<>(list);
        if(set.size() != 6)
            throw new IllegalArgumentException("A Team can't have same cards.");
        return new Team(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
    }
}
