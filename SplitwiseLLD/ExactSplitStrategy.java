package SplitwiseLLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactSplitStrategy implements SplitStrategy {

    @Override
    public void split(Expense expense, Group group, Map<User, Double> exactSplit) {

        Double amountToBePaid = expense.amount;
        User payingUser = expense.user;

        Map<User, Map<User, Double>> balanceMap = group.balanceMap;
        List<User> usersInSplit = group.users;

        if (exactSplit.size() != usersInSplit.size()) {
            System.out.println("Enter exact split amounts for all users.");
            return;
        }

        double splitSum = 0;

        for (Double split : exactSplit.values()) {
            if (split == null || split < 0) {
                System.out.println("Invalid split amount.");
                return;
            }
            splitSum += split;
        }

        if (Double.compare(splitSum, amountToBePaid) != 0) {
            System.out.println("Total split amount must equal the expense amount.");
            return;
        }

        for (User user : usersInSplit) {
            if (user != payingUser) {
                balanceMap.computeIfAbsent(payingUser, k -> new HashMap<>())
                        .merge(user, exactSplit.get(user), Double::sum);
            }
        }
    }
}