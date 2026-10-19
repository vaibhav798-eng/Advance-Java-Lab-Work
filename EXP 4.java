package calculator;
public class form1 extends javax.swing.JFrame {
int a;
int count=0;
public form1() {
initComponents();
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"1");
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"2");
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"3");
}
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"4");
}
private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"5");
}
private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"6");
}
private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"7");
}
private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"8");
}
private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"9");
}
private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText(jTextField1.getText()+"0");
}
private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=1;
}
private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=2;
}
private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=3;
}
private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=4;
}
private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=5;
}
private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
a=Integer.parseInt(jTextField1.getText());
jTextField1.setText("");
count=6;
}
private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {
int b=Integer.parseInt(jTextField1.getText());
int c=0;
if(count==1)
c=a+b;
else if(count==2)
c=a-b;
else if(count==3)
c=a*b;
else if(count==4)
c=a/b;
else if(count==5)
c=a%b;
else if(count==6)
c=a*b;
jTextField1.setText(Integer.toString(c));
}
private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
jTextField1.setText("");
}
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new form1().setVisible(true); }
});
} }
