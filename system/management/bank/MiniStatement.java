package system.management.bank;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {
	String pinnumber;
	
	MiniStatement(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		setTitle("Mini Statement");
		
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		
		JLabel bank = new JLabel("IND Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where PIN = '"+pinnumber+"'");
			if(rs.next()) {
				card.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
			
				}
		}catch (Exception e){
			System.out.println(e);
		}
		
		
		try {
			int bal=0;
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
						+ rs.getString("Type_Transaction") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ 
						 rs.getString("Amount")+"<br><br><html>");
				
				if(rs.getString("Type_Transaction").equals("Deposit"))
					bal+= Integer.parseInt(rs.getString("amount"));
				else
					bal-= Integer.parseInt(rs.getString("amount"));
				balance.setText("Your current account balance is Rs "+bal);
				
			}
		}catch (Exception e){
			System.out.println(e);
		}
		
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		new MiniStatement("");
	}
}
