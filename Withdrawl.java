
package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JButton Withdraw,back;
    JTextField amount;
    String pinumber;
     Withdrawl(String pinumber){
         this.pinumber = pinumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
       Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355,485,150,30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
         setSize(900,900);
         setLocation(300,0);
         setVisible(true);
     }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Withdraw){
           String number = amount.getText();
           Date date = new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
           }else{
               try{
               Con con = new Con();
               String query = "Insert into bank value('"+pinumber+"','"+date+"','Withdrawl','"+number+"')";
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs"+number+"Withdraw successfully");
               setVisible(false);
               new Transactions(pinumber).setVisible(true);
           }catch(Exception e){
             System.out.println(e);  
           }
         }
        }else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
