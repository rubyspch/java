import java.util.Scanner;
public class BarChart {
    public String calcScore(String name, int score){
        String bar = name + "  ";
        for(int i=0;i<score;i++){
            bar+="*";
        }
        return bar;
    }
    public void makeBarChart(){
        Scanner scan = new Scanner(System.in);

        String art="Art";
        String bob="Bob";
        String cal="Cal";
        String dan="Dan";
        String eli="Eli";
        System.out.printf("Enter points earned by Art >> %n");
        int artScore= scan.nextInt();
        System.out.printf("Enter points earned by Bob >> %n");
        int bobScore= scan.nextInt();
        System.out.printf("Enter points earned by Cal >> %n");
        int calScore= scan.nextInt();
        System.out.printf("Enter points earned by Dan >> %n");
        int danScore= scan.nextInt();
        System.out.printf("Enter points earned by Eli >> %n");
        int eliScore= scan.nextInt();

        String artDisplay= calcScore(art, artScore);
        String bobDisplay= calcScore(bob, bobScore);
        String calDisplay= calcScore(cal, calScore);
        String danDisplay= calcScore(dan, danScore);
        String eliDisplay= calcScore(eli, eliScore);

        System.out.printf("Points for Game%n%n%s%n%s%n%s%n%s%n%s", artDisplay, bobDisplay,calDisplay,danDisplay,eliDisplay);

    }
    public static void main(String[] args) {
        BarChart methods=new BarChart();
        methods.makeBarChart();
    }
}
