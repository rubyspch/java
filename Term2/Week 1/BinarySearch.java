import java.util.Random;

public class BinarySearch {
    //binarysearch2 with assertions added!
    static int binarySearch2(int [] a, int x){

        //precondition
        assert(isSorted(a));

        //get initial values of l and r
        int l =0;
        int r= a.length-1;

        //assert whether invariant holds (that x is bw l and r)
        assert (BSInvariant(a,x,l,r));

        while(l<=r){
        //assert that invariant holds before each iteration
            assert (BSInvariant(a,x,l,r));

            int m = (l+r)/2;

            if(a[m] < x) //If array at midpoint is lower than x
                l= m+1; // then make new start point 1 after midpoint
            else {
                if (a[m] > x) //if array at midpoint is higher than x
                    r = m - 1; // then make new end point 1 before midpoint
                else {
                    assert (BSPostCondition(a, x, m));
                    return m; // otherwise, return the midpoint bc it is x
                }
            }
            //check invariant holds again after loop bc values are updated within
            assert (BSInvariant(a,x,l,r));
        }
        assert(l>r); //tests the variant
        assert (BSInvariant(a,x,l,r));

        assert(BSPostCondition(a,x,l)); //assert that postcodition is valid for insertion at l
        return l; // return l, the current starting point
    }

    public static void main(String[] args) {
//        BinarySearch go = new BinarySearch();
        int[] a = {2, 5, 6, 9, 12, 40, 50, 100, 230, 432, 564};
//        System.out.println("Will first binary search with the array ");
//
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " (" + i + "), "); //prints array values and there positions
//
//        System.out.println("\n");
//
//        System.out.println(presenceMessage(a, 1));
//        System.out.println(presenceMessage(a, 2));
//        System.out.println(presenceMessage(a, 3));
//        System.out.println(presenceMessage(a, 12));
//        System.out.println(presenceMessage(a, 14));
//        System.out.println(presenceMessage(a, 40));
//        System.out.println(presenceMessage(a, 41));
//        System.out.println(presenceMessage(a, 564));
//        System.out.println(presenceMessage(a, 565));

        //^ this tests shows us the program works, because it is giving
        // us the correct answer with these 9 examples.
        // but to be more thorough we create a random generator

        System.out.println("\nMore systematic testing follows:");

        int bigNumber = 10 * 1000;

        System.out.println("Creating a sorted array with " + bigNumber + " elements...");
        //create array of bigNumber positions:
        int[] b = new int[bigNumber];

        Random r = new Random();
        int n = 0;

        // Should be chosen to be relatively small to avoid overflow (above int range):
        int step = 10;

        // In case there is overflow if bigNumber is too big:
        assert (bigNumber * step > 0 && bigNumber * step > bigNumber);
        //^ checks bigNum is above 0 and multiplied by step it is still bigger,
        //meaning it doesn't blow above int range.
        //assert means there will be an error if it fails, so we don't
        //run the array.

        for (int i = 0; i < b.length; i++) { //picks num bw 0 and the step, so 0 and 9.
            n = n + r.nextInt(step); //add random num to n

            // In case there is overflow if bigNumber is too big.
            assert (n >= 0); //check again in case of overflow

            b[i] = n; // make n the next value (bc n keeps increasing, the array will be created as sorted(precondition requirement!))
        }

        int numberOfTrials = 10 * 1000;

        System.out.println("Done.\n");
        System.out.println("Will now run binary search "
                + numberOfTrials
                + " times with the above array and random items.");

        int count = 0;

        for (int t = 0; t < numberOfTrials; t++) {
            int x = r.nextInt(bigNumber); //
            int i = binarySearch2(b, x);

            if (0 <= i && i < a.length && b[i] == x) {
                count++; //counts the times the random num is in the array
            }
        }

        System.out.println("Done.\n");
        System.out.println(count
                + " random numbers were found in the array out of "
                + numberOfTrials);
    }

    static String presenceMessage(int[] a, int x) {

        int i = binarySearch2(a, x);

        if (0 <= i && i < a.length && a[i] == x)
            return ("The element " + x + " is present at position " + i);
        else if (i == -1)
            return ("The element " + x + " is absent"); //this won't be used in binarySearch2
        else
            return ("The element " + x + " has to be inserted at position " + i);
    }
    //THIS HAS TESTED IT A FINITE NUM OF TIMES RANDOMLY
    //EVEN IF WE'RE SURE IT WORKS, WE WANT TO BE SURE WHY IT WORKS
    //BY DECORATING THE PROGRAM, ADDING ASSERTIONS FOR PRE,POST AND INVAR CONDITIONS

    //checks whether x is in array
    static boolean isIn(int[] a, int x) {
        for (int y : a)
            if (y == x)
                return true;

        return false;
    } //boolean answer, true if x in a, false if not.
    //2 check whether array is sorted
    static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) //go through array
            if (a[i] > a[i + 1]) //check each position is smaller than the next
                return false; //if not, return false
        return true; //if loop goes through well and that condition is never met
                    // that means the array is sorted
    }
// Logical implication USED FOR INVARIANT CHECK

    static boolean implies(boolean a, boolean b) {
        return (!a || b);
        // this works bc we need b to be true, if a is true
    }

    // Condition maintained by the body of the while loop:

    static boolean BSInvariant(int[] a, int x, int l, int r) {
        // 0 <= l && r <= a.length-1; THIS IS OUR WHILE LOOP CONDITION

        boolean b = 0 <= l && r <= a.length - 1;

        // And if any position i of the array a has x in it,
        // then l <= i <= r.

        //check that if array has x in it, then i must be w/i range b
        for (int i = 0; i < a.length; i++)
            b = b && implies(a[i] == x, l <= i && i <= r);

        return b;
    }
    //post condition for this version of binary search
    static boolean BSPostCondition(int[] a, int x, int i) {
        return //should be true if x is not in a but i showswhere it should go OR
                // x is in a at position i
                (!isIn(a, x) && a[i-1]<x && a[i+1]>x)
                        || (a[i] == x);
    }
}
