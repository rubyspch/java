import java.time.LocalDate;

public class FitnessTracker {
    private String activity;
    private int minutes;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    FitnessTracker(){
        //SETTING THE PARAMS MANUALLY
//        this.activity = "running";
//        this.minutes = 0;
//        this.date = LocalDate.of(2021,1,1);

        //CAN ALSO USE THIS KEYWORD TO RUN THE OVERLOADED CONSTRUCTOR WITH THE DEFAULT PARAMETERS
        this("running", LocalDate.of(2021,1,1), 0);
        //ie calling one constructor from another
    }
    FitnessTracker(String activity, LocalDate date, int minutes){
        this.activity = activity;
        this.date = date;
        this.minutes = minutes;
    }
}
