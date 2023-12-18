package com.example.lynn_books_recommendation;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomGeneratorController {
    public Button RandLit;
    public Button Lynn;
    public Button RandPhi;
    public Text RandText;
    public ImageView ImageDisplay;
    public ArrayList<Book> Literature = new ArrayList<>();
    public ArrayList<Book> Philosophy = new ArrayList<>();
    public Book book;
    public Book BookRandom;


    public void clickGoBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Stage stage = (Stage) Lynn.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void initialize() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Literature.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()){
            scanner.nextLine();
            String Title = scanner.nextLine();
            String Author = scanner.nextLine();
            String Pages = scanner.nextLine();
            String PublishedYear = scanner.nextLine();
            String Description = scanner.nextLine();
            String LinkBook = scanner.nextLine();
            String LinkCover = scanner.nextLine();
            Book book = new Book(Title,Author,Pages,PublishedYear,Description,LinkBook,LinkCover);
            Literature.add(book);
        }

        file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Philosophy.txt");
        scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()){
            scanner.nextLine();
            String Title = scanner.nextLine();
            String Author = scanner.nextLine();
            String Pages = scanner.nextLine();
            String PublishedYear = scanner.nextLine();
            String Description = scanner.nextLine();
            String LinkBook = scanner.nextLine();
            String LinkCover = scanner.nextLine();
            Book book = new Book(Title,Author,Pages,PublishedYear,Description,LinkBook,LinkCover);
            Philosophy.add(book);
        }


    }

    //Random a book in Literature Library
    public void clickRandomLiterature() {
    Random rand = new Random();
    int n = rand.nextInt(Literature.toArray().length);
    BookRandom = Literature.get(n);
    ImageDisplay.setImage(new Image(BookRandom.LinkCover));



}

    //Random a book in Philosophy Library
    public void clickRandomPhilosophy() {
        Random rand = new Random();
        int n = rand.nextInt(Philosophy.toArray().length);
        BookRandom = Philosophy.get(n);
        ImageDisplay.setImage(new Image(BookRandom.LinkCover));

    }

    //Random a book in one of these 2 libraries
    public void clickRandomLynn() {
        Random rand = new Random();
        int n = rand.nextInt(2);

        if (n==0) clickRandomLiterature();else clickRandomPhilosophy();

    }

    public void clickViewBook() throws IOException{
        Data.getData().book = BookRandom;
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("BookView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        Stage stage = new Stage();
        stage.setY(120);
        stage.setX(350);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}

