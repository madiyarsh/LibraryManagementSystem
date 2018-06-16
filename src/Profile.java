import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile{
   
    private String name,isbn,dateIssue,dateReturn;
    
    
    public Profile() {
        this.isbn=null;
        this.dateIssue=null;
        this.dateReturn=null;
        this.name=null;
    }
    
    public Profile(String name,String isbn, String dateIssue, String dateReturn) {
        this.name=name;
        this.dateIssue=dateIssue;
        this.dateReturn=dateReturn;
        this.isbn=isbn;
     
    }
   
    public String getISBN(){
	return isbn;
    }
    
    public String getdateIssue(){
        return dateIssue;    
    }
   
    public String getdateReturn(){
        return dateReturn;    
    }
    
    public String getName(){
        return name;
    }
    public void setdateReturn(String date){
        dateReturn=date;
    }
}
