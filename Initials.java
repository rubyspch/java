import java.util.Scanner;
public class Initials {
    public static void main(String [] args){
        char initial1 = 'R';
        char initial2 = 'S';
        char initial3 = 'C';
        System.out.printf("%c.%c.%c.%n", initial1, initial2, initial3);
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter first initial:");
        String yourInitial1 = userInput.nextLine();
        System.out.print("Please enter second initial:");
        String yourInitial2 = userInput.nextLine();
        System.out.print("Please enter third initial:");
        String yourInitial3 = userInput.nextLine();
        System.out.printf("%s.%s.%s.", yourInitial1, yourInitial2, yourInitial3);




    }
}
