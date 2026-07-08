import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bookCount = 0;
        boolean done = true;

        while(done){
            System.out.println("1. Add Book");
            System.out.println("2. Show all Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search book by Title");
            System.out.println("6. Show all borrowed books");
            System.out.println("7. Remove Book");
            System.out.println("8. Show newest book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    if(bookCount == books.length){
                        System.out.println("The book list is full");
                        break;
                    }
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine().toLowerCase();

                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine().toLowerCase();

                    System.out.print("Enter Book Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    if(title == null || author == null || year < 0 || year > 9999){
                        System.out.println("Invalid Input, please write smth");
                    }
                    books[bookCount] = new Book(title,author,year);
                    bookCount++;

                    System.out.println("The book has been added succesfully to the book list");
                    System.out.println("**************-------------****************");
                    break;

                case 2:
                    if(bookCount == 0){
                        System.out.println("The book list is empty");
                    } else{
                        for(int i = 0; i < bookCount; i++){
                            books[i].bookINfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("***********************");
                    System.out.println("Borrow Book");
                    System.out.println("***********************");

                    if(bookCount == 0){
                        System.out.println("The book list is empty");
                    }
                    for(int  i = 0; i < bookCount; i++){
                        System.out.println(i + 1 + " - " + books[i].title + " - " + books[i].author + " - " + books[i].year);
                    }
                    System.out.print("Select number for Borrow Book: ");
                    int borrowBook = scanner.nextInt();
                    scanner.nextLine();
                    int index = borrowBook - 1;

                    if(borrowBook < 1 || borrowBook > bookCount){
                        System.out.println("Invalid Input, please write smth");
                    }
                    if(books[index].isAvailable == false){
                        System.out.println("The book has been borrowed already");
                    }else{
                        books[index].isAvailable = false;
                        System.out.println("You borrowed " +  books[index].title + " from the book list");
                    }
                    break;

                case 4:
                    System.out.println("***********************");
                    System.out.println("Return Book");
                    System.out.println("***********************");

                    if(bookCount == 0){
                        System.out.println("The book list is empty");
                    }
                    for(int  i = 0; i < bookCount; i++){
                        System.out.println(i + 1 + " - " + books[i].title + " - " + books[i].author + " - " + books[i].year);
                    }
                    System.out.print("Return Book: ");
                    int returnBook = scanner.nextInt();
                    scanner.nextLine();
                    int index1 = returnBook - 1;
                    if(returnBook < 1 || returnBook > bookCount){
                        System.out.println("Invalid Input, please write smth");
                    }
                    if(books[index1].isAvailable == true){
                        System.out.println("The book was not borrowed");
                    } else{
                        books[index1].isAvailable = true;
                        System.out.println("You returned " +  books[index1].title + " from the book list");
                    }
                    break;
                case 5:
                    System.out.println("***********************");
                    System.out.println("Search Book by Title");
                    System.out.println("***********************");

                    System.out.println("Enter Book Title: ");
                    String title1 = scanner.nextLine().toLowerCase();
                    boolean found = false;

                    for(int  i = 0; i < bookCount; i++){
                        if(books[i].title.toLowerCase().contains(title1.toLowerCase())){
                            System.out.println("The title you looking for " + books[i].title);
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("The title you looking for does not exist");
                    }
                    break;

                case 6:
                    System.out.println("***********************");
                    System.out.println("Show all borrowed books");
                    System.out.println("***********************");

                    if(bookCount == 0){
                        System.out.println("The book list is empty");
                    }
                    for(int  i = 0; i < bookCount; i++){
                        if(books[i].isAvailable == false){
                            System.out.println(i + 1 + " - " + books[i].title);
                        }
                    }
                    System.out.println("****************************************");
                    break;

                case 7:
                    System.out.println("***************************");
                    System.out.println("Remove Book");
                    System.out.println("***************************");

                    for(int  i = 0; i < bookCount; i++){
                        System.out.println(i + 1 + " - " + books[i].title);
                    }
                    System.out.print("Choose Book to remove: ");
                    int removeBook = scanner.nextInt();
                    int index2 = removeBook - 1;
                    for(int  i = index2; i < bookCount - 1; i++){
                        books[i] = books[i + 1];
                    }
                    books[bookCount - 1] = null;
                    bookCount--;
                    System.out.println("You removed " +  books[index2].title + " successfully from the book list");
                    break;

                case 8:
                    int newestIndex = 0;
                    for(int i = 0; i < bookCount; i++){
                        if(books[i].year > books[newestIndex].year){
                            newestIndex = i;
                        }
                    }
                    System.out.println("Newest Book: " + books[newestIndex].title + " -  " + books[newestIndex].author);
                    break;

                case 9:
                    done =  false;
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        System.out.println("************************");
        System.out.println("Thank you for your work!");
        scanner.close();
    }
}
