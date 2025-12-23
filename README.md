# ༼ つ ◕_◕ ༽つ Merge tactics teambuilder️



<p align="center">
  <img src="https://img.shields.io/badge/Java-21-blue" alt="Java Version" />
  <img src="https://img.shields.io/badge/Tests-JUnit%204-blue" alt="Tests" />
  <img src="https://img.shields.io/badge/Tests%20Passed-Passing-brightgreen" alt="Tests Passed" />
  <img src="https://img.shields.io/badge/License-MIT-lightgrey" alt="License" />
</p>

---

This Java project allows to calculate and determine all the "buffed" possible 
teams constructible in Merge Tactics. 
The cards and the clans/traits used here are based on 
the [december 2025](https://supercell.com/en/games/clashroyale/blog/release-notes/merge-tactics-update-december-2025/)
released version.

---
## ✨Features
Here, I tried to make a constructor for all "buffed" teams possible. I define here a "buffed" team
as a team of cards where we exploit all the possible clan/trait buffs. A "buffed" team is, in 
that case, a team in which all occurrences of a clan/trait are of 0, 2, 4 or 6 exclusively. That
maximises the possible buffs, but it doesn't ensure a good team or to win, that stats may be the
worst possible, if all the buffs are good then it is a "buffed" team. (●'◡'●)

- ✅ `Main` 
  - The `Main` file, when run, creates a `teams.txt` file in resources and writes in it all the 
  possible buffed teams constructible.
- ✅ `TeamAdvisor`
  - The `TeamAdvisor` file, when run, reads the `teams.txt` file and extracts from it all the teams. Then
  it asks the user to give pre-existent cards in the team and prints the teams that have the given cards in it.

---
##  ༼ つ ◕_◕ ༽つ Usage
Just clone the repo and run the `Main`, then run the `TeamAdvisor` and that's it!

---
## (☞ﾟヮﾟ)☞  Project Structure

    src
    └─── main
         └── java
              ├── Main.java              # Entry point – buffed team generation
              ├── TeamAdvisor.java       # Team filtering reading
              ├── Utilities.java         # Helper with utility method
              └── entities
                  ├── Card.java          # Card definition and logic
                  ├── Clans.java         # Clan/trait enum
                  ├── ExistingCards.java # Predefined cards enum
                  └── Team.java          # Team definition and logic
       

    resources
    └── teams.txt              # Generated teams by the Main

    test
    └── main
        └── java
            └── entities
                ├── MyCardTest.java    # Unit tests for Card
                └── MyTeamTest.java    # Unit tests for Team

---
## (╯°□°）╯︵ ┻━┻ Example usage and its output
When the pre-existent cards are **Bandit** and **Executioner**: 

    What is the next preexistent card in the Team?
    Bandit

    Do you still have another preexistant card  ? 0 = No - 1 = Yes
    1

    What is the next preexistent card in the Team?
    Executioner

    Do you still have another preexistant card  ? 0 = No - 1 = Yes
    0

    Preexistant cards were entered, let's find some teams:
    [Bandit, Executioner, Archer queen, Wizard, Goblin, Dart goblin]
    [Bandit, Executioner, Archer queen, Wizard, Royal ghost, Skeleton dragon]
    [Bandit, Executioner, Barbarian, Wizard, Golden knight, Prince]
    [Bandit, Executioner, Valkyrie, Wizard, Goblin, Goblin machine]
    [Bandit, Executioner, Valkyrie, Wizard, Royal ghost, Skeleton king]
    [Bandit, Executioner, Spear goblin, Goblin machine, Royal ghost, Skeleton king]
    [Bandit, Executioner, Spear goblin, Dart goblin, Royal ghost, Skeleton dragon]
    [Bandit, Executioner, Musketeer, Princess, Royal ghost, Witch]


---
##  (┬┬﹏┬┬) Tests
I provided some basic tests in the test directory for `Card` and `Team` classes just to be sure their
instantiation was good as well as the `equals` method but for the main code of generating the teams
and reading them in the files, the only test was to try it and verify by hand (•_•). 

    ⚠️ Performance Note
    One of the tests in `MyTeamTest` is a real **BRUTEFORCE** trying all the combinations possible for
    every card with also some repetitions (`constructor_throws_exception`), so, that test may take 10-20 
    minutes to finish (⊙_⊙;).


---
## 🔄 Make it your own and update it
All the constructing, writing and reading "buffed" teams is normally dynamic so it has not 
to be updated but for the cards and clans/traits you'll have to update them by hand. 
Go in `main/java/entities`: 
- For the clans/traits, go in the `Clans` file and modify if clans were removed or added. 
- For the cards, go in `ExistingCards` file and add the new ones in the same format as the previous
ones. The creation of those cards rely on the `Card` class. 

---
## 🦉 Author 𓂀

**owl**  
🔗 [GitHub – owl](https://github.com/owl-Holmes)

---

## 📄 License

Distributed under the MIT License.  
For more details, see the LICENSE file.