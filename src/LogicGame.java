import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogicGame {
    private int[][] circleOrCross = new int[3][3];
    private static int counter = 0;
    private int playerX = 1, playerO = 2;
    private Stage primaryStage;
    private ListenThread listenThread;

    public void setListenThread(ListenThread listenThread) {
        this.listenThread = listenThread;
    }


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setCircleOrCross(int oneOrTwo, int column, int row) {
        circleOrCross[column][row] = oneOrTwo;
    }

    public int getCircleOrCross(int column, int row) {
        return circleOrCross[column][row];
    }

    private void showWinO() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/winO.fxml"));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(pane, 400, 400));
    }

    private void showWinX() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/winX.fxml"));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(pane, 400, 400));
    }

    private void showDraw() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/draw.fxml"));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(pane, 400, 400));
    }

    private static int condition = 0;

    public void stateOfGame(int player) {

        if (circleOrCross[0][0] == player && circleOrCross[1][1] == player && circleOrCross[2][2] == player) {
            condition = 1;
            if (player == 1) {
                showWinX();
            } else {
                showWinO();
            }
            listenThread.shutdown();
        }

        if (circleOrCross[0][2] == player && circleOrCross[1][1] == player && circleOrCross[2][0] == player) {
            condition = 1;

            if (player == 1) {
                showWinX();
            } else {
                showWinO();
            }
            listenThread.shutdown();
        }

        for (int i = 0; i < 3; i++) {
            if (circleOrCross[i][0] == player && circleOrCross[i][1] == player && circleOrCross[i][2] == player) {
                condition = 1;
                if (player == 1) {
                    showWinX();
                } else {
                    showWinO();
                }
                listenThread.shutdown();
            }

            if (circleOrCross[0][i] == player && circleOrCross[1][i] == player && circleOrCross[2][i] == player) {
                condition = 1;
                if (player == 1) {
                    showWinX();
                } else {
                    showWinO();
                }
                listenThread.shutdown();
            }
        }
        if (condition == 0 && counter == 9) {
            showDraw();
            listenThread.shutdown();
        }

    }

    public int move() {
        counter += 1;
        return counter;
    }
}
