package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit,withdraw,fastcash,ministmt,pinchange,balance,exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber=pinnumber;
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(175, 220, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(145,321,128,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		
		withdraw = new JButton("Cash Withdrawl");
		withdraw.setBounds(315,321,130,25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(145,349,130,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		
		ministmt = new JButton("Mini Statement");
		ministmt.setBounds(315,349,130,25);
		ministmt.addActionListener(this);
		image.add(ministmt);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(145,377,130,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(315,377,130,25);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(315,405,130,23);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(800,700);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	
	public static void main(String args[]) {
		
		new Transactions("");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== exit)
			System.exit(0);
		else if(ae.getSource()==deposit)
		{
		
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
	}
		else if(ae.getSource()==withdraw)
		{
		
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
	}
		else if(ae.getSource()==fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
			
		}
		else if(ae.getSource()==pinchange)
		{
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
			
		}
		else if(ae.getSource()==balance)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
			
		}
		else if(ae.getSource()==ministmt)
		{

			
			new MiniStatement(pinnumber).setVisible(true);
			
		}
		
		
	}
}
