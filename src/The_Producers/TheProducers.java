package The_Producers;

import Iterator.Iterator;

public interface TheProducers {




    void add(String name, int payPerHour, CollaboratorType type);

    Iterator<Collaborator> staff();

    CollaboratorType getType(String type);



}
