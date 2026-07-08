public class Book {
    String title;
    String author;
    int year;
    boolean isAvailable = true;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }
    void library(){
        System.out.println("Library has this book" + this.title);
    }
    void bookINfo(){
        System.out.println("Name  of the book: " + this.title);
        System.out.println("Book's author: " + this.author);
        System.out.println("Publication year: " + this.year);
        System.out.println("The book is available: " + this.isAvailable);
    }

}
