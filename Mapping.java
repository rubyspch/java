import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /* TODO
     * create a static LocationMap object
     */
    static LocationMap locationMap = new LocationMap();

    /* TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabMapping = new HashMap<>();

    /* TODO
     * create a FileLogger object
     */
    FileLogger fileLoggerObj = new FileLogger();

    /*
     * TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger consoleLoggerObj = new ConsoleLogger();

//constructor
    public Mapping() {
        //vocabulary.put("QUIT", "Q"); //example
        /* TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        vocabMapping.put("QUIT", "Q");
        vocabMapping.put("SOUTH", "S");
        vocabMapping.put("WEST", "Q");
        vocabMapping.put("SOUTHWEST", "Q");
        vocabMapping.put("SOUTHEAST", "Q");
        vocabMapping.put("NORTH", "Q");
        vocabMapping.put("NORTHEAST", "Q");
        vocabMapping.put("NORTHWEST", "Q");
        vocabMapping.put("UP", "Q");
        vocabMapping.put("DOWN", "Q");
        vocabMapping.put("EAST", "Q");
        //Add all of the possible variations from the output files to a hashmap.
    }

    public void mapping() {

        /* TODO
         * create a Scanner object
         */
        Scanner sc = new Scanner(System.in);

        /*
         * initialise a location variable with the INITIAL_LOCATION
         */
        int location = INITIAL_LOCATION;

        // change this to be while location is not 0?
        while (true) {

            /* TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            //print the "YOU ARE IN/AT..." line to thing

            /* TODO
             * verify if the location is exit
             */
            //check if its 0

            /* TODO
             * get a map of the exits for the location
             */
            //get the exits from Location.exits() (I think from there maybe elsewhere)

            /* TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            //print the "Available exits are" line, possibly using string builder

            /* TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            //get scanner input, nextLine()

            /* TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */
            //check the input has a direction in it, will need to split and trim the input I think - check the expected outputs

            /* TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
            //either change location or do the error process in the outputs
            //look up the integer key in location map, grab the location value, check the available exits
        }
    }

    public static void main(String[] args) {
        /*TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        // Creates Mapping object which has the vocab mapping to check and convert the user's inputs
        Mapping goMap = new Mapping();
        goMap.mapping();
    }

}
