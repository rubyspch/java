public class Example3 {
    public static void main(String[] args) {
        try {
            int[] a = {1};
            System.out.printf(a[2] + "");
        } catch(NullPointerException e){
            System.out.printf("Your array is null");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.printf("Your index is out of bounds");
        } catch(Exception e){
            System.out.printf("Something else went wrong");
        }
    }
}
