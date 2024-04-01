package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.*;

public class SignUpOne extends JFrame implements ActionListener {
	
	
	long random;
	JTextField nameField,fnameField,emailField,addressField,cityField,stateField,pincodeField;
	JButton next;
	JRadioButton male,female,married,unmarried,others;
	JDateChooser datechooser;
	SignUpOne(){
		
		setSize(850,1000);
		setLocation(250,0);
		setLayout(null);
		setVisible(true);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong()% 9000L )+1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO: "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20, 600, 40);
		add(formno);
		
		JLabel personalDetail = new JLabel("Page 1 : Personal Details");
		personalDetail.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetail.setBounds(290,80, 400, 30);
		add(personalDetail);
		
		
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Raleway",Font.BOLD,14));
		nameField.setBounds(300,140,400,30);
		add(nameField);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameField.setBounds(300,190,400,30);
		add(fnameField);
		
		
		
		JLabel dob = new JLabel("Date Of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		datechooser = new JDateChooser();
		datechooser.setBounds(300,240,400,30);
		datechooser.setBackground(Color.black);
		datechooser.setForeground(Color.white);
		add(datechooser);
		
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 120, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		JLabel Email = new JLabel("Email:");
		Email.setFont(new Font("Raleway",Font.BOLD,20));
		Email.setBounds(100,340,200,30);
		add(Email);
		
		
		emailField = new JTextField();
		emailField.setFont(new Font("Raleway",Font.BOLD,14));
		emailField.setBounds(300,340,400,30);
		add(emailField);
		
		
		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		others = new JRadioButton("Others");
		others.setBounds(630, 390, 100, 30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		gendergroup.add(others);
		gendergroup.add(married);
		gendergroup.add(unmarried);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Raleway",Font.BOLD,14));
		addressField.setBounds(300,440,400,30);
		add(addressField);
		
		JLabel city = new JLabel("City");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Raleway",Font.BOLD,14));
		cityField.setBounds(300,490,400,30);
		add(cityField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateField = new JTextField();
		stateField.setFont(new Font("Raleway",Font.BOLD,14));
		stateField.setBounds(300,540,400,30);
		add(stateField);
		
		
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeField = new JTextField();
		pincodeField.setFont(new Font("Raleway",Font.BOLD,14));
		pincodeField.setBounds(300,590,400,30);
		add(pincodeField);
		
		
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(620,630,80,30);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.white);
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno = "" +random;
		String name = nameField.getText();
		String fname = fnameField.getText();
		String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String sgender = null;
		if(male.isSelected())
			sgender = "Male";
		else if(female.isSelected())
			sgender="Female";
		
		String email = emailField.getText();
		String marital = null;
		
		if(married.isSelected())
			marital ="Married";
		else if(unmarried.isSelected())
			marital="Unmarried";
		else if(others.isSelected())
			marital="others";
		
		String address = addressField.getText();
		String city = cityField.getText();
		String state = stateField.getText();
		String pincode = pincodeField.getText();
		
		//Validations
		try {
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name is required");
		}
		else
		{
			Conn c = new Conn(); 
			String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+
					"', '"+sgender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+
					pincode+"', '"+state+"')";
			c.s.executeUpdate(query);
			setVisible(false);
			new SignUpTwo(formno).setVisible(true);
			}
	}catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	
	public static void main(String args[]) {
		new SignUpOne();
	}
}
