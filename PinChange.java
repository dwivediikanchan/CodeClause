package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField pin,repin;
    String pinumber;
    PinChange(String pinumber){
        this.pinumber= pinumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25) ); 
        pin.setBounds(330,320,180,25);
        add(pin);
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25) ); 
        repin.setBounds(330,360,180,25);
        add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        JLabel repintext = new JLabel("Re-enter PIN:");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == change){
         try{
             String npin =pin.getText();
             String rpin =repin.getText();
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null,"Entered pin does not match");
                 return;
             }
             if(npin.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter new pin");
                 return;  
             }
             if(rpin.equals("")){
               JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                 return;  
             }
             Con  con = new Con();
             String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinumber+"'";
             String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinumber+"'";
             String query3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pinumber+"'";
             con.s.executeUpdate(query1);
             con.s.executeUpdate(query2);
             con.s.executeUpdate(query3);
             JOptionPane.showMessageDialog(null,"PIN changed successfully");
             setVisible(false);
             new Transactions(rpin).setVisible(true  );
         }catch(Exception e){
             System.out.println(e);
        }
      } else {
    setVisible(false);
    new Transactions(pinumber).setVisible(true  );
     }

     } 
    public static void main(String args[]) {
       new PinChange("").setVisible(true);
    }
}
