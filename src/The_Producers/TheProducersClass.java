package The_Producers;

import Iterator.*;
import Staff.*;
import Staff.Tag_Interfaces.*;

public class TheProducersClass implements TheProducers {

    Iterator<Recording> calendar;
    Iterator<Collaborator> staff;

    public TheProducersClass(){
        staff = new IteratorClass<Collaborator>();
        calendar = new IteratorClass<Recording>();
    }

    @Override
    public void add(String name, int payPerHour, CollaboratorType type) {
        switch (type) {
            case SENIOR_PRODUCER:
                SeniorProducer s = new CollaboratorClass(name, payPerHour);
                staff.add((Collaborator) s);
                break;
            case JUNIOR_PRODUCER:
                JuniorProducer j = new CollaboratorClass(name, payPerHour);
                staff.add((Collaborator) j);
                break;
            case VEDETTE_ACTOR:
                Actor va = new VedetteClass(name, payPerHour);
                ((Vedette) va).getName();
                staff.add((Collaborator) va);
                break;
            case NORMAL_ACTOR:
                Actor Na = new CollaboratorClass(name, payPerHour);
                staff.add((Collaborator) Na);
                break;
            case VEDETTE_DIRECTOR:
                Director Vd = new VedetteClass(name, payPerHour);
                staff.add((Collaborator) Vd);
                break;
            case NORMAL_DIRECTOR:
                Director Nd = new CollaboratorClass(name, payPerHour);
                staff.add((Collaborator) Nd);
                break;
            case TECHNICIAN:
                Technician T = new CollaboratorClass(name, payPerHour);
                staff.add((Collaborator) T);
        }
    }

    @Override
    public Iterator<Collaborator> staff() {
        return staff;
    }

    public int getType(String type){
        switch(type){
            case "":
        }
    return 0;
    }

    
    public void test(){

        if (staff.next() instanceof Actor)
            System.out.println("Actor");

        if (staff.next() instanceof Vedette)
            System.out.println("Vedette");

        if (staff.next() instanceof Collaborator)
            System.out.println("Collaborator");

    }

}
