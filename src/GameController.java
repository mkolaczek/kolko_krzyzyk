import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameController {

    private Label labelX;
    private Label labelO;
    private LogicGame logicGame = new LogicGame();


//    public GameController() throws IOException {
//
//        FXMLLoader loader = new FXMLLoader();
//        FXMLLoader loader2 = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("/fxml/LabelX.fxml"));
//        this.labelX = loader.load();
//        loader2.setLocation(this.getClass().getResource("/fxml/LabelO.fxml"));
//        this.labelO = loader2.load();
//
//    }

//    @FXML
//    void initialize() {
//
//    }


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
        setCircleOrCross(borderPane00);
    }

    @FXML
    void touch01(MouseEvent event) {
        setCircleOrCross(borderPane01);
    }

    @FXML
    void touch02(MouseEvent event) {
        setCircleOrCross(borderPane02);
    }

    @FXML
    void touch10(MouseEvent event) {
        setCircleOrCross(borderPane10);
    }

    @FXML
    void touch11(MouseEvent event) {
        setCircleOrCross(borderPane11);
    }

    @FXML
    void touch12(MouseEvent event) {
        setCircleOrCross(borderPane12);
    }

    @FXML
    void touch20(MouseEvent event) {
        setCircleOrCross(borderPane20);
    }

    @FXML
    void touch21(MouseEvent event) {
        setCircleOrCross(borderPane21);
    }

    @FXML
    void touch22(MouseEvent event) {
        setCircleOrCross(borderPane22);
    }

    private void setCircleOrCross(BorderPane borderPane){
        int counter = logicGame.move();
        if (counter % 2 == 0) {
            LabelX labelX = new LabelX();
            borderPane.setCenter(labelX.getLabelX());
        }
        else {
            LabelO labelO = new LabelO();
            borderPane.setCenter(labelO.getLabelO());
        }
    }
}
