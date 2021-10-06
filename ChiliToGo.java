import java.util.Scanner;
public class ChiliToGo {
    public void LetsOrder(){
        final int ADULT_MEAL= 7;
        final int CHILD_MEAL= 4;
        Scanner scan = new Scanner(System.in);
        System.out.printf("How many adult meals would you like?%n");
        int adultInput = scan.nextInt();
        System.out.printf("How many child meals would you like?%n");
        int childInput = scan.nextInt();
        System.out.printf("Your order will cost £%d, for %d adult meals and %d child meals.%n", (ADULT_MEAL*adultInput+CHILD_MEAL*childInput), adultInput, childInput);
    }
    public static void main(String[] args) {
        ChiliToGo go = new ChiliToGo();
        go.LetsOrder();
    }
}
