public class IncreasedProduction {
    public void Production(){
        int raiseMonth=0;
        float currentProduction = 4000;
        for(int i=0;i<24;i++){
            currentProduction+= (currentProduction/100)*6;
            System.out.printf("Month %d: Worker produces %f%n", i, currentProduction);
            if(currentProduction>7000){
                if(raiseMonth==0) {
                    raiseMonth = i;
                }
            }
        }
        System.out.printf("The month in which production exceeds 7000.0 is month %d", raiseMonth);
    }
    public static void main(String[] args) {
        IncreasedProduction methods = new IncreasedProduction();
        methods.Production();
    }
}
