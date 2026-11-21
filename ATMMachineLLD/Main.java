package ATMMachineLLD;

public class Main {
    public static void main(String args[]){
        CashDispenser oneHundred=new OneHundred(10);
        CashDispenser twoHundred=new TwoHundred(10);
        CashDispenser fiveHundred=new FiveHundred(10);

        fiveHundred.setNext(twoHundred);
        twoHundred.setNext(oneHundred);

        fiveHundred.dispenseCash(2900);
    }
}
