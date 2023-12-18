module com.example.lynn_books_recommendation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lynn_books_recommendation to javafx.fxml;
    exports com.example.lynn_books_recommendation;
}