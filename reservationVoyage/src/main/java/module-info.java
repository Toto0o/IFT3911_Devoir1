module ca.umontreal.reservationvoyage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens ca.umontreal.reservationvoyage to javafx.fxml;
    exports ca.umontreal.reservationvoyage;
}