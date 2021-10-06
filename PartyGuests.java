import java.util.Scanner;

public class PartyGuests {

    public void Calculate(){
        boolean large;
        final int PRICE_PER_GUEST = 75;

        System.out.printf("Please enter the number of guests attending the event");

        Scanner scan = new Scanner(System.in);
        int guests = scan.nextInt();

        if (guests>50){
            large = true;
        } else{
            large = false;
        }

        System.out.printf("***********Carly's Catering****************\n");
        System.out.printf("The number of guests are %d and the total cost for these guests is £%d%n", guests, (PRICE_PER_GUEST*guests));
        System.out.printf("Is the event large or not: %b", large);


    }

    public static void main(String[] args) {
        PartyGuests go = new PartyGuests();
        go.Calculate();
    }

}
