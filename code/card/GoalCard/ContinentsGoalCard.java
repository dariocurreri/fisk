package risk;

import java.util.List;

/**
 * Carta obiettivo dei continenti da conquistare.
 */
public class ContinentsGoalCard extends GoalCard<List<Continent>> {

    /**
     * Istanzia una carta obiettivo dei continenti da conquistare.
     *
     * @param continents continenti da conquistare
     */
    public ContinentsGoalCard(List<Continent> continents) {
        super(continents);
    }

    @Override
    public String toString() {
        String goal = "Continents to conquer goal card: ";
        goal = this.card.stream().map((continent) -> continent.getName() + ", ").reduce(goal, String::concat);
        return goal.substring(0, goal.lastIndexOf(","));
    }

}
