package opertiondemo;
import java.sql.*;
import javax.swing.*;
public class operationdemo1 extends javax.swing.JFrame {
ResultSet rs1;
/** Creates new form operationdemo1 */
public operationdemo1() {
initComponents();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
Statement
stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
);
rs1=stmt.executeQuery("select * from student");
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
try
{System.out.println("Outside rs1");
if(rs1.next()){
System.out.println("Inside rs1");
String r1=rs1.getString(1);
String n1=rs1.getString(2);
String a1=rs1.getString(3);
jTextField1.setText(r1);
jTextField2.setText(n1);
jTextField3.setText(a1);
}
else
{
JOptionPane.showMessageDialog(this, "eND OF THE RECORD");
}
}catch(Exception e)
{}
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
Statement stmt=conn.createStatement();
String qry=("Insert into student
values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"')");
stmt.executeUpdate(qry);
JOptionPane.showMessageDialog(this, "Record inserted");
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
try
{System.out.println("Outside rs1");
if(rs1.previous()){
System.out.println("Inside rs1");
String r1=rs1.getString(1);
String n1=rs1.getString(2);
String a1=rs1.getString(3);
jTextField1.setText(r1);
jTextField2.setText(n1);
jTextField3.setText(a1);
}
}catch(Exception e)
{}
}
private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
Statement
stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
);
rs=stmt.executeQuery("select * from student");
rs.first();
String r=rs.getString(1);
String n=rs.getString(2);
String a=rs.getString(3);
jTextField1.setText(r);
jTextField2.setText(n);
jTextField3.setText(a);
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
Statement
stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
);
rs=stmt.executeQuery("select * from student");
rs.last();
String r=rs.getString(1);
String n=rs.getString(2);
String a=rs.getString(3);
jTextField1.setText(r);
jTextField2.setText(n);
jTextField3.setText(a);
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
String qry="update student set rollnum="+jTextField1.getText()+",age="+jTextField3.getText()+"
where name='"+jTextField2.getText()+"'";
Statement stmt=conn.createStatement();
stmt.executeUpdate(qry);
JOptionPane.showMessageDialog(this, "Record Updated");
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
Statement stmt=conn.createStatement();
stmt.executeUpdate("delete * from student where rollnum="+jTextField1.getText()+"");
JOptionPane.showMessageDialog(this, "Record deleted");
jTextField1.setText(" ");
jTextField2.setText(" ");
jTextField3.setText(" ");
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());
}
}
private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
System.exit(0);
// TODO add your handling code here:
}
private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(" ");
jTextField2.setText(" ");
jTextField3.setText(" ");
// TODO add your handling code here:
}
private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try
{
// Connection conn;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "Jdbc:Odbc:g4";
Connection conn = DriverManager.getConnection(url);
ResultSet rs;
Statement stmt=conn.createStatement();
rs=stmt.executeQuery("Select * from student");
while(rs.next()){
String r=rs.getString(1);
String n=rs.getString(2);
String a=rs.getString(3);
jTextField1.setText(r);
jTextField2.setText(n);
jTextField3.setText(a);
}
conn.close();
}
catch (Exception e) {
System.err.println("Got an exception! ");
System.err.println(e.getMessage());

}}}
