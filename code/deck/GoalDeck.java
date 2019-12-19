/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.*;

/**
 *
 * @author dario
 */
public class GoalDeck extends Deck<GoalCard> {

    public GoalDeck(List<Continent> continents, List<Territory> territories) {
        this.deck.add(new NumberTerritoriesGoalCard(territories.size() / 2));
        this.deck.add(new NumberTerritoriesGoalCard(territories.size() / 7 * 3));
        for (Continent continent : continents) {
            List<Continent> temp = new ArrayList<>();
            temp.add(continent);
            Random random = new Random();
            Continent otherContinent = continents.get(random.nextInt(continents.size()));
            while (continent.equals(otherContinent)) {
                otherContinent = continents.get(random.nextInt(continents.size()));
            }
            temp.add(otherContinent);
            this.deck.add(new ContinentsGoalCard(temp));
        }
        for (RiskColor color : RiskColor.values()) {
            this.deck.add(new KillGoalCard(color));
        }
        Collections.shuffle(this.deck);
    }

    @Override
    public String toString() {
        return "Goal Deck: " + super.toString();
    }

}
