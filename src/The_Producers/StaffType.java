package The_Producers;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa todos os tipos de Colaboradores.
 */
public enum StaffType {

     SENIOR_PRODUCER    ("senior","","produtor senior "),
     JUNIOR_PRODUCER    ("junior","","produtor junior "),
     VEDETTE_ACTOR      ("actor","vedeta","actor vedeta "),
     NORMAL_ACTOR       ("actor","normal", "actor normal "),
     VEDETTE_DIRECTOR   ("realizador","vedeta","realizador vedeta "),
     NORMAL_DIRECTOR    ("realizador","normal","realizador normal "),
     TECHNICIAN         ("tecnico","","tecnico " );

     private final String type;
     private final String subType;
     private final String output;

     StaffType(String type, String subType, String output){
         this.type = type;
         this.subType = subType;
         this.output = output;
    }

    /**
     * Devolve o tipo principal.
     *
     * @return type.
     */
    public final String getType(){
        return type;
    }

    /**
     * Devolve o sub tipo.
     *
     * @return subType.
     */
    public final String getSubType(){
        return subType;
    }

    /**
     * Devolve o output associado ao comando "REGISTA".
     *
     * @return output.
     */
    public final String getOutput(){
        return output;
    }
}
