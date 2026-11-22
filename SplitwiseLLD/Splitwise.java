package SplitwiseLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    public Map<String,User>userMap;
    public Map<String,Group>groupMap;

    public Splitwise(){
        this.userMap=new HashMap<>();
        this.groupMap=new HashMap<>();
    }

    public Group createGroup(String groupName){
        Group group=new Group(groupName);
        this.groupMap.put(group.id, group);
        System.out.println("Group created with groupname: "+groupName);
        return group;
    }

    public User createUser(String userName){
        User user=new User(userName);
        this.userMap.put(user.id, user);
        System.out.println("User created with userName: "+userName);
        return user;
    }

    public void addUserToGroup(Group group, User user){
        group.addUser(user);
    }

    public Expense createExpense(User user,Double amount, String groupId){
        Expense expense=new Expense(user, amount);
        Group group=groupMap.get(groupId);
        group.addExpense(expense);
        return expense;
    }

    public void splitExpense(Expense expense,Group group,SplitType splitType){
        if(splitType.equals(SplitType.EQUAL)){
            EqualSpitStrategy equalSpitStrategy=new EqualSpitStrategy();
            equalSpitStrategy.split(expense, group, new HashMap<>());
        }
    }

    public void splitExpenseByPercentage(Expense expense,Group group,SplitType splitType, Map<User,Double>splitPercentage){
        if(splitType.equals(SplitType.PERCENTAGE)){
            PercentageSplitStrategy percentageSplitStrategy=new PercentageSplitStrategy();
            percentageSplitStrategy.split(expense, group, splitPercentage);
        }
    }

    public void splitExpenseByExactSplit(Expense expense,Group group,SplitType splitType, Map<User,Double>splitValue){
        if(splitType.equals(SplitType.EXACT)){
            ExactSplitStrategy exactSplitStrategy=new ExactSplitStrategy();
            exactSplitStrategy.split(expense, group, splitValue);
        }
    }

    public void showBalance(Group group){
        group.showBalance();
    }

    public void payMoney(User user1, User user2, Double amount, Group group){
        group.payMoney(user1, user2, amount);
    }
}   
