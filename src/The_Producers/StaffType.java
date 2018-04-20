package The_Producers;

public enum StaffType {

     SENIOR_PRODUCER("produtor","senior"),
     JUNIOR_PRODUCER("produtor"," junior"),
     VEDETTE_ACTOR ("actor","vedeta"),
     NORMAL_ACTOR  ("actor","normal"),
     VEDETTE_DIRECTOR("realizador","vedeta"),
     NORMAL_DIRECTOR ("realizador","normal"),
     TECHNICIAN("tecnico","");

    private final String type;
    private final String subType;

    StaffType(String type, String subType){
        this.type = type;
        this.subType = subType;
    }

    public final String getType(){
        return type;
    }

    public final String getSubType(){
        return subType;
    }
}
