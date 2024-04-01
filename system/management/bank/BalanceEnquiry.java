package system.management.bank;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry  extends JFrame implements ActionListener{

	
	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber)
	{
		this.pinnumber= pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image  = new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		
		back = new JButton("Back");
		back.setBounds(385,405,120,23);
		back.addActionListener(this);
		image.add(back);
		
		
		int balance = 0;
		
		Conn c = new Conn();
		try {
				ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
				
				while(rs.next())
				{
					if(rs.getString("Type_Transaction").equals("Deposit"))
						balance+= Integer.parseInt(rs.getString("amount"));
					else
						balance-= Integer.parseInt(rs.getString("amount"));
				}
	
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		JLabel text = new JLabel("Your Current Account balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 100, 400, 300);
		image.add(text);
		
		
		
		
		setSize(900,700);
		setLocation(200,0);
		setUndecorated(true);
		setVisible(true);

		
		
	}
	
	public static void main(String args[])
	{
		
		new BalanceEnquiry("");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== back)
		{
			setVisible(false);
			new Transactions(pinnumber);
		}
		
	}
}
