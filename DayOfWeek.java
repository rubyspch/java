import java.util.Scanner;

public class DayOfWeek {
    enum Day{
        MON,
        TUE,
        WED,
        THURS,
        FRI,
        SAT,
        SUN
    }
    public static void main(String[] args) {
        String userCode = "";
        Scanner scan = new Scanner(System.in);

        System.out.printf("The Days are:%n");
        for(Day day : Day.values()){
            System.out.printf(day + " ");
        }

        Boolean checkIncomplete = false;

        while(!(checkIncomplete)){
            System.out.printf("%nEnter the day code to find our hours >> ");
            userCode = scan.nextLine().toUpperCase();

            for(Day day : Day.values()){
                if (userCode.equals(day.toString()))
                    checkIncomplete = true;
            }

        }

        switch(userCode.toUpperCase()){
            case "SAT":{
                System.out.printf("10 - 6");
                break;
            }
            case "SUN":{
                System.out.printf("11 - 5");
                break;
            }
            default:{
                System.out.printf("9 - 9");
            }
        }

    }
}
