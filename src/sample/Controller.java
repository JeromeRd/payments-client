package sample;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextField userIdentifier;
    @FXML private TextField userPassword;
    @FXML private TextField urlAuth;
    @FXML private TextField urlApi;
    @FXML private TextField urlApp;
    @FXML private Button createUser;
    @FXML private Button deleteUser;
    @FXML private Button createConnection;
    @FXML private Button deleteConnection;
    @FXML private ComboBox source;
    @FXML private ComboBox destination;
    @FXML private TextField amount;
    @FXML private TextField currency;
    @FXML private TextField label;
    @FXML private Button initiatePayment;
    @FXML private TextArea output;
    @FXML private TableView<Payment> payments;

    String newLine = System.getProperty("line.separator");

    public void log(String message) {
        output.appendText(message+newLine);
    }

    @FXML
    private void createUser() {
        log("Create user ");

        log("User created");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventBusSingleton.getInstance().register(this);
    }

    @Subscribe
    public void handlePurchaseEvent(MenuEvent menuEvent) {
        switch (menuEvent.getTypeMenuEvent()) {
            case CREATE_USER:
                createUser();
                break;
            case CLEAN_OUTPUT:
                cleanOutput();
                break;
            case TEST:
                test();
                break;
        }
    }



    private void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        Payment payment = new Payment();
        payment.setAmount("190");
        payment.setDestination("Dest 1");
        payment.setSource("Source 1");
        payment.setDate("02/09/18");
        payment.setReason("Reason 1");
        payment.setStatus("OK");

        Payment payment2 = new Payment();
        payment2.setAmount("23");
        payment2.setDestination("Dest 2");
        payment2.setSource("Source 2");
        payment2.setDate("04/09/18");
        payment2.setReason("Reason 2");
        payment2.setStatus("FAILED");

        payments.getItems().add(payment);
        payments.getItems().add(payment2);
    }

    private void cleanOutput() {
        output.setText("");
    }
}
