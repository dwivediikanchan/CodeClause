package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;



public class MiniStatement extends JFrame{
    
    String pinumber;
    MiniStatement(String pinumber){
        setTitle("Mini Statement");
        this.pinumber= pinumber;
        setLayout(null);
        
        
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel balance =new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
         try{
                 Con c = new Con();
                ResultSet rs = c.s.executeQuery("select * from login where pin='"+pinumber+"'");
                
                while(rs.next()){
                    card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                    
                   }
                }catch (Exception e){
                        System.out.println(e);
                        }
         try{
                Con c = new Con();
                int bal =0;
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinumber+"'");
                
                while(rs.next()){
                    mini.setText(mini.getText() + "<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                    if(rs.getString("type").equals("Deposit")){
                        bal +=  Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -=  Integer.parseInt(rs.getString("amount"));
                    }
                   }
                balance.setText("Your current account balance is Rs"+bal);
                }catch (Exception e){
                        System.out.println(e);
                        }
        
        
        
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
    }
     
    public static void main(String args[]) {
       new MiniStatement("");
    }
}
+++++++