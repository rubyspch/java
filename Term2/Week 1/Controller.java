package fsd.week1.demolecture;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField id;

    @FXML
    private Label email;

    @FXML
    private CheckBox item1;

    @FXML
    private CheckBox item2;

    @FXML
    private CheckBox oop;

    @FXML
    private CheckBox alg;

    @FXML
    private ListView<String> myListView;

    private String departments[] = {"Edgbaston", "Selly Oak"};

    private String whichDepart;

    @FXML
    private Label whichDept;


    @FXML
    public void display() {
        System.out.println("Name: " + name.getText()
                + "StudId: " + id.getText());
        email.setText(id.getText() + "@student.bham.ac.uk");
    }

    public void isChecked(ActionEvent e) {

       // if (e.getSource().equals(oop) && oop.isSelected())
        if(oop.isSelected())
            System.out.println(name.getText() + " You chose OOP");
        else if (e.getSource().equals(alg))
            System.out.println(name.getText() + " You chose Algorithms");
    }

//    public void clickItem(ActionEvent e) {
//        if (e.getSource().equals(item1) || e.getSource().equals(item2))
//            System.out.println("An item was checked");
//    }

    public void clickItem(){
        if (item1.isSelected() || item2.isSelected())
            System.out.println("An item was selected");
    }

    public void initialize(URL location, ResourceBundle rb) {
        //to load items into the ListView
        myListView.setPrefSize(100, 200);
        myListView.getItems().addAll(departments);
        //adding a listener for when a change occurs
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            //making the change in the ListView
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                whichDepart = myListView.getSelectionModel().getSelectedItem();
                whichDept.setText(whichDepart);
            }
        });
    }
}