public class Card {
    char suit;
    int num;

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        Card myCard = new Card();
        Card yourCard = new Card();
        myCard.setNum(5);
        yourCard.setNum(7);
        myCard.setSuit('s');
        yourCard.setSuit('h');

        System.out.printf("My card is the "+ myCard.getNum()+ " of " + myCard.getSuit());
        System.out.printf("Your card is the "+ yourCard.getNum()+ " of " + yourCard.getSuit());
    }
}
