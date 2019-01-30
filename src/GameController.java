import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class GameController {

    private Label labelX;
    private Label labelO;
    private LogicGame logicGame;
    private MulticastSocket socket;
    private InetAddress group;

    public BorderPane getBorderPane00() {
        return borderPane00;
    }

    public BorderPane getBorderPane10() {
        return borderPane10;
    }

    public BorderPane getBorderPane20() {
        return borderPane20;
    }

    public BorderPane getBorderPane01() {
        return borderPane01;
    }

    public BorderPane getBorderPane11() {
        return borderPane11;
    }

    public BorderPane getBorderPane21() {
        return borderPane21;
    }

    public BorderPane getBorderPane02() {
        return borderPane02;
    }

    public BorderPane getBorderPane12() {
        return borderPane12;
    }

    public BorderPane getBorderPane22() {
        return borderPane22;
    }

    public GameController() {

        try {
            this.group = InetAddress.getByName("239.0.0.222");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            this.socket = new MulticastSocket(5000);
            socket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogicGame(LogicGame logicGame) {
        this.logicGame = logicGame;
    }

    private void sendMsg(String touch){
        DatagramPacket msg = new DatagramPacket(touch.getBytes(), touch.length(),
                group, 5000);
        try {
            socket.send(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private BorderPane borderPane00;

    @FXML
    private BorderPane borderPane10;

    @FXML
    private BorderPane borderPane20;

    @FXML
    private BorderPane borderPane01;

    @FXML
    private BorderPane borderPane11;

    @FXML
    private BorderPane borderPane21;

    @FXML
    private BorderPane borderPane02;

    @FXML
    private BorderPane borderPane12;

    @FXML
    private BorderPane borderPane22;

    @FXML
    void touch00(MouseEvent event) {
        sendMsg("touch00");
    }

    @FXML
    void touch01(MouseEvent event) {
        sendMsg("touch01");
    }

    @FXML
    void touch02(MouseEvent event) {
        sendMsg("touch02");
    }

    @FXML
    void touch10(MouseEvent event) {
        sendMsg("touch10");
    }

    @FXML
    void touch11(MouseEvent event) {
        sendMsg("touch11");
    }

    @FXML
    void touch12(MouseEvent event) {
        sendMsg("touch12");
    }

    @FXML
    void touch20(MouseEvent event) {
        sendMsg("touch20");
    }

    @FXML
    void touch21(MouseEvent event) {
        sendMsg("touch21");
    }

    @FXML
    void touch22(MouseEvent event) {
        sendMsg("touch22");
    }

    // 1 to krzyzyk
    // 2 to kolko
   public void setCircleOrCross(BorderPane borderPane, int column, int row) {
        int counter = logicGame.move();

        if (counter % 2 == 0) {
            LabelX labelX = new LabelX();
            borderPane.setCenter(labelX.getLabelX());
            logicGame.setCircleOrCross(1, column, row);
            logicGame.stateOfGame(1);
        } else {
            LabelO labelO = new LabelO();
            borderPane.setCenter(labelO.getLabelO());
            logicGame.setCircleOrCross(2, column, row);
            logicGame.stateOfGame(2);
        }

    }
}
