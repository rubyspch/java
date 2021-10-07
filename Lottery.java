import java.util.*;
public class Lottery {
    public void Play(){
        //double random1 = (Math.random())*10;
        //int randomInt1= (int) random1;
        int random1 = (int) (Math.random()*10);
        int random2 = (int) (Math.random()*10);
        int random3 = (int) (Math.random()*10);
        int winnings=0;
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
            if(random1==first|| random1==second || random1==third){
                if(random2==first|| random2==second || random2==third){
                    if(random3==first|| random3==second || random3==third){
                        winnings=1000;
                    } else{
                        winnings=100;
                    }
                }
            } else if(random2==first|| random2==second || random2==third && random3==first|| random3==second || random3==third){
                winnings=100;
            } else if(random2==first|| random2==second || random2==third && random3==first|| random3==second || random3==third){
            }
        }
    }
    public static void main(String[] args) {
        Lottery go = new Lottery();
        go.Play();
    }
}
