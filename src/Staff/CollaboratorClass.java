package Staff;

public class CollaboratorClass implements Collaborator {
    int payPerHour;
    String name;

    public CollaboratorClass (String name, int payPerHour){
        this.name = name;
        this.payPerHour = payPerHour;
    }

    public String getName(){
        return name;
    }

    public int getPayPerHour(){
        return payPerHour;
    }
}
