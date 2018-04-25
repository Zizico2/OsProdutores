package Array;

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

   // void remove(Elem object);

    void initialize();

    Elem[] getArray();

    Elem remove();

    void remove(int i);

    int getCurrent();
}
