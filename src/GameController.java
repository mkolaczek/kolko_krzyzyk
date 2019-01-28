import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class GameController {

    private Label labelX;
    private Label labelO;
    private LogicGame logicGame;

    public void setLogicGame(LogicGame logicGame) {
        this.logicGame = logicGame;
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
        if (logicGame.getCircleOrCross(0, 0) == 0)
            setCircleOrCross(borderPane00, 0, 0);

    }

    @FXML
    void touch01(MouseEvent event) {
        if (logicGame.getCircleOrCross(0, 1) == 0)
            setCircleOrCross(borderPane01, 0, 1);
    }

    @FXML
    void touch02(MouseEvent event) {
        if (logicGame.getCircleOrCross(0, 2) == 0)
            setCircleOrCross(borderPane02, 0, 2);
    }

    @FXML
    void touch10(MouseEvent event) {
        if (logicGame.getCircleOrCross(1, 0) == 0)
            setCircleOrCross(borderPane10, 1, 0);
    }

    @FXML
    void touch11(MouseEvent event) {
        if (logicGame.getCircleOrCross(1, 1) == 0)
            setCircleOrCross(borderPane11, 1, 1);
    }

    @FXML
    void touch12(MouseEvent event) {
        if (logicGame.getCircleOrCross(1, 2) == 0)
            setCircleOrCross(borderPane12, 1, 2);
    }

    @FXML
    void touch20(MouseEvent event) {
        if (logicGame.getCircleOrCross(2, 0) == 0)
            setCircleOrCross(borderPane20, 2, 0);
    }

    @FXML
    void touch21(MouseEvent event) {
        if (logicGame.getCircleOrCross(2, 1) == 0)
            setCircleOrCross(borderPane21, 2, 1);
    }

    @FXML
    void touch22(MouseEvent event) {
        if (logicGame.getCircleOrCross(2, 2) == 0)
            setCircleOrCross(borderPane22, 2, 2);
    }

    // 1 to krzyzyk
    // 2 to kolko
    private void setCircleOrCross(BorderPane borderPane, int column, int row) {
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
