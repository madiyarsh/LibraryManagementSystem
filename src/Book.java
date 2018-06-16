
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

public class Book {

	private int stock;
	private String author,title,publisher,isbn,llc,year;
	
	public Book() {
		author=null;
		title=null;
		year=null;
		isbn=null;
		publisher=null;
		llc=null;
		stock=0;
	}
	
	public Book( String author, String title,String year,String isbn, String publisher,String llc,int stock) {
                this.author=author;
		this.title=title;
		this.year=year;
		this.isbn=isbn;
		this.publisher=publisher;
		this.llc=llc;
		this.stock=stock;
              
	}

    Book(Type String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
       
	public String getTitle(){
		return title;
	}
        public void setTitle(String title){
                this.title=title;
        }
        
	public String getYear(){
		return year;
	}
        public void setYear(String year){
                this.year=year;
        }
        
	public String getLLC(){
		return llc;
	}
        public void setLLC(String llc){
                this.llc=llc;
        }
        
	public String getISBN(){
		return isbn;
	}
        public void setISBN(String isbn){
                this.isbn=isbn;
        }
        
	public String getAuthor(){
		return author;
	}
        public void setAuthor(String author){
                this.author=author;
        }
        
	public String getPublisher(){
		return publisher;
	}
        public void setPublisher(String publisher){
                this.publisher=publisher;
        }
        
	public int getStock(){
		return stock;
	}
        public void setStock(int stock){
                this.stock=stock;
        }
}
