import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.io.IOException;

public class LabelX extends Node {
    private Label labelX;

    public Label getLabelX() {
        return labelX;
    }

    public LabelX(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/LabelX.fxml"));
        try {
            labelX = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
