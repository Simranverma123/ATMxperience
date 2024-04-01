package system.management.bank;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {

	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	Withdrawl(String pinnumber)
	{
	
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon i1= new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,15 ));
		text.setBounds(150,230,400,20);
		image.add(text);
		
		
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(150, 270, 290, 25);
		image.add(amount);
		
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(300,375,150,25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		
		back = new JButton("Back");
		back.setBounds(300,405,150,25);
		back.addActionListener(this);
		image.add(back);
		
		
		
		setSize(800,700);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Withdrawl("");
		
	}

	public void actionPerformed(ActionEvent ae) {
	
			if(ae.getSource()== withdraw)
			{
				int balance = 0;
				
				String amnt = amount.getText();
				Date date = new Date();
				if(amnt.equals(""))
					JOptionPane.showMessageDialog(null,"Please enter the amount to withdraw");
				else
				{
					
					try {
					Conn conn = new Conn();
					
					ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
					while(rs.next())
					{
						if(rs.getString("Type_Transaction").equals("Deposit"))
							balance+= Integer.parseInt(rs.getString("Amount"));
						else
							balance-= Integer.parseInt(rs.getString("Amount"));
					}
					}
					catch (Exception e)
					{
					System.out.println(e);
					}
					
				}
				if(ae.getSource()!= back && balance < Integer.parseInt(amnt))
				{
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
					return;
				}
					
					
				else {
					try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amnt+"');";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amnt+" withdraw successfully.");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
					
					}catch (Exception e)
					{
					System.out.println(e);
					}
					
			}
		}
		
			else if(ae.getSource()==back)
			{
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
		}
}