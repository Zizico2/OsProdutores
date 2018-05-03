import The_Producers.TheProducers;
import The_Producers.TheProducersClass;
import java.util.Scanner;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class Main {

    private static final int DATE_NUMBER_FORMAT = 6;
    private static final int MAIN_STAFF_NUMBER = 3;
    private enum Message{

        PROMPT                          ("> "),
        REGISTRY_COMPLETE               ("Colaborador registado com sucesso!"),
        DUPLICATE_NAME                  ("Ja existe um colaborador com o mesmo nome."),
        INVALID_TYPE                    ("Tipo de colaborador desconhecido."),
        INVALID_SUBTYPE                 ("Notoriedade invalida."),
        INVALID_SALARY                  ("Acha mesmo que este colaborador vai pagar para trabalhar?"),
        NO_STAFF_MEMBERS                ("Nao existem colaboradores registados."),
        DUPLICATE_SCENERY_NAME          ("Localizacao ja tinha sido registada."),
        INVALID_SCENERY_COST            ("Acha que eles nos pagam para gravar la?"),
        SCENERY_REGISTRY_COMPLETE       ("Cenario registado."),
        INVALID_DURATION                ("Duracao invalida."),
        NO_SITES                        ("Nao existem localizacoes registadas."),
        ALREADY_EXISTS_IN_BLACKLIST     ("Que falta de paciencia para divas..."),
        INVALID_DATE_OF_RECORDING       ("Data de gravacao invalida."),
        NO_PERFORMED_RECORDINGS         ("Nenhuma gravacao realizada."),
        NO_PLANNED_RECORDINGS           ("Nenhuma gravacao prevista."),
        UNKNOWN_SITE                    ("Local desconhecido."),
        EMPTY_BLACKLIST                 (" da-se bem com todos!"),
        UNKNOWN_STAFF_MEMBER            ("Colaborador desconhecido."),
        SCHEDULE_COMPLETE               ("Gravacao agendada com sucesso!"),
        SCHEDULED_RECORDING_SUSPENDED   ("Gravacao pendente de uma birra."),
        RECORDING_WITH_CONFLICTED_DATES ("Gravacao nao agendada por conflito de datas."),
        RECORDINGS_RESCHEDULED          ("Gravacao prioritaria agendada provocou mudancas noutra(s) gravacao(oes)."),
        NO_GRUDGE_BETWEEN               ("Nao existe zanga com "),
        UNKNOWN_PRODUCER                ("Produtor desconhecido."),
        UNKNOWN_DIRECTOR                ("Realizador desconhecido."),
        UNKNOWN_TECHNICIAN              ("Tecnico desconhecido."),
        NOT_VEDETTE                     (" nao e uma vedeta."),
        NOT_A_STAFF_MEMBER              (" nao e um colaborador."),
        NO_RECORDING_WITH               ("Nenhuma gravacao prevista com "),
        NO_RECORDING_AT                 ("Nenhuma gravacao prevista em "),
        NO_RECORDINGS_TO_RECORD         ("Nenhuma gravacao agendada."),
        RECORDINGS_SAVED                (" gravacoes salvas!"),
        DEFAULT_LIST_MSG                ("0 euros orcamentados."),
        PLACED                          (" colocou "),
        ON_HIS_BLACKLIST_SUSPENDING     (" na sua lista negra, suspendendo "),
        N_RECORDINGS                    (" gravacoes."),
        LOVES                           (" <3 " ),
        POINT                           ("."),
        SPACE                           (" "),
        VOID_MESSAGE                    (""),
        UNKNOWN                         ("Opcao inexistente."),
        EXITING                         ("Ate a proxima");


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
                        mope(in, tP);
                        break;

                    case RECONCILE:
                        reconcile(in,tP);
                        break;

                    case PERFORMED:
                        performed(tP);
                        break;

                    case PLANNED:
                        planned(tP);
                        break;

                    case SITE:
                        site(in,tP);
                        break;

                    case COLLABORATOR:
                        staffMember(in,tP);
                        break;

                    case RECORD:
                        record(tP);
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
        String exBullyName = in.nextLine();
        String exVictimName = in.nextLine();

        if(!tP.isThereAVedetteNamed(exBullyName))
            System.out.println(exBullyName + Message.NOT_VEDETTE.msg);

        else if(!tP.isThereAFightWith(exBullyName,exVictimName))
            System.out.println(Message.NO_GRUDGE_BETWEEN.msg + exVictimName + Message.POINT.msg);

        else
            System.out.println(exBullyName + Message.LOVES.msg + exVictimName + Message.POINT.msg + Message.SPACE.msg + tP.reconcile(exBullyName,exVictimName) + Message.RECORDINGS_SAVED.msg);
    }

    private static void schedule(Scanner in, TheProducers tP) {
        int[] localDateTime = new int[6];
        String[] mainNames = new String[3];
        String scenery = in.nextLine();

        for(int i = 0; i < DATE_NUMBER_FORMAT; i++)
            localDateTime[i] = in.nextInt();
        in.nextLine();

        for(int i = 0; i < MAIN_STAFF_NUMBER; i++)
            mainNames[i] = in.nextLine();

        int numberOfStaffMembers = in.nextInt() + MAIN_STAFF_NUMBER;
        in.nextLine();

        String[] names = new String[numberOfStaffMembers];
        System.arraycopy(mainNames, 0, names, 0, MAIN_STAFF_NUMBER);

        for (int i = MAIN_STAFF_NUMBER; i < numberOfStaffMembers; i++)
            names[i] = in.nextLine();

        if(!tP.isThereASiteNamed(scenery))
            System.out.println(Message.UNKNOWN_SITE.msg);

        else if(!tP.isDateValid(localDateTime))
            System.out.println(Message.INVALID_DATE_OF_RECORDING.msg);

        else if(!tP.isDurationValid(localDateTime[5]))
            System.out.println(Message.INVALID_DURATION.msg);

        else if(!tP.isThereAProducerNamed(mainNames[0]))
            System.out.println(Message.UNKNOWN_PRODUCER.msg);

        else if(!tP.isThereADirectorNamed(mainNames[1]))
            System.out.println(Message.UNKNOWN_DIRECTOR.msg);

        else if(!tP.isThereATechnicianNamed(mainNames[2]))
            System.out.println(Message.UNKNOWN_TECHNICIAN.msg);

        else if(!tP.isThereStaffMembersNamed(names,numberOfStaffMembers))
            System.out.println(Message.UNKNOWN_STAFF_MEMBER.msg);

        else if(tP.isThereFightsBetweenThisStaff(names)){
            tP.scheduleRecording(scenery,localDateTime,names, true);
            System.out.println(Message.SCHEDULED_RECORDING_SUSPENDED.msg);
        }
        else if(tP.isThereDatesConflict(scenery,localDateTime,names))
            System.out.println(Message.RECORDING_WITH_CONFLICTED_DATES.msg);

        else if(tP.isReschuleNeeded(scenery,localDateTime,names)){
            System.out.println(Message.RECORDINGS_RESCHEDULED.msg);
            tP.reschedule(scenery,localDateTime,names);
        }

        else{
                tP.scheduleRecording(scenery, localDateTime, names, false);
                System.out.println(Message.SCHEDULE_COMPLETE.msg);
            }
        }

    private static void record( TheProducers tP) {
        if(tP.listPlannedRecordings().equals(Message.VOID_MESSAGE.msg))
            System.out.println(Message.NO_RECORDINGS_TO_RECORD.msg);
        else
             System.out.println(tP.record());
    }

    private static void poutances(Scanner in, TheProducers tP) {
        String name = in.nextLine();
        String msg = tP.poutances(name);
        if(msg.equals(Message.VOID_MESSAGE.msg))
            System.out.println(name + Message.EMPTY_BLACKLIST.msg);
        else
            System.out.print(msg);

    }

    private static void staffMember(Scanner in, TheProducers tP) {
        String name = in.nextLine();
        String msg = tP.staffMember(name);
        if(!tP.isThereAStaffMemberNamed(name))
            System.out.println(Message.UNKNOWN_STAFF_MEMBER.msg);

        else{
            if (msg.equals(Message.DEFAULT_LIST_MSG.msg))
                System.out.println(Message.NO_RECORDING_WITH.msg + name + Message.POINT.msg);

            else
                System.out.println(msg);
        }
    }

    private static void site(Scanner in, TheProducers tP){
        String scenery = in.nextLine();
        String msg = tP.site(scenery);

        if(!tP.isThereASiteNamed(scenery))
            System.out.println(Message.UNKNOWN_SITE.msg);

        else{
            if (msg.equals(Message.DEFAULT_LIST_MSG.msg))
                System.out.println(Message.NO_RECORDING_AT.msg + scenery + Message.POINT.msg);
            else
                System.out.println(msg);
        }
    }

    private static void planned(TheProducers tP) {
        String msg = tP.listPlannedRecordings();

        if (msg.equals(Message.VOID_MESSAGE.msg))
            System.out.println(Message.NO_PLANNED_RECORDINGS.msg);
        else
            System.out.println(msg);
    }

    private static void performed(TheProducers tP) {
        String msg = tP.listPerformedRecordings();

        if (msg.equals(Message.VOID_MESSAGE.msg))
            System.out.println(Message.NO_PERFORMED_RECORDINGS.msg);
        else
            System.out.println(msg);
    }

    private static void mope(Scanner in, TheProducers tP) {
        String bullyName = in.nextLine();
        String victimName = in.nextLine();

        if(!tP.isThereAVedetteNamed(bullyName))
            System.out.println(bullyName + Message.NOT_VEDETTE.msg);

        else if(!tP.isThereAStaffMemberNamed(victimName))
            System.out.println(victimName + Message.NOT_A_STAFF_MEMBER.msg);

        else if(tP.isThereAFightWith(bullyName,victimName))
            System.out.println(Message.ALREADY_EXISTS_IN_BLACKLIST.msg);

        else
            System.out.println(bullyName + Message.PLACED.msg + victimName + Message.ON_HIS_BLACKLIST_SUSPENDING.msg + tP.mope(bullyName,victimName) + Message.N_RECORDINGS.msg);
    }

    private static void sceneries(TheProducers tP) {
        String msg = tP.listSceneries();
        if(!msg.equals(Message.VOID_MESSAGE.msg))
            System.out.print(msg);
        else
            System.out.println(Message.NO_SITES.msg);
    }

    private static void scenery(Scanner in, TheProducers tP) {
        String name = in.nextLine();
        int cost = in.nextInt();
        in.nextLine();

        if (tP.duplicateSceneryName(name))
            System.out.println(Message.DUPLICATE_SCENERY_NAME.msg);
        else if (tP.isCostInvalid(cost))
            System.out.println(Message.INVALID_SCENERY_COST.msg);
        else {
            tP.addScenery(name, cost);
            System.out.println(Message.SCENERY_REGISTRY_COMPLETE.msg);
        }
    }

    private static void register(Scanner in, TheProducers tP) {
        String type = in.next();
        String subType = "";

        if(!in.hasNextInt())
            subType = in.next();

        int moneyPerHour =in.nextInt();
        String name  = in.nextLine().substring(1);

        if (tP.isThereAStaffMemberNamed(name))
            System.out.println(Message.DUPLICATE_NAME.msg);

        else if(!tP.isTypeValid(type))
            System.out.println(Message.INVALID_TYPE.msg);

        else if(!tP.isSubTypeValid(subType))
            System.out.println(Message.INVALID_SUBTYPE.msg);

        else if(tP.isCostInvalid(moneyPerHour))
            System.out.println(Message.INVALID_SALARY.msg);

        else{
            tP.register(name,moneyPerHour,type,subType);
            System.out.println(Message.REGISTRY_COMPLETE.msg);
        }

    }

    private static void staff( TheProducers tP) {
        String msg = tP.staff();
        if(!msg.equals(Message.VOID_MESSAGE.msg))
            System.out.print(msg);
        else
            System.out.println(Message.NO_STAFF_MEMBERS.msg);
    }

    private static void help(){
        for(Command C : Command.values())
            if(C  != Command.UNKNOWN)
                System.out.println(C.description);

    }
}