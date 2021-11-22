import java.util.Arrays;

public class BingoCard {
    /*
      The two arrays are private and their structure is NEVER exposed to another
      class, which is why the getCardNumbers returns a String that needs
      further processing.

      While this is not computationally efficient, it is good programming
      practice to hide data structures (information hiding).
     */
    private int[][] numbers;
    private boolean[][] markedOff;

    private int numberOfRows;
    private int numberOfColumns;

    public BingoCard(int numberOfRows, int numberOfColumns) {
        setNumberOfRows(numberOfRows);
        setNumberOfColumns(numberOfColumns);

        numbers = new int[numberOfRows][numberOfColumns];
        markedOff = new boolean[numberOfRows][numberOfColumns];
        resetMarked();
    }

    public void resetMarked() {
    /* TODO
          Reset the data structure to be entirely false. Java defaults booleans
          to false so you can make use of that.
     */
        markedOff = new boolean[numberOfRows][numberOfColumns];
    }

    /* TODO
          implement the getters and setters for rows / columns as seen below
    */
    public int getNumberOfRows() {
    /* TODO
          change the return from 0 to the appropriate return
     */
        return this.numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
    /* TODO
          change the return from 0 to the appropriate return
     */
        return this.numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
    /* TODO
          implement code here
     */
        this.numberOfColumns = numberOfColumns;
    }

    public String getCardNumbers() {
    /* TODO
      flatten the numbers array into a single string with each number separated by the currently required separator
      but no leading or trailing copies of that separator.
      For example if the separator were currently a single space,
      then no extra spaces before the first number nor after the last number.
   */
        StringBuilder sb = new StringBuilder();
    /* TODO
          all the cards are stored as a grid ([][] numbers) of rows / columns, so for example, numbers 3 4 5 6 will be
          printed as follows:
          3  4
          5  6
     */
        for (int i = 0; i < numbers.length; ++i) {
            for (int x = 0; x < numbers[i].length; ++x) {
                if (i == numbers.length - 1 && x == numbers[i].length - 1)
                    sb.append(numbers[i][x]);
                else
                    sb.append(numbers[i][x]).append(Defaults.getNumberSeparator());
            }
        }
    /* TODO
          return the grid as a string
     */
        return sb.toString();
    }

    public void setCardNumbers(String[] numbersAsStrings) {
    /* TODO
          the array of strings [] numbersAsStrings is cast to an integer as [] numbersList, for you
          set the grid from this list
     */
        int[] numbersList =
                Arrays.stream(numbersAsStrings).mapToInt(Integer::parseInt).toArray();
        int index = 0;

    /* TODO
          the goal of this method is to get the numbers entered into the [][] numbers format
     */
        for (int i = 0; i < numbers.length; ++i) {
            for (int x = 0; x < numbers[i].length; ++x) {
                numbers[i][x] = numbersList[index];
                ++index;
            }
        }

    }

    public void markNumber(int number) {
    /* TODO
          make use of the [][] markedOff to mark off numbers from [][] numbers as they match
          if not matching an appropriate message must be printed, verify against expected output files
     */
        boolean check = false;

        for (int i = 0; i < getNumberOfRows(); ++i) {
            for (int x = 0; x < getNumberOfColumns(); ++x) {
                if (numbers[i][x] == number) {
                    markedOff[i][x] = true;
                    check = true;
                }
            }
        }
        if (check) {
            System.out.printf("Marked off %d%n", number);
        } else {
            System.out.printf("Number %d not on this card%n", number);
        }
    }

    public boolean isWinner() {
    /* TODO
          check if there is a winner or not
          all elements of [][] markedOff should be marked off to have a winner (full house)
     */
        boolean check = true;
        for (int i = 0; i < this.getNumberOfRows(); ++i) {
            for (int x = 0; x < this.getNumberOfColumns(); ++x) {
                if (!markedOff[i][x]) {
                    check = false;
                    break;
                }
            }
        }
        /*
         * Search each card object is markedOff array for any false values
         * checks for false values, if it finds one check equals false. so if there is no winner return false
         */

        //change return statement accordingly (either true or false)
        return check;
    }
}