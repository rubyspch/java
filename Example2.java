import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("What's your fave number?");
        try {
            int n = sc.nextInt();
            System.out.printf(n + "");
        } catch (Exception e){
            System.out.printf("Sorry, lease enter a number");
        }
    }
}
