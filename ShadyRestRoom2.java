import java.util.Scanner;

public class ShadyRestRoom2 {
    public void chooseRoom(){
        int price;
        String type;
        System.out.printf("Which room type would you like? %nType 1 for queen bed%nType 2 for king bed%nType 3 for king bed with pullout couch%n");
        Scanner userChoice = new Scanner(System.in);
        int choice = userChoice.nextInt();
        switch(choice){
            case(1):{
                type="Queen";
                price = 125;
                break;
            }
            case(2):{
                type="King";
                price = 139;
                break;
            }
            case(3):{
                type="King with pullout";
                price = 165;
                break;
            }
            default:{
                type="Invalid code";
                price = 0;
            }
        }
        System.out.printf("You chose %s. The price is $%d.%n", type, price);
        if (choice==1 || choice ==2 || choice==3){
            System.out.printf("Which view would you like?%nType 1 for lake view%nType 2 for park view%n");
            int viewChoice = userChoice.nextInt();
            if(viewChoice==1){
                price= price+15;
                System.out.printf("The new price is £%d.", price);
            }
        }
    }
    public static void main(String[] args) {
        ShadyRestRoom2 go = new ShadyRestRoom2();
        go.chooseRoom();
    }
}
