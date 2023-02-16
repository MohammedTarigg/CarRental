package com.car_rental;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class customerpage {
    private Scene scene;

    customerpage(Stage stage) {
        HBox root = new HBox();

        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setMinWidth(700);
        gp.setHgap(10);
        gp.setVgap(10);
        // gp.setAlignment(Pos.CENTER);

        blueLabel lb = new blueLabel("manage Customers");
        lb.setPadding(new Insets(0, 0, 10, 0));
        bp.setAlignment(lb, Pos.CENTER);
        bp.setTop(lb);

        blueLabel lb1 = new blueLabel("Customer id");
        blueLabel lb2 = new blueLabel("Customer name");
        blueLabel lb3 = new blueLabel("Address");
        blueLabel lb4 = new blueLabel("Phone");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();

        VBox vb1 = new VBox(lb1, tf1);
        vb1.setAlignment(Pos.CENTER);
        VBox vb2 = new VBox(lb2, tf2);
        vb2.setAlignment(Pos.CENTER);
        VBox vb3 = new VBox(lb3, tf3);
        vb3.setAlignment(Pos.CENTER);
        VBox vb4 = new VBox();

        gp.addRow(1, vb1, vb2, vb3);

        blueLabel lb6 = new blueLabel("Customer list");
        gp.add(lb6, 0, 3);
        bp.setCenter(gp);

        TableView<Customer> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.autosize();

        TableColumn<Customer, String> tc1 = new TableColumn<>("Customer id");
        TableColumn<Customer, String> tc2 = new TableColumn<>("Customer name");
        TableColumn<Customer, String> tc3 = new TableColumn<>("Address");

        tc1.setCellValueFactory(customer -> new ReadOnlyStringWrapper(customer.getValue().getCid()));
        tc2.setCellValueFactory(customer -> new ReadOnlyStringWrapper(customer.getValue().getCname()));
        tc3.setCellValueFactory(customer -> new ReadOnlyStringWrapper(customer.getValue().getAdd()));

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Customer> data = FXCollections.observableArrayList(
                new Customer("123", "Mohamed", "Omdurman"));
        table.getColumns().addAll(tc1, tc2, tc3);
        table.setItems(data);
        bp.setBottom(table);

        Button b1 = new Button("save");
        b1.setOnAction((e) -> {
            String cid = tf1.getText();
            String cname = tf2.getText();
            String add = tf3.getText();
            data.add(new Customer(cid, cname, add));
            table.setItems(data);
        });
        Button b2 = new Button("delete");
        b2.setOnAction((e) -> {
            Customer selectedItem = table.getSelectionModel().getSelectedItem();
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

class Customer {
    String cid;
    String cname;
    String add;

    public Customer(String cid, String cname, String add) {
        this.cid = cid;
        this.cname = cname;
        this.add = add;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}