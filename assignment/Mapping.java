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

    /*TODO
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
        vocabMapping.put("WEST", "W");
        vocabMapping.put("SOUTHWEST", "SW");
        vocabMapping.put("SOUTHEAST", "SE");
        vocabMapping.put("NORTH", "N");
        vocabMapping.put("NORTHEAST", "NE");
        vocabMapping.put("NORTHWEST", "NW");
        vocabMapping.put("UP", "U");
        vocabMapping.put("DOWN", "D");
        vocabMapping.put("EAST", "E");
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

        //Variable Initialisation
        Map<String, Integer> locationExits;
        StringBuilder message;
        String input;
        String[] inputArray;
        boolean acceptedDirection = false;
        Location currentPlace;
        String currentElement;

        while (location != 0) {
            /* TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            currentPlace = locationMap.get(location);
            fileLoggerObj.log(currentPlace.getDescription() + "\n");
            consoleLoggerObj.log(currentPlace.getDescription() + "%n");

            /* TODO
             * verify if the location is exit
             */
            if (currentPlace.getLocationId() != 0) {
                /* TODO
                 * get a map of the exits for the location
                 */
                locationExits = currentPlace.getExits();
                /* TODO
                 * print the available exits (to both console and file)
                 * crosscheck with the ExpectedOutput files
                 * Hint: you can use a StringBuilder to append the exits
                 */
                message = new StringBuilder("Available exits are ");

                for (String i : locationExits.keySet()) {
                    message.append(i).append(", ");
                }
                fileLoggerObj.log(message + "\n");
                consoleLoggerObj.log(message + "%n");

                /* TODO
                 * input a direction
                 * ensure that the input is converted to uppercase
                 */
                input = sc.nextLine().trim().toUpperCase();
                /* TODO
                 * are we dealing with a letter / word for the direction to go to?
                 * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
                 * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
                 * if the input contains multiple words, extract each word
                 * find the direction to go to using the vocabulary mapping
                 * if multiple viable directions are specified in the input, choose the last one
                 */
                /* TODO
                 * if user can go in that direction, then set the location to that direction
                 * otherwise print an error message (to both console and file)
                 * check the ExpectedOutput files
                 */
                inputArray = input.split(" ");
                if (inputArray.length > 1 || inputArray[0].length() > 2 || inputArray[0].equalsIgnoreCase("UP")) {
                    for (String s : inputArray) {
                        currentElement = s;
                        if (vocabMapping.containsKey(currentElement) && locationExits.containsKey(vocabMapping.get(currentElement))) {
                            location = locationExits.get(vocabMapping.get(currentElement));
                            acceptedDirection = true;
                        }
                    }
                } else {
                    currentElement = inputArray[0];
                    if (vocabMapping.containsValue(currentElement) && locationExits.containsKey(currentElement)) {
                        location = locationExits.get(currentElement);
                        acceptedDirection = true;
                    }
                }
                if (!acceptedDirection) {
                    fileLoggerObj.log("You cannot go in that direction\n");
                    consoleLoggerObj.log("You cannot go in that direction%n");
                }
                acceptedDirection = false;
            }

        }
        currentPlace = locationMap.get(0);
        fileLoggerObj.log(currentPlace.getDescription() + "\n");
        consoleLoggerObj.log(currentPlace.getDescription() + "%n");
    }

    public static void main(String[] args) {
        /*TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping goMap = new Mapping();
        goMap.mapping();
    }

}
