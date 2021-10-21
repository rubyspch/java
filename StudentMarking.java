import java.util.Scanner;
// DO NOT import anything else

/**
 * This class forms Java Assignment 1, 2021
 */
public class StudentMarking {

    /**
     * The message that the main menu must display --- DO NOT CHANGE THIS
     */
    public final String MENU_TEMPLATE =
            "%nWelcome to the Student System. Please enter an option 0 to 3%n"
                    + "0. Exit%n"
                    + "1. Generate a student ID%n"
                    + "2. Capture marks for students%n"
                    + "3. List student IDs and average mark%n";
    /**
     * DO NOT CHANGE THIS
     */
    public final String NOT_FOUND_TEMPLATE =
            "No student id of %s exists";
   /* Do NOT change the two templates ABOVE this comment.
      DO CHANGE the templates BELOW.
   */
    // TODO (All questions) - Complete these templates which will be used throughout the program
    public final String ENTER_MARK_TEMPLATE = "Please enter mark %d for student %s%n";
    public final String STUDENT_ID_TEMPLATE = "Your studID is %s";
    public final String NAME_RESPONSE_TEMPLATE = "You entered a given name of %s and a surname of %s%n";
    public final String LOW_HIGH_TEMPLATE = "Student %s has a lowest mark of %d%nA highest mark of %d%n";
    public final String AVG_MARKS_TEMPLATE = "Student ***%s*** has an average of %6.2f%n";
    public final String COLUMN_1_TEMPLATE = "Highest"; //need to work this out! get the spacing and template right!
    public final String COLUMN_2_TEMPLATE = "Lowest%n";
    public final String REPORT_PER_STUD_TEMPLATE = "| Student ID %3d is %6s | Average is  %5.2f |%n";
    public final String CHART_KEY_TEMPLATE = "*"; //Include the spacing here?

    /**
     * Creates a student ID based on user input
     *
     * @param sc Scanner reading {@link System#in} re-used from {@link StudentMarking#main(String[])}
     * @return a studentID according to the pattern specified in {@link StudentMarking#STUDENT_ID_TEMPLATE}
     */
    public String generateStudId(Scanner sc) {
        // TODO (3.4) - Complete the generateStudId method which will allow a user to generate a student id
        String studId = ""; // TODO Don't have unnecessary initialisations
        String firstName = "";
        String lastName = "";
        int middleFirstName;
        int middleLastName;
        String lastNameLengthPadded;

        System.out.printf(
                "Please enter your given name and surname (Enter 0 to return to main menu)%n");
        String userInput = sc.nextLine();
        int userInputLength = userInput.length();

        if (userInput.equals("0")) {
            return studId;
        } else {
            //Split the input into first and last name
            for (int i = 0; i < userInputLength; i++) {
                if (userInput.charAt(i) == ' ') {
                    firstName = userInput.substring(0, i);
                    lastName = userInput.substring(i + 1, userInputLength);
                }
            }
            //Get middle position of firstName and lastName
            middleFirstName = (int) Math.ceil(firstName.length() / 2);
            middleLastName = (int) Math.ceil(lastName.length() / 2);

            //Print names
            System.out.printf(NAME_RESPONSE_TEMPLATE, firstName, lastName);

            lastNameLengthPadded = String.format("%02d",lastName.length());

            //Concatonate and print studId
            studId = (firstName.substring(0, 1)).toUpperCase() + (lastName.substring(0, 1)).toUpperCase() + lastNameLengthPadded + firstName.charAt(middleFirstName) + lastName.charAt(middleLastName);
            System.out.printf( STUDENT_ID_TEMPLATE, studId);
        }
        return studId;
    }

    /**
     * Reads three marks (restricted to a floor and ceiling) for a student and returns their mean
     *
     * @param sc     Scanner reading {@link System#in} re-used from {@link StudentMarking#main(String[])}
     * @param studId a well-formed ID created by {@link StudentMarking#generateStudId(Scanner)}
     * @return the mean of the three marks entered for the student
     */
    public double captureMarks(Scanner sc, String studId) {
        // TODO (3.5) - Complete the captureMarks method which will allow a user to input three mark for a chosen student
        StudentMarking sm = new StudentMarking();

        // DO NOT change MAX_MARK and MIN_MARK
        final int MAX_MARK = 100;
        final int MIN_MARK = 0;

        //what does unnecessary mean?
        double avg;

        int[] studentMarks = new int[3];
        int low;
        int high;
        int currentMark;
        int placeholder;

        //Capture marks and add to array
        for(int i=1;i<=3;i++){
            System.out.printf(ENTER_MARK_TEMPLATE,i,studId);
            currentMark = sc.nextInt();
            while (currentMark<MIN_MARK || currentMark>MAX_MARK){
                System.out.printf(ENTER_MARK_TEMPLATE,i,studId);
                currentMark = sc.nextInt();
            }
            studentMarks[i-1]=currentMark;
        }
        sc.nextLine();
        avg = (double) (studentMarks[0] +studentMarks[1] +studentMarks[2])/3;

        //sort array the lowest mark to highest
        for(int x=0;x<studentMarks.length;x++) {
            for (int i = 0; i < studentMarks.length - 1; i++) {
                if (studentMarks[i] > studentMarks[i + 1]) {
                    placeholder = studentMarks[i + 1];
                    studentMarks[i + 1] = studentMarks[i];
                    studentMarks[i] = placeholder;
                }
            }
        }
        high = studentMarks[2];
        low = studentMarks[0];

        //print marks
        System.out.printf(LOW_HIGH_TEMPLATE, studId, low, high);
        System.out.printf(AVG_MARKS_TEMPLATE, studId, avg);

        //Conditionally print bar chart
        System.out.printf("Would you like to print a bar chart? [y/n]%n");
        String barChartAnswer = (sc.nextLine()).toLowerCase();
        if(barChartAnswer.equals("y")){
            sm.printBarChart(studId, high,low);
        }
        return avg;
    }

    /**
     * outputs a simple character-based vertical bar chart with 2 columns
     *
     * @param studId a well-formed ID created by {@link StudentMarking#generateStudId(Scanner)}
     * @param high   a student's highest mark
     * @param low    a student's lowest mark
     */
    public void printBarChart(String studId, int high, int low) {
        // TODO (3.6) - Complete the printBarChart method which will print a bar chart of the highest and lowest results of a student
        // Try https://stackoverflow.com/questions/10374544/how-can-i-print-line-side-by-side-in-java
        String barChart="";
        System.out.printf("Student id statistics: %s%n",studId);
        for(int i=high;i>0;--i){
            barChart+="   " + CHART_KEY_TEMPLATE;
            if(!(i>low)){
                barChart+="           "+CHART_KEY_TEMPLATE+"%n";
            } else{
                barChart+="%n";
            }
        }
        System.out.printf(barChart);
        System.out.printf(COLUMN_1_TEMPLATE + "     " + COLUMN_2_TEMPLATE);
        System.out.printf("%4d%12d%n", high, low);
    }

    /**
     * Prints a specially formatted report, one line per student
     *
     * @param studList student IDs originally generated by {@link StudentMarking#generateStudId(Scanner)}
     * @param count    the total number of students in the system
     * @param avgArray mean (average) marks
     */
    public void reportPerStud(String[] studList,
                              int count,
                              double[] avgArray) {
        for(int i=0;i<count;i++){
            System.out.printf(REPORT_PER_STUD_TEMPLATE, i+1, studList[i], avgArray[i]);
        }
    }
    /**
     * The main menu
     */
    public void displayMenu() {
        // TODO (3.2) - Complete the displayMenu method to use the appropriate template with printf
        System.out.printf(MENU_TEMPLATE);
    }
    /**
     * The controlling logic of the program. Creates and re-uses a {@link Scanner} that reads from {@link System#in}.
     *
     * @param args Command-line parameters (ignored)
     */

    public static void main(String[] args) {
        // TODO (3.3) - Complete the main method to give the program its core

        // DO NOT change sc, sm, EXIT_CODE, and MAX_STUDENTS
        Scanner sc = new Scanner(System.in);
        StudentMarking sm = new StudentMarking();
        final int EXIT_CODE = 0;
        final int MAX_STUDENTS = 5;

        // TODO Initialise these
        String[] keepStudId= new String[MAX_STUDENTS];
        double[] avgArray= new double[MAX_STUDENTS];
        int studentCount= 0;

        // TODO Build a loop around displaying the menu and reading then processing input
        sm.displayMenu();
        int userInputDisplayMenu = sc.nextInt(); //may need to do nextLine()after this
        sc.nextLine();

        while(userInputDisplayMenu!=EXIT_CODE){
            switch(userInputDisplayMenu){
                case(1):{
                    if(studentCount==5){
                        System.out.printf("You cannot add any more students to the array");
                        break;
                    }
                    String currentId= sm.generateStudId(sc); //run genStud and capture returned id
                    if(currentId.length()==0){
                        break;
                    } else{
                        keepStudId[studentCount] = currentId; //place id in array
                        ++studentCount; //increment studentCount
                    }
                    break;
                }
                case(2):{
                    Boolean validStudId = false;
                    double currentAverage;
                    int arrayPositionStudent = 0;

                    System.out.printf("Please enter the studId to capture their marks (Enter 0 to return to main menu)%n");
                    String captureMarksStudId = sc.nextLine();

                    if(captureMarksStudId.equals("0")){
                        break;
                    }

                    for (int i = 0; i < keepStudId.length; ++i) {
                        if(keepStudId[i]==null){
                            continue;
                        } else if (keepStudId[i].equals(captureMarksStudId)) {
                            validStudId = true;
                            arrayPositionStudent = i;
                        }
                    }

                    if (validStudId) {
                        currentAverage = sm.captureMarks(sc, captureMarksStudId); //problem with static array call?
                        avgArray[arrayPositionStudent]=currentAverage; //position the avg corresponding to id position
                    } else {
                        System.out.printf(sm.NOT_FOUND_TEMPLATE, captureMarksStudId);
                    }
                    break;
                }
                case(3):{
                    sm.reportPerStud(keepStudId, studentCount, avgArray);
                    break;
                }
                default:{
                    // Handle invalid main menu input
                    System.out.printf(
                            "You have entered an invalid option. Enter 0, 1, 2 or 3%n");// Skeleton: keep, unchanged
                }
            }
            sm.displayMenu();
            userInputDisplayMenu = sc.nextInt();
            sc.nextLine();
        }
        System.out.printf("Goodbye%n");
    }
}

/*
    TODO Before you submit:
         1. ensure your code compiles
         2. ensure your code does not print anything it is not supposed to
         3. ensure your code has not changed any of the class or method signatures from the skeleton code
         4. check the Problems tab for the specific types of problems listed in the assignment document
         5. reformat your code: Code > Reformat Code
         6. ensure your code still compiles (yes, again)
 */