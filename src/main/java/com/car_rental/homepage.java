package com.car_rental;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class homepage {

    private Scene scene;

    public homepage(Stage stage) {
        HBox root = new HBox();

        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setMinWidth(700);
        gp.setHgap(10);
        gp.setVgap(10);
        // gp.setAlignment(Pos.CENTER);

        blueLabel lb = new blueLabel("manage cars");
        lb.setPadding(new Insets(0, 0, 10, 0));
        bp.setAlignment(lb, Pos.CENTER);
        bp.setTop(lb);

        blueLabel lb1 = new blueLabel("registration no");
        blueLabel lb2 = new blueLabel("brand");
        blueLabel lb3 = new blueLabel("model");
        blueLabel lb4 = new blueLabel("price");
        // blueLabel lb5 = new blueLabel("state");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        // TextField tf5 = new TextField();
        // blueLabel lb5 = new blueLabel("state");

        VBox vb1 = new VBox(lb1, tf1);
        vb1.setAlignment(Pos.CENTER);
        VBox vb2 = new VBox(lb2, tf2);
        vb2.setAlignment(Pos.CENTER);
        VBox vb3 = new VBox(lb3, tf3);
        vb3.setAlignment(Pos.CENTER);
        VBox vb4 = new VBox(lb4, tf4);
        vb4.setAlignment(Pos.CENTER);
        // VBox vb5 = new VBox(lb5, tf5);
        // vb5.setAlignment(Pos.CENTER);
        gp.addRow(1, vb1, vb2, vb3, vb4);

        blueLabel lb6 = new blueLabel("car list");
        gp.add(lb6, 0, 3);
        bp.setCenter(gp);

        TableView<Car> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.autosize();

        TableColumn<Car, String> tc1 = new TableColumn<>("Registration no");
        TableColumn<Car, String> tc2 = new TableColumn<>("Brand");
        TableColumn<Car, String> tc3 = new TableColumn<>("Model");
        TableColumn<Car, String> tc4 = new TableColumn<>("Price");

        tc1.setCellValueFactory(car -> new ReadOnlyStringWrapper(car.getValue().getRn()));
        tc2.setCellValueFactory(car -> new ReadOnlyStringWrapper(car.getValue().getB()));
        tc3.setCellValueFactory(car -> new ReadOnlyStringWrapper(car.getValue().getM()));
        tc4.setCellValueFactory(car -> new ReadOnlyStringWrapper(car.getValue().getP()));

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Car> data = FXCollections.observableArrayList(
                new Car("886", "Mercedes", "2017", "90000"));
        table.getColumns().addAll(tc1, tc2, tc3, tc4);
        table.setItems(data);
        bp.setBottom(table);

        Button b1 = new Button("save");
        b1.setOnAction((e) -> {
            String rn = tf1.getText();
            String b = tf2.getText();
            String m = tf3.getText();
            String p = tf4.getText();
            data.add(new Car(rn, b, m, p));
            table.setItems(data);
        });
        Button b2 = new Button("delete");
        b2.setOnAction((e) -> {
            Car selectedItem = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selectedItem);
        });
        gp.add(b1, 1, 2);
        gp.add(b2, 2, 2);

        root.setMargin(bp, new Insets(10));
        sidebar sideBar = new sidebar(stage);
        root.getChildren().addAll(sideBar.getSidebar(), bp);
        scene = new Scene(root, 900, 500);
    }

    public Scene getScene() {
        return scene;
    }

}

class blueLabel extends Label {
    public blueLabel(String text) {
        super(text);
        this.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        this.setTextFill(Color.BLUE);
    }
}

class Car {
    String rn;
    String b;
    String m;
    String p;

    public Car(String rn, String b, String m, String p) {
        this.rn = rn;
        this.b = b;
        this.m = m;
        this.p = p;
    }

    public String getRn() {
        return this.rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getM() {
        return this.m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getP() {
        return this.p;
    }

    public void setP(String p) {
        this.p = p;
    }
}