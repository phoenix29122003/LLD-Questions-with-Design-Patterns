package SplitwiseLLD;

import java.util.UUID;

public class Expense {
    public String id;
    public User user;
    public Double amount;

    public Expense(User user, Double amount){
        this.id=UUID.randomUUID().toString();
        this.user=user;
        this.amount=amount;
    }
}
