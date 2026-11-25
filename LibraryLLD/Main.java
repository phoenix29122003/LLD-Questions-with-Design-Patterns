package LibraryLLD;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]){
        Library library=new Library();

        Book harryPotter=library.registerBook("Harry Poter", " J.K. Rowling", 10);
        System.out.println();

        Member manu=library.registerMember("Manu");
        System.out.println();

        LocalDate today=LocalDate.now();
        LocalDate dueDate=today.plusDays(14);
        Loan loan=library.boorowBook(manu.id, harryPotter.id, today, dueDate);
        System.out.println();

        library.returnBook(loan.id);
        System.out.println();

        library.viewBorrowedBooks(manu.id);
        System.out.println();

        library.showHistory(manu.id);

    }
}
