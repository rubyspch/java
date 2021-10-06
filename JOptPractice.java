import javax.swing.JOptionPane;
public class JOptPractice {
    public static void main (String[] args)
    {
        String userEnters= JOptionPane.showInputDialog ("What is your name?");

        System.out.println("You entered " + userEnters + ".");

        String useAge= JOptionPane.showInputDialog("what is your age?");

        int useAgeInt= Integer.parseInt(useAge);
        int birthYear= 2021-useAgeInt;

        JOptionPane.showMessageDialog(null,"You were born in " + birthYear, "Your Birth Year", JOptionPane.INFORMATION_MESSAGE);

    }
}


