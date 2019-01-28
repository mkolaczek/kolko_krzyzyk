public class LogicGame {
   private int[] circleOrCross = new int[9];
   private static int counter = 0;



    public int move(){
       counter += 1;
       return  counter;
   }
}
