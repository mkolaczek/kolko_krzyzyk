import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;


import java.io.IOException;

public class LabelO extends Node {
    private Label labelO;

    public Label getLabelO() {
        return labelO;
    }

    public LabelO(){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/LabelO.fxml"));
        try {
            labelO = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
