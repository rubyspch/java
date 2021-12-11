public class FinallyExample {
    public static void main(String[] args) {
        try{
            int a = 5/1;
        }catch(Exception e){
            System.out.println(e);
        } finally{
            System.out.printf("This is in finally, it always gets run");
        }
    }
}