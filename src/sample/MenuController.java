package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void cleanOutput() {
        EventBusSingleton.getInstance().post(new MenuEvent(MenuEvent.TypeMenuEvent.CLEAN_OUTPUT));
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    @FXML
    public void getAccessToken() {
        CommandLineController.log("Get access token for user ");
    }

    @FXML
    private void createUser() {
        EventBusSingleton.getInstance().post(new MenuEvent(MenuEvent.TypeMenuEvent.CREATE_USER));
    }

    @FXML
    public void createConnection() {
        CommandLineController.log("Create connection");

        CommandLineController.log("Connection created");
    }

    @FXML
    public void initiatePayment() {
        CommandLineController.log("Initiate payment");

        CommandLineController.log("Payment initiated");
    }

    @FXML
    private void getVersion() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        System.out.println(model.getVersion());

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.getPrimaryStage());
        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        Text version = new Text("Version " + model.getVersion());
        version.setTextAlignment(TextAlignment.CENTER);
        dialogVbox.getChildren().add(version);
        Scene dialogScene = new Scene(dialogVbox, 100, 40);
        dialog.setResizable(false);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleAboutAction(final ActionEvent event)
    {
        //TODO show version and other informations
    }

    /**
     * Handle action related to input.
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event)
    {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
            {
                provideAboutFunctionality();
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.Q)
            {
                exit();
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.P)
            {
                initiatePayment();
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.C)
            {
                createConnection();
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.U)
            {
                createUser();
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
            {
                try {
                    getVersion();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.E)
            {
                cleanOutput();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality()
    {
        System.out.println("You clicked on About!");
    }
}
