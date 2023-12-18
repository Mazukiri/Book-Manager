package com.example.lynn_books_recommendation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

//Open the Application
public class LynnOpen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        stage.setResizable(false);
        stage.getIcons().add(new Image(System.getProperty("user.dir") + "\\src\\main\\resources\\GraphicResource\\Button\\AppIcon.png"));
        stage.setTitle("Lynn Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}