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
        Object aux = null;

        switch (type) {
            case SENIOR_PRODUCER:
                SeniorProducer s = new CollaboratorClass(name, payPerHour);
                aux = s;
                break;
            case JUNIOR_PRODUCER:
                JuniorProducer j = new CollaboratorClass(name, payPerHour);
                aux = j;
                break;
            case VEDETTE_ACTOR:
                Actor va = new VedetteClass(name, payPerHour);
                aux = va;
                break;
            case NORMAL_ACTOR:
                Actor Na = new CollaboratorClass(name, payPerHour);
                aux = Na;
                break;
            case VEDETTE_DIRECTOR:
                Director Vd = new VedetteClass(name, payPerHour);
                aux = Vd;
                break;
            case NORMAL_DIRECTOR:
                Director Nd = new CollaboratorClass(name, payPerHour);
                aux = Nd;
                break;
            case TECHNICIAN:
                Technician T = new CollaboratorClass(name, payPerHour);
                aux = T;
        }
        staff.add((Collaborator) aux);
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

}
