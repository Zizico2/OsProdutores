package The_Producers;

public enum CollaboratorType {

     SENIOR_PRODUCER("senior",0),
     JUNIOR_PRODUCER("junior",1),
     VEDETTE_ACTOR ("actor vedeta",2),
     NORMAL_ACTOR  ("actor normal", 3),
     VEDETTE_DIRECTOR("realizador vedeta",4),
     NORMAL_DIRECTOR ("realizador normal",5),
     TECHNICIAN("tecnico",6);






    private final int code;
    private final String input;

    CollaboratorType(String input, int code){
        this.code = code;
        this.input= input;
    }

    public final String getInput(){
        return input;
    }

    public final int getCode() {
        return code;
    }
}
