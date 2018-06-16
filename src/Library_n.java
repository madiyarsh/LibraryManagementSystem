
import java.awt.Font;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
        
public class Library_n extends javax.swing.JFrame {
    
    Login account = new Login();
    ExcelReader reader = new ExcelReader();
    ExcelWriter writer = new ExcelWriter();
    UserCheck check=new UserCheck();
    Profile user = new Profile();
    static boolean sortedAscendingly = false;
    
    static String currentUser=null;
    
    
    static ArrayList<Profile> Zere = new ArrayList<Profile>();
    static ArrayList<Profile> Madiyar = new ArrayList<Profile>();
    static ArrayList<Profile> Amanzhol = new ArrayList<Profile>();
    
    public void main(String username) throws IOException, FileNotFoundException{
       
	reader.SimpleReader();
        
        currentUser=username;
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library_n().setVisible(true);   
                
            }
        });
    }
  

    
    public Library_n() {
       
        initComponents();
        
        
        if(account.name.equals("zere") || account.name.equals("aman") || account.name.equals("madi")){
            
            jBtnDelete.setVisible(false);
            jBtnAdd.setVisible(false);
            jBtnModify.setVisible(false);
            jBtnHistory.setVisible(false);
            jBtnNewbook.setVisible(false);
                   
        }
        else if(account.name.equals("Aresh")){
            jBtnIssue.setVisible(false);
            jBtnReturn.setVisible(false);
            jBtnTaken.setVisible(false);
        
        }
      
        
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1000,700);
        jBtnAdd.setEnabled(false);
        
        Search(); 
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                writer.SimpleWriter();
                System.exit(0);
                
            }
          });
        jTable1.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = jTable1.columnAtPoint(e.getPoint());
                if (sortedAscendingly) {
                    reader.descendingSort(col);
                    sortedAscendingly = false;
                } else {
                    reader.ascendingSort(col);
                    sortedAscendingly = true;
                }
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Cleaner();
                Search();
            }
        });
          jTxtTitle.addKeyListener(new KeyAdapter() {
           
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        jTxtTitle.transferFocusBackward();
                    } else {
                        jTxtTitle.transferFocus();
                    }
                    e.consume();
                }
            }
        });
          
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jTxtSearch = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTxtAuthor = new javax.swing.JTextField();
        jTxtYear = new javax.swing.JTextField();
        jTxtISBN = new javax.swing.JTextField();
        jTxtPublisher = new javax.swing.JTextField();
        jTxtLLC = new javax.swing.JTextField();
        jTxtStock = new javax.swing.JTextField();
        jTxtTitle = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnDelete = new javax.swing.JButton();
        jBtnModify = new javax.swing.JButton();
        jBtnNewbook = new javax.swing.JButton();
        jBtnIssue = new javax.swing.JButton();
        jBtnTaken = new javax.swing.JButton();
        jBtnReturn = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        jBtnHistory = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author", "Title", "Year", "ISBN", "Publisher", "LLC", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 58, 590, 400));

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 18, -1, -1));
        getContentPane().add(jTxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 18, 184, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Author", "Year", "ISBN", "Publisher", "LLC", "ID", "Stock", "All" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));

        jTxtAuthor.setEditable(false);
        jTxtAuthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtAuthorFocusGained(evt);
            }
        });
        jTxtAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtAuthorMousePressed(evt);
            }
        });
        jTxtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtAuthorKeyPressed(evt);
            }
        });
        getContentPane().add(jTxtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 55, 256, -1));

        jTxtYear.setEditable(false);
        jTxtYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtYearFocusGained(evt);
            }
        });
        jTxtYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtYearMousePressed(evt);
            }
        });
        getContentPane().add(jTxtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 215, 256, -1));

        jTxtISBN.setEditable(false);
        jTxtISBN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtISBNFocusGained(evt);
            }
        });
        jTxtISBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtISBNMousePressed(evt);
            }
        });
        getContentPane().add(jTxtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 265, 256, -1));

        jTxtPublisher.setEditable(false);
        jTxtPublisher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtPublisherFocusGained(evt);
            }
        });
        jTxtPublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtPublisherMousePressed(evt);
            }
        });
        getContentPane().add(jTxtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 315, 256, -1));

        jTxtLLC.setEditable(false);
        jTxtLLC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtLLCFocusGained(evt);
            }
        });
        jTxtLLC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtLLCMousePressed(evt);
            }
        });
        getContentPane().add(jTxtLLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 365, 256, -1));

        jTxtStock.setEditable(false);
        jTxtStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtStockFocusGained(evt);
            }
        });
        jTxtStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtStockMousePressed(evt);
            }
        });
        getContentPane().add(jTxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 415, 256, -1));

        jTxtTitle.setEditable(false);
        jTxtTitle.setColumns(20);
        jTxtTitle.setRows(5);
        jTxtTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtTitleFocusGained(evt);
            }
        });
        jTxtTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTxtTitleMousePressed(evt);
            }
        });
        getContentPane().add(jTxtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 115, 256, 78));

        jLabel1.setText("Author:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jLabel2.setText("Title:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        jLabel3.setText("Year:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, -1, -1));

        jLabel4.setText("ISBN:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        jLabel5.setText("Publisher:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        jLabel6.setText("LLC:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, -1, -1));

        jLabel7.setText("Stock:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        jBtnDelete.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 120, 40));

        jBtnModify.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnModify.setText("Modify Book");
        jBtnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 120, 40));

        jBtnNewbook.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnNewbook.setText("New Book");
        jBtnNewbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewbookActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnNewbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 120, 40));

        jBtnIssue.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnIssue.setText("Issue");
        jBtnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIssueActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 120, 40));

        jBtnTaken.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnTaken.setText("Show the list taken books");
        jBtnTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTakenActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnTaken, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 630, 240, 40));

        jBtnReturn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnReturn.setText("Return");
        jBtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 120, 40));

        jBtnAdd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnAdd.setText("Add Book");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 120, 40));

        jBtnLogout.setText("Log Out");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jBtnHistory.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jBtnHistory.setText("Show the history ");
        jBtnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHistoryActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 240, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon("/Users/madiyarsharipov/NetBeansProjects/JavaApplication1/back2.png")); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, -120, 1370, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //int d=1;
   
    
    public void Search(){
    
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        

        if((String)jComboBox1.getSelectedItem()=="Author"){
        Cleaner();
        for(int i=0; i<reader.library.size();i++){
           
            if(reader.library.get(i).getAuthor().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
        
        
        if((String)jComboBox1.getSelectedItem()=="Title"){
        Cleaner();
         for(int i=0; i<reader.library.size();i++){
            if(reader.library.get(i).getTitle().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
        
        if((String)jComboBox1.getSelectedItem()=="Year"){
        Cleaner();
         for(int i=0; i<reader.library.size();i++){
           
            if(reader.library.get(i).getYear().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
        if((String)jComboBox1.getSelectedItem()=="ISBN"){
        Cleaner();
         for(int i=0; i<reader.library.size();i++){
           
            if(reader.library.get(i).getISBN().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
        
        if((String)jComboBox1.getSelectedItem()=="Publisher"){
        Cleaner();
         for(int i=0; i<reader.library.size();i++){
           
            if(reader.library.get(i).getPublisher().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
        
        if((String)jComboBox1.getSelectedItem()=="LLC"){
        Cleaner();
         for(int i=0; i<reader.library.size();i++){
           
            if(reader.library.get(i).getLLC().toLowerCase().contains(jTxtSearch.getText().toLowerCase())){
                model.addRow(new Object[]{reader.library.get(i).getAuthor(),reader.library.get(i).getTitle(),
                                          reader.library.get(i).getYear(),reader.library.get(i).getISBN(),reader.library.get(i).getPublisher(),
                                          reader.library.get(i).getLLC(),reader.library.get(i).getStock()});
            
            }

        }
        }
       
        if((String)jComboBox1.getSelectedItem()=="All"){
        Cleaner();
        
        ArrayList<Book> searchArray = new ArrayList<Book>();
            searchArray = reader.searchResults(jTxtSearch.getText().toLowerCase());

            for (int i = 0; i < searchArray.size(); i++) {

                model.addRow(new Object[]{searchArray.get(i).getAuthor(), searchArray.get(i).getTitle(),
                    searchArray.get(i).getYear(), searchArray.get(i).getISBN(), searchArray.get(i).getPublisher(),
                    searchArray.get(i).getLLC(), searchArray.get(i).getStock()});
        }
  
    }
}
    public void Cleaner(){
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int rowCount = model.getRowCount();
        
        for (int i = rowCount - 1; i >= 0; i--) {
           
        model.removeRow(i);
        }
    }
    
    public void ToEdit(){
        
        jTxtTitle.setEditable(true);
        jTxtAuthor.setEditable(true);
        jTxtYear.setEditable(true);
        jTxtISBN.setEditable(true);
        jTxtPublisher.setEditable(true);
        jTxtLLC.setEditable(true);
        jTxtStock.setEditable(true);
       
        
        jTxtTitle.setForeground(Color.GRAY);
        jTxtAuthor.setForeground(Color.GRAY);
        jTxtYear.setForeground(Color.GRAY);
        jTxtISBN.setForeground(Color.GRAY);
        jTxtPublisher.setForeground(Color.GRAY);
        jTxtLLC.setForeground(Color.GRAY);
        jTxtStock.setForeground(Color.GRAY);
        
        
        jTxtTitle.setFont(jTxtTitle.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtAuthor.setFont(jTxtAuthor.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtYear.setFont(jTxtYear.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtISBN.setFont(jTxtISBN.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtPublisher.setFont(jTxtPublisher.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtLLC.setFont(jTxtLLC.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        jTxtStock.setFont(jTxtStock.getFont().deriveFont(Font.BOLD | Font.ITALIC));
    }
    public void Edited(){
        jTxtTitle.setEditable(false);
        jTxtAuthor.setEditable(false);
        jTxtYear.setEditable(false);
        jTxtISBN.setEditable(false);
        jTxtPublisher.setEditable(false);
        jTxtLLC.setEditable(false);
        jTxtStock.setEditable(false); 
        
        jTxtTitle.setForeground(Color.black);
        jTxtAuthor.setForeground(Color.black);
        jTxtYear.setForeground(Color.black);
        jTxtISBN.setForeground(Color.black);
        jTxtPublisher.setForeground(Color.black);
        jTxtLLC.setForeground(Color.black);
        jTxtStock.setForeground(Color.black);
        
        jTxtTitle.setFont(jTxtTitle.getFont().deriveFont(Font.PLAIN));
        jTxtAuthor.setFont(jTxtAuthor.getFont().deriveFont(Font.PLAIN));
        jTxtYear.setFont(jTxtYear.getFont().deriveFont(Font.PLAIN));
        jTxtISBN.setFont(jTxtISBN.getFont().deriveFont(Font.PLAIN));
        jTxtPublisher.setFont(jTxtPublisher.getFont().deriveFont(Font.PLAIN));
        jTxtLLC.setFont(jTxtLLC.getFont().deriveFont(Font.PLAIN));
        jTxtStock.setFont(jTxtStock.getFont().deriveFont(Font.PLAIN));
    }
    
    
    
    
    
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        Search();        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        jTxtTitle.setLineWrap(true);
        
        int selectedRowIndex = jTable1.getSelectedRow();
        jTxtAuthor.setText(model.getValueAt(selectedRowIndex,0).toString());
        jTxtTitle.setText(model.getValueAt(selectedRowIndex,1).toString());
        jTxtYear.setText(model.getValueAt(selectedRowIndex,2).toString());
        jTxtISBN.setText(model.getValueAt(selectedRowIndex,3).toString());
        jTxtPublisher.setText(model.getValueAt(selectedRowIndex,4).toString());
        jTxtLLC.setText(model.getValueAt(selectedRowIndex,5).toString());
        jTxtStock.setText(model.getValueAt(selectedRowIndex,6).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        JFrame confirm = new JFrame();
        System.out.println(jTxtAuthor.getText());
        System.out.println(jTxtTitle.getText());
        System.out.println(jTxtYear.getText());
        System.out.println(jTxtISBN.getText());
        System.out.println(jTxtPublisher.getText());
        System.out.println(jTxtLLC.getText());
        System.out.println(Integer.parseInt(jTxtStock.getText()));
       
        
        
        
        
                confirm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                int input = JOptionPane.showConfirmDialog(null, "Are you sure that you want delete this book from the database?","Confirmation" ,JOptionPane.YES_NO_OPTION);
                if(input==1){
                    confirm.dispose();
                } 
                if(input==0){
                    
                    reader.library.remove(reader.indeces.indexOf(jTxtISBN.getText()));
                    reader.indeces.remove(reader.indeces.indexOf(jTxtISBN.getText()));
                    
                            
                    jTxtTitle.setText(null);
                    jTxtAuthor.setText(null);
                    jTxtYear.setText(null);
                    jTxtISBN.setText(null);
                    jTxtPublisher.setText(null);
                    jTxtLLC.setText(null);
                    jTxtStock.setText(null);     
                    Search();
                }
    }//GEN-LAST:event_jBtnDeleteActionPerformed
    int z=0;
    String a=null,b=null,c=null,d=null,e=null,f=null,g=null;
    
       
    private boolean checkISBN(String isbn){
        for(int i=0;i<reader.library.size();i++ ){
            if(!isbn.equals(reader.library.get(i).getISBN())){
            if(isbn.equals(reader.library.get(i).getISBN())){
                return false;
            }
            }
        }
        return true;
    }
    static boolean hey=true;
    
    private void jBtnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModifyActionPerformed
       if(!jTable1.getSelectionModel().isSelectionEmpty()){
       
       if(z==0){
        
        jBtnModify.setBackground(Color.BLACK);
        jBtnModify.setForeground(Color.GRAY);
        jBtnModify.setText("End Modify");
        a=jTxtTitle.getText();
        b=jTxtAuthor.getText();
        c=jTxtYear.getText();
        d=jTxtISBN.getText();
        e=jTxtPublisher.getText();
        f=jTxtLLC.getText();
        g=jTxtStock.getText(); 
        
        ToEdit();
        
        jBtnDelete.setEnabled(false);
        jBtnNewbook.setEnabled(false);
        jTable1.setEnabled(false);
        jBtnAdd.setEnabled(false);
        
       
      
        
       }
       if(z==1){
       
     if(jTxtYear.getText().matches("\\d{4}") && Integer.parseInt(jTxtYear.getText())<2020){
              if((jTxtISBN.getText().matches("^\\d{10}.*") || jTxtISBN.getText().matches("\\d{13}.*" ))&& (checkISBN(jTxtISBN.getText()) )){
                  if(!jTxtTitle.getText().equals("")){
                      if(jTxtStock.getText().matches("^\\d+$")){
        if(z==1){
          
            
          if(!jTxtTitle.getText().equals(a) || !jTxtAuthor.getText().equals(b) ||
               !jTxtYear.getText().equals(c) || !jTxtISBN.getText().equals(d) || !jTxtPublisher.getText().equals(e) || 
               !jTxtLLC.getText().equals(f) || !jTxtStock.getText().equals(g)){ 
          
                JFrame confirm = new JFrame();
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                

                int input = JOptionPane.showConfirmDialog(null, "Are you sure that you want to make changes?","Confirmation" ,JOptionPane.YES_NO_OPTION);
                if(input==1){
                        jTxtTitle.setText(a);
                        jTxtAuthor.setText(b);
                        jTxtYear.setText(c);
                        jTxtISBN.setText(d);
                        jTxtPublisher.setText(e);
                        jTxtLLC.setText(f);
                        jTxtStock.setText(g);
                        confirm.dispose();
                }
                if(input==0){
                    
                    reader.library.set(reader.indeces.indexOf(d),new Book(jTxtAuthor.getText(),jTxtTitle.getText(),jTxtYear.getText(), 
                                       jTxtISBN.getText(),jTxtPublisher.getText(),jTxtLLC.getText(),
                                       Integer.parseInt(jTxtStock.getText())));
                        jBtnDelete.setEnabled(true);
                        jBtnNewbook.setEnabled(true);
                        jTable1.setEnabled(true);
                        confirm.dispose();
                        Search();
                
                }
              
            }
            jBtnModify.setBackground(null);
            jBtnModify.setForeground(null);
            jBtnModify.setText("Modify Book");
            jBtnDelete.setEnabled(true);
            jBtnNewbook.setEnabled(true);
            jBtnAdd.setEnabled(true);
            jTable1.setEnabled(true);
            Edited();
            z=z-2;
            hey=true;
            }
               
                        }
                      else{
                        hey=false;
                      JFrame frame = new JFrame();
                      JOptionPane.showMessageDialog(frame, "invalid stock number ");
                      
                      }
                  }
                  else{
                      hey=false;
                      JFrame frame = new JFrame();
                      JOptionPane.showMessageDialog(frame, "please indicate the title of the book");
                      
                  }
              }
              else{
                  hey=false;
                  JFrame frame = new JFrame();
              JOptionPane.showMessageDialog(frame, "invalid isbn format");
              
              }
              
          }
          else{
                hey=false;
              JFrame frame = new JFrame();
              JOptionPane.showMessageDialog(frame, "invalid year format");
              
          }
       
       }
       if(hey){
         z++;
       }
       }
       else{
           JFrame frame = new JFrame();
           JOptionPane.showMessageDialog(frame, "you should pick a book for modifying");
           hey=true;
       }
    }//GEN-LAST:event_jBtnModifyActionPerformed
static int k =0;
int ButtonPress =0;
    private void jBtnNewbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewbookActionPerformed
        
        if(k==0){
            ButtonPress =1;
            jBtnNewbook.setBackground(Color.BLACK);
            jBtnNewbook.setForeground(Color.GRAY);
            
            jBtnAdd.setEnabled(true);
            jBtnNewbook.setText("Close");
            jBtnDelete.setEnabled(false);
            jBtnModify.setEnabled(false);
            jTable1.setEnabled(false);
            
            jTxtTitle.setText("[Enter Title of the Book]");
            jTxtAuthor.setText("[Enter name of the Author]");
            jTxtYear.setText("[Enter the Year of publiation]");
            jTxtISBN.setText("[Enter ISBN of the book]");
            jTxtPublisher.setText("[Enter the Publisher of the book]");
            jTxtLLC.setText("[Enter LLC of the book]");
            jTxtStock.setText("[Enter the number of books available]");
            
            
            ToEdit();
            
        }
        
        
        if(k==1){
           /* if((jTxtTitle.getText().equals("[Enter Title of the Book]") || jTxtTitle.getText().equals("")) &&
               (jTxtAuthor.getText().equals("[Enter name of the Author]") || jTxtAuthor.getText().equals(""))&&
               (jTxtYear.getText().equals("[Enter the Year of publiation]") || jTxtYear.getText().equals("")) &&
               (jTxtISBN.getText().equals("[Enter ISBN of the book]") || jTxtISBN.getText().equals("")) &&
               (jTxtPublisher.getText().equals("[Enter the Publisher of the book]") || jTxtLLC.getText().equals("")) &&
               (jTxtLLC.getText().equals("[Enter LLC of the book]") || jTxtLLC.getText().equals("")) &&
               (jTxtStock.getText().equals("[Enter the number of books available]") || jTxtStock.getText().equals(""))){
              */
               jTxtTitle.setText("");
               jTxtAuthor.setText("");
               jTxtYear.setText("");
               jTxtISBN.setText("");
               jTxtPublisher.setText("");
               jTxtLLC.setText("");
               jTxtStock.setText("");
                
                Search();
                k=k-2;
                jBtnAdd.setEnabled(false);
                jBtnNewbook.setText("New Book");
                jBtnNewbook.setBackground(null);
                jBtnNewbook.setForeground(null);
                jBtnDelete.setEnabled(true);
                jBtnModify.setEnabled(true);
                jTable1.setEnabled(true);
                ButtonPress =0;
                Edited();
           // }
            
        }
        
        
        k++;
        
    }//GEN-LAST:event_jBtnNewbookActionPerformed

    private void jTxtAuthorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtAuthorMousePressed
       if(ButtonPress==1)
        jTxtAuthor.setText(null);
    }//GEN-LAST:event_jTxtAuthorMousePressed

    private void jTxtTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtTitleMousePressed
      if(ButtonPress==1)
        jTxtTitle.setText(null);
    }//GEN-LAST:event_jTxtTitleMousePressed

    private void jTxtYearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtYearMousePressed
      if(ButtonPress==1)
        jTxtYear.setText(null);
    }//GEN-LAST:event_jTxtYearMousePressed

    private void jTxtISBNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtISBNMousePressed
      if(ButtonPress==1) 
        jTxtISBN.setText(null);
    }//GEN-LAST:event_jTxtISBNMousePressed

    private void jTxtPublisherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtPublisherMousePressed
      if(ButtonPress==1)  
        jTxtPublisher.setText(null);
    }//GEN-LAST:event_jTxtPublisherMousePressed

    private void jTxtLLCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtLLCMousePressed
      if(ButtonPress==1)  
        jTxtLLC.setText(null);
    }//GEN-LAST:event_jTxtLLCMousePressed

    private void jTxtStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtStockMousePressed
      if(ButtonPress==1)  
        jTxtStock.setText(null);
    }//GEN-LAST:event_jTxtStockMousePressed
    
    private void jBtnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIssueActionPerformed
      
        
          
      
        if(!jTxtISBN.getText().equals("")){ 
        if(!jTxtStock.getText().equals("0")){
         try {
           
            
            int i=reader.indeces.indexOf(jTxtISBN.getText());
            
            
            SimpleDateFormat issueDate = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy ");
            Date date = new Date();
            String returnDate="not returned yet...";
            
            Profile thebook= new Profile(currentUser,jTxtISBN.getText(),issueDate.format(date),returnDate);
            
            if(check.SimpleCheck(currentUser, jTxtISBN.getText())){
                
                System.out.println(thebook.getdateIssue());
                reader.library.get(i).setStock(reader.library.get(i).getStock()-1);
                jTxtStock.setText(String.valueOf(reader.library.get(i).getStock()));
                
                Search();
                
                System.out.println(currentUser);
                
                if(currentUser.equals("zere")){
                    Zere.add(thebook);
                    writer.WriteUsers(Zere);
                }
                else if(currentUser.equals("aman")){
                    Amanzhol.add(thebook);
                    writer.WriteUsers(Amanzhol);
                }
                else if(currentUser.equals("madi")){
                    Madiyar.add(thebook);
                    writer.WriteUsers(Madiyar);
                }
                
            }
            else{
                JFrame frame = new JFrame();
               JOptionPane.showMessageDialog(frame, "Sorry, but you have already taken this book");
            
            }
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{
           JFrame frame = new JFrame();
           JOptionPane.showMessageDialog(frame, "Sorry,no book is available in the library");
            
        }
      }
      else{
      JFrame frame = new JFrame();
           JOptionPane.showMessageDialog(frame, "You need to pick a book first");
      }
      
    }//GEN-LAST:event_jBtnIssueActionPerformed
    int readIndex=0;

    private void jBtnTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTakenActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            ArrayList<String> Array = new ArrayList<String>(reader.ReadJournal(currentUser));
            
            if(readIndex==0){
            Cleaner();
            
            
            
            
            
            
        
           
            for(int i=0; i<Array.size();i++){
                
           
                int k = reader.indeces.indexOf(Array.get(i));
                
                model.addRow(new Object[]{reader.library.get(k).getAuthor(),reader.library.get(k).getTitle(),
                                          reader.library.get(k).getYear(),reader.library.get(k).getISBN(),
                                          reader.library.get(k).getPublisher(),
                                          reader.library.get(k).getLLC(),reader.library.get(k).getStock()});
                
            } 
            }
            
                  
                     
                    
            
           
            
            
        } catch (IOException ex) {
            Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBtnTakenActionPerformed

    private void jBtnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReturnActionPerformed
        try {
            if(check.returnCheck(jTxtISBN.getText(),currentUser)){
                if(!jTxtISBN.getText().equals("")){
                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        
                        ArrayList<String> Array = new ArrayList<String>(reader.ReadJournal(currentUser));
                        
                        Array.remove(Array.indexOf(jTxtISBN.getText()));
                        
                        System.out.println("Size2 "+Array.size());
                        Cleaner();
                        for(int i=0; i<Array.size();i++){
                            
                            
                            int k = reader.indeces.indexOf(Array.get(i));
                            
                            model.addRow(new Object[]{reader.library.get(k).getAuthor(),reader.library.get(k).getTitle(),
                                reader.library.get(k).getYear(),reader.library.get(k).getISBN(),
                                reader.library.get(k).getPublisher(),
                                reader.library.get(k).getLLC(),reader.library.get(k).getStock()});
                            
                            
                        }
                        
                        int i=reader.indeces.indexOf(jTxtISBN.getText());
                        reader.library.get(i).setStock(reader.library.get(i).getStock()+1);
                        jTxtStock.setText(String.valueOf(reader.library.get(i).getStock()+1));
                        
                        SimpleDateFormat returnDate = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy ");
                        Date date = new Date();
                        
                        System.out.println("WHY now>1?");
                        System.out.println(jTxtISBN.getText());
                        
                        System.out.println("WHY now>2?");
                        
                        
                        
                        writer.CompleteUsers(returnDate.format(date),currentUser,jTxtISBN.getText());
                        
                        
                        
                        
                        
                        jTxtTitle.setText(null);
                        jTxtAuthor.setText(null);
                        jTxtYear.setText(null);
                        jTxtISBN.setText(null);
                        jTxtPublisher.setText(null);
                        jTxtLLC.setText(null);
                        jTxtStock.setText(null);
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BiffException ex) {
                        Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (WriteException ex) {
                        Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "You need to pick a book first");
                }
            }else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "You didn't issue this book");
            }   } catch (IOException ex) {
            Logger.getLogger(Library_n.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnReturnActionPerformed

    private void jTxtAuthorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAuthorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAuthorKeyPressed

    private void jTxtAuthorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtAuthorFocusGained
        if(ButtonPress==1) {
            jTxtAuthor.setText(null);
        }
    }//GEN-LAST:event_jTxtAuthorFocusGained

    private void jTxtTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtTitleFocusGained
        if(ButtonPress==1) {
            jTxtTitle.setText(null);
        }   
    }//GEN-LAST:event_jTxtTitleFocusGained

    private void jTxtYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtYearFocusGained
        if(ButtonPress==1) {
            jTxtYear.setText(null);
        }
    }//GEN-LAST:event_jTxtYearFocusGained

    private void jTxtISBNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtISBNFocusGained
        if(ButtonPress==1) {
            jTxtISBN.setText(null);
        }
    }//GEN-LAST:event_jTxtISBNFocusGained

    private void jTxtPublisherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtPublisherFocusGained
        if(ButtonPress==1) {
            jTxtPublisher.setText(null);
        }
    }//GEN-LAST:event_jTxtPublisherFocusGained

    private void jTxtLLCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtLLCFocusGained
        if(ButtonPress==1) {
            jTxtLLC.setText(null);
        }
    }//GEN-LAST:event_jTxtLLCFocusGained

    private void jTxtStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtStockFocusGained
        if(ButtonPress==1) {
            jTxtStock.setText(null);
        }
    }//GEN-LAST:event_jTxtStockFocusGained

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        if(k==1){
            if(!jTxtTitle.getText().equals("[Enter Title of the Book]") &&
               !jTxtYear.getText().equals("[Enter the Year of publiation]") &&
               !jTxtISBN.getText().equals("[Enter ISBN of the book]") &&
               !jTxtPublisher.getText().equals("[Enter the Publisher of the book]") &&
               !jTxtLLC.getText().equals("[Enter LLC of the book]") &&
               !jTxtStock.getText().equals("[Enter the number of books available]")){
                    if( jTxtAuthor.getText().equals("[Enter name of the Author]")){
                        jTxtAuthor.setText("");
                    }
                    if( jTxtLLC.getText().equals("[Enter LLC of the book]")){
                        jTxtLLC.setText("");
                    }
                    
                    if(jTxtYear.getText().matches("\\d{4}") && Integer.parseInt(jTxtYear.getText())<2020){
                      if((jTxtISBN.getText().matches("^\\d{10}.*") || jTxtISBN.getText().matches("\\d{13}.*" ))&& checkISBN(jTxtISBN.getText())){
                         if(!jTxtTitle.getText().equals("")){
                            if(jTxtStock.getText().matches("^\\d+$")){
                    
                    
                                reader.library.add(new Book(  jTxtAuthor.getText(),
                                                        jTxtTitle.getText(), 
                                                        jTxtYear.getText(), 
                                                        jTxtISBN.getText(), 
                                                        jTxtLLC.getText(),
                                                        jTxtPublisher.getText(),
                                                        Integer.parseInt(jTxtStock.getText()) ));

                                reader.indeces.add(jTxtISBN.getText());
                                Search();
                            k=k-2;
                            jBtnAdd.setEnabled(false);
                            jBtnNewbook.setText("New Book");
                            jBtnNewbook.setBackground(null);
                            jBtnNewbook.setForeground(null);
                            ButtonPress =0;
                            jBtnDelete.setEnabled(true);
                            jBtnModify.setEnabled(true);
                            jTable1.setEnabled(true);
                            
                            Edited();
                            }
                                
                            else{
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(frame, "invalid stock number ");
                            }
                            }
                        else{
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "please indicate the title of the book");
                        }
                        }
                    else{
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "invalid isbn format");
                    }
                    }
                else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "invalid year format");
            }      
            }
        else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "please fill in all fields");
            }
            
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHistoryActionPerformed
        History.main(null);
    }//GEN-LAST:event_jBtnHistoryActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        
        writer.SimpleWriter();
        reader.library.clear();
        dispose();
        Login.main(null);
        
     
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    
  /*  public static void main(String args[]) throws IOException {
         ExcelReader reader = new ExcelReader();
		reader.SimpleReader();
                
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library_n().setVisible(true);
        
            }
        });    
        
      
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnHistory;
    private javax.swing.JButton jBtnIssue;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JButton jBtnModify;
    private javax.swing.JButton jBtnNewbook;
    private javax.swing.JButton jBtnReturn;
    private javax.swing.JButton jBtnTaken;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtAuthor;
    private javax.swing.JTextField jTxtISBN;
    private javax.swing.JTextField jTxtLLC;
    private javax.swing.JTextField jTxtPublisher;
    private javax.swing.JTextField jTxtSearch;
    private javax.swing.JTextField jTxtStock;
    private javax.swing.JTextArea jTxtTitle;
    private javax.swing.JTextField jTxtYear;
    // End of variables declaration//GEN-END:variables

    private void If(boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
