import java.util.Scanner;

public class FinallyExample2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try{
            System.out.println(sc.next());
        }catch(Exception e){
            System.out.println(e);
        } finally{ //run important things for the object you're using - eg a close/end method!
            System.out.println("Thanks");
            sc.close();
        }
    }
}
