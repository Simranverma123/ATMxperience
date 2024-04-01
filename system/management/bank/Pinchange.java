package system.management.bank;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;

public class Pinchange extends JFrame implements ActionListener{

	JPasswordField pin,rpin;
	JButton change, back;
	String pinnumber;
	Pinchange(String pinnumber)
	{
		this.pinnumber= pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont( new Font("System",Font.BOLD,14));
		text.setBounds(200,250,200,25);
		image.add(text);
		
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont( new Font("System",Font.BOLD,15));
		pintext.setBounds(140,290,100,20);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,14));
		pin.setBounds(300,290,150,20);
		image.add(pin);
		
		
		
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont( new Font("System",Font.BOLD,15));
		repintext.setBounds(140,320,200,20);
		image.add(repintext);
		
		rpin = new JPasswordField();
		rpin.setFont(new Font("Raleway",Font.BOLD,15));
		rpin.setBounds(300,320,150,20);
		image.add(rpin);
	
		
		change = new JButton("CHANGE");
		change.setBounds(330,430,120,23);
		change.addActionListener(this);
		image.add(change);
		
		
		back = new JButton("BACK");
		back.setBounds(330,460,120,23);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(800,800);
		setLocation(300,0);
		setVisible(true);
		
	
	}
	
	
	public static void main(String args[])
	{
		new Pinchange("").setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		String npin = pin.getText();
		String rnpin = rpin.getText();
		if(ae.getSource()==change) {
			try {
			
				
			
				if(!npin.equals(rnpin))
				{
					JOptionPane.showMessageDialog(null,"Entered PIN doesn not match.");
					return;
				}
				
				if(npin.equals(""))
				{	JOptionPane.showMessageDialog(null,"Please Enter PIN.");
					return;
				}
				if(rnpin.equals(""))
				{	JOptionPane.showMessageDialog(null,"Please Enter PIN.");
					return;
				}
				
				Conn conn = new Conn();
				String q1 = "update bank set PIN = '"+rnpin+"' where PIN = '"+pinnumber+"'";
				
				String q2 = "update login set PIN = '"+rnpin+"' where PIN = '"+pinnumber+"'";
				
				String q3 = "update signupthree set PIN = '"+rnpin+"' where PIN = '"+pinnumber+"'";
				
				conn.s.executeUpdate(q1);
				conn.s.executeUpdate(q2);
				conn.s.executeUpdate(q3);

				JOptionPane.showMessageDialog(null,"PIN changed successfully.");
				
				setVisible(false);
				new Transactions(rnpin).setVisible(true);
				}
			catch (Exception e) {
					System.out.println(e);
				}
		}
		else if(ae.getSource()=="back") {
			setVisible(false);
			new Transactions(rnpin).setVisible(true);
			
			}
		}
}
	
