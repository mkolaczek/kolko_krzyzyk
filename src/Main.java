import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        InetAddress group = null;
        try {
            group = InetAddress.getByName("239.0.0.222");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MulticastSocket socket = new MulticastSocket(5000);
        socket.joinGroup(group);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/game.fxml"));

        GridPane gridPane = loader.load();
        LogicGame logicGame = new LogicGame();

        GameController gameController = loader.getController();
        gameController.setLogicGame(logicGame);

        ListenThread listenThread = new ListenThread(socket, group, gameController,logicGame);
        logicGame.setListenThread(listenThread);
        logicGame.setPrimaryStage(primaryStage);
        
        primaryStage.setTitle("Kółko i krzyżyk");
        primaryStage.setScene(new Scene(gridPane, 400, 400));

        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {

        launch(args);

    }
}
