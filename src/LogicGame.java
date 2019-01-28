import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class LogicGame {
   private int[][] circleOrCross = new int[3][3];
   private static int counter = 0;
   private int playerX = 1, playerO = 2;
   private GridPane gridPane;

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void setCircleOrCross(int oneOrTwo, int column, int row) {
        circleOrCross[column][row] = oneOrTwo;
    }

    public int getCircleOrCross(int column, int row) {
        return circleOrCross[column][row];
    }

    public void stateOfGame( int player){

        if (circleOrCross[0][0] == player && circleOrCross[1][1] == player && circleOrCross[2][2] == player){
            System.out.println("wygral1 " + player);
        }

        if (circleOrCross[0][2] == player && circleOrCross[1][1] == player && circleOrCross[2][0] == player){

            System.out.println("wygral2 " + player);
        }

        for(int i = 0; i < 3; i++){
            if (circleOrCross[i][0] == player && circleOrCross[i][1] == player && circleOrCross[i][2] == player){
                System.out.println("wygral3 " + player);
            }

            if(circleOrCross[0][i] == player && circleOrCross[1][i] == player && circleOrCross[2][i] == player){
                System.out.println("wygral4 " + player);
            }
        }
        if(counter == 9){
            System.out.println("remis");
        }

    }

    public int move(){
       counter += 1;
       return  counter;
   }
}
