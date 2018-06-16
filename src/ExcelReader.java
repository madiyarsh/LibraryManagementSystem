import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	
	static ArrayList<Book> library = new ArrayList<Book>();
        static ArrayList<String> indeces= new ArrayList<String>();
        
	public void SimpleReader()  throws IOException{

		FileInputStream fis = new FileInputStream("lmsdb.xls");
		Workbook wb = (Workbook) new HSSFWorkbook(fis);
              
               
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();
                
                
                for(int i=1;i<rowcount;i++){
                    
                        
			String author = wb.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
			String title = wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
			String year = wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
			String isbn = wb.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
			String publisher = wb.getSheetAt(0).getRow(i).getCell(5).getStringCellValue();
			String llc = wb.getSheetAt(0).getRow(i).getCell(6).getStringCellValue();
			int stock = (int) wb.getSheetAt(0).getRow(i).getCell(7).getNumericCellValue();

                        year=year.replaceAll("\\D+","");
                        
			Book thebook = new Book(author, title, year, isbn, publisher, llc, stock);
                        
			library.add(thebook);
                        indeces.add(isbn);
                        
                   
                    }
                
		}
    
    public static ArrayList<Book> searchResults(String wordsToFind) {
        ArrayList<Book> searchResults = new ArrayList<>();
        searchResults.clear();
        ArrayList<Book> foundByWords = (ArrayList<Book>) library.clone();
        String[] tokens = wordsToFind.split(" ");
        for (String token : tokens) {
            for (Book book : foundByWords) {
                if (book.getAuthor().toLowerCase().contains(token)) {
                    searchResults.add(book);
                } else {
                    if (book.getTitle().toLowerCase().contains(token)) {
                        searchResults.add(book);
                    } else {
                        if (book.getYear().toLowerCase().contains(token)) {
                            searchResults.add(book);
                        } else {
                            if (book.getISBN().toLowerCase().contains(token)) {
                                searchResults.add(book);
                            } else {
                                if (book.getPublisher().toLowerCase().contains(token)) {
                                    searchResults.add(book);
                                } else {
                                    if (book.getLLC().toLowerCase().contains(token)) {
                                        searchResults.add(book);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            foundByWords = (ArrayList<Book>) searchResults.clone();
            searchResults.clear();
        }
        return foundByWords;
    }

    public static void ascendingSort(int header) {
        if (header == 0) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getAuthor().compareTo(library.get(j + 1).getAuthor()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 1) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getTitle().compareTo(library.get(j + 1).getTitle()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 2) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getYear().compareTo(library.get(j + 1).getYear()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 3) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getISBN().compareTo(library.get(j + 1).getISBN()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 4) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getPublisher().compareTo(library.get(j + 1).getPublisher()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 5) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getLLC().compareTo(library.get(j + 1).getLLC()) > 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 6) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getStock() > library.get(j + 1).getStock()) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
    }
    
    public static void descendingSort(int header){
        if (header == 0) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getAuthor().compareTo(library.get(j + 1).getAuthor()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 1) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getTitle().compareTo(library.get(j + 1).getTitle()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 2) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getYear().compareTo(library.get(j + 1).getYear()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 3) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getISBN().compareTo(library.get(j + 1).getISBN()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 4) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getPublisher().compareTo(library.get(j + 1).getPublisher()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 5) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getLLC().compareTo(library.get(j + 1).getLLC()) < 0) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
        if (header == 6) {
            for (int i = 0; i < library.size() - 1; i++) {
                for (int j = 0; j < library.size() - i - 1; j++) {
                    if (library.get(j).getStock() < library.get(j + 1).getStock()) {
                        Collections.swap(library, j, j + 1);
                    }
                }
            }
        }
    }
    
    void ReadData(String name, String bn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
   
   
    public ArrayList<String> ReadJournal(String user) throws FileNotFoundException, IOException{
        ArrayList<String> User = new ArrayList<String>();
        
        FileInputStream fis = new FileInputStream("users.xls");
        Workbook wb = (Workbook) new HSSFWorkbook(fis);
        
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();
                
                
                for(int i=0;i<rowcount;i++){
                    
                   String name = wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
                   String date = wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
                   String isbn = wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
                   
                   if(name.equals(user) && date.equals("not returned yet...")){
                            User.add(isbn);
                    }
                  
                
                }
                return User;
    }
}
                

        


