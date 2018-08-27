package sample;

import java.util.Scanner;

public class CommandLineApp {

    private static final String prompterIn = ">>";
    private static final String START_COMMAND = "start";
    private static final String CREATE_COMMAND = "create";
    private static final String DELETE_COMMAND = "del";
    private static final String UI_COMMAND = "ui";
    private static final String HELP_COMMAND = "help";
    private static final String EXIT_COMMAND = "exit";

    private static final String CREATE_OPTIONS = "[-u, -c]";
    private static final String DELETE_OPTIONS = "[-u, -c]";

    private static final String START_DESCRIPTION = "create user and connection, and initiate payments";
    private static final String CREATE_DESCRIPTION = "create a user [-u] or a connection [-c]";
    private static final String DELETE_DESCRIPTION = "delete a user [-u] or a connection [-c]";
    private static final String UI_DESCRIPTION = "start user interface";
    private static final String HELP_DESCRIPTION = "display commands";

    public static void start() {
        String command;
        System.out.println(displayHelp());
        Scanner in = new Scanner(System.in);
        in.useDelimiter(System.lineSeparator() + "|\n");
        do {
            System.out.print(prompterIn);
            command = in.nextLine();
            switch (command) {
                case UI_COMMAND:
                    in.close();
                    CommandLineController.log("Stop command line.");
                    CommandLineController.log("Start user interface.");
                    Main.getPrimaryStage().show();
                    break;
                case START_COMMAND:
                    CommandLineController.start();
                    break;
                case CREATE_COMMAND:
                    CommandLineController.createUser();
                    break;
                case DELETE_COMMAND:
                    CommandLineController.deleteConnection();
                    break;
                case HELP_COMMAND:
                    System.out.println(displayHelp());
                    break;
                case EXIT_COMMAND:
                    CommandLineController.exit();
                    break;
                case "test":
                    System.out.print("test");
                    break;
                default:
                    System.out.println("Bad command. Try \"help\"");
                    break;
            }
        } while (!EXIT_COMMAND.equals(command.toLowerCase().trim())
                && !UI_COMMAND.equals(command.toLowerCase().trim()));
    }

    private static String displayHelp() {
        StringBuffer stringBuffer = new StringBuffer()
                .append("+----------+").append(System.lineSeparator())
                .append("+ COMMANDS +").append(System.lineSeparator())
                .append("+----------+").append(System.lineSeparator())
                .append("+ ").append(START_COMMAND.toUpperCase()).append(" : ").append(START_DESCRIPTION).append(System.lineSeparator())
                .append("+ ").append(CREATE_COMMAND.toUpperCase()).append(" ").append(CREATE_OPTIONS).append(" : ").append(CREATE_DESCRIPTION).append(System.lineSeparator())
                .append("+ ").append(DELETE_COMMAND.toUpperCase()).append(" ").append(DELETE_OPTIONS).append(" : ").append(DELETE_DESCRIPTION).append(System.lineSeparator())
                .append("+ ").append(UI_COMMAND.toUpperCase()).append(" : ").append(UI_DESCRIPTION).append(System.lineSeparator())
                .append("+ ").append(HELP_COMMAND.toUpperCase()).append(" : ").append(HELP_DESCRIPTION).append(System.lineSeparator())
                .append("+ ").append(EXIT_COMMAND.toUpperCase()).append(System.lineSeparator())
                .append("+----------+").append(System.lineSeparator());
        return stringBuffer.toString();
    }
}
