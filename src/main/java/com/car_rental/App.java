package com.car_rental;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            loginpage login = new loginpage(stage);
            stage.setScene(login.getScene());
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}