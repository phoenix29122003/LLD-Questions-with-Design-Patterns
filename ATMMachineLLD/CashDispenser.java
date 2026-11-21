package ATMMachineLLD;

public abstract class CashDispenser {
    public Integer value;
    public Integer count;
    public CashDispenser nextDispenser;
    
    public CashDispenser(Integer value,Integer count){
        this.value=value;
        this.count=count;
        this.nextDispenser=null;
    }

    public void setNext(CashDispenser cashDispenser){
        this.nextDispenser=cashDispenser;
    }

    public void dispenseCash(Integer amount){
        if(amount<=0){
            throw new IllegalArgumentException("Cannot dispense zero or negative amount: "+amount);
        }
        else{
            Integer noteCount=Math.min(amount/value,count);
            System.out.println(noteCount + " is dispensed for note value: "+value);
            count-=noteCount;
            Integer restAmount=amount-value*noteCount;
            if(restAmount>0){
                if(nextDispenser!=null){
                    nextDispenser.dispenseCash(restAmount);
                }
                else{
                    throw new IllegalStateException("Cannot dispense the amount: "+amount);
                }
            }
        }
    }
}
