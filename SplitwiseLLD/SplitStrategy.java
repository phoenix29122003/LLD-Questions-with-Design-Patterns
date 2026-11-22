package SplitwiseLLD;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    void split(Expense expense,Group group,Map<User,Double> splitValues);
}
