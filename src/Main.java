
import The_Producers.*;

import java.util.Scanner;

public class Main {

    private enum Message{

        PROMPT      ("> "),
        REGISTRY_COMPLETE       ("Colaborador registado com sucesso!"),
        MSG3        (""),
        MSG4        (""),
        MSG5        (""),
        MSG6        (""),
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
        UNKNOWN      ("","UNKNOWN");

        private final String cmd;
        private final String description;

        Command(String description,String cmd){
            this.cmd = cmd;
            this.description= description;
        }
    }

    public static void main(String[] args){
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
            cmd = getCommand(in);

                switch(cmd){
                    case REGISTER:
                        register(in, tP);
                        break;

                    case STAFF:
                        staff(in, tP);
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
                System.out.println();
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
        String type = in.next().trim();

        if(in.hasNextInt())
            type = type + in.next().trim();

        int PayPerHour = in.nextInt();




    }

    private static void staff(Scanner in, TheProducers tP) {
    }

    private static void help(){
        for(Command C : Command.values())
            System.out.println(C.description);
    }
}