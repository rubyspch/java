import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        //map is a set of key/value pairs
        //for this - key is name, value is id
        //The <> diamond holds the types for your pairs

        HashMap<String, Integer> empIds = new HashMap<>();

        //^ here we're telling java we want to map some strings to some ids
        //HashMap is a specific implementation of the Maps interface.

        //Adding a mapping to the map:
        empIds.put("Lewis", 44);
        empIds.put("Lando", 4);
        empIds.put("Carlos", 5);
        System.out.println(empIds);

        //put will also update a value if you rewrite a key
        empIds.put("Carlos", 55);

        //This will print them but in a random order, they're just pairs, not an ordered array
        System.out.println(empIds);

        // Look up a key and see its corresponding value
        System.out.println(empIds.get("Lewis"));

        //Can check if map has a specific key or value, returns boolean
        System.out.println(empIds.containsKey("Toto"));
        System.out.println(empIds.containsValue(96));

        //replace can be used to update current k,v pairs
        // but is diff to put bc it won't do anything
        // if the key doesn't already exist
        empIds.replace("Karlos", 55);

        // This will only add specified k,v pair if
        //the key doesn't already exist
        empIds.putIfAbsent("George", 63);
        System.out.println(empIds);

        //remove
        empIds.remove("George");
        System.out.println(empIds);

    }
}
