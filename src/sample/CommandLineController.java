package sample;

public class CommandLineController {

    private static final String prompterOut = "==>";

    public static void start() {
        log("Start");
    }

    public static void createUser() {
        log("Create user");
    }

    public static void createConnection() {
        log("Create connection");
    }

    public static void deleteConnection() {
        log("Delete connection");
    }

    public static void exit() {
        System.exit(0);
    }

    public static void log(String message) {
        System.out.println(prompterOut + " " + message);
    }
}
