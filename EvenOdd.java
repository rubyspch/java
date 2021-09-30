import java.util.Scanner;
public class EvenOdd {
    public static void main(String [] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a number");
        int num = userInput.nextInt();
        if (num%2==0){
            System.out.print("The number is even");
        } else{
            System.out.print("The number is odd");
        }
    }
}
