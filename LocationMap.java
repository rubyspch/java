import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME = "locations.txt";
    private static final String DIRECTIONS_FILE_NAME = "directions.txt";

    /**
     * TODO
     * create a static locations HashMap
     */
    static HashMap<Integer, Location> locationsHashMap = new HashMap<>();

    static {
        /* TODO
         * create a FileLogger object
         */
        FileLogger fileLoggerObj = new FileLogger();

        /* TODO
         * create a ConsoleLogger object
         */

        ConsoleLogger consoleLoggerObj = new ConsoleLogger();


        /* TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put the location and a new Location object in the locations HashMap, using temporary empty hashmaps for exits
         */
        String fileContent;
        String[] splitFileContent; //= new String[3]; says initialisation is redundant?
        int currentLocation;
        int currentDestination;
        String currentDirection;

        try { //what resource does it need? The scanner and the file reader?
            //read each line and extract location int and description
            //store the int and description in a Location object with temporary blank exits
            //print all locations using filelogger and consolelogger to console output

            FileReader readLocFile = new FileReader(LOCATIONS_FILE_NAME);
            Scanner sc = new Scanner(readLocFile);

            consoleLoggerObj.log("Available locations:%n");
            fileLoggerObj.log("Available locations:\n");

            while(sc.hasNextLine()){
                fileContent = sc.nextLine();

                //extract parts
                fileContent = fileContent.replaceFirst(",", ": "); //(this is neater I think? Maybe try it?)


                //print information
                //fileContent = locationNumber + ": " + splitFileContent[1];
                consoleLoggerObj.log(fileContent + "%n");
                fileLoggerObj.log(fileContent + "\n");

                splitFileContent = fileContent.split(": ");
                int locationNumber = Integer.parseInt(splitFileContent[0]);

                //store in Location object and in Locations hashmap
                Location currentLoc = new Location(locationNumber, splitFileContent[1], null);
                locationsHashMap.put(locationNumber,currentLoc);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * add the exits for each location
         */
        //read directions file using try catch
        try { //what resource does it need?
            FileReader readDirFile = new FileReader(DIRECTIONS_FILE_NAME);
            Scanner sc2 = new Scanner(readDirFile);

            //read each line and extract location, direction and destination
            fileLoggerObj.log("Available directions:\n");
            consoleLoggerObj.log("Available directions:%n");

            while(sc2.hasNextLine()) {
                fileContent = sc2.nextLine();
                fileContent = fileContent.replace(",",": ");
                //print all locations,directions and destinations using filelogger and consolelogger
                consoleLoggerObj.log(fileContent + "%n");
                fileLoggerObj.log(fileContent + "\n");
                //store the exits for each in locations using Location.addExits()
                splitFileContent = fileContent.split(": ");
                currentLocation = Integer.parseInt(splitFileContent[0]);
                currentDestination = Integer.parseInt(splitFileContent[2]);
                currentDirection = splitFileContent[1];
                //adds the destination and direction to the exits list. Think this allows you to change the old object using a reference to it.
                if (locationsHashMap.containsKey(currentLocation)){
                    Location currentObject = locationsHashMap.get(currentLocation);
                    currentObject.addExit(currentDirection,currentDestination);
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return locationsHashMap.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return locationsHashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return locationsHashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return locationsHashMap.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return locationsHashMap.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return locationsHashMap.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return locationsHashMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        //TODO
    }

    @Override
    public void clear() {
        //TODO
        // clear the locationsHashMap?
        locationsHashMap.clear();
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return null; //return all the keys?
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return null; //return all the values?
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return null;
    }
}
