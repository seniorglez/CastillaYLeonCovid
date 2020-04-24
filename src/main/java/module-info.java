module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.seniorglez.cobid to javafx.fxml;
    opens com.seniorglez.cobid.model to javafx.base;
    exports com.seniorglez.cobid;
}