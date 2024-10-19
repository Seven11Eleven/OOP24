package oop24.Lab2.problem1.partb;

public abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear){
        this.title  = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString(){
        return "Title: " + title + "\n" + "Author: " + author + "\n" + "Publication YEar: " + publicationYear + "\n" + "Item Type: " + getItemType() + "\n";
    }

    public abstract String getItemType();
}
