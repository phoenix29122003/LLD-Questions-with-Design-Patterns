public abstract class CoffeeDecorator implements Coffee{
    public Coffee baseCoffee;

    public CoffeeDecorator(Coffee baseCoffee){
        this.baseCoffee=baseCoffee;
    }
}
