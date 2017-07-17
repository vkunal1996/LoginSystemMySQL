/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author scarletspeedster
 */
class EmptyException extends Exception
{
    private String msg;
    EmptyException(String msg)
    {
        this.msg=msg;
    }
    public String getMessage()
    {
        return msg;
    }
}
public class SignUpForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form SignUpForm
     * 
     */
    PreparedStatement st;
    ResultSet rs;
    Connection cn;
    String sql;
    
    String username,pass,rpass,hintq,hinta,email;
        char ch[];
    
    public void Myconnection()
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LallyInfosysProject?autoReconnect=true&useSSL=true","scarlet","Lmno1996&&");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    public void Close()throws Exception
    {
        cn.close();
    }
    
    public SignUpForm() 
    {
        Myconnection();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf2 = new javax.swing.JPasswordField();
        tf3 = new javax.swing.JPasswordField();
        tf4 = new javax.swing.JTextField();
        tf5 = new javax.swing.JPasswordField();
        tf6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Sign Up..");
        setPreferredSize(new java.awt.Dimension(410, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        getContentPane().add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setText("Retype Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setText("Hint Question");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setText("Hint Answer");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        getContentPane().add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 190, -1));
        getContentPane().add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 190, -1));
        getContentPane().add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, -1));
        getContentPane().add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, -1));
        getContentPane().add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 190, -1));

        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
            username=tf1.getText();
            ch=tf2.getPassword();
            pass=new String(ch);
            ch=tf3.getPassword();
            rpass=new String(ch);
            if(!pass.equals(rpass))
            {
             JOptionPane.showMessageDialog(this,"Password Don't Match");
            }
        else
        {
        hintq=tf4.getText();
        
        ch=tf5.getPassword();
        hinta=new String(ch);
        
        email=tf6.getText();
        }
        
      if(username.isEmpty()||pass.isEmpty()||rpass.isEmpty()||hintq.isEmpty()||hinta.isEmpty()||email.isEmpty())
      {
          JOptionPane.showMessageDialog(this,"Please Fill the EMpty Fields");
      }
      
      else
      {
        
        try
        {
        sql="Select * from Users where Username=? ||Email=?";
        st=cn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        st.setString(1,username);
        st.setString(2,email);
        rs=st.executeQuery();
        rs.last();
            if(rs.getRow()==0)
            {
                sql="Insert into Users Values(?,?,?,?,?)";
                st=cn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                st.setString(1,username);
                st.setString(2,pass);
                st.setString(3,hintq);
                st.setString(4,hinta);
                st.setString(5,email);
                st.executeUpdate();
                JOptionPane.showMessageDialog(this,"Registration SuccessFull");
                this.setVisible(false);
                Close();
            }
                else
                {
                JOptionPane.showMessageDialog(this,"User Already Exists");
                }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
            
        }
      }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    private javax.swing.JPasswordField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JPasswordField tf5;
    private javax.swing.JTextField tf6;
    // End of variables declaration//GEN-END:variables
}
