package core.prix;

import core.reservations.Reservation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Paiement {

    private String name, email, passport;
    private String credit;


    public Paiement(String name, String email, String passport, String credit) {
        this.name = name;
        this.email = email;
        this.passport = passport;
        this.credit = credit;
    }

    public boolean isValid() {
        return true;
    }

    public static void payer(Reservation reservation) {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 200, 400);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        Label lblName = new Label("Name: ");
        Label lblEmail = new Label("Email: ");
        Label lblPassport = new Label("Passport: ");
        Label lblCredit = new Label("Credit: ");

        TextField tfName = new TextField();
        tfName.setMaxWidth(200);
        TextField tfEmail = new TextField();
        tfEmail.setMaxWidth(200);
        TextField tfPassport = new TextField();
        tfPassport.setMaxWidth(200);
        TextField tfCredit = new TextField();
        tfCredit.setMaxWidth(200);

        Button btnPay = new Button("Pay");

        vbox.getChildren().addAll(lblName, tfName);
        vbox.getChildren().addAll(lblEmail, tfEmail);
        vbox.getChildren().addAll(lblPassport, tfPassport);
        vbox.getChildren().addAll(lblCredit, tfCredit);
        vbox.getChildren().addAll(btnPay);

        btnPay.setOnAction(e -> {
            String name = tfName.getText();
            String email = tfEmail.getText();
            String passport = tfPassport.getText();
            String credit = tfCredit.getText();

            reservation.addPaiement(new Paiement(name, email, passport, credit));
            vbox.getChildren().clear();
            vbox.getChildren().add(new Text("Success!"));
        });
    }
}
