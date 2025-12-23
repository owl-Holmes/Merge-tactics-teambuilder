package main.java.entities;
import java.util.Arrays;
import java.util.List;

import static main.java.entities.Clans.*;

/**
 * Enum representing all the playable cards actually available in Merge Tactics.
 *
 * @author owl
 */
public enum ExistingCards {
    BANDIT(          "Bandit",          ASSASSIN, ACE),
    PEKKA_CARD(      "PEKKA",           BRAWLER, PEKKA),
    EXECUTIONER(     "Executioner",     BLASTER, ACE),
    MEGA_KNIGHT(     "Mega knight",     BRAWLER, ACE),
    ARCHER_QUEEN(    "Archer queen",    CLAN, RANGER),
    BARBARIAN(       "Barbarian",       CLAN, BRAWLER),
    VALKYRIE(        "Valkyrie",        CLAN, BRUTALIST),
    ELECTRO_GIANT(   "Electro giant",   GIANT, SUPERSTAR),
    WIZARD(          "Wizard",          BLASTER, CLAN),
    GOBLIN_CARD(     "Goblin",          ASSASSIN, GOBLIN),
    SPEAR_GOBLIN(    "Spear goblin",    GOBLIN, BLASTER),
    GOBLIN_MACHINE(  "Goblin machine",  GOBLIN, BRUTALIST),
    DART_GOBLIN(     "Dart goblin",     GOBLIN, RANGER),
    GOLDEN_KNIGHT(   "Golden knight",   ASSASSIN, NOBLE),
    MUSKETEER(       "Musketeer",       NOBLE, SUPERSTAR),
    PRINCE(          "Prince",          NOBLE, BRAWLER),
    PRINCESS(        "Princess",        NOBLE, BLASTER),
    ROYAL_GHOST(     "Royal ghost",     ASSASSIN, UNDEAD),
    WITCH(           "Witch",           UNDEAD, SUPERSTAR),
    SKELETON_KING(   "Skeleton king",   UNDEAD, BRUTALIST),
    SKELETON_DRAGON( "Skeleton dragon", UNDEAD, RANGER),
    MINI_PEKKA(      "Mini PEKKA",      PEKKA, BRUTALIST),
    ROYAL_GIANT(     "Royal giant",     GIANT, RANGER),
    MONK(            "Monk",            ACE, SUPERSTAR);

    private final Card card;

    /**
     * Constructor of a Merge Tactics card adapted in {@code ExistingCards}.
     *
     * @param name The name of the considered {@link Card}.
     * @param c1 Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
     * @param c2 Every troop has 2 traits; each trait has unique effects when activated by 2 or 4 troops.
     */
    ExistingCards(String name, Clans c1, Clans c2) {
        this.card = new Card(name, c1, c2);
    }

    /**
     * Gives the card encapsulated in the {@code ExistingCards} enum.
     *
     * @return the considered {@link Card}.
     */
    public Card card() {
        return card;
    }

    /**
     * Utility static public variable useful to get all possible actually available Merge Tactics cards.
     *
     * @return a List containing all actually available cards.
     */
    public static List<Card> allCards() {
        return Arrays.stream(values())
                .map(ExistingCards::card)
                .toList();
    }
}