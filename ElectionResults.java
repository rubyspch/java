public class ElectionResults {

    public void electionResults(){
        float conservative = 100;
        float labour = 60;
        float green = 15;
        float totalVotes = conservative + labour +green;
        System.out.printf("The Conservative party got %.2f percent of the vote%n The Labour party got %.2f percent of the vote%n The Green party got %.2f percent of the vote%n", ((conservative/totalVotes)*100), ((labour/totalVotes)*100), ((green/totalVotes)*100));

    }

    public static void main(String[] args) {
        ElectionResults go = new ElectionResults();
        go.electionResults();

    }
}
