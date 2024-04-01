
package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener  {
	JTextField panTextField,aadharTextField;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religionTextField,categoryTextField,educationTextField,occupationTextField,incomeTextField;
	String formno;
	SignUpTwo(String formno){
		this.formno = formno;
		setSize(850,1000);
		setLocation(250,0);
		setLayout(null);
		setVisible(true);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		
		JLabel additonalDetails = new JLabel("Page 2 : Additional Details");
		additonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additonalDetails.setBounds(290,80,400,30);
		add(additonalDetails);
		
		
		
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String valReligion[] = {"Hinduism","Islam","Sikh","Christian","Others"};
		religionTextField = new JComboBox(valReligion);
		religionTextField.setBounds(300, 140, 400, 30);
		religionTextField.setBackground(Color.white);
		add(religionTextField);
		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,190,200,30);
		add(category);
		
		String valCategory[] = {"General","OBC","SC","ST","Others"};
		categoryTextField = new JComboBox(valCategory);
		categoryTextField.setBounds(300, 190, 400, 30);
		categoryTextField.setBackground(Color.white);
		categoryTextField.setBackground(Color.white);
		add(categoryTextField);
		
		
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		
		String valIncome[] = {"NIL","< 50,000" ,"< 1,50,000","< 2,50,000","<5,00,000","Upto 10,00,0000"};
		incomeTextField = new JComboBox(valIncome);
		incomeTextField.setBounds(300, 240, 400, 30);
		incomeTextField.setBackground(Color.white);
		add(incomeTextField);
	
		
		JLabel educational = new JLabel("Educational");
		educational.setFont(new Font("Raleway",Font.BOLD,20));
		educational.setBounds(100,290,200,30);
		add(educational);
		
	
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100,315,200,30);
		add(qualification);
	
		
		String valEducation[] = {"Non-Graduate","Graduate" ,"Post-Graduate","Doctrate","Others"};
		educationTextField = new JComboBox(valEducation);
		educationTextField.setBounds(300, 315, 400, 30);
		educationTextField.setBackground(Color.white);
		add(educationTextField); 
		
	
		
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,390,200,30);
		add(occupation);
	
		
		String occupationVal[] = {"Salaried","Graduate" ,"Self-Employed","Business","Student","Retired","Others"};
		occupationTextField = new JComboBox(occupationVal);
		occupationTextField.setBounds(300, 390, 400, 30);
		occupationTextField.setBackground(Color.white);
		add(occupationTextField); 
		
		
		
		
		
		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,440,200,30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway",Font.BOLD,14));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
		
		JLabel aadhar = new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100,490,200,30);
		add(aadhar);
		
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
		aadharTextField.setBounds(300,490,400,30);
		add(aadharTextField);
		
		JLabel senior = new JLabel("Senior Citizen:");
		senior.setFont(new Font("Raleway",Font.BOLD,20));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		
		syes = new JRadioButton("Yes");
		syes.setFont(new Font("Raleway",Font.BOLD,14));
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setFont(new Font("Raleway",Font.BOLD,14));
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup scitizen = new ButtonGroup();
		scitizen.add(syes);
		scitizen.add(sno);
		
		JLabel exaccount = new JLabel("Existing Account:");
		exaccount.setFont(new Font("Raleway",Font.BOLD,20));
		exaccount.setBounds(100,590,200,30);
		add(exaccount);
		
		
		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway",Font.BOLD,14));
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway",Font.BOLD,14));
		eno.setBackground(Color.white);
		eno.setBounds(450,590,100,30);
		add(eno);
		
		ButtonGroup eaccount =new ButtonGroup();
		eaccount.add(eyes);
		eaccount.add(eno);
		

		
		
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
//	
		String sreligion = (String)religionTextField.getSelectedItem();
		String scategory = (String) categoryTextField.getSelectedItem();
		String sincome  = (String) incomeTextField.getSelectedItem();
		String seducation = (String) educationTextField.getSelectedItem();
		String soccupation = (String) occupationTextField.getSelectedItem();
		String seniorcitizen = null;
		if(syes.isSelected())
		{
			seniorcitizen = "Yes";
		}
		else if(sno.isSelected())
		{
			seniorcitizen="No";
		
		}
				
		String existingaccount = null;
		if(eyes.isSelected()) {
			existingaccount="Yes";
		}else if(eno.isSelected())
		{	existingaccount="No";
		}
		
		String span = panTextField.getText();
		String saadhar = aadharTextField.getText();
		
	
		try {
	
			Conn c = new Conn(); 
			String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+seducation+
	"', '"+sincome+"', '"+soccupation+"', '"+span+"', '"+saadhar+"','"+seniorcitizen+"', '"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			
			
			setVisible(false);
			
			new SignUpThree(formno).setVisible(true);
		}catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public static void main(String args[]) {
		new SignUpTwo("");
	}

}
