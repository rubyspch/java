import java.time.LocalDate;

public class TestFitnessTracker {
    public static void main(String[] args) {
        FitnessTracker go = new FitnessTracker();
        System.out.printf(go.getActivity() + " " + go.getMinutes() + " minutes on " + go.getDate() + "%n");

        FitnessTracker go2 = new FitnessTracker("bicycling", LocalDate.of(2020,3,23), 35);
        System.out.printf(go2.getActivity() + " " + go2.getMinutes() + " minutes on " + go2.getDate());

    }
}
