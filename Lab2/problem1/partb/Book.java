package oop24.Lab2.problem1.partb;



public class Book extends LibraryItem {
    private BookBinding binding;

    public Book(String title, String author, int publicationYear, BookBinding binding) {
        super(title, author, publicationYear);
        this.binding = binding;
    }


    public BookBinding getBinding() {
        return binding;
    }

    public void setBinding(BookBinding binding) {
        this.binding = binding;
    }

    public void reissueWithNewBinding(BookBinding newBinding){
        this.binding = newBinding;
        System.out.println("Книга была перевыщупена в новом переплете: " + newBinding);
    }

    @Override
    public String getItemType(){
        return "Book";
    }

    @Override
    public String toString(){
        return super.toString() + "Binding: " + binding;
    }

}
