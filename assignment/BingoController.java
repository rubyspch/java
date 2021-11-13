import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BingoController {

    private final String[] mainMenuItems = {"Exit",
            "Play bingo",
            "Set number separator",
            "Create a bingo card",
            "List existing cards",
            "Set bingo card size"};

    /* TODO
          complete constants attached to mainMenuItems
     */
    private final String OPTION_EXIT = " 0: ";
    private final String OPTION_PLAY = " 1: ";
    private final String OPTION_SEPARATOR = " 2: ";
    private final String OPTION_CREATE_CARD = " 3: ";
    private final String OPTION_LIST_CARDS = " 4: ";
    private final String OPTION_SIZE = " 5: ";

    private final String[] options = {
            OPTION_EXIT,
            OPTION_PLAY,
            OPTION_SEPARATOR,
            OPTION_CREATE_CARD,
            OPTION_LIST_CARDS,
            OPTION_SIZE };

    /* TODO
          X complete default size of rows / columns as specified in the Defaults class
          X create an arraylist of BingoCard cards
          X include getters and setters for row / column sizes
     */
    private int currentRowSize = Defaults.DEFAULT_NUMBER_OF_ROWS;
    private int currentColumnSize = Defaults.DEFAULT_NUMBER_OF_COLUMNS;

    /* TODO
          X create an ArrayList of BingoCard cards
     */
    ArrayList<BingoCard> currentCards = new ArrayList<BingoCard>();
   //implement code here

    /* TODO
          X implement getters and setters for currentRowSize / currentColumnSize
     */
    public int getCurrentRowSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return this.currentRowSize;
    }

    public void setCurrentRowSize(int currentRowSize) {
       /* TODO
             implement code here
     */
        this.currentRowSize = currentRowSize;
    }

    public int getCurrentColumnSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return this.currentColumnSize;
    }

    public void setCurrentColumnSize(int currentColumnSize) {
        /* TODO implement code here*/
        this.currentColumnSize = currentColumnSize;
    }

    /* TODO
          add a new BingoCard card
     */
    public void addNewCard(BingoCard card) {
        //implement code here
        currentCards.add(card);
    }

    /* TODO
          include an appropriate message to the the number of rows as well as the number of columns
     */
    public void setSize() {
        setCurrentRowSize(parseInt(Toolkit.getInputForMessage(
                "Enter the number of rows for the card")));
        setCurrentColumnSize(parseInt(Toolkit.getInputForMessage(
                "Enter the number of columns for the card")));
        System.out.printf("The bingo card size is set to %d rows X %d columns%n",
                getCurrentRowSize(),
                getCurrentColumnSize());
    }

    /* TODO
           ensure that the correct amount of numbers are entered
           print a message that shows the numbers entered using Toolkit.printArray(numbers)
           create, setCardNumbers and add the card as a BingoCard
     */
    public void createCard() {
        /* TODO
              calculate how many numbers are required to be entered based on the number or rows / columns
         */
        int numbersRequired = currentRowSize * currentColumnSize;

        String[] numbers;

        boolean correctAmountOfNumbersEntered = false;
        /* TODO
              verify whether the numbers entered is not correct by printing an appropriate message
              verify against the expected output files
         */
        do {
            numbers = Toolkit.getInputForMessage(
                            String.format(
                                    "Enter %d numbers for your card (separated by " +
                                            "'%s')",
                                    numbersRequired,
                                    Defaults.getNumberSeparator()))
                    .trim()
                    .split(Defaults.getNumberSeparator());
            /* TODO
              verify if the correctAmountOfNumbersEntered is true or false dependant on the numbersRequired calculation
            */

            if (numbers.length!=numbersRequired){
                System.out.printf("Try again: you entered %d numbers instead of %d%n", numbers.length, numbersRequired);
            } else {
                correctAmountOfNumbersEntered = true; //changes according to calculation inserted here
            }

            //insert code here
        } while (!correctAmountOfNumbersEntered);

        /* TODO
              print an appropriate message using ToolKit.printArray() to show the numbers entered
         */

        System.out.println(Toolkit.printArray(numbers)); //insert code here

        /* TODO
              create new BingoCard
         */
        BingoCard card = new BingoCard(currentRowSize, currentColumnSize);
       //insert code here
        /* TODO
              setCardNumbers for the new card
         */
        card.setCardNumbers(numbers);
        //insert code here
        /* TODO
              add the card to the ArrayList
         */
        addNewCard(card); //is this right use of addNewCard??
        //insert code here
    }

    /* TODO
         this method goes with printCardAsGrid() seen below
         when option 4 is chosen to list existing cards it prints each card accordingly
         for example, it should show the following
         Card 0 numbers:
         1  2
         3  4 (check with expected output files)
    */

    public void listCards() {
        /* TODO
              insert code here to find all cards to be printed accordingly
         */
        for(BingoCard card : currentCards){
            System.out.printf("Card %2d numbers:%n", currentCards.indexOf(card));
            printCardAsGrid(card.getCardNumbers());
        }
        /* TODO
              call printCardAsGrid() method here, Hint: use getCardNumbers() when getting cards
         */
        /*
         * for each bingo card in the array print the getCardNumbers() returned string
         */
        }

    /* TODO
          this is for option 4, list existing cards where all the cards are printed as a grid
          of rows / columns, so numbers 3 4 5 6 will be printed as follows:
          3  4
          5  6
          it is a follow on method from listCards() and ensures that the grid structure is printed
     */
    public void printCardAsGrid(String numbers) {
        //insert code here to print numbers as a grid
        System.out.printf(numbers);
    }

    /* TODO
          use Toolkit.getInputForMessage to enter a new separator
          print a message what the new separator is
     */

    public void setSeparator() {
        String sep = Toolkit.getInputForMessage("Enter the new separator");
        Defaults.setNumberSeparator(sep);
        System.out.printf("Separator is '%s'%n", Defaults.getNumberSeparator());
        /* TODO
              make use of setNumberSeparator() and getNumberSeparator()
         */
    }

    /* TODO
         reset all BingoCards using resetMarked (to false)
     */
    public void resetAllCards() {
        //insert code here
        //For each Card object, run obj.resetMarked()
        for(BingoCard card : currentCards)
            card.resetMarked();
    }

    /* TODO
          mark off a number that was called when it equals one of the numbers on the BingoCard
     */
    public void markNumbers(int number) {
        //insert code here

        for(BingoCard card : currentCards){
            System.out.printf("Checking card %d for %d%n", currentCards.indexOf(card), number);
            card.markNumber(number);
        }

        /*
        For each Card obj
            print "Checking card X for number Y"
            in bingo card loop the rows and columns looking for number
                if found, stop loop and store the row and column
                mark row and column in obj.markedOff as true
                if found "Marked off Y (obj num)"
                if nor found "number X is not found on this card"
         */
    }

   /* TODO
         make use of isWinner() to determine who the winner is
         the method should return the index of who the winner is
    */
    public int getWinnerId() {
        //insert code here
        int check = -1;
        for(BingoCard card : currentCards){
            if(card.isWinner())
                if (currentCards.indexOf(card)>check)
                    check = currentCards.indexOf(card); //if there are 2 winners, the smaller index wins
        }
        /*
         * for each obj call isWinner();
         * if false is returned, return -1, if true is returned, return the index of the winner in the array of objects
         */
        return check;
    }

    /* TODO
          please take note that the game will not end until there is a winning sequence
     */
    public void play() {
        System.out.println("Eyes down, look in!");
        resetAllCards();

        boolean weHaveAWinner;
        do {
            markNumbers(parseInt( //search objects for inputted number
                    Toolkit.getInputForMessage("Enter the next number")
                            .trim()));

            int winnerID = getWinnerId(); //checks for winner
            weHaveAWinner = winnerID != Defaults.NO_WINNER;
            if (weHaveAWinner) //this will be true is winnerID does not find false in markedOff?
                System.out.printf("And the winner is card %d%n", winnerID);
        } while (!weHaveAWinner); //stops only when a winner is found
    }

    public String getMenu(String[] menuItems) {
    /* TODO
        change this method so it prints a proper numbered menu
        analyse the correct format from the ExpectedOutput files
        menuText is returned
     */
        StringBuilder menuText = new StringBuilder();

        for(int i = 0; i < menuItems.length;++i){
            menuText.append(options[i]).append(menuItems[i]).append("\n");
        }

        //insert code here
        return menuText.toString();
    }
    /* TODO
          complete the menu using switch to call the appropriate method calls
     */
    public void run() {
        boolean finished = false;
        do {
            switch (Toolkit.getInputForMessage(getMenu(mainMenuItems))) {
                case("0"):{
                    finished= true;
                    break;
                    //toolkit.GOODBYE MESSAGE is printed in BingRunner
                }
                case("1"):{
                    //play the game
                    play();
                    break;
                }
                case("2"):{
                    // edit separator
                    setSeparator();
                    break;
                }
                case("3"):{
                    //create card
                    createCard();
                    break;
                }
                case("4"):{
                    //print existing cards
                    listCards();
                    break;
                }
                case("5"):{
                    //setCardSize
                    setSize();
                    break;
                }
                default:{
                    // error message of some kind?
                    // find in outputs
                }

            }
        } while (!finished);
    }
}