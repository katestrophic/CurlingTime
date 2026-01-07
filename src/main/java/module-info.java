/// @purpose manages dependencies and modules
module katestrophic.curlingtime {
    requires javafx.controls;
    requires javafx.fxml;

    // opens: grant access to package (JavaFX/Jackson)
    opens katestrophic.curlingtime to javafx.fxml;

    // exports: makes the main package available to JavaFX runtime
    exports katestrophic.curlingtime;
}