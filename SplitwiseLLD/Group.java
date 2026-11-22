package SplitwiseLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Group {
    public String id;
    public String groupName;
    public List<User> users;
    public List<Expense> expenses;
    public Map<User,Map<User,Double>>balanceMap;

    public Group(String groupName){
        this.id=UUID.randomUUID().toString();
        this.groupName=groupName;
        this.users=new ArrayList<>();
        this.expenses=new ArrayList<>();
        this.balanceMap=new HashMap<>();
    }

    public void addUser(User user){
        this.users.add(user);
        System.out.println(user.name + " is added to group: "+groupName);
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
        System.out.println("Expense paid by user: "+expense.user.name + " of amount: "+expense.amount + " is added to groupName: "+groupName);
    }

    public void showBalance(){
        for(User receiver:balanceMap.keySet()){
            Map<User,Double>deptMap=balanceMap.get(receiver);
            for(User user:deptMap.keySet()){
                Double amount=deptMap.get(user);
                System.out.println(user.name + " owns amount: "+amount + " to user: "+receiver.name);
            }
        }
    }

    public void payMoney(User user1, User user2, Double amount){
        Double deptAmount=balanceMap.get(user1).get(user2);
        if(deptAmount>amount){
            Map<User,Double>deptors=balanceMap.get(user1);
            deptors.merge(user2, -amount, Double::sum);
            System.out.println(user2.name +" had paid amount: "+amount +" to "+ user1.name + " Now "+( deptAmount-amount) +" is left to pay.");
        }
        else if(deptAmount==amount){
            balanceMap.get(user1).remove(user2);
            System.out.println(user2.name + " has paid all depts to "+user1.name);
        }
        else{
            System.out.println("Hey, "+ user2.name +", You are paying more than dept to "+user1.name);
        }
    }
}
