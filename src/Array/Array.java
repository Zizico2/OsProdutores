package Array;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa uma coleção de elementos genericos.
 *
 * @param <Elem> elemento generico (ie. StaffMember, Vedette, Recording, etc.).
 */
public interface Array<Elem> {

    //Constantes
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

    /**
     * Adiciona um objeto ao vetor da class numa determinada posicao.
     *
     * @param object objeto a adicionar.
     * @param pos    posicao.
     */
    void add(Elem object, int pos);

    /**
     * inicializa o iterador, aka current = 0.
     */
    void initialize();


    /**
     * remove o elemento 0 do vetor e devolve o.
     *
     * @return elemento removido.
     */
    Elem remove();


    /**
     * remove o elemento numa determinada posicao.
     *
     * @param i posicao do elemento a remover.
     */
    void remove(int i);

    /**
     * remove um determinado elemento.
     *
     * @param e elemento a remover.
     */
    void remove(Elem e);


    /**
     * devolve o indice do elemento corrente.
     *
     * @return current - 1.
     */
    int getCurrentElem();

    /**
     * devolve o indice do ultimo elemento do array.
     *
     * @return counter.
     */
    int length();
}
