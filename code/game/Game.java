package risk;

import java.util.List;
import java.util.Map;

public class Game {

    protected final List<Tris> allTris;
    protected final Map<Tris, Integer> trisBonus;
    protected final Map<Continent, Integer> continentsBonus;
    protected final List<Territory> territories;
    protected final List<Continent> continents;
    protected final ClassicDice[] attackDice;
    protected final ClassicDice[] defenseDice;
    protected final GoalDeck goalsDeck;
    protected final TerritoryDeck territoriesDeck;
    protected final SymbolDeck symbolDeck;
    protected final Map<RiskColor, TankPool> tanksPolls;

    public Game(List<Tris> allTris, Map<Tris, Integer> trisBonus,
            Map<Continent, Integer> continentsBonus, List<Territory> territories,
            List<Continent> continents, ClassicDice[] attackDice,
            ClassicDice[] defenseDice, GoalDeck goaslDeck,
            TerritoryDeck territoriesDeck, SymbolDeck symbolDeck,
            Map<RiskColor, TankPool> tanksPools) {
        this.allTris = allTris;
        this.trisBonus = trisBonus;
        this.continentsBonus = continentsBonus;
        this.territories = territories;
        this.continents = continents;
        this.attackDice = attackDice;
        this.defenseDice = defenseDice;
        this.goalsDeck = goaslDeck;
        this.territoriesDeck = territoriesDeck;
        this.symbolDeck = symbolDeck;
        this.tanksPolls = tanksPools;
    }

    public Integer getTrisBonus(Tris tris) {
        for (Tris validTris: this.trisBonus.keySet()) {
            if (validTris.equals(tris)) {
                return this.trisBonus.get(validTris);
            }
        }
        return null;
    }

    public Integer getContinentBonus(Continent continent) {
        for (Continent c: this.continentsBonus.keySet()) {
            if (c.equals(continent)) {
                return this.continentsBonus.get(c);
            }
        }
        return null;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public TerritoryDeck getTerritoriesDeck() {
        return this.territoriesDeck;
    }

    public GoalDeck getGoalsDeck() {
        return this.goalsDeck;
    }

    public Map<Tris, Integer> getAllTrisBonus() {
        return this.trisBonus;
    }
    
    public Map<Continent, Integer> getAllContinentsBonus() {
        return this.continentsBonus;
    }

    public ClassicDice[] getAttackDice() {
        return this.attackDice;
    }

    public ClassicDice[] getDefenseDice() {
        return this.defenseDice;
    }

    public TankPool getTanksPools(RiskColor riskColor) {
        return this.tanksPolls.get(riskColor);
    }

    public SymbolDeck getSymbolDeck() {
        return symbolDeck;
    }
    
}
