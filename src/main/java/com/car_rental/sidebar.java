package com.car_rental;

import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class sidebar {
    VBox sideBar = new VBox();

    public sidebar(Stage stage) {
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        sideBar.setPadding(new Insets(0, 50, 0, 40));
        sidebarLabel cars = new sidebarLabel("cars");
        sidebarLabel customerN = new sidebarLabel("customer");
        sidebarLabel rentCarsN = new sidebarLabel("rent car");
        sidebarLabel returnCarsN = new sidebarLabel("return car");
        sidebarLabel logout = new sidebarLabel("logout");
        logout.setPadding(new Insets(200, 0, 0, 0));
        cars.setOnMouseClicked((e) -> {
            homepage home = new homepage(stage);
            stage.setScene(home.getScene());
        });
        customerN.setOnMouseClicked((e) -> {
            customerpage customer = new customerpage(stage);
            stage.setScene(customer.getScene());
        });
        rentCarsN.setOnMouseClicked((e) -> {
            rentpage rent = new rentpage(stage);
            stage.setScene(rent.getScene());
        });
        returnCarsN.setOnMouseClicked((e) -> {
            returnpage returnp = new returnpage(stage);
            stage.setScene(returnp.getScene());
        });
        logout.setOnMouseClicked((e) -> {
            loginpage login = new loginpage(stage);
            stage.setScene(login.getScene());
        });

        sideBar.getChildren().addAll(cars, customerN, rentCarsN, returnCarsN, logout);

    }

    public VBox getSidebar() {
        return sideBar;
    }
}

class sidebarLabel extends Label {
    public sidebarLabel(String text) {
        super(text);
        this.setTextFill(Color.WHITE);
        this.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        this.setPadding(new Insets(10, 0, 10, 0));
    }
}
