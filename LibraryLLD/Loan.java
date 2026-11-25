package LibraryLLD;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Loan {
    public String id;
    public String bookId;
    public String memberId;
    public LocalDate borrowDate;
    public LocalDate dueDate;
    public LocalDate returnDate;

    public Loan(String bookId, String memberId, LocalDate borrowDate, LocalDate dueDate){
        this.id=UUID.randomUUID().toString();
        this.bookId=bookId;
        this.memberId=memberId;
        this.borrowDate=borrowDate;
        this.dueDate=dueDate;
        this.returnDate=null;
    }
}
