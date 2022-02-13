package pizza.order.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public ChoiceBox<String> toppingsChoice;
    @FXML
    public String[] choices = {"Mushroom", "Onion", "Pepper", "Mozzarella"};
    @FXML
    public void initialize(){
        toppingsChoice.getItems().addAll(choices);
    }

}