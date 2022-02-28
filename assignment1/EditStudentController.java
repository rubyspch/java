package fsd.assignment.assignment1;

import fsd.assignment.assignment1.datamodel.Student;
import fsd.assignment.assignment1.datamodel.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


public class EditStudentController {
    //all of the variables declared below correspond with the edit-students.fxml
    @FXML
    private Label yearStudyDisplay;

    @FXML
    private Label mod1Edit;

    @FXML
    private Label mod2Edit;

    @FXML
    private Label mod3Edit;

    @FXML
    private ChoiceBox<String> mod1ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod2ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod3ChoiceEdit;

    //the modChoices variables correspond to the []
    private String mod1S, mod2S, mod3S;

    private String modChoices[] = {"OOP", "Data Algo", "DS", "Maths", "AI",
            "Adv Programming", "Project"};

    public void initialize() {

        /* TODO: add all the modChoices to each ChoiceBox
         */
        //insert 3 lines of code here
        mod1ChoiceEdit.setItems(FXCollections.observableArrayList(modChoices));
        mod2ChoiceEdit.setItems(FXCollections.observableArrayList(modChoices));
        mod3ChoiceEdit.setItems(FXCollections.observableArrayList(modChoices));

        //these lines have been given to you includes the setOnAction if a ChoiceBox is selected
        mod1ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod2ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod3ChoiceEdit.setOnAction(this::getChoiceEdit);
    }

    //to ensure that detail pops up to edit
    public void setToEdit(Student stu) {
        /* TODO: display the student to be edited details
         */
        //insert 4 lines of code here
        yearStudyDisplay.setText("/n" + stu.getYearOfStudy());
        mod1Edit.setText("/n" + stu.getModule1());
        mod2Edit.setText("/n" + stu.getModule2());
        mod3Edit.setText("/n" + stu.getModule3()); // these could be wrong!
        /* TODO: get the new module choices using mod1S, mod2S and mod3S
         */
        mod1S = mod1ChoiceEdit.getValue();
        mod2S = mod2ChoiceEdit.getValue();
        mod3S = mod3ChoiceEdit.getValue();
    }

    public Student processEdit(Student stu) {
        /* TODO: complete the observableIst statement by getting all students from StudentData
                 to be collected in allStudents
         */
        ObservableList<Student> allStudents = StudentData.getInstance().getStudents();
        /* TODO: get studId and year of study
         */
        String studIdS = stu.getStudId();
        String yearStudyS = stu.getYearOfStudy();
        /* TODO: remove the student to be edited from allStudents
         */
        //insert the line to remove the student here
        allStudents.remove(stu);
        /* TODO: add the student back by creating a new object reference and calling the addStudentData()
         */
        Student changedStu = new Student(studIdS, yearStudyS, mod1S, mod2S, mod3S);
        //call the addStudentData()
        StudentData.getInstance().addStudentData(changedStu);
        /* TODO: return the newly edited student back to the Controller class / editStudent()
         */
        return changedStu;
    }

    public void getChoiceEdit(ActionEvent event) {
        /* TODO: complete the 3 if... statements using event
         */
        if(event.getSource().equals(mod1ChoiceEdit))
            mod1S = mod1ChoiceEdit.getValue();
        else if (event.getSource().equals(mod2ChoiceEdit))
            mod2S = mod2ChoiceEdit.getValue();
        else if( event.getSource().equals(mod3ChoiceEdit))
            mod3S = mod3ChoiceEdit.getValue();
        else
            System.out.print("Error with getChoiceEdit() in editStudentController()");
        //^ this might work but if not look at event handling again
        //also may have variables confused so double check all that
        //is this right? maybe it means set the choicebox's value not the mod2s variables...
        // also if it does work make it a switch statement?
    }
}
