package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
 
	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	Deposit(String pinnumber)
	{
	
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon i1= new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,15 ));
		text.setBounds(150,230,400,20);
		image.add(text);
		
		
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(150, 270, 290, 25);
		image.add(amount);
		
		
		deposit = new JButton("Deposit");
		deposit.setBounds(300,375,150,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
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
		new Deposit("");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	
			if(ae.getSource()== deposit)
			{
				
				String amnt = amount.getText();
				Date date = new Date();
				if(amnt.equals(""))
					JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
				else
				{
					try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amnt+"');";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amnt+" deposited successfully.");
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
