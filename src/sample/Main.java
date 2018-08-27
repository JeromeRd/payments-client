package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    private static Usage usage = Usage.COMMAND_LINE;
    private static Stage primaryStage;

    enum Usage {
        UI, COMMAND_LINE
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Platform.setImplicitExit(false);

        Parent root = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        primaryStage.setTitle("Payment client");
        primaryStage.setScene(new Scene(root, 510, 650));
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        switch (usage) {
            case COMMAND_LINE:
                CommandLineApp.start();
                break;
            case UI:
                primaryStage.show();
                break;
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String strUsage = args[0];
            if (strUsage != null) {
                usage = Usage.valueOf(strUsage);
            }
        }
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
