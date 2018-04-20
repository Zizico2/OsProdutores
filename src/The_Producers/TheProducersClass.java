package The_Producers;

import Iterator.*;
import Staff.Tags.Actor;
import Staff.Tags.Director;
import Staff.StaffMembers.JuniorProducerClass;
import Staff.StaffMembers.SeniorProducerClass;
import Staff.Tag_Interfaces.*;

public class TheProducersClass implements TheProducers {

    private Iterator<Recording> calendar;
    private Iterator<Collaborator> staff;

    public TheProducersClass(){
        staff = new IteratorClass<Collaborator>();
        calendar = new IteratorClass<Recording>();
    }

    @Override
    public void add(String name, int payPerHour, CollaboratorType type) {
        Collaborator aux = null;

        switch (type) {
            case SENIOR_PRODUCER:
                SeniorProducerClass s = new CollaboratorClass(name, payPerHour);
                aux = (Collaborator) s;
                break;
            case JUNIOR_PRODUCER:
                JuniorProducerClass j = new CollaboratorClass(name, payPerHour);
                aux = (Collaborator) j;
                break;
            case VEDETTE_ACTOR:
                Actor va = new VedetteClass(name, payPerHour);
                aux = (Collaborator) va;
                break;
            case NORMAL_ACTOR:
                Actor Na = new CollaboratorClass(name, payPerHour);
                aux = (Collaborator) Na;
                break;
            case VEDETTE_DIRECTOR:
                Director Vd = new VedetteClass(name, payPerHour);
                aux = (Collaborator) Vd;
                break;
            case NORMAL_DIRECTOR:
                Director Nd = new CollaboratorClass(name, payPerHour);
                aux = (Collaborator) Nd;
                break;
            case TECHNICIAN:
                Technician T = new CollaboratorClass(name, payPerHour);
                aux = (Collaborator) T;
        }
        staff.add(aux);
    }

    @Override
    public Iterator<Collaborator> staff() {
        return staff;
    }

    @Override
    public CollaboratorType getType(String type){
        CollaboratorType aux = null;
        for(CollaboratorType CT : CollaboratorType.values())
            if(CT.getInput().equals(type))
                aux = CT;
    return aux;
    }
}
