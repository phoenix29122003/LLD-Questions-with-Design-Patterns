package SplitwiseLLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override 
    public void split(Expense expense,Group group,Map<User,Double>percentage){
        Double amountToBePaid=expense.amount;
        User payingUser=expense.user;
        Map<User,Map<User,Double>>balanceMap=group.balanceMap;
        List<User>usersInSplit=group.users;

        if(percentage.size()!=usersInSplit.size()){
            System.out.println("Enter all users percentage.");
            return;
        }

        Double percentageSum=0.0;
        for(Double percentageValue: percentage.values()){
            percentageSum+=percentageValue;
            if(percentageValue<0){
                System.out.println("Percentage value is negative. Enter valid percentage value.");
                return;
            }
        }

        if(percentageSum!=100){
            System.out.println("Total percentage is not 100%. Enter valid percentage for each user");
            return;
        }
        
        for(User user:usersInSplit){
            if(user!=payingUser){
                balanceMap.computeIfAbsent(payingUser, k-> new HashMap<>())
                .merge(user, amountToBePaid*percentage.get(user)/100, Double::sum);
            }
        }
        
    }
}
