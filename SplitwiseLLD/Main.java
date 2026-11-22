package SplitwiseLLD;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]){
        Splitwise splitwise=new Splitwise();

        Group group = splitwise.createGroup("Group1");
        System.out.println();

        User manu=splitwise.createUser("Manu");
        User tanu=splitwise.createUser("Tanu");
        User janu=splitwise.createUser("Janu");
        System.out.println();

        splitwise.addUserToGroup(group, janu);
        splitwise.addUserToGroup(group, manu);
        splitwise.addUserToGroup(group, tanu);
        System.out.println();

        Expense expense=splitwise.createExpense(manu, 100.00, group.id);
        System.out.println();

        // splitwise.splitExpense(expense,group,SplitType.EQUAL);
        // splitwise.showBalance(group);
        // System.out.println();

        // splitwise.payMoney(manu, tanu, 12.00, group);
        // splitwise.showBalance(group);
        // System.out.println();


        // Map<User, Integer> splitPercentage = new HashMap<>();
        // splitPercentage.put(manu, 50);
        // splitPercentage.put(tanu, 20);
        // splitPercentage.put(janu, 30);
        // splitwise.splitExpenseByPercentage(expense, group, SplitType.PERCENTAGE,splitPercentage);
        // splitwise.showBalance(group);

        Map<User, Double> splitValue = new HashMap<>();
        splitValue.put(manu, 50.0);
        splitValue.put(tanu, 20.0);
        splitValue.put(janu, 30.0);
        splitwise.splitExpenseByExactSplit(expense, group, SplitType.EXACT,splitValue);
        splitwise.showBalance(group);



    }
}
