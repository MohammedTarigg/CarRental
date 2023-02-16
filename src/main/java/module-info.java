module com.car_rental {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens com.car_rental to javafx.fxml;

    exports com.car_rental;
}
