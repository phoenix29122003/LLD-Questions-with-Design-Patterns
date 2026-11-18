public class Main {
    public static void main(String args[]){
        Coffee latte=new Latte();
        Coffee latteWithMilk=new MilkDecorator(latte);
        Coffee latteWithMilkAndSugar=new SugarDecorator(latteWithMilk);

        System.out.println(latteWithMilkAndSugar.getCost());
        System.out.println(latteWithMilkAndSugar.getDescription());
    }
}
