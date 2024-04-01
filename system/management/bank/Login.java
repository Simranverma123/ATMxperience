package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	
	JButton clear,signIn,signUp;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login() {
		
	    setTitle("AUTOMATED TELLER MACHINE");
	    setLayout(null);
	    setVisible(true);
	    setLocation(350, 200);
	    setSize(800, 480);
	    
	    ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
	    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    
	    JLabel label = new JLabel(i3);
	    label.setBounds(70, 10, 100, 100);
	    add(label);
	    
	    JLabel textLabel = new JLabel("WELCOME TO ATM");
	    textLabel.setFont(new Font(("Ostward"),Font.BOLD,38));
	    textLabel.setBounds(200, 40, 400, 40);
	    add(textLabel);
	    
	    
	    JLabel cardNo = new JLabel("Card No:");
	    cardNo.setFont(new Font(("Ostward"),Font.BOLD,28));
	    cardNo.setBounds(120, 150, 150, 40);
	    add(cardNo);
	    
	    cardTextField= new JTextField();
	    cardTextField.setBounds(300, 150, 250, 30);
	    cardTextField.setFont(new Font(("Ostward"),Font.BOLD,14));
	    add(cardTextField);
	    
	    
	    JLabel pin = new JLabel("PIN:");
	    pin.setFont(new Font(("Ostward"),Font.BOLD,28));
	    pin.setBounds(120, 220, 250, 30);
	    add(pin);
	    
	    pinTextField= new JPasswordField();
	    pinTextField.setBounds(300, 220, 250, 30);
	    pinTextField.setFont(new Font(("Ostward"),Font.BOLD,14));
	    add(pinTextField);
	    
	    
	    signIn = new JButton("SIGN IN");
	    signIn.setBounds(300, 300, 100, 30);
	    signIn.setBackground(Color.black);
	    signIn.setForeground(Color.white);
	    signIn.addActionListener(this);
	    add(signIn);
	    
	    clear = new JButton("CLEAR");
	    clear.setBounds(430, 300, 100, 30);
	    clear.setBackground(Color.black);
	    clear.setForeground(Color.white);
	    clear.addActionListener(this);
	    add(clear);
	    
	    signUp = new JButton("SIGN UP");
	    signUp.setBounds(300, 350, 230, 30);
	    signUp.setBackground(Color.black);
	    signUp.setForeground(Color.white);
	    signUp.addActionListener(this);
	    add(signUp);
	    
	    
	    getContentPane().setBackground(Color.WHITE);
	      
	   
	    
	    
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==clear)
		{
		 cardTextField.setText("");
		 pinTextField.setText("");
			
		}
		else if(ae.getSource()== signIn) {
			
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			
			String q1 = "select * from login where Card_Number = '"+cardnumber+"' and PIN = '"+pinnumber+"'";
			try {
				
				ResultSet rs = conn.s.executeQuery(q1);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			}catch (Exception e)
			{
				System.out.println();
			}
			
			
		}
		else if(ae.getSource()==signUp) {
			setVisible(false);
			
			new SignUpOne().setVisible(true);
			
		}
		else {
		}
	}
	
public static void main(String args[])
{
	new Login();
}
}
