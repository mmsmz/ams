/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams_facerecognition.UI;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JOptionPane;


import ams_facerecognition.DB_Connection;
import ams_facerecognition.Employee;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
 
/**
 *
 * @author A.RA
 */
public class Employee_UI extends javax.swing.JFrame {
     Connection conn;
     ResultSet rs =null; 
     PreparedStatement pst=null; 
    /**
     * Creates new form Students_UI
     */
    public Employee_UI() {
        
          try
            {
                DB_Connection dbObj = new DB_Connection();
                conn = dbObj.getConnection();
            }
            catch (Exception ex)
            {
             
                JOptionPane.showMessageDialog(null, "Can't Open Connection!! " + ex.getMessage());
            }
        initComponents();
        distable();
        showuser_id();
        
    }

    private void showuser_id() { 
       try {
       String sql = "SELECT MAX(emp_id )+1 as emp_id from employee";
       rs = pst.executeQuery(sql);
       while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("emp_id");
        tttt.setText(String.valueOf(id));

      }
      rs.close();
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, e); 
       }
    }
    
    private void distable() { 
      try { 
        String sql ="SELECT  emp_id, name, gender, nicNo, homeAddress, contactNo, emailId, qualification, DATE_FORMAT(join_date, '%y-%m-%d'), department from employee"; 
        pst=conn.prepareStatement(sql); 
        rs=pst.executeQuery();
        jTable1Emp.setModel(DbUtils.resultSetToTableModel(rs)); 
        
        }
        catch (Exception e) { 
        JOptionPane.showMessageDialog(null, e); 
       } 
    }
    
    public void refresh(){
        showuser_id();
        txtempid.setText("");
        jgender.setText("");
        txtnicNo1.setText("");
        txthomeAddress.setText("");
        txtcontactNr.setText("+9");
        txtemailID.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentID = new javax.swing.JLabel();
        txtempid = new javax.swing.JTextField();
        jgender = new javax.swing.JLabel();
        nicno = new javax.swing.JLabel();
        radiobtnMale = new javax.swing.JRadioButton();
        radiobtnFemale = new javax.swing.JRadioButton();
        emailid = new javax.swing.JLabel();
        txtemailID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1Emp = new javax.swing.JTable();
        contactno1 = new javax.swing.JLabel();
        homeaddress = new javax.swing.JLabel();
        btnenroll = new javax.swing.JButton();
        btnupdate1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txthomeAddress = new javax.swing.JEditorPane();
        emailid1 = new javax.swing.JLabel();
        txtqualification = new javax.swing.JTextField();
        datepicker = new javax.swing.JLabel();
        emailid3 = new javax.swing.JLabel();
        txtDataPicker = new com.toedter.calendar.JDateChooser();
        txtDepartment = new javax.swing.JComboBox<>();
        txtnicNo1 = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        emailid2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtcontactNr = new javax.swing.JFormattedTextField();
        tttt = new javax.swing.JTextField();
        enst = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentID.setText("*Employee Name :");
        StudentID.setToolTipText("");
        getContentPane().add(StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 30));

        txtempid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtempid.setForeground(new java.awt.Color(102, 102, 102));
        txtempid.setEnabled(false);
        txtempid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtempidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtempidFocusLost(evt);
            }
        });
        getContentPane().add(txtempid, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 40, 50));

        jgender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jgender.setText("*GENDER :");
        getContentPane().add(jgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 100, 40));

        nicno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nicno.setText("*NIC Nr. :");
        nicno.setToolTipText("");
        getContentPane().add(nicno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 100, 30));

        radiobtnMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radiobtnMale.setText("   Male");
        radiobtnMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnMaleActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 110, 40));

        radiobtnFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radiobtnFemale.setText("   Female");
        radiobtnFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnFemaleActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 110, 40));

        emailid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailid.setText("*EMAIL_ID :");
        getContentPane().add(emailid, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 130, 30));

        txtemailID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtemailID.setForeground(new java.awt.Color(102, 102, 102));
        txtemailID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailIDFocusLost(evt);
            }
        });
        getContentPane().add(txtemailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 300, 50));

        jTable1Emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Emp_ID ", "Name", "Gender", "Nic Nr.", "Home Address", "Contact No", "emailId", "qualification", "join_date", "department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1Emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1EmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1Emp);
        if (jTable1Emp.getColumnModel().getColumnCount() > 0) {
            jTable1Emp.getColumnModel().getColumn(0).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(1).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(2).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(3).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(4).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(5).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(6).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(7).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(8).setResizable(false);
            jTable1Emp.getColumnModel().getColumn(9).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1080, 310));

        contactno1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contactno1.setText("*CONTACT NO :");
        getContentPane().add(contactno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, 30));

        homeaddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        homeaddress.setText("HOME ADDRESS :");
        homeaddress.setToolTipText("");
        getContentPane().add(homeaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 160, 30));

        btnenroll.setBackground(new java.awt.Color(102, 102, 255));
        btnenroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnenroll.setText("Enroll");
        btnenroll.setToolTipText("");
        btnenroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenrollActionPerformed(evt);
            }
        });
        getContentPane().add(btnenroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 140, 60));

        btnupdate1.setBackground(new java.awt.Color(102, 102, 255));
        btnupdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnupdate1.setText("UPDATE");
        btnupdate1.setToolTipText("");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 130, 60));

        txthomeAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthomeAddress.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(txthomeAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 300, 50));

        emailid1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailid1.setText("Search");
        getContentPane().add(emailid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 80, 30));

        txtqualification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtqualification.setForeground(new java.awt.Color(102, 102, 102));
        txtqualification.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtqualificationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqualificationFocusLost(evt);
            }
        });
        getContentPane().add(txtqualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 300, 50));

        datepicker.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        datepicker.setText("*Join Date:");
        getContentPane().add(datepicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 110, 30));

        emailid3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailid3.setText("*Department :");
        getContentPane().add(emailid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 140, 30));
        getContentPane().add(txtDataPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 300, 50));

        txtDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ass.Developer", "Developer", "Senior Developer", "Ass.QA", "QA", "Senior AQ", "Consultant", "Arhectect", "Designer", "", "" }));
        getContentPane().add(txtDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 300, 50));

        txtnicNo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnicNo1.setForeground(new java.awt.Color(102, 102, 102));
        txtnicNo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnicNo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnicNo1FocusLost(evt);
            }
        });
        getContentPane().add(txtnicNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 300, 50));

        txtEmployeeName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmployeeName.setForeground(new java.awt.Color(102, 102, 102));
        txtEmployeeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmployeeNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmployeeNameFocusLost(evt);
            }
        });
        getContentPane().add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 300, 50));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 190, 40));

        emailid2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailid2.setText("*Qualification :");
        getContentPane().add(emailid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 140, 30));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            txtcontactNr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+94-#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtcontactNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 300, 50));
        jPanel1.add(tttt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 50, 30));

        enst.setBackground(new java.awt.Color(204, 51, 0));
        enst.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        enst.setText("Register EMployee");
        jPanel1.add(enst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 50));
        enst.getAccessibleContext().setAccessibleName("Register Employee");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 840));

        setSize(new java.awt.Dimension(1139, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtempidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtempidFocusGained

      
    }//GEN-LAST:event_txtempidFocusGained

    private void txtempidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtempidFocusLost
       
    }//GEN-LAST:event_txtempidFocusLost

    private void txtemailIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailIDFocusGained

    private void txtemailIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailIDFocusLost
    //validing the email using regix

    
    private void btnenrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenrollActionPerformed

        String gender = null;
        
               // Pattern p = Pattern.compile("^(+94[0-9]{13}))$");
     //   Matcher m = p.matcher(txtcontactNr.getText());
        if (radiobtnMale.isSelected()) {
        gender = "Male";
        }
        else if (radiobtnFemale.isSelected()) {
        gender = "Female";
        }
        else {
            JOptionPane.showMessageDialog(new JFrame(), "Please Select the gender", "Dialog", JOptionPane.ERROR_MESSAGE);
        }
        if (txtEmployeeName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter the Employee Name", "Dialog: Fields Can't be Empty", JOptionPane.ERROR_MESSAGE);
        }
        else if (txtnicNo1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter the NIC Number", "Dialog: Fields Can't be Empty", JOptionPane.ERROR_MESSAGE);
        }
        else if (txthomeAddress.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter the CHome Address", "Dialog: Fields Can't be Empty", JOptionPane.ERROR_MESSAGE);
        }
     /*   if(!m.matches())
        {
  
            JOptionPane.showMessageDialog(null, "please enter a valid mobile number 999-999-9999, 9999999999, (999) 999-9999", "Dialog: Fields Can't be Empty", JOptionPane.ERROR_MESSAGE);
        }*/
        
        else if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtemailID.getText()))){
            JOptionPane.showMessageDialog(new JFrame(), "please enter a valid email address", "Dialog: Fields Can't be Empty", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try{
                    Employee obj=new Employee();
                    
                    obj.setName(txtEmployeeName.getText());
                    obj.setGender(gender.toString());
                    obj.setNicNo(txtnicNo1.getText());
                    obj.setHomeAddress(txthomeAddress.getText());
                    
                   

                    obj.setContactNo(txtcontactNr.getText());
                   
                    obj.setEmailId(txtemailID.getText());
                   
                    
                    obj.setQualification(txtqualification.getText());
                  
                    //obj.setJoin_date(txtDataPicker.getDateFormatString().toString());
                    obj.setJoin_date(txtDataPicker.getDate());
                
                  // SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");               
                 //  String tranDate = df.format(join_date.getDate());
                  // java.util.Date regDate = java.util.Date.valueOf(tranDate);
    //4.9
                    obj.setDepartment(Integer.parseInt(txtDepartment.getSelectedItem().toString()));
                    obj.addemployee(obj);

                    JOptionPane.showMessageDialog(this, "Successfully Employee Registered", "Success", JOptionPane.INFORMATION_MESSAGE);
                    distable();
                    refresh();
            }
            catch (Exception ex) {
                System.out.println(" "+ex.toString());
           //     JOptionPane.showMessageDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnenrollActionPerformed

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
         
        try{
           String gender = null;
        if (radiobtnMale.isSelected()) {
                gender ="Male";
        }
        else if (radiobtnFemale.isSelected()) {
        
        gender = "Female";
        }
            String value0= txtempid.getText();
            String value1=txtEmployeeName.getText();
            String value2=gender;
            String value3=txtnicNo1.getText();
            String value4=txthomeAddress.getText();
            String value5=txtcontactNr.getText();
            String value6=txtemailID.getText();
            String value7=txtqualification.getText();
         
            String value8=txtDataPicker.getDateFormatString();
            
            String value9=txtDepartment.toString();
            
            String sql= "UPDATE Employee SET name='"+value1+"',gender='"+value2+"',nicNo='"+value3
            +"', homeAddress='"+value4+"', contactNo='"+value5+"' , emailId='"+value6+"', qualification = '"+value7+"', join_date = '"+value8+"', department = '"+value9+"'   where Employee.emp_ID='"+value0+"'";           
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(this, "Sucessfully Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        distable();
        refresh();
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void txtqualificationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqualificationFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqualificationFocusGained

    private void txtqualificationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqualificationFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqualificationFocusLost

    private void txtnicNo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnicNo1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicNo1FocusGained

    private void txtnicNo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnicNo1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicNo1FocusLost

    private void txtEmployeeNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployeeNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeNameFocusGained

    private void txtEmployeeNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployeeNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeNameFocusLost

    private void radiobtnFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnFemaleActionPerformed

    }//GEN-LAST:event_radiobtnFemaleActionPerformed

    private void radiobtnMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnMaleActionPerformed

    }//GEN-LAST:event_radiobtnMaleActionPerformed

    private void jTable1EmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1EmpMouseClicked
       
        try {
        DefaultTableModel model = (DefaultTableModel) jTable1Emp.getModel();
        int selectedRowIndex = jTable1Emp.getSelectedRow();
        txtempid.setText(model.getValueAt(selectedRowIndex, 0 ).toString());
        txtEmployeeName.setText(model.getValueAt(selectedRowIndex, 1 ).toString());
        
        if(model.getValueAt(selectedRowIndex, 2).toString().equals("Male")){
            radiobtnMale.setSelected(true);
            radiobtnFemale.setSelected(false);

        }
        else if(model.getValueAt(selectedRowIndex, 2).toString().equals("Female")){
            radiobtnFemale.setSelected(true);
            radiobtnMale.setSelected(false);

        }

        txtnicNo1.setText(model.getValueAt(selectedRowIndex, 3).toString());
        txthomeAddress.setText(model.getValueAt(selectedRowIndex, 4 ).toString());
        txtcontactNr.setText(model.getValueAt(selectedRowIndex, 5 ).toString());
        txtemailID.setText(model.getValueAt(selectedRowIndex, 6 ).toString());
        txtqualification.setText(model.getValueAt(selectedRowIndex, 7 ).toString());
        //yyyy-MM-dd
        //yyyy-MM-dd
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRowIndex, 8 ));
        txtDataPicker.setDate(date);
        
        txtDepartment.setSelectedItem(model.getValueAt(selectedRowIndex, 9).toString());

         } catch (ParseException ex) {
             Logger.getLogger(Employee_UI.class.getName()).log(Level.SEVERE, null, ex);
         }
      
        
        
        
        /*obj.setJoin_date(txtDataPicker.getDateFormatString());
        obj.setDepartment(txtDepartment.getSelectedItem().toString());*/

        //String gender = null;

        /* if (gender == "Male") {
            radiobtnMale.isSelected();
        }
        else if (gender == "Female") {
            radiobtnFemale.isSelected();
        }*/

    }//GEN-LAST:event_jTable1EmpMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StudentID;
    private javax.swing.JButton btnenroll;
    private javax.swing.JButton btnupdate1;
    private javax.swing.JLabel contactno1;
    private javax.swing.JLabel datepicker;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel emailid1;
    private javax.swing.JLabel emailid2;
    private javax.swing.JLabel emailid3;
    private javax.swing.JLabel enst;
    private javax.swing.JLabel homeaddress;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1Emp;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jgender;
    private javax.swing.JLabel nicno;
    private javax.swing.JRadioButton radiobtnFemale;
    private javax.swing.JRadioButton radiobtnMale;
    private javax.swing.JTextField tttt;
    private com.toedter.calendar.JDateChooser txtDataPicker;
    private javax.swing.JComboBox<String> txtDepartment;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JFormattedTextField txtcontactNr;
    private javax.swing.JTextField txtemailID;
    private javax.swing.JTextField txtempid;
    private javax.swing.JEditorPane txthomeAddress;
    private javax.swing.JTextField txtnicNo1;
    private javax.swing.JTextField txtqualification;
    // End of variables declaration//GEN-END:variables
}
