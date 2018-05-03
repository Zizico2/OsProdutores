package Array;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface Array<Elem> {

    int DEFAULT_SIZE = 10;
    int GROWTH_RATE = 2;

    /**
     * Verifica se existe um elemento a seguir no vetor.
     *
     * @return - true se houver elemento a seguir;
     *           false se nao houver.
     */
    boolean hasNext();

    /**
     *
     * @return - Element - Object Class
     */
    Elem next();

    /**
     * Adiciona um objeto ao vetor da class.
     *
     * @param object objeto a adicionar.
     */
    void add(Elem object);

    void add(Elem object,int pos);

   // void remove(Elem object);

    void initialize();

    Elem[] getArray();

    Elem remove();

    void remove(int i);

    void remove(Elem e);

    int getCurrentElem();

    int length();
}
