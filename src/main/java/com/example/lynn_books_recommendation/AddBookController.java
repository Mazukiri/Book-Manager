package com.example.lynn_books_recommendation;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddBookController {
    public TextField Title;
    public TextField Author;
    public TextField Pages;
    public TextField PublishedYear;
    public TextField TextCover;
    public Button ChooseCover;
    public TextArea Description;
    public Button AddBook;
    public TextField TextFile;
    public Button ChooseFile;
    public Text Error;
    public String type;

    /*
    *   This function will check whether the user has filled all the fields yet. If they did it correctly, then the book information
    * will be stored in a file(database). Otherwise, it asks them to fill all the required forms.
    */
    public void clickAddBook() throws IOException {
        if (Title.getText().equals("")
            || Author.getText().equals("")
            || Pages.getText().equals("")
            || PublishedYear.getText().equals("")
            || Description.getText().equals("")
            || TextCover.getText().equals("")
                || TextFile.getText().equals("")) {
                Error.setText("Lynn can't add book ! All the fields have to be filled ><");
                return;
        }
        FileWriter fileWriter;
        if (type.equals("Literature")) {
            fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Literature.txt",true);
        } else {
            fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\LynnLibrary\\Philosophy.txt",true);
        }
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write(Title.getText() + "\n");
        fileWriter.write(Author.getText() + "\n");
        fileWriter.write(Pages.getText() + "\n");
        fileWriter.write(PublishedYear.getText() + "\n");
        fileWriter.write(Description.getText() + "\n");
        fileWriter.write(TextFile.getText() + "\n");
        fileWriter.write(TextCover.getText() + "\n");
        fileWriter.close();

        Stage stage = (Stage) Title.getScene().getWindow();
        stage.close();
    }

    //Set the type of the book
    public void setType(String type){
        this.type = type;
    }

    //Choose ebook file
    public void clickChoosePDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF File","*.pdf"));
        File file = fileChooser.showOpenDialog(Title.getScene().getWindow());
        TextFile.setText(file.getPath());
    }

    //Choose ebook cover
    public void clickChooseCover() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG File","*.jpg")
        ,new FileChooser.ExtensionFilter("JPEG File","*.jpeg")
        ,new FileChooser.ExtensionFilter("PNG File","*.png"));
        File file = fileChooser.showOpenDialog(Title.getScene().getWindow());
        TextCover.setText(file.getPath());
    }
}
