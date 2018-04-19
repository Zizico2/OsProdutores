package Staff;

import Iterator.Iterator;

public class VedetteClass extends CollaboratorClass implements Vedette {

    Iterator<Collaborator> blacklist;

    public VedetteClass(String name, int payPerHour) {
        super(name, payPerHour);
    }

    public void mope(String name){

    }
}
