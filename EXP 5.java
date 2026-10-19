package javaapplication5;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class NewJFrame extends javax.swing.JFrame {
public NewJFrame() {
initComponents();
}
private void initComponents() {
jTextField1 = new javax.swing.JTextField();
jTextField2 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jButton1.setText("Login");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g2";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
Statement stmt=conn.createStatement();
rs=stmt.executeQuery("select * from mytab");
while(rs.next())
{
if(((jTextField1.getText()).equals(rs.getString(1)))&& ((jTextField2.getText()).equals(rs.getString(2)))){
JOptionPane.showMessageDialog(this, "login successfull");
System.exit(0);
}}
JOptionPane.showMessageDialog(this, "login unsuccessfull");
System.exit(0);
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
}
