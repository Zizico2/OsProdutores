package Scenery;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um cenário.
 */
public interface Scenery {

    /**
     * Devolve o preco por hora.
     *
     * @return pricePerHour.
     */
    int getPricePerHour();

    /**
     * Devolve o nome.
     *
     * @return name.
     */
    String getName();
}
