package com.example.lynn_books_recommendation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListBookController {
    public TextField SearchField;
    public Button AddBook;
    public ImageView Book1;
    public ImageView Book2;
    public ImageView Book3;
    public ImageView Book4;
    public ImageView Book5;
    public ImageView Backward;
    public ImageView Forward;
    public ArrayList<Book> Literature = new ArrayList<>();
    public ArrayList<Book> Philosophy = new ArrayList<>();
    public ArrayList<Book> LiteratureDisplay = new ArrayList<>();
    public ArrayList<Book> PhilosophyDisplay = new ArrayList<>();
    public Text Title;
    public int firstDisplayBook;

    //Get to the previous screen
    public void clickGoBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("WhatIsInside.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Stage stage = (Stage) AddBook.getScene().getWindow();
        stage.setScene(scene);
    }

    //Add a new book
    public void clickAddBook() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LynnOpen.class.getResource("AddBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        AddBookController addBookController = fxmlLoader.getController();
        addBookController.setType(Title.getText());
        Stage stage = new Stage();
        stage.setY(120);
        stage.setX(650);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        readFile();
    }

    //Add the book to the database.
    public void updateFile() throws IOException {
        Data data = Data.getData();
        if (data.type.equals("Literature")){
            FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Literature.txt");
            for(int i=0; i<Literature.size(); i++){
                Book book = Literature.get(i);
                fileWriter.write("\n");
                fileWriter.write((i + 1) + ".\n");
                fileWriter.write(book.Title + '\n');
                fileWriter.write(book.Author + '\n');
                fileWriter.write(book.Pages + '\n');
                fileWriter.write(book.PublishedYear + '\n');
                fileWriter.write(book.Description + '\n');
                fileWriter.write(book.LinkBook + '\n');
                fileWriter.write(book.LinkCover );
            }
            fileWriter.close();
        } else {
            FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Philosophy.txt");
            for(int i=0; i<Philosophy.size(); i++) {
                Book book = Philosophy.get(i);
                fileWriter.write("\n");
                fileWriter.write((i + 1) + ".\n");
                fileWriter.write(book.Title + '\n');
                fileWriter.write(book.Author + '\n');
                fileWriter.write(book.Pages + '\n');
                fileWriter.write(book.PublishedYear + '\n');
                fileWriter.write(book.Description + '\n');
                fileWriter.write(book.LinkBook + '\n');
                fileWriter.write(book.LinkCover );
            }
            fileWriter.close();
        }
    }

    //Load the database into the Literature and Philosophy Library
    public void readFile() throws IOException {
        Literature = new ArrayList<>();
        Philosophy = new ArrayList<>();
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
        updateFile();
        SearchAndShowBook(firstDisplayBook, Data.getData().type);
    }

    //Search book by Title and display the result in order
    public void SearchAndShowBook(int firstDisplayBook,String type){
        this.firstDisplayBook = firstDisplayBook;
        LiteratureDisplay = new ArrayList<>();
        PhilosophyDisplay = new ArrayList<>();
        if (SearchField.getText().equals("")) {
            LiteratureDisplay.addAll(Literature);
            PhilosophyDisplay.addAll(Philosophy);
        } else {
            String search = SearchField.getText().toLowerCase();
            if (type.equals("Literature")){
                for (Book literature : Literature) {
                    String literatureString = literature.Title.toLowerCase();
                    if (literatureString.contains(search)) {
                        LiteratureDisplay.add(literature);
                    }
                }
            } else {
                for (Book philosophy : Philosophy) {
                    String philosophyString = philosophy.Title.toLowerCase();
                    if (philosophyString.contains(search)) {
                        PhilosophyDisplay.add(philosophy);
                    }
                } 
            }
        }
        if(type.equals("Literature")){
            if (LiteratureDisplay.size() >= firstDisplayBook ) Book1.setImage(new Image(LiteratureDisplay.get(firstDisplayBook - 1).LinkCover)); else Book1.setImage(null);
            if (LiteratureDisplay.size() >= firstDisplayBook +1) Book2.setImage(new Image(LiteratureDisplay.get(firstDisplayBook).LinkCover)); else Book2.setImage(null);
            if (LiteratureDisplay.size() >= firstDisplayBook + 2 ) Book3.setImage(new Image(LiteratureDisplay.get(firstDisplayBook + 1).LinkCover)); else Book3.setImage(null);
            if (LiteratureDisplay.size() >= firstDisplayBook + 3 ) Book4.setImage(new Image(LiteratureDisplay.get(firstDisplayBook + 2).LinkCover)); else Book4.setImage(null);
            if (LiteratureDisplay.size() >= firstDisplayBook + 4 ) Book5.setImage(new Image(LiteratureDisplay.get(firstDisplayBook + 3).LinkCover)); else Book5.setImage(null);
        } else {
            if (PhilosophyDisplay.size() >= firstDisplayBook  ) Book1.setImage(new Image(PhilosophyDisplay.get(firstDisplayBook - 1).LinkCover)); else Book1.setImage(null);
            if (PhilosophyDisplay.size() >= firstDisplayBook + 1) Book2.setImage(new Image(PhilosophyDisplay.get(firstDisplayBook).LinkCover)); else Book2.setImage(null);
            if (PhilosophyDisplay.size() >= firstDisplayBook + 2 ) Book3.setImage(new Image(PhilosophyDisplay.get(firstDisplayBook + 1).LinkCover)); else Book3.setImage(null);
            if (PhilosophyDisplay.size() >= firstDisplayBook + 3 ) Book4.setImage(new Image(PhilosophyDisplay.get(firstDisplayBook + 2).LinkCover)); else Book4.setImage(null);
            if (PhilosophyDisplay.size() >= firstDisplayBook + 4 ) Book5.setImage(new Image(PhilosophyDisplay.get(firstDisplayBook + 3).LinkCover)); else Book5.setImage(null);
        }
    }

    @FXML
    public void initialize() throws IOException {
        firstDisplayBook = 1;
        readFile();
        SearchAndShowBook(1,Data.getData().type);
    }

    //Open the book
    public void clickViewBook(int p) throws IOException {
        Data data = Data.getData();
        if (data.type.equals("Literature")){
            if (LiteratureDisplay.size() >= firstDisplayBook + p) {
                data.book = LiteratureDisplay.get(firstDisplayBook + p -1);

            } else return;
        } else {
            if (PhilosophyDisplay.size() >= firstDisplayBook + p) {
                data.book = PhilosophyDisplay.get(firstDisplayBook + p -1);
            } else return;
        }
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

    public void clickViewBook1() throws IOException {
        clickViewBook(0);
    }

    public void clickViewBook2() throws IOException {
        clickViewBook(1);
    }

    public void clickViewBook3() throws IOException {
        clickViewBook(2);
    }

    public void clickViewBook4() throws IOException {
        clickViewBook(3);
    }

    public void clickViewBook5() throws IOException {
        clickViewBook(4);
    }

    //move to the previous page
    public void clickBack() {
        if (firstDisplayBook == 1) return;
        SearchAndShowBook(firstDisplayBook - 1,Data.getData().type);
    }

    //move to the next page
    public void clickNext() {
        Data data = Data.getData();
        if (data.type.equals("Literature")){
            if (Literature.size() == firstDisplayBook + 4) return;
            SearchAndShowBook(firstDisplayBook + 1,Data.getData().type);
        } else {
            if (Philosophy.size() == firstDisplayBook + 4) return;
            SearchAndShowBook(firstDisplayBook + 1,Data.getData().type);
        }
    }

    //Display the result after changing what you type on the search bar
    public void SearchChanged() {
        SearchAndShowBook(1,Data.getData().type);
    }
}
