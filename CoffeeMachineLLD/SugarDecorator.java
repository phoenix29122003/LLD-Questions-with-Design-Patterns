public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee baseCoffee){
        super(baseCoffee);
    }

    @Override 
    public String getDescription(){
        return baseCoffee.getDescription() + " Sugar";
    }

    @Override 
    public Integer getCost(){
        return baseCoffee.getCost()+5;
    }
}
