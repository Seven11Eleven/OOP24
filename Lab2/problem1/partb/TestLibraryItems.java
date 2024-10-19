package oop24.Lab2.problem1.partb;

public class TestLibraryItems {

    public static void main(String[] args){
        Book book = new Book("Clean Architecture", "Robert Marting", 2018, BookBinding.PAPERBACK);
        System.out.println(book.toString());

        book.reissueWithNewBinding(BookBinding.SPIRAL);
        System.out.println("после перевыпуска: " + book.toString() );
    }
}
