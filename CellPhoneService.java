import java.util.Scanner;
public class CellPhoneService {

    public void ChoosePlan(){
        final String PLAN_A = "Plan A $49 per month";
        final String PLAN_B = "Plan B $55 per month";
        final String PLAN_C = "Plan C $61 per month";
        final String PLAN_D = "Plan D $70 per month";
        final String PLAN_E = "Plan E $79 per month";
        final String PLAN_F = "Plan F $87 per month";

        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter talk minutes needed%n");
        int minutes = scan.nextInt();
        System.out.printf("Enter text messages needed%n");
        int texts = scan.nextInt();
        System.out.printf("Enter gigabytes of data needed%n");
        int data = scan.nextInt();
        if(data>0){
            if(data>3){
                System.out.printf("%s",PLAN_F);
            } else{
                System.out.printf("%s",PLAN_E);
            }
        } else{
            if(minutes<500){
                if(texts==0){
                    System.out.printf("%s%n", PLAN_A);
                } else{
                    System.out.printf("%s%n", PLAN_B);
                }
            } else{
                if(texts<100){
                    System.out.printf("%s%n", PLAN_C);
                } else{
                    System.out.printf("%s%n", PLAN_D);
                }
            }
        }

    }
    public static void main(String[] args) {
        CellPhoneService go = new CellPhoneService();
        go.ChoosePlan();
    }
}
