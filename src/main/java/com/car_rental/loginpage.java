package com.car_rental;

import java.io.File;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class loginpage {
    private Scene scene;

    public loginpage(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Label userName = new Label("User Name:");
        userName.setTextFill(Color.BLUE);
        Label pw = new Label("Password:");
        pw.setTextFill(Color.BLUE);
        grid.addColumn(0, userName, pw);
        TextField userTextField = new TextField();
        PasswordField pwTextField = new PasswordField();
        Button btn = new Button("Sign in");
        btn.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        btn.setStyle("-fx-background-color: blue;");
        grid.addColumn(1, userTextField, pwTextField, btn);

        Text botText = new Text("Best service in the country");
        botText.setFill(Color.WHITE);
        botText.setFont(Font.font("Tahoma", FontWeight.BOLD, 23));
        VBox botvb = new VBox(botText);
        botvb.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        botvb.setPadding(new Insets(30, 0, 30, 0));
        botvb.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();

        VBox topContainer = new VBox();
        topContainer.setAlignment(Pos.CENTER);
        Text sceneTitle = new Text("Car Rental");
        sceneTitle.setFill(Color.BLUE);
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 23));
        Image pic = new Image(new File(
                "C:/Users/kasber/Desktop/vsc/java/jfx-projects/car_rental/src/main/java/com/car_rental/logo.jpg")
                .toURI().toString());
        ImageView picContainer = new ImageView(pic);
        topContainer.getChildren().addAll(sceneTitle, picContainer);

        root.setAlignment(sceneTitle, Pos.CENTER);
        root.setPadding(new Insets(50, 0, 0, 0));
        root.setTop(topContainer);
        root.setCenter(grid);
        root.setBottom(botvb);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        btn.setOnAction(event -> {
            String user = userTextField.getText();
            String password = pwTextField.getText();

            if (user.equals("user") && password.equals("password")) {
                homepage home = new homepage(stage);
                stage.setScene(home.getScene());
            } else {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Login failed");
            }
        });

        scene = new Scene(root, 500, 500);
    }

    public Scene getScene() {
        return scene;
    }
}
