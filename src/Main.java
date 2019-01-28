import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/game.fxml"));

        GridPane gridPane = loader.load();
//        GameController gameController = loader.getController();
        primaryStage.setTitle("Kółko i krzyżyk");
        primaryStage.setScene(new Scene(gridPane, 400, 400));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
