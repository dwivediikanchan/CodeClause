
package bank.managment.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;




public class SignupTwo extends JFrame implements ActionListener {

    
    JTextField pannumberTextField,aadharnumberTextField;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    JComboBox religion,category,qualification,occupation,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        
                
        JLabel additionaldetails = new JLabel("Page2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22) ); 
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20) ); 
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
            
        
        JLabel fname = new JLabel("Category :");
        fname .setFont(new Font("Raleway",Font.BOLD,20) ); 
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20) ); 
        dob .setBounds(100,240,200,30);
        add(dob);
       
        String incomeCategory[] = {"Null","< 1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income= new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel email = new JLabel("Educational");
        email .setFont(new Font("Raleway",Font.BOLD,20) ); 
        email .setBounds(100,290,200,30);
        add(email );
        
        
        
                
        JLabel gender = new JLabel("Qualification:");
        gender.setFont(new Font("Raleway",Font.BOLD,20) ); 
        gender.setBounds(100,315,200,30);
        add(gender);
        String educationalValues[] = {"Non Graduation","Graduation","Post Graduation","Doctrate","Others"};
        qualification= new JComboBox(educationalValues);
        qualification.setBounds(300,340,400,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20) ); 
        marital.setBounds(100,390,200,30);
        add(marital);
        String occupationValues[] = {"Salaried","Graduation","Self-Employed","Business","Student","Retired","Others"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
         
        
        JLabel pannumber = new JLabel("Pan Number:");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20) ); 
        pannumber.setBounds(100,440,200,30);
        add(pannumber);
        pannumberTextField = new JTextField();
        pannumberTextField.setBounds(300,440,400,30);
        pannumberTextField.setFont(new Font("Raleway",Font.BOLD,14) );
        add(pannumberTextField);
        
                
        JLabel aadharnumber = new JLabel("Aadhar Number:");
        aadharnumber.setFont(new Font("Raleway",Font.BOLD,20) ); 
        aadharnumber.setBounds(100,490,200,30);
        add(aadharnumber);
        aadharnumberTextField = new JTextField();
        aadharnumberTextField.setBounds(300,490,400,30);
        aadharnumberTextField.setFont(new Font("Raleway",Font.BOLD,14) );
        add(aadharnumberTextField);
        
        JLabel seniorcitizen= new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20) ); 
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
      
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorcitizengroup  =new  ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);
        
        
        
        JLabel accountexisting= new JLabel("Account Existing:");
        accountexisting.setFont(new Font("Raleway",Font.BOLD,20) ); 
        accountexisting.setBounds(100,590,200,30);
        add(accountexisting);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
      
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup accountexistinggroup  =new  ButtonGroup();
        accountexistinggroup.add(eyes);
        accountexistinggroup.add(eno);
        
        
        
           next = new JButton("Next");
           next.setBackground(Color.BLACK);
           next.setForeground(Color.WHITE);
           next.setFont(new Font("Raleway",Font.BOLD,14));
           next.setBounds(620,660,80,30);
           next.addActionListener(this);
           add(next);
           
                
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
            
            String sreligion = (String)religion.getSelectedItem();
            String scategory = (String)category.getSelectedItem();
            String sincome = (String)income.getSelectedItem();
            String squalification = (String)qualification.getSelectedItem();
            String soccupation = (String)occupation.getSelectedItem();
            String seniorcitizen = null;
            if(syes.isSelected()){
                seniorcitizen = "Yes";
            }else if (sno.isSelected()){
                seniorcitizen = "No";
            }
            String accountexisting = null;
            if(eyes.isSelected()){
                accountexisting = "Yes";
            }else if (eno.isSelected()){
                accountexisting = "No";
            }
            String pannumber = pannumberTextField.getText();
            String aadharnumber = aadharnumberTextField.getText();
            
            try{
                
                    Con c = new Con();
                    String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+pannumber+"','"+aadharnumber+"','"+seniorcitizen+"','"+accountexisting+"')";
                    c.s.executeUpdate(query);
                    new SignupThree(formno).setVisible(true);
                    setVisible(false);
                
            }catch (Exception e){
                System.out.println(e);
            }
                    
            
        }
    
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
