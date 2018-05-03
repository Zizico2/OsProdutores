package Scenery;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class SceneryClass implements Scenery {

    // Variaveis de instancia
    private final String name;
    private final int pricePerHour;

    // Construtor
    public SceneryClass(String name, int pricePerHour){
        this.name = name;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }
}
