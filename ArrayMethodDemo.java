public class ArrayMethodDemo {
    public void Display(int[] array){
        System.out.printf("(1) Display All the Integers ");
        for(int val : array)
        System.out.printf(val + " ");
    }
    public void Reverse(int[] array){
        System.out.printf("%n(2) The numbers in reverse order are ");
        for(int i= array.length -1;i>=0;--i)
            System.out.printf(array[i] + " ");
    }
    public void Sum(int[] array){
        int sum = 0;
        for( int val : array)
            sum+=val;
        System.out.printf("%n(3) The sum of all numbers is %d", sum);
    }
    public void Limit(int[] array, int limit){
        System.out.printf("%n(4) ");
        for (int val : array) {
            if (val < limit)
                System.out.printf(val + " ");
        }
        System.out.printf( "are less than the limit %d%n", limit);
    }
    public double Average(int[] array){
        double sum = 0;
        for( int val : array)
            sum+=val;
        double avg = sum/array.length;
        System.out.printf("(5) The average is %.1f%n", avg);
        return avg;
    }
    public void GreaterThan(Double average, int[] array){
        System.out.printf("(6) ");
        for( int val : array){
            if (val>average)
                System.out.printf(val + " ");
        }
        System.out.printf("are greater than the average");
    }

    public static void main(String[] args) {
        ArrayMethodDemo go = new ArrayMethodDemo();
        int[] array = {12, 15, 34, 67, 4, 9, 10, 7, 13, 50};
        go.Display(array);
        go.Reverse(array);
        go.Sum(array);
        go.Limit(array, 12);
        Double average = go.Average(array);
        go.GreaterThan(average, array);
    }
}
