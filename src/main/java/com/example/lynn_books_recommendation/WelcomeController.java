package com.example.lynn_books_recommendation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {
    public Button tryLynn;
    public Button getInside;

    //Move to the Library Chooser
    public void clickGetInside() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("WhatIsInside.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Stage stage = (Stage) tryLynn.getScene().getWindow();
        stage.setScene(scene);
    }

    //Move to the Suggestion Part
    public void clickTryLynn() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("RandomGenerator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Stage stage = (Stage) tryLynn.getScene().getWindow();
        stage.setScene(scene);
    }
}