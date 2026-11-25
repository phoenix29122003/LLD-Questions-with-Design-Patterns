package LibraryLLD;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    public Map<Book,Integer>bookInventory;
    public Map<String,Member>members;
    public Map<String,Book>books;
    public Map<String,Loan>loans;

    public Library(){
        this.books=new HashMap<>();
        this.members=new HashMap<>();
        this.bookInventory=new HashMap<>();
        this.loans=new HashMap<>();
    }

    public Book registerBook(String title, String author, Integer count){
        Book book=new Book(title, author);
        this.books.put(book.id, book);
        this.bookInventory.put(book, count);
        System.out.println(book.title + " written by author: "+book.author + " is registered with number of copies: "+count);
        return book;
    }

    public Member registerMember(String name){
        Member member=new Member(name);
        members.put(member.id, member);
        System.out.println("Member: "+member.name + " is registered in library.");
        return member;
    }

    public Loan boorowBook(String memberId, String bookId, LocalDate borrowDate, LocalDate dueDate){
        Book book=books.get(bookId);
        if(bookInventory.get(book)>0){
            Loan loan=new Loan(bookId, memberId, borrowDate, dueDate);
            loans.put(loan.id, loan);
            bookInventory.put(book, bookInventory.get(book)-1);
            System.out.println(book.title + " is borrowed by "+ members.get(memberId).name);
            return loan;
        }
        else{
            System.out.println("Book is unavailable.");
            return null;
        }
    }

    public void returnBook(String loanId){
        Loan loan=loans.get(loanId);
        String bookId=loan.bookId;
        String memberId=loan.memberId;
        Member member=members.get(memberId);
        Book book=books.get(bookId);

        if(loan.returnDate!=null){
            System.out.println("Book is already returned.");
            return;
        }

        loan.returnDate=LocalDate.now();
        bookInventory.put(book, bookInventory.get(book)+1);
        System.out.println("Book: "+book.title+ " is returned by: "+ member.name);
    }

    public void viewBorrowedBooks(String memberId){
        for(Loan loan:loans.values()){
            if(loan.memberId.equals(memberId) && loan.returnDate==null){
                System.out.println("Book: "+books.get(loan.bookId).title+ " Due Date: "+ loan.dueDate);
            }
        }
    }

    public void showHistory(String memberId){
        for(Loan loan:loans.values()){
            if(loan.memberId.equals(memberId)){
                if(loan.returnDate==null){
                    System.out.println("Book: "+books.get(loan.bookId).title+ " Due Date: "+ loan.dueDate);
                }
                else{
                    System.out.println("Book: "+books.get(loan.bookId).title+ " Due Date: "+ loan.dueDate + " Return Date: "+loan.returnDate);
                }
            }
        }
    }
}
