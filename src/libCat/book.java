
package libCat;


public class book {
  
    String Title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;  //whether or not it is checked out.
    int dayCheckedOut = -1;
    
    public book(String bookTitle, int bookPageCount, int bookISBN ){
        this.Title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    //Getters
    public String getTitle(){
        return this.Title;
    }
    
    public int getPageCount(){
        return this.pageCount;
    }
    
    public int getISBN(){
        return this.ISBN;
    }
    
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }
    
    //setters
    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
    }
    
    public void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
}
