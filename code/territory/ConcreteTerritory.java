package risk;

public class ConcreteTerritory extends Territory {

    public ConcreteTerritory(String territoryName) {
        super(territoryName);
    }

    /**
        Uguaglianza basata sul nome.
    */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof ConcreteTerritory) {
                ConcreteTerritory otherTerritory = (ConcreteTerritory) obj;
                return this.name.equalsIgnoreCase(otherTerritory.name);
            }
        }
        return false;
    }

}
