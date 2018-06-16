
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.RichTextString;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;




public class ExcelWriter {
    
    ExcelReader reader = new ExcelReader();
   
    
    public void SimpleWriter() {
        
            HSSFWorkbook wb = new HSSFWorkbook(); 
            
        
            Sheet sheet = (Sheet) wb.createSheet(); 
             
                Cell cell0 = sheet.createRow(0).createCell(0);
                Cell cell1 = sheet.createRow(0).createCell(1); 
                Cell cell2 = sheet.createRow(0).createCell(2); 
                Cell cell3 = sheet.createRow(0).createCell(3);
                Cell cell4 = sheet.createRow(0).createCell(4); 
                Cell cell5 = sheet.createRow(0).createCell(5); 
                Cell cell6 = sheet.createRow(0).createCell(6); 
                Cell cell7 = sheet.createRow(0).createCell(7); 
                
                cell0.setCellValue("#");
                cell1.setCellValue("Author"); 
                cell2.setCellValue("Title"); 
                cell3.setCellValue("Year"); 
                cell4.setCellValue("ISBN"); 
                cell5.setCellValue("Publisher"); 
                cell6.setCellValue("getLLC"); 
                cell7.setCellValue("Stock");
                
            for(int i=0; i<reader.library.size(); i++){
                
                cell0 = sheet.createRow(i+1).createCell(0);
                cell1 = sheet.createRow(i+1).createCell(1); 
                cell2 = sheet.createRow(i+1).createCell(2); 
                cell3 = sheet.createRow(i+1).createCell(3);
                cell4 = sheet.createRow(i+1).createCell(4); 
                cell5 = sheet.createRow(i+1).createCell(5); 
                cell6 = sheet.createRow(i+1).createCell(6); 
                cell7 = sheet.createRow(i+1).createCell(7); 
                
                cell0.setCellValue(i+1);
                cell1.setCellValue(reader.library.get(i).getAuthor()); 
                cell2.setCellValue(reader.library.get(i).getTitle()); 
                cell3.setCellValue(reader.library.get(i).getYear()); 
                cell4.setCellValue(reader.library.get(i).getISBN()); 
                cell5.setCellValue(reader.library.get(i).getPublisher()); 
                cell6.setCellValue(reader.library.get(i).getLLC()); 
                cell7.setCellValue(reader.library.get(i).getStock());
                
         
            } 

            try{ 
            FileOutputStream output1 = new FileOutputStream("lmsdb.xls"); 
            wb.write(output1); 
            output1.close(); 

            }catch(Exception e){ 
            e.printStackTrace(); 
            }

    }
    
    
    public void WriteUsers(ArrayList<Profile> array) throws FileNotFoundException, IOException, BiffException, WriteException{
        
        File file = new File("users.xls");
        
        jxl.Workbook aWorkBook = jxl.Workbook.getWorkbook(new File("users.xls"));
        WritableWorkbook aCopy = jxl.Workbook.createWorkbook(new File("users.xls"), aWorkBook);
        WritableSheet aCopySheet = aCopy.getSheet(0);
        
        
        
        int lastEx=aCopySheet.getRows();;
        int lastAr=array.size()-1;

        System.out.println(array.get(lastAr).getISBN());

                Label anotherWritableCell0 = new Label(0, lastEx, array.get(lastAr).getName()); 
                Label anotherWritableCell2 = new Label(1, lastEx, array.get(lastAr).getdateIssue()); 
                Label anotherWritableCell3 = new Label(2, lastEx, array.get(lastAr).getdateReturn());
                Label anotherWritableCell4 = new Label(3, lastEx, array.get(lastAr).getISBN());
                
                aCopySheet.addCell(anotherWritableCell0); 
                aCopySheet.addCell(anotherWritableCell2); 
                aCopySheet.addCell(anotherWritableCell3); 
                aCopySheet.addCell(anotherWritableCell4); 

                aCopy.write(); 
                aCopy.close();
        

    }
    
     public void CompleteUsers(String date,String name,String isbn) throws IOException, BiffException, WriteException{
        
                FileInputStream fis = new FileInputStream("users.xls");
                
		HSSFWorkbook wb =  new HSSFWorkbook(fis);
               
                int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();

                System.out.println("Rowcount in CoCh "+rowcount);
       
                for(int i=0;i<rowcount;i++){
                    
                        if(name.equals(wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue()) &&
                           isbn.equals(wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue())){
                            
                
                        File file = new File("users.xls");
                        jxl.Workbook aWorkBook = jxl.Workbook.getWorkbook(new File("users.xls"));
                        WritableWorkbook aCopy = jxl.Workbook.createWorkbook(new File("users.xls"), aWorkBook);
                        WritableSheet aCopySheet = aCopy.getSheet(0);

        

                
                        Label anotherWritableCell2 = new Label(2, i, date);
                        aCopySheet.addCell(anotherWritableCell2); 


                        aCopy.write(); 
                        aCopy.close();
                        }
                }
    
    }
    
}
