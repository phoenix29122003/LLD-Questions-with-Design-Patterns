public class Latte implements Coffee{
    @Override 
    public String getDescription(){
        return "Latte";
    }

    @Override 
    public Integer getCost(){
        return 130;
    }
}
