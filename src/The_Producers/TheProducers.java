package The_Producers;

import Iterator.Iterator;
import Staff.Collaborator;

public interface TheProducers {




    void add(String name, int payPerHour, CollaboratorType type);

    Iterator<Collaborator> staff();



}
