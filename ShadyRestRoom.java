import java.util.Scanner;
public class ShadyRestRoom {
    public void RoomPrice(){
        int price;
        String type;
        System.out.printf("Which room type would you like? %nType 1 for queen bed%nType 2 for king bed%nType 3 for king bed with pullout couch%n");
        Scanner userChoice = new Scanner(System.in);
        int choice = userChoice.nextInt();
        if(choice==1){
            type="Queen";
            price = 125;
        } else if(choice==2){
            type="King";
            price = 139;
        } else if(choice==3){
            type="King with pullout";
            price = 165;
        } else{
            type="Invalid code";
            price = 0;
        }
        System.out.printf("You chose %s. The price is $%d.", type, price);
    }

    public static void main(String[] args) {
        ShadyRestRoom go = new ShadyRestRoom();
        go.RoomPrice();
    }
}