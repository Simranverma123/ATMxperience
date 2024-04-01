package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener {
	
	JRadioButton current,saving,fixed,recurring;
	JCheckBox atm,mb,ib,alert,CBook,stmt,declare;
	JButton Submit,Cancel;
	String formno;
	SignUpThree(String formno) {
		this.formno=formno;
		setLayout(null);
		JLabel l1= new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,20));
		l1.setBounds(280, 20, 400, 40);
		add(l1);
		
		JLabel type= new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,20));
		type.setBounds(100,100, 200, 30);
		add(type);
		
		
		
		saving = new JRadioButton("Saving Account");
		saving.setFont(new Font("Raleway",Font.BOLD,14));
		saving.setBackground(Color.white);
		saving.setBounds(100,140, 240, 20);
		add(saving);
		
		current = new JRadioButton("Current Account");
		current.setFont(new Font("Raleway",Font.BOLD,14));
		current.setBackground(Color.white);
		current.setBounds(350,140,250, 20);
		add(current);
		
		fixed = new JRadioButton("Fixed Deposit Account");
		fixed.setFont(new Font("Raleway",Font.BOLD,14));
		fixed.setBackground(Color.white);
		fixed.setBounds(100,175, 250, 20);
		add(fixed);
		
		recurring = new JRadioButton("Recurring Deposit Account");
		recurring.setFont(new Font("Raleway",Font.BOLD,14));
		recurring.setBackground(Color.white);
		recurring.setBounds(350,175, 250, 20);
		add(recurring);
		
		ButtonGroup acctype = new ButtonGroup();
		acctype.add(saving);
		acctype.add(recurring);
		acctype.add(fixed);
		acctype.add(current);
		
		
		
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,20));
		card.setBounds(100,220,200,30);
		add(card);
		
		
		JLabel number = new JLabel("5040-XXXX-XXXX-XXXX");
		number.setFont(new Font("Raleway",Font.BOLD,20));
		number.setBounds(330,220,300,30);
		add(number);
		
		
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway",Font.BOLD,10));
		cardDetail.setBounds(100,250,300,30);
		add(cardDetail);
		
		JLabel pin = new JLabel("Pin");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,290,200,30);
		add(pin);
		
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,20));
		pnumber.setBounds(330,290,300,30);
		add(pnumber);
		
		JLabel lpin = new JLabel("Your 4 Digit Password");
		lpin.setFont(new Font("Raleway",Font.BOLD,10));
		lpin.setBounds(100,320,300,30);
		add(lpin);
		
		
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,20));
		services.setBounds(100,360,400,30);
		add(services);
		
		
		

		atm = new JCheckBox("ATM CARD");
		atm.setBackground(Color.WHITE);
		atm.setFont(new Font("Raleway",Font.BOLD,14));
		atm.setBounds(100,420,200,30);
		add(atm);
		
		ib = new JCheckBox("Internet Banking");
		ib.setBackground(Color.WHITE);
		ib.setFont(new Font("Raleway",Font.BOLD,14));
		ib.setBounds(350,420,200,30);
		add(ib);
		
		
		mb = new JCheckBox("Mobile Banking");
		mb.setBackground(Color.WHITE);
		mb.setFont(new Font("Raleway",Font.BOLD,14));
		mb.setBounds(100,470,200,30);
		add(mb);
		
		alert = new JCheckBox("Email/SMS Alerts");
		alert.setBackground(Color.WHITE);
		alert.setFont(new Font("Raleway",Font.BOLD,14));
		alert.setBounds(350,470,200,30);
		add(alert);
		
		CBook = new JCheckBox("Cheque Book");
		CBook.setBackground(Color.WHITE);
		CBook.setFont(new Font("Raleway",Font.BOLD,14));
		CBook.setBounds(100,520,200,30);
		add(CBook);
		
		stmt = new JCheckBox("E-Statement");
		stmt.setBackground(Color.WHITE);
		stmt.setFont(new Font("Raleway",Font.BOLD,14));
		stmt.setBounds(350,520,200,30);
		add(stmt);
		
		declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
		declare.setBackground(Color.WHITE);
		declare.setFont(new Font("Raleway",Font.BOLD,14));
		declare.setBounds(100,580,700,30);
		add(declare);
		
		
		
		Submit = new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.white);
		Submit.setFont(new Font("Raleway",Font.BOLD,14));
		Submit.setBounds(250,630,100,30);
		Submit.addActionListener(this);
		add(Submit);
		
		
		Cancel = new JButton("Cancel");
		Cancel.setBackground(Color.black);
		Cancel.setForeground(Color.white);
		Cancel.setFont(new Font("Raleway",Font.BOLD,14));
		Cancel.setBounds(420,630,100,30);
		Cancel.addActionListener(this);
		add(Cancel);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		  
		
		
	
		
		
		
	}
	public static void main(String args[]) {
		new SignUpThree("");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {

		
		if(ae.getSource()==Submit){
			
			String saccountType=null;
			if(saving.isSelected())
				saccountType="Saving Account";
			else if(current.isSelected())
				saccountType ="Current Account";
			else if(recurring.isSelected())
				saccountType="Recurring Deposit Account";
			else if(fixed.isSelected())
				saccountType = "Fixed Deposit Account";
			
			Random random = new Random();
			String cardNum ="" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			
			String pinNum = ""+ Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility ="";
			
			if(atm.isSelected())
				facility = facility+" ATM Card";
			
			else if(ib.isSelected())
				facility = facility+" Internet Banking";
			else if(mb.isSelected())
				facility = facility+" Mobile Banking";
			else if(alert.isSelected())
				facility = facility+" Email/SMS Alerts";
			else if(CBook.isSelected())
				facility = facility+" Cheque Book";
			else if(stmt.isSelected())
				facility = facility+" E-statement";
			
			
			
			
			try {
				if(saccountType.equals("")) 
					JOptionPane.showMessageDialog(null,"Account Type is Required");
				else
				{
					Conn conn = new Conn();
					String q1 = "insert into signupthree values('"+formno+"', '"+saccountType+"', '"+cardNum+
							"', '"+pinNum+"', '"+facility+"');";
				
					String q2 = "insert into login values('"+formno+"', '"+cardNum+
							"', '"+pinNum+"');";
					
					conn.s.executeUpdate(q1);
					conn.s.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "Card Number: "+cardNum+"\nPin: "+pinNum);
				
				setVisible(false);
				new Deposit(pinNum).setVisible(false);
				}	
					
					
			}catch (Exception e)
			{	System.out.println(e);
			}

		}
		
		
		else if(ae.getSource()==Cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

}
