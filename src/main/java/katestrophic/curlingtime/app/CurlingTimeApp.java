package katestrophic.curlingtime.app;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/// @purpose JavaFX lifecycle and handles scenes
public class CurlingTimeApp extends Application {
    @Override
    public void start (Stage stage) throws IOException {
        // FXMLLoader fxmlLoader
        // Scene scene
        stage.setTitle("Curling Time");
        // stage.setScene(scene)
        stage.show();
    }
}
