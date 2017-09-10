
package libCat;

import java.util.HashMap;
import java.util.Map;

public class libraryCatalogue {

    Map<String,book> bookCollection = new HashMap<String,book>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;
    
    public libraryCatalogue(Map<String, book> collection){
        this.bookCollection = collection;
    }
    
    public libraryCatalogue(Map<String,book> collection, int lengthOfCheckoutPeriod,
            double initialLateFee, double feePerLateDay){
    this.bookCollection = collection;
    this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
    this.initialLateFee = initialLateFee;
    this.feePerLateDay = feePerLateDay;
    }
    
    //getters
    public int getCurrentDay(){
      return this.currentDay;  
    }
    
    public Map<String,book> getBookCollection(){
        return this.bookCollection;
    }
    
    public book getBook(String bookTitle){
        return this.getBookCollection().get(bookTitle);
    }
    
    public int getLengthOfCheckoutPeriod(){
        return this.lengthOfCheckoutPeriod;
    }
    
    public double getInitialLateFee(){
        return this.initialLateFee;
    }
    
    public double getFeePerLateDay(){
        return this.feePerLateDay;
    }
    
    //setters
    
    public void nextDay(){
        currentDay++;
    }
            
    public void setDay(int day){
        currentDay = day;
    }
    
    //instance methods
    
    public void checkOutBook(String title){
        book book = getBook(title);
        if (book.getIsCheckedOut()){
            bookAlreadyCheckedOut(book);
        }else{
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day "
                    +(getCurrentDay() + getLengthOfCheckoutPeriod())+".");
        }
    }
    
    public void returnBook(String title){
        book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut()+ getLengthOfCheckoutPeriod());
        
        if (daysLate > 0){
            System.out.println("you owe the library $"+ (getInitialLateFee()+daysLate * getFeePerLateDay()+
                " because your book is "+daysLate+ " days overdue."));
        }else{
            System.out.println("book Returned. thank you");
        }
        book.setIsCheckedOut(false, -1);
    }
    
    public void bookAlreadyCheckedOut(book book){
       
            System.out.println("Sorry "+ book.getTitle()+ "is already checked out."+" It should be available on day "
                  +(book.getDayCheckedOut() + getLengthOfCheckoutPeriod())+".");
}
    
    public static void main(String[] args) {
        Map <String, book> bookCollection = new HashMap<String, book>();
        book harry = new book("Harry Potter", 508, 9999999);
        bookCollection.put("Harry Potter", harry);
        libraryCatalogue lib = new libraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
    }
    
}
