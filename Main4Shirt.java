public class Main {
    public static void main(String[] args) {
        Shirt s = new Shirt(); // new Shirt() calls the constructor method, creating a new shirt object
        s.putOn();

        // Using the default constructor you can set size and colour this way:
        s.setSize('m');
        s.setColour("orange");
        System.out.printf("s: " +s.getColour() + " "+ s.getSize());
        /*
        BUT INSTEAD YOU CAN PASS THE VALUES ON CREATION, IF YOU CREATE YOUR OWN CONSTRUCTOR
         */
        Shirt s2 = new Shirt("purple", 's');
        System.out.printf("s2: " + s2.getColour() + " " + s2.getSize());
    }
}
