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

public class FastCash extends JFrame implements ActionListener{
	

	JButton a100,a500,a1000, a5000, a10000,a2000,back;
	String pinnumber;
	FastCash(String pinnumber)
	{
	
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon i1= new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		

		JLabel text = new JLabel("Select withdrawl amount");
		text.setBounds(175, 220, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		a100 = new JButton("Rs 100");
		a100.setBounds(145,321,128,25);
		a100.addActionListener(this);
		image.add(a100);
		
		
		
		a500 = new JButton("Rs 500");
		a500.setBounds(315,321,130,25);
		a500.addActionListener(this);
		image.add(a500);
		
		
		
		a1000 = new JButton("Rs 1000");
		a1000.setBounds(145,349,130,25);
		a1000.addActionListener(this);
		image.add(a1000);
		
		
		a2000 = new JButton("Rs 2000");
		a2000.setBounds(315,349,130,25);
		a2000.addActionListener(this);
		image.add(a2000);
		
		a5000 = new JButton("Rs 5000");
		a5000.setBounds(145,377,130,25);
		a5000.addActionListener(this);
		image.add(a5000);
		
		a10000 = new JButton("Rs 10000");
		a10000.setBounds(315,377,130,25);
		a10000.addActionListener(this);
		image.add(a10000);
		
		back = new JButton("Back");
		back.setBounds(315,405,130,23);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(800,700);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new FastCash("");
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else {
			
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
					ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
					int balance = 0;
					while(rs.next())
					{
						if(rs.getString("Type_Transaction").equals("Deposit"))
							balance+= Integer.parseInt(rs.getString("amount"));
						else
							balance-= Integer.parseInt(rs.getString("amount"));
					}
					if(ae.getSource()!= back && balance < Integer.parseInt(amount))
					{
						JOptionPane.showMessageDialog(null,"Insufficient Balance");
						return;
					}
				
					Date date = new Date();
					String query = "insert into bank values('"+pinnumber+"' , '"+date+"', 'Withdrawl', '"+amount+"');" ;
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs"+amount+" debited successfully.");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}	
			
			
		}
	}
}