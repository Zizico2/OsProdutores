package Staff;

import Staff.Tag_Interfaces.*;

public interface Collaborator extends SeniorProducer, JuniorProducer, Technician, Director, Actor {

    int getPayPerHour();
    String getName();
}


