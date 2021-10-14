import java.util.*;
public class Lottery {
    public void Play(){
        //double random1 = (Math.random())*10;
        //int randomInt1= (int) random1;
        int random1 = (int) (Math.random()*10);
        int random2 = (int) (Math.random()*10);
        int random3 = (int) (Math.random()*10);
        int winnings=0;
        int matches=0;
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter first digit%n");
        int first = scan.nextInt();
        System.out.printf("Enter second digit%n");
        int second = scan.nextInt();
        System.out.printf("Enter third digit%n");
        int third = scan.nextInt();
        String userNum= Integer.toString(first) +Integer.toString(second)+ Integer.toString(third);
        String randomNum= Integer.toString(random1) +Integer.toString(random2)+ Integer.toString(random3);
        System.out.printf("You guessed %s %n", userNum);
        System.out.printf("Winning number was %s%n", randomNum);
        if(userNum.equals(randomNum)){
            winnings=1000000;
        } else{
            if(first==random1||first==random2||first==random3){
                matches+=1;
            }
            if(second==random1||second==random2||second==random3){
                matches+=1;
            }
            if(third==random1||third==random2||third==random3){
                matches+=1;
            }
            switch(matches){
                case(1): {
                    winnings = 10;
                    break;
                }
                case(2): {
                    winnings = 100;
                    break;
                }
                case(3): {
                    winnings = 1000;
                    break;
                }
                default:
                    winnings=0;
            }
        }

        System.out.printf("You guessed %d%d%d%n", first, second, third);
        System.out.printf("Winning number was %d%d%d%n", random1,random2, random3);
        System.out.printf("You have won %d%n", winnings);

    }
    public static void main(String[] args) {
        Lottery go = new Lottery();
        go.Play();
    }
}