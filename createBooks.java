
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 /*
 * @author: Hector Felix
 * @Date: 2/21/19
 */
public class createBooks {

    public booksArrayList<bookObject> booksList = new booksArrayList<>();
    public booksArrayList<Integer> yearList = new booksArrayList<>();
    public booksArrayList<String> subjectList = new booksArrayList<>();
    public booksArrayList<bookObject> searchBooksList = new booksArrayList<>();
    bookObject b1 = new bookObject();

    private final int MAX_BOOKS = 20;

    public void makeYears() { //generate a set of 20 random years to be used in book object creation
        int temp = b1.randomYear();
        this.yearList.add(temp);
        
        for (int i = 0; i < 19; i++) {
            temp = b1.randomYear();
            
            while (yearList.checkDup(temp)) {
                temp = b1.randomYear();
            }
            
            this.yearList.add(temp);
        }
    }

    public void makeSubjects() { 
        booksArrayList<String> tempList = new booksArrayList<>(); //
//first adding all available subjects to arraylist, then randomly selecting them from list, while at the same time removing them after used
        for (int i = 0; i < 4; i++) {
            tempList.add("Programming");
            tempList.add("Data Structures");
            tempList.add("Algorithms");
            tempList.add("Operating Systems");
            tempList.add("Gaming");
        }

        for (int i = 0; i < MAX_BOOKS; i++) {
            
            int temp = (int) (Math.random() * (tempList.getSize() - 1));
            subjectList.add(tempList.get(temp));
            tempList.remove(temp);
            
        }
    }

    public void menu() { //menu that displays to user and executes command user selects
        int option;
        boolean matchFound=false;
        Scanner s = new Scanner(System.in);
        makeSubjects();
        makeYears();
        makeBooks();

        do {

            System.out.println("\n1) List All the Books\n"
                    + "2) Display the books sorted according to year of publication, starting with the oldest one\n"
                    + "3) Sort the books according to length in pages, starting with the shortest\n"
                    + "4) Sort the books according to review ratings, starting with the highest rating\n"
                    + "5) Ask user for a subject, and display all the books belonging to that specific subject\n"
                    + "6) Search for a specific book by name, and display all the details if the book exists\n"
                    + "7) Add a book to the list of books (ask the user for all the details)\n"
                    + "8) Exit");
            System.out.print("Please Select an Option: ");

            option = s.nextInt();

            switch (option) { //selection sort to sort years, pages, and ratings
                case 1:
                    System.out.println(booksList);
                    break;

                case 2:
                    for (int i = 0; i < booksList.getSize() - 1; i++) {
                        int a = i;
                        for (int j = i + 1; j < booksList.getSize(); j++) {
                            if (booksList.get(a).getYear() > booksList.get(j).getYear()) {
                                a = j;
                            }
                        }

                        bookObject temp = booksList.get(i);
                        booksList.set(i, booksList.get(a));
                        booksList.set(a, temp);
                    }
                    System.out.println(booksList);
                    break;
                case 3:
                    for (int i = 0; i < booksList.getSize() - 1; i++) {
                        int m = i;
                        for (int j = i + 1; j < booksList.getSize(); j++) {
                            if (booksList.get(m).getPages() > booksList.get(j).getPages()) {
                                m = j;
                            }
                        }
                        bookObject temp = booksList.get(i);
                        booksList.set(i, booksList.get(m));
                        booksList.set(m, temp);
                    }

                    break;
                case 4:
                    for (int i = 0; i < booksList.getSize() - 1; i++) {
                        int m = i;
                        for (int j = i + 1; j < booksList.getSize(); j++) {
                            if (booksList.get(m).getRating() < booksList.get(j).getRating()) {
                                m = j;
                            }
                        }
                        bookObject temp = booksList.get(i);
                        booksList.set(i, booksList.get(m));
                        booksList.set(m, temp);
                    }
                    break;
                case 5:
                    matchFound=false;
                    System.out.println("Enter Subject to Search for: ");
                    s.nextLine();
                    String searchSubject = s.nextLine();
                    for (int i = 0; i < booksList.getSize(); i++) {
                        if (booksList.get(i).getSubject().toUpperCase().contains(searchSubject.toUpperCase())) {
                            searchBooksList.add(booksList.get(i));
                            matchFound=true;
                        }
                    }
                    System.out.println(searchBooksList);
                    searchBooksList.clear();
                    if (!matchFound)
                        System.out.println("\nNo Match Found!");
                    break;
                case 6:
                    matchFound=false;
                    System.out.println("Enter Name to Search for: ");
                    s.nextLine();
                    String searchName = s.nextLine();
                    for (int i = 0; i < booksList.getSize(); i++) {
                        if (booksList.get(i).getName().toUpperCase().equals(searchName.toUpperCase())) {
                            System.out.println("Match Found!");
                            System.out.println(booksList.get(i));
                            matchFound=true;    
                        } 
                    }
                    if (!matchFound)
                        System.out.println("\nNo Match Found!");

                    break;
                case 7:
                    System.out.println("Enter Book Name: ");
                    s.nextLine();
                    String addName = s.nextLine();

                    System.out.println("Enter Book Year(1980-2019): ");
                    int addYear = s.nextInt();
                    while (addYear < 1980 || addYear > 2019) {
                        System.out.println("Please Select Year Between 1980 and 2019:");
                        addYear = s.nextInt();
                    }

                    System.out.println("Enter Book Pages(50-1000): ");
                    int addPages = s.nextInt();
                    while (addPages < 50 || addPages > 1000) {
                        System.out.println("Please Select Pages Between 50 and 1000:");
                        addPages = s.nextInt();
                    }

                    System.out.println("Enter Book Rating(1.0-10.0): ");
                    double addRating = s.nextDouble();
                    while (addRating < 1.0 || addRating > 10.0) {
                        System.out.println("Please Select Rating Between 1.0 and 10.0:");
                        addRating = s.nextDouble();
                    }

                    System.out.println("Enter Book Subject: ");
                    s.nextLine();
                    String addSubject = s.nextLine();

                    bookObject bo = new bookObject(addName, addYear, addPages, addRating, addSubject);
                    booksList.add(bo);

                default:
                    break;
            }
        } while (option != 8);
    }

    public void makeBooks() {
        for (int i = 0; i < MAX_BOOKS; i++) {
            bookObject bo = new bookObject("Book" + (i + 1), yearList.get(i), b1.randomPages(), b1.randomRating(), subjectList.get(i));
            booksList.add(bo);
        }
    }
}
