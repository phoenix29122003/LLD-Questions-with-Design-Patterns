package SplitwiseLLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSpitStrategy implements SplitStrategy{
    @Override 
    public void split(Expense expense,Group group, Map<User,Double> splitValues){
        Double amountPaid=expense.amount;
        User paidByUser=expense.user;
        List<User>usersInSplit=group.users;
        Map<User, Map<User, Double>> balanceMap=group.balanceMap;
        Double equalSplitAmount=amountPaid/usersInSplit.size();

        for(User user:usersInSplit){
            if(user!=paidByUser){
                balanceMap.computeIfAbsent(paidByUser, k-> new HashMap<>())
                .merge(user, equalSplitAmount, Double::sum);
            }
        }
    }
}
