package week2.todolist.week2todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import week2.todolist.week2todolist.datamodel.ToDoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public ListView<ToDoItem> toDoListView; //The <> Links it to data ToDoItem class

    @FXML
    public TextArea itemDetailsTextArea;

    private List<ToDoItem> toDoItems;

    public void initialize(){
        ToDoItem item1 = new ToDoItem("Post birthday card", "Buy and write out birthday card",
                LocalDate.of(2022, Month.JULY, 17));
        ToDoItem item2 = new ToDoItem("Weekend away", "Book for the weekend away and get pets booked in",
                LocalDate.of(2022, Month.APRIL, 10));
        ToDoItem item3 = new ToDoItem("Plan birthday party", "Send out invites for the birthday and book venue",
                LocalDate.of(2022, Month.SEPTEMBER, 01));
        ToDoItem item4 = new ToDoItem("Get car serviced", "Book a service date for before we go away for the weekend",
                LocalDate.of(2022, Month.MARCH, 05));
        ToDoItem item5 = new ToDoItem("Assignments for FSD", "Plan for assignment deadlines in term 2",
                LocalDate.of(2022, Month.JANUARY, 25));
        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);
        toDoListView.getItems().setAll(toDoItems);

        //So only one thing can be selected at a time:
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    public void handleClickListView(MouseEvent mouseEvent) {
        //grabs the one the user selected and store in item
        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());
    }

}