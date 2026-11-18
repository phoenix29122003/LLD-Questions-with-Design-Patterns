public class Espresso implements Coffee{
    @Override 
    public String getDescription(){
        return "Espresso";
    }

    @Override 
    public Integer getCost(){
        return 100;
    }
}
