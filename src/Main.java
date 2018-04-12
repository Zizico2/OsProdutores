import TheProducers.*;

import java.util.Scanner;

public class Main {


    private static final String PREMIUM = "Premium";
    private static final String BASIC = "Basic";

    private enum Message{

        NO_ACCOUNTS ("No accounts."),
        ACCOUNT_ADDED ("Account was added."),
        INVALID_ACCOUNT ("Account already exists."),
        FILE_UPLOADED ("File uploaded into account."),
        ACCOUNT_NOT_EXIST ("Account does not exist."),
        FILE_ALREADY_EXISTS ("File already exists in the account."),
        TOO_BIG ("File size exceeds account capacity."),
        FILE_SHARED ("File was shared."),
        FILE_NOT_EXIST ("File does not exist."),
        UNAUTHORIZED_SHARING ("Account does not allow file sharing."),
        SHARING_ALREADY_EXISTS ("File already shared."),
        UNKNOWN  ("Unknown command!"),
        EXITING ("Exiting...");


        private final String msg;
        Message(String msg){
            this.msg = msg;
        }
    }

    private enum Command{
        ADD ("ADD"),
        UPLOAD ("UPLOAD"),
        SHARE  ("SHARE"),
        MINSPACE  ("MINSPACE"),
        LISTFILES  ("LISTFILES"),
        LISTALL  ("LISTALL"),
        EXIT  ("EXIT"),
        UNKNOWN  ("UNKNOIWN");

        private final String cmd;
        Command(String cmd){
            this.cmd = cmd;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TheProducers tP = new TheProducersClass();
        executeCommand(input,tP);
        input.close();
    }

    private static Command getCommand(Scanner input) {
        try {
            String cmd = input.nextLine().toUpperCase();
            return Command.valueOf(cmd);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }





    private static void executeCommand(Scanner in, TheProducers tP ){
        Command cmd = null;
        cmd = getCommand(in);
        System.out.println(cmd);

        while(!cmd.equals(Command.EXIT)){
            cmd = getCommand(in);

                switch(cmd){
                    case ADD:
                        add(in, tP);
                        break;

                    case UPLOAD:
                        upload(in, tP);
                        break;

                    case SHARE:
                        share(in, tP);
                        break;

                    case MINSPACE:
                        minSpace(tP);
                        break;

                    case LISTFILES:
                        listFiles(in, tP);
                        break;

                    case LISTALL:
                        listAll(tP);
                        break;

                    case EXIT:
                        System.out.println(Message.EXITING);
                        break;

                    case UNKNOWN:
                        System.out.println(Message.UNKNOWN);
                        break;
                }
                    System.out.println();
                }
            }
        }
