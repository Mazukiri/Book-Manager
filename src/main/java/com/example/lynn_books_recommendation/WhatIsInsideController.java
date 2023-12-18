package com.example.lynn_books_recommendation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WhatIsInsideController {

    public Button Literature;
    public Button Philosophy;
    public String type;

    //Choose Literature Library
    public void clickLiterature(MouseEvent mouseEvent) throws IOException {
        type = "Literature";
        Data data = Data.getData();
        data.type = "Literature";
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("ListBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);

        Stage stage = (Stage) Literature.getScene().getWindow();
        stage.setScene(scene);
    }

    //Choose Philosophy Library
    public void clickPhilosophy(MouseEvent mouseEvent) throws IOException {
        type = "Philosophy";
        Data data = Data.getData();
        data.type = "Philosophy";
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("ListBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);

        Stage stage = (Stage) Philosophy.getScene().getWindow();
        stage.setScene(scene);
    }

    public void clickGoBack(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Stage stage = (Stage) Philosophy.getScene().getWindow();
        stage.setScene(scene);
    }
}
