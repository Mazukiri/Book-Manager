package com.example.lynn_books_recommendation;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class BookViewController extends Application{
    public ImageView BookDisplayer;
    public Text Title;
    public Text Author;
    public Text Pages;
    public Text PublishedYear;
    public Text Description;
    public Button OpenBook;

    @FXML //Create an initialization status for the program
    public void initialize(){
        Data data = Data.getData();
        Book book = data.book;
        Title.setText(book.Title);
        Author.setText("Author:  " + book.Author);
        Pages.setText("Pages:  " + book.Pages);
        PublishedYear.setText("PublishedYear:  " + book.PublishedYear);
        Description.setText(book.Description);
        Image image = new Image(book.LinkCover);
        BookDisplayer.setImage(image);
    }

    //Click on the book cover to open it in your PDF reader
    public void clickReadBook(MouseEvent mouseEvent) {
        Data data = Data.getData();
        File file = new File(data.book.LinkBook);
        HostServices hostServices = getHostServices();
        hostServices.showDocument(file.getAbsolutePath());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}

