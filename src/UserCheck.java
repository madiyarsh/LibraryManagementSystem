import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class UserCheck {
    
    public boolean SimpleCheck(String name, String isbn)  throws IOException{

		FileInputStream fis = new FileInputStream("users.xls");
                
		HSSFWorkbook wb =  new HSSFWorkbook(fis);
               
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();

       
                for(int i=0;i<rowcount;i++){
                    System.out.println(i);
                        if(name.equals(wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue()) &&
                           isbn.equals(wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue()) &&
                           wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue().equals("not returned yet...")){
                            return false;
                        }
			
                   
                    }
                return true;
		}
    
    
     public boolean returnCheck(String isbn, String name)  throws IOException{

		FileInputStream fis = new FileInputStream("users.xls");
                
		HSSFWorkbook wb =  new HSSFWorkbook(fis);
               
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();

       
                for(int i=0;i<rowcount;i++){
                    System.out.println(i);
                        if(name.equals(wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue()) &&
                           isbn.equals(wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue()) ){
                           
                            return true;
                        }
			
                   
                    }
                return false;
		}
    
    public int CompleteCheck(String name, String isbn) throws FileNotFoundException, IOException{
        
    FileInputStream fis = new FileInputStream("users.xls");
                
		HSSFWorkbook wb =  new HSSFWorkbook(fis);
               
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();

                System.out.println("Rowcount "+rowcount);
       
                for(int i=0;i<rowcount;i++){
                    System.out.println(i);
                        if(name.equals(wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue()) &&
                           isbn.equals(wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue())){
                            return i;
                        }
			
                   
                    }
                return -1;
    
    }
}
