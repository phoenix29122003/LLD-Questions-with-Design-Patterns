public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee baseCoffee){
        super(baseCoffee);
    }

    @Override 
    public String getDescription(){
        return baseCoffee.getDescription() + " Milk";
    }

    @Override 
    public Integer getCost(){
        return baseCoffee.getCost()+20;
    }
}
