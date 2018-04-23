import Staff.*;
import Staff.StaffMembers.Vedette.*;
import The_Producers.TheProducers;
import The_Producers.TheProducersClass;

import java.util.Scanner;

public class Main {

    private enum Message{

        PROMPT                  ("> "),
        REGISTRY_COMPLETE       ("Colaborador registado com sucesso!"),
        DUPLICATE_NAME          ("Ja existe um colaborador com o mesmo nome."),
        INVALID_TYPE            ("Tipo de colaborador desconhecido."),
        INVALID_SUBTYPE         ("Notoriedade invalida."),
        INVALID_SALARY          ("Acha mesmo que este colaborador vai pagar para trabalhar?"),
        MSG7        (""),
        MSG8        (""),
        MSG9        (""),
        MSG10       (""),
        MSG11       (""),
        UNKNOWN     ("Opcao inexistente."),
        EXITING     ("Ate a proxima");


        private final String msg;
        Message(String msg){
            this.msg = msg;
        }
    }

    private enum Command{
        REGISTER     ("regista - regista um novo colaborador","REGISTA"),
        STAFF        ("staff - lista os colaboradores registados","STAFF"),
        SCENERY      ("cenario - regista um novo local para gravacoes","CENARIO"),
        SCENERIES    ("cenarios - lista os locais para gravacoes registados","CENARIOS"),
        SCHEDULE     ("marca - marca uma nova gravacao","MARCA"),
        MOPE         ("amua - vedeta deixa de trabalhar com colaborador","AMUA"),
        RECONCILE    ("reconcilia - vedeta faz as pazes com colaborador","RECONCILIA"),
        PERFORMED    ("realizadas - lista as gravacoes realizadas","REALIZADAS"),
        PLANNED      ("previstas - lista as gravacoes previstas","PREVISTAS"),
        SITE         ("local - lista as gravacoes previstas para um local","LOCAL"),
        COLLABORATOR ("colaborador - lista as gravacoes previstas para um colaborador","COLABORADOR"),
        RECORD       ("grava - executa a proxima gravacao agendada","GRAVA"),
        POUTANCES    ("amuancos - lista os colaboradores com quem uma vedeta esta amuada","AMUANCOS"),
        HELP         ("ajuda - Mostra a ajuda","AJUDA"),
        EXIT         ("sai - Termina a execucao do programa","SAI"),
        UNKNOWN      ("","");

        private final String cmd;
        private final String description;

        Command(String description,String cmd){
            this.cmd = cmd;
            this.description= description;
        }
    }

    public static void main(String[] args){
        StaffMember s = new VedetteActorClass("",2);

        Scanner input = new Scanner(System.in);
        TheProducers tP = new TheProducersClass();
        executeCommand(input,tP);
        input.close();
    }

    private static Command getCommand(Scanner input) {
        String cmd = input.nextLine().toUpperCase();
        for(Command Cmd: Command.values())
            if(cmd.equals(Cmd.cmd))
                return Cmd;
        return Command.UNKNOWN;
    }

    private static void executeCommand(Scanner in, TheProducers tP ){
        Command cmd = Command.UNKNOWN;

        while(!cmd.equals(Command.EXIT)){
            System.out.print(Message.PROMPT.msg);
            cmd = getCommand(in);

                switch(cmd){
                    case REGISTER:
                        register(in, tP);
                        break;

                    case STAFF:
                        staff(tP);
                        break;

                    case SCENERY:
                        scenery(in, tP);
                        break;

                    case SCENERIES:
                        sceneries(tP);
                        break;

                    case SCHEDULE:
                        schedule(in, tP);
                        break;

                    case MOPE:
                        mope(tP);
                        break;

                    case RECONCILE:
                        reconcile(in,tP);
                        break;

                    case PERFORMED:
                        performed(in,tP);
                        break;

                    case PLANNED:
                        planned(in,tP);
                        break;

                    case SITE:
                        site(in,tP);
                        break;

                    case COLLABORATOR:
                        collaborator(in,tP);
                        break;

                    case RECORD:
                        record(in,tP);
                        break;

                    case POUTANCES:
                        poutances(in,tP);
                        break;

                    case HELP:
                        help();
                        break;

                    case EXIT:
                        System.out.println(Message.EXITING.msg);
                        break;

                    case UNKNOWN:
                        System.out.println(Message.UNKNOWN.msg);
                }
        }
    }

    private static void reconcile(Scanner in, TheProducers tP) {
    }

    private static void schedule(Scanner in, TheProducers tP) {
    }

    private static void record(Scanner in, TheProducers tP) {
    }

    private static void poutances(Scanner in, TheProducers tP) {
    }

    private static void collaborator(Scanner in, TheProducers tP) {
    }

    private static void site(Scanner in, TheProducers tP) {
    }

    private static void planned(Scanner in, TheProducers tP) {
    }

    private static void performed(Scanner in, TheProducers tP) {
    }

    private static void mope(TheProducers tP) {
    }

    private static void sceneries(TheProducers tP) {
    }

    private static void scenery(Scanner in, TheProducers tP) {
    }

    private static void register(Scanner in, TheProducers tP) {
        String type = in.next();
        String subType = "";

        if(!in.hasNextInt())
            subType = in.next();


        int moneyPerHour =in.nextInt();
        String name  = in.nextLine().substring(1);

        if (tP.duplicateName(name))
            System.out.println(Message.DUPLICATE_NAME.msg);

        else if(!tP.isTypeValid(type))
            System.out.println(Message.INVALID_TYPE.msg);

        else if(!tP.isSubTypeValid(subType))
            System.out.println(Message.INVALID_SUBTYPE.msg);

        else if(!tP.isSalaryValid(moneyPerHour))
            System.out.println(Message.INVALID_SALARY.msg);

        else{
            tP.register(name,moneyPerHour,type,subType);
            System.out.println(Message.REGISTRY_COMPLETE.msg);
        }

    }

    private static void staff( TheProducers tP) {
        String msg = tP.Staff();
        if(!msg.equals(""))
            System.out.print(tP.Staff());
        else
            System.out.println("Nao existem colaboradores registados.");
    }

    private static void help(){
        for(Command C : Command.values())
            if(C  != Command.UNKNOWN)
                System.out.println(C.description);

    }
}