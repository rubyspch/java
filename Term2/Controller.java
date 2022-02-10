package fsd.week2.todolist2;

import fsd.week2.todolist2.datamodel.ToDoData;
import fsd.week2.todolist2.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize() {
//        ToDoItem item1 = new ToDoItem("Post birthday card", "Buy and write out birthday card",
//                LocalDate.of(2022, Month.JULY, 17));
//        ToDoItem item2 = new ToDoItem("Weekend away", "Book for the weekend away and get pets booked in",
//                LocalDate.of(2022, Month.APRIL, 10));
//        ToDoItem item3 = new ToDoItem("Plan birthday party", "Send out invites for the birthday and book venue",
//                LocalDate.of(2022, Month.SEPTEMBER, 01));
//        ToDoItem item4 = new ToDoItem("Get car serviced", "Book a service date for before we go away for the weekend",
//                LocalDate.of(2022, Month.MARCH, 05));
//        ToDoItem item5 = new ToDoItem("Assignments for FSD", "Plan for assignment deadlines in term 2",
//                LocalDate.of(2022, Month.JANUARY, 25));
//        toDoItems = new ArrayList<ToDoItem>();
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//        toDoItems.add(item5);
//
//        this is the once off code to create the file the first time
  //     ToDoData.getInstance().setToDoItems(toDoItems);

        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {

            @Override
            public void changed(ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue) {
                if(newValue != null){
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    //deadlineLabel.setText(item.getDeadline().toString());
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        //populate the toDoListView
        toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
        //set it to select one item at a time
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}