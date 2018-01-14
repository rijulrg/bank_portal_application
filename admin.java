import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.sql.*;
import java.awt.event.*;
import java.lang.String.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.*;
class admin extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JTextField tf1;
JPasswordField tf2;
JButton b1,b2,b3;
admin()
{
setLayout(null);
setBounds(550,250,260,200);
setVisible(true);
l1=new JLabel("ADMIN");
l1.setBounds(100,35,80,20);
l2=new JLabel("Username");
l2.setBounds(20,60,100,20);
l3=new JLabel("Password");
l3.setBounds(20,90,100,20);
tf1=new JTextField();
tf1.setBounds(120,60,100,20);
tf2=new JPasswordField();
tf2.setBounds(120,90,100,20);

Border border=BorderFactory.createRaisedBevelBorder();
Border tripleborder=new CompoundBorder(new CompoundBorder(border,border),border);
UIManager.put("Button.border",tripleborder);



b1=new JButton("Proceed");
b1.setBounds(20,130,100,20);
b1.addActionListener(this);
b2=new JButton("Exit");
b2.setBounds(140,130,80,20);
b2.addActionListener(this);
b3=new JButton("Change Password");
b3.setBounds(40,160,150,20);
setBackground(Color.blue);
b3.addActionListener(this);
getContentPane().setBackground(Color.blue);
add(l1);
add(l2);
add(tf1);
add(l3);
add(tf2);
add(b1);
add(b2);
add(b3);
tf1.requestFocus(true);
setSize(240,250);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		
			tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
		{
			PreparedStatement ps=con.prepareStatement("Select * from admin where username=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"Administration has been logged in");
				dispose();
				new login();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Not Valid");
				tf1.setText("");
				tf2.setText("");
			}
		}
		}
		else if(e1.getSource()==b2)
		{
			dispose();
		}
		else if(e1.getSource()==b3)
		{
			dispose();
			new change();
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
public static void main(String args[])
{
	admin a=new admin();
	a.setTitle("ADMIN");
	a.setResizable(false);
}
}
class login extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JTextField tf1;
JPasswordField tf2;
JButton b1,b2,b3,b4;
login()
{
setLayout(null);
setVisible(true);
setBounds(550,250,260,200);
l1=new JLabel("User Login");
l1.setBounds(95,35,80,20);
l2=new JLabel("Username");
l2.setBounds(20,60,100,20);
l3=new JLabel("Password");
l3.setBounds(20,90,100,20);
tf1=new JTextField();
tf1.setBounds(120,60,100,20);
tf2=new JPasswordField();
tf2.setBounds(120,90,100,20);
b1=new JButton("Cancel");
b1.setBounds(20,130,100,30);
b1.addActionListener(this);
b2=new JButton("Reset");
b2.setBounds(150,130,100,30);
b2.addActionListener(this);
b3=new JButton("Sign Up");
b3.setBounds(240,60,80,20);
b3.addActionListener(this);
b4=new JButton("Login");
b4.setBounds(240,90,80,20);
b4.addActionListener(this);
getContentPane().setBackground(Color.green);
add(l1);
add(l2);
add(tf1);
add(l3);
add(tf2);
add(b1);
add(b2);
add(b3);
add(b4);
tf1.requestFocus(true);
setSize(350,250);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		
		tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			dispose();
			new admin();
		}
		else if(e1.getSource()==b2)
		{
			tf1.setText("");
			tf2.setText("");
		}
		else if(e1.getSource()==b3)
		{
			dispose();
			new signup();
		}
		else if(e1.getSource()==b4)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
		{
			PreparedStatement ps=con.prepareStatement("Select * from login where username=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"User has been logged in");
				dispose();
				new epage();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Not Valid");
				tf1.setText("");
				tf2.setText("");
			}
		}
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class change extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField tf1;
	JPasswordField tf2,tf3,tf4;
	JButton b1,b2,b3,b4;
	change()
	{
		setLayout(null);
		setVisible(true);
		setBounds(550,250,350,350);
		getContentPane().setBackground(Color.blue);
		l1=new JLabel("Username");
		l1.setBounds(30,30,100,40);
		l2=new JLabel("Password");
		l2.setBounds(30,70,100,40);
		l3=new JLabel("New Password");
		l3.setBounds(30,110,100,40);
		l4=new JLabel("Confirm Password");
		l4.setBounds(30,150,120,40);
		tf1=new JTextField();
		tf1.setBounds(180,40,100,20);
		tf2=new JPasswordField();
		tf2.setBounds(180,80,100,20);
		tf3=new JPasswordField();
		tf3.setBounds(180,120,100,20);
		tf4=new JPasswordField();
		tf4.setBounds(180,160,100,20);
		b1=new JButton("Check");
		b1.setBounds(50,200,100,40);
		b1.addActionListener(this);
		b2=new JButton("Cancel");
		b2.setBounds(180,200,100,40);
		b2.addActionListener(this);
		b3=new JButton("Update");
		b3.setBounds(50,200,100,40);
		b3.addActionListener(this);
		b4=new JButton("Cancel");
		b4.setBounds(180,200,100,40);
		b4.addActionListener(this);
		add(l1);
		add(l2);
		add(b1);
		add(b2);
		add(tf1);
		add(tf2);
	}
	public  void actionPerformed(ActionEvent e1)
	{
		try
		{
			tf1.requestFocus();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
			if(e1.getSource()==b1)
			{
				if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
				{
				PreparedStatement ps=con.prepareStatement("select * from admin where username=? and password=?");
				ps.setString(1,tf1.getText());
				ps.setString(2,tf2.getText());
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					//JOptionPane.showMessageDialog(this,"verified");
					add(b3);
					add(b4);
					add(tf3);
					add(tf4);
					add(l3);
					add(l4);
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(true);
					b4.setVisible(true);
					tf3.setVisible(true);
					tf4.setVisible(true);
					l3.setVisible(true);
					l4.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Not a valid user");
				}
				}
			}
			else if(e1.getSource()==b2)
			{
				dispose();
				new admin();
			}
			else if(e1.getSource()==b3)
			{
				if(tf3.getText().equals(tf4.getText()))
				{	
				PreparedStatement ps1=con.prepareStatement("update admin set password=? where username=? and password=?");
				ps1.setString(1,tf3.getText());
				ps1.setString(2,tf1.getText());
				ps1.setString(3,tf2.getText());
				ps1.executeUpdate();
				JOptionPane.showMessageDialog(this,"password changed");
				dispose();
				new admin();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"enter same password");
					tf3.setText("");
					tf4.setText("");
				}
			}
			else if(e1.getSource()==b4)
			{
				dispose();
				new change();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Expection is +"+ex);
		}
	}
}
class signup extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JButton b1,b2,b3;
TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	signup()
	{
		setLayout(null);
		setVisible(true);
		setBounds(250,0,1000,750);
		Font f= new Font("Serif",Font.BOLD,72);
		Font f1= new Font("Ravie",Font.BOLD,16);
		setContentPane(new JLabel(new ImageIcon("2.jpg")));
		l1= new JLabel("PERSONAL DETAILS");
		l1.setFont(f);
		l1.setForeground(Color.yellow);
		l1.setBounds(150,50,1000,150);
		l2=new JLabel("Name");
		l2.setBounds(350,250,200,20);
		l2.setFont(f1);
		l2.setForeground(Color.red);
		l3=new JLabel("Date of Birth");
		l3.setBounds(350,280,200,20);
		l3.setFont(f1);
		l3.setForeground(Color.red);
		l4=new JLabel("Address");
		l4.setBounds(350,310,200,20);
		l4.setFont(f1);
		l4.setForeground(Color.red);
		l5=new JLabel("Contact No.");
		l5.setBounds(350,340,200,20);
		l5.setFont(f1);
		l5.setForeground(Color.red);
		l6=new JLabel("Gender");
		l6.setBounds(350,370,200,20);
		l6.setFont(f1);
		l6.setForeground(Color.red);
		l7=new JLabel("Religion");
		l7.setBounds(350,400,200,20);
		l7.setFont(f1);
		l7.setForeground(Color.red);
		l8=new JLabel("Category");
		l8.setBounds(350,430,200,20);
		l8.setFont(f1);
		l8.setForeground(Color.red);
		l9=new JLabel("Type of Account");
		l9.setBounds(350,460,200,20);
		l9.setFont(f1);
		l9.setForeground(Color.red);
		l10=new JLabel("Balance");
		l10.setBounds(350,490,200,20);
		l10.setFont(f1);
		l10.setForeground(Color.red);
		l11=new JLabel("Password");
		l11.setBounds(350,520,200,20);
		l11.setFont(f1);
		l11.setForeground(Color.red);
		tf1=new TextField();
		tf1.setBounds(560,250,100,20);
		tf2=new TextField();
		tf2.setBounds(560,280,100,20);
		tf3=new TextField();
		tf3.setBounds(560,310,100,20);
		tf4=new TextField();
		tf4.setBounds(560,340,100,20);
		tf5=new TextField();
		tf5.setBounds(560,370,100,20);
		tf6=new TextField();
		tf6.setBounds(560,400,100,20);
		tf7=new TextField();
		tf7.setBounds(560,430,100,20);
		tf8=new TextField();
		tf8.setBounds(560,460,100,20);
		tf9=new TextField();
		tf9.setBounds(560,490,100,20);
		tf10=new TextField();
		tf10.setBounds(560,520,100,20);
		tf10.setEchoChar('*');
		b1= new JButton("Back");
		b1.setBounds(20,20,100,50);
		b1.addActionListener(this);
		b2= new JButton("Exit");
		b2.setBounds(20,600,100,50);
		b2.addActionListener(this);
		b3= new JButton("Submit");
		b3.setBounds(820,600,100,50);
		b3.addActionListener(this);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(tf7);
		add(tf8);
		add(tf9);
		add(tf10);
		add(b1);
		add(b2);
		add(b3);
	//	tf1.requestFocus(true);
	}
	public void actionPerformed(ActionEvent e1)
	{
		try
		{
		//	tf1.requestFocus(true);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
			int accno=10000;
			if(e1.getSource()==b3)
			{
				if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals("")||tf8.getText().equals("")||tf9.getText().equals("")||tf10.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Enter all details");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					tf6.setText("");
					tf7.setText("");
					tf8.setText("");
					tf9.setText("");
					tf10.setText("");
				}
				else
				{
					PreparedStatement ps=con.prepareStatement("insert into data values(?,?,?,?,?,?,?,?,?,?,?)");
					PreparedStatement ps1=con.prepareStatement("select * from data");
					ResultSet rs=ps1.executeQuery();
					while(rs.next())
					{
						accno=rs.getInt(1);
					}
					accno++;
					ps.setInt(1,accno);
					ps.setString(2,tf1.getText());
					ps.setString(3,tf2.getText());
					ps.setString(4,tf3.getText());
					ps.setString(5,tf4.getText());
					ps.setString(6,tf5.getText());
					ps.setString(7,tf6.getText());
					ps.setString(8,tf7.getText());
					ps.setString(9,tf8.getText());
					ps.setInt(10,Integer.parseInt(tf9.getText()));
					ps.setString(11,tf10.getText());
					ps.executeUpdate();
					PreparedStatement ps2=con.prepareStatement("insert into login values(?,?)");
					ps2.setString(1,tf1.getText());
					ps2.setString(2,tf10.getText());
					ps2.executeUpdate();
					JOptionPane.showMessageDialog(this,"Your Account No is "+accno);
					dispose();
					new login();
					
				}
			}
			else if(e1.getSource()==b2)
				{
					dispose();
				}
				else if(e1.getSource()==b1)
				{
					dispose();
					new login();
				}
			}
		catch(Exception ex)
		{
			System.out.println("Expection is +"+ex);
		}
	}
}
class epage extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3;
epage()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,800);
Font f= new Font("Serif",Font.BOLD,48);
Font f1= new Font("Serif",Font.BOLD,24);
Font f2= new Font("Serif",Font.BOLD,18);
l1=new JLabel("PROJECT ON PUNJAB NATIONAL BANK");
l1.setFont(f);
l1.setBounds(30,40,1000,100);
l2=new JLabel("CHITKARA UNIVERSITY");
l2.setBounds(370,350,400,50);
l2.setFont(f1);
l3=new JLabel("RAJPURA PUNJAB");
l3.setBounds(410,400,400,50);
l3.setFont(f1);
l4=new JLabel("Submitted By: RG");
l4.setBounds(20,600,300,25);
l4.setFont(f2);
l5=new JLabel("Roll No= 1510991518");
l5.setBounds(20,625,300,25);
l5.setFont(f2);
l6=new JLabel("CSE");
l6.setBounds(20,650,300,25);
l6.setFont(f2);
ImageIcon i1=new ImageIcon("1.png");
b1=new JButton("",i1);
b1.setBounds(415,450,200,100);
b2=new JButton("Exit");
b2.setBounds(750,600,80,40);
b2.addActionListener(this);
b3=new JButton("Enter");
b3.setBounds(850,600,80,40);
b3.addActionListener(this);
getContentPane().setBackground(Color.blue);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(b1);
add(b2);
add(b3);
}
public void actionPerformed(ActionEvent e1)
	{
		try
		{
		//	tf1.requestFocus(true);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
			if(e1.getSource()==b2)
			{
				dispose();
			}
			else if(e1.getSource()==b3)
			{
				dispose();
				new details();
			}
			}
		catch(Exception ex)
		{
			System.out.println("Expection is +"+ex);
		}
	}
}
class details extends JFrame implements ActionListener
{
JLabel l1;
JButton b2,b3,b4,b5,b6,b7,b8,b9;
	details()
	{
		setLayout(null);
		setVisible(true);
		setBounds(250,0,1000,800);
		Font f= new Font("Serif",Font.BOLD,72);
		l1=new JLabel("AVAILABLE FACILITIES");
		l1.setBounds(50,30,1000,150);
		l1.setFont(f);
		l1.setForeground(Color.white);
		b2= new JButton("Transaction");
		b2.setBounds(400,330,200,20);
		b2.addActionListener(this);
		b3= new JButton("View all Accounts");
		b3.setBounds(400,360,200,20);
		b3.addActionListener(this);
		b4= new JButton("Delete an Account");
		b4.setBounds(400,390,200,20);
		b4.addActionListener(this);
		b5= new JButton("Amount Transfer");
		b5.setBounds(400,420,200,20);
		b5.addActionListener(this);
		b6= new JButton("View Transaction Details");
		b6.setBounds(400,450,200,20);
		b6.addActionListener(this);
		b7= new JButton("Any Problems");
		b7.setBounds(400,480,200,20);
		b7.addActionListener(this);
		b8= new JButton("Not Interested?");
		b8.setBounds(400,510,200,20);
		b8.addActionListener(this);
		b9= new JButton("Back");
		b9.setBounds(920,550,80,50);
		b9.addActionListener(this);
		setContentPane(new JLabel(new ImageIcon("logo.jpg")));
		add(l1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
	}
	public void actionPerformed(ActionEvent e1)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
			if(e1.getSource()==b2)
			{
				dispose();
				new transaction();
			}
			else if(e1.getSource()==b3)
			{
				dispose();
				JOptionPane.showMessageDialog(this,"Only admin can view it");
				new admin1();
			}
			else if(e1.getSource()==b4)
			{
				dispose();
				new delete();
			}
			else if(e1.getSource()==b5)
			{
				dispose();
				new transfer();
			}
			else if(e1.getSource()==b6)
			{
				dispose();
				new viewtrandetails();
			}
			else if(e1.getSource()==b7)
			{
				dispose();
				new problem();
			}
			else if(e1.getSource()==b8)
			{
				dispose();
				JOptionPane.showMessageDialog(this,"Tata Bye Bye !!!");
			}
			else if(e1.getSource()==b9)
			{
				dispose();
				new epage();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Expection is +"+ex);
		}
	}	
}
class transaction extends JFrame implements ActionListener
{
JLabel l1;
JButton b1,b2,b3,b4;
transaction()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
Font f=new Font("Serif",Font.BOLD,96);
Font f1=new Font("chiller",Font.BOLD,16);
setContentPane(new JLabel(new ImageIcon("bg.jpg")));
l1= new JLabel("Transaction Facilities");
l1.setBounds(40,30,1000,150);
l1.setFont(f);
l1.setForeground(Color.cyan);
b1=new JButton("DEPOSIT");
b1.setBounds(420,250,200,50);
b1.setFont(f1);
b1.addActionListener(this);
b2=new JButton("WITHDRAW");
b2.setBounds(420,320,200,50);
b2.setFont(f1);
b2.addActionListener(this);
b3=new JButton("VIEW ACCOUNT");
b3.setBounds(420,390,200,50);
b3.setFont(f1);
b3.addActionListener(this);
b4=new JButton("BACK");
b4.setBounds(420,460,200,50);
b4.setFont(f1);
b4.addActionListener(this);
add(l1);
add(b1);
add(b2);
add(b3);
add(b4);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			dispose();
			new deposit();
		}
		else if(e1.getSource()==b2)
		{
			dispose();
			new withdraw();
		}
		else if(e1.getSource()==b3)
		{
			dispose();
			new viewacc();
		}
		else if(e1.getSource()==b4)
		{
			dispose();
			new details();
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}	
}
class withdraw extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf3;
JPasswordField tf2;
JButton b1,b2,b3,b4;
JScrollPane sp;
JTable t1;
withdraw()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
setContentPane(new JLabel(new ImageIcon("3.jpg")));
Font f=new Font("serif",Font.BOLD,48);
Font f1=new Font("Ravie",Font.BOLD,16);
l1=new JLabel("CASH WITHDRAW");
l1.setBounds(320,30,450,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("Enter your Account No.");
l2.setBounds(150,150,400,30);
l2.setFont(f1);
l2.setForeground(Color.white);
l3=new JLabel("Password");
l3.setBounds(150,190,400,30);
l3.setFont(f1); 	
l3.setForeground(Color.white);	
l4=new JLabel("enter amount");
l4.setBounds(150,190,400,30);
l4.setFont(f1);
l4.setForeground(Color.white);

l5=new JLabel("new label");
l5.setBounds(300,340,450,30);
l5.setFont(f1);
l5.setForeground(Color.white);
l6=new JLabel("new label");
l6.setBounds(300,390,450,30);
l6.setFont(f1);
l6.setForeground(Color.white);
l7=new JLabel("new label");
l7.setBounds(300,440,450,30);
l7.setFont(f1);
l7.setForeground(Color.white);
l9=new JLabel("debited");

			
tf1=new JTextField();
tf1.setBounds(560,150,100,30);
tf2=new JPasswordField();
tf2.setBounds(560,190,100,30);
tf3=new JTextField();
tf3.setBounds(560,190,100,30);
b1=new JButton("Back");
b1.setBounds(30,30,80,50);
b1.addActionListener(this);
b2=new JButton("Verify");
b2.setBounds(500,250,80,50);
b2.addActionListener(this);
b3=new JButton("Withdraw");
b3.setBounds(500,250,140,50);
b3.addActionListener(this);
b4=new JButton("Show Records");
b4.setBounds(690,250,120,50);
b4.addActionListener(this);
add(l1);
add(l2);
add(l3);
add(tf1);
add(tf2);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			dispose();
			new transaction();
		}
		else if(e1.getSource()==b2)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"verified");
				add(l4);
				add(tf3);
				add(b3);
				add(b4);
				tf1.setEditable(false);
				l4.setVisible(true);
				b3.setVisible(true);
				b4.setVisible(true);
				tf3.setVisible(true);
				l3.setVisible(false);
				b2.setVisible(false);
				tf2.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(this,"Enter correct details");
			//dispose();
			}
		}
		else if(e1.getSource()==b3)
		{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=?");
			ps.setString(1,tf1.getText());
			Date d1=Calendar.getInstance().getTime();
			SimpleDateFormat sdf1=new SimpleDateFormat("dd:MM:yyyy;HH:mm:ss");
			l8=new JLabel(sdf1.format(d1));
			ResultSet rs=ps.executeQuery();
			int bal,cbal,nbal;
			while(rs.next())
			{
				
				bal=Integer.parseInt(tf3.getText());
				cbal=Integer.parseInt(rs.getString("balance"));
			//	System.out.print("Balance = "+cbal);
				nbal=cbal-bal;
			//	System.out.print("Balance = "+nbal);
				PreparedStatement ps1=con.prepareStatement("update data set balance=? where accountno=?");
				ps1.setInt(1,nbal);
				ps1.setString(2,tf1.getText());
				ps1.executeUpdate();
				JOptionPane.showMessageDialog(this,"withdrawed");
				add(l6);
				l6.setVisible(true);
				l6.setText("Account Previous Balance was "+ String.valueOf(cbal));
				add(l7);
				l7.setVisible(true);
				l7.setText("Account Current Balance is "+ String.valueOf(nbal));
				PreparedStatement ps2=con.prepareStatement("insert into record values(?,?,?,?)");
				ps2.setString(1,l8.getText());
				ps2.setInt(2,Integer.parseInt(tf1.getText()));
				ps2.setString(3,l9.getText());
				ps2.setInt(4,bal);
				ps2.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Saved !!!");
			}
		}
		else if(e1.getSource()==b4)
		{
			int count=0,i=0;
			String s[]={"date","Account No","Type","Amount"};
		PreparedStatement ps3=con.prepareStatement("Select count(*) from record where accountno=? and type=?");
		ps3.setInt(1,Integer.parseInt(tf1.getText()));
		ps3.setString(2,l9.getText());
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
			count=rs3.getInt(1);
		}
		String s1[][]=new String[count][4];
		PreparedStatement ps4=con.prepareStatement("Select * from record where accountno=? and type=?");
		ps4.setInt(1,Integer.parseInt(tf1.getText()));
		ps4.setString(2,l9.getText());
		ResultSet rs4=ps4.executeQuery();
		while(rs4.next())
		{
			s1[i][0]=rs4.getString(1);
			s1[i][1]=rs4.getString(2);
			s1[i][2]=rs4.getString(3);
			s1[i][3]=rs4.getString(4);
			i++;
		}
		t1=new JTable(s1,s);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		sp=new JScrollPane(t1,v,h);
		sp.setVisible(true);
		sp.setBounds(50,550,250,100);
		add(sp);
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class deposit extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf3;
JPasswordField tf2;
JTable t1;
JScrollPane sp;
JButton b1,b2,b3,b4;
deposit()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
setContentPane(new JLabel(new ImageIcon("3.jpg")));
Font f=new Font("serif",Font.BOLD,48);
Font f1=new Font("Ravie",Font.BOLD,16);
l1=new JLabel("CASH DEPOSIT");
l1.setBounds(350,30,400,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("Enter your Account No.");
l2.setBounds(150,150,400,30);
l2.setFont(f1);
l2.setForeground(Color.white);
l3=new JLabel("Password");
l3.setBounds(150,190,400,30);
l3.setFont(f1);
l3.setForeground(Color.white);
l4=new JLabel("enter amount");
l4.setBounds(150,190,400,30);
l4.setFont(f1);
l4.setForeground(Color.white);





l5=new JLabel("new label");
l5.setBounds(300,340,450,30);
l5.setFont(f1);
l5.setForeground(Color.white);
l6=new JLabel("new label");
l6.setBounds(300,390,450,30);
l6.setFont(f1);
l6.setForeground(Color.white);
l7=new JLabel("new label");
l7.setBounds(300,440,450,30);
l7.setFont(f1);
l7.setForeground(Color.white);
l9=new JLabel("credited");

tf1=new JTextField();
tf1.setBounds(560,150,100,30);
tf2=new JPasswordField();
tf2.setBounds(560,190,100,30);
tf3=new JTextField();
tf3.setBounds(560,190,100,30);
b1=new JButton("Back");
b1.setBounds(30,30,80,50);
b1.addActionListener(this);
b2=new JButton("Verify");
b2.setBounds(500,250,80,50);
b2.addActionListener(this);
b3=new JButton("Deposit");
b3.setBounds(500,250,80,50);
b3.addActionListener(this);
b4=new JButton("Show Records");
b4.setBounds(590,250,120,50);
b4.addActionListener(this);
add(l1);
add(l2);
add(l3);
add(tf1);
add(tf2);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			dispose();
			new transaction();
		}
		else if(e1.getSource()==b2)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"verified");
				add(l4);
				add(tf3);
				add(b3);
				add(b4);
				tf1.setEditable(false);
				l4.setVisible(true);
				b4.setVisible(true);
				b3.setVisible(true);
				tf3.setVisible(true);
				l3.setVisible(false);
				b2.setVisible(false);
				tf2.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(this,"Enter correct details");
			//dispose();
			}
		}
		else if(e1.getSource()==b3)
		{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=?");
			ps.setString(1,tf1.getText());
Date d1=Calendar.getInstance().getTime();
			SimpleDateFormat sdf1=new SimpleDateFormat("dd:MM:yyyy;HH:mm:ss");
			l8=new JLabel(sdf1.format(d1));
			ResultSet rs=ps.executeQuery();
			int bal,cbal,nbal;
			while(rs.next())
			{
		
				bal=Integer.parseInt(tf3.getText());
				cbal=Integer.parseInt(rs.getString("balance"));
				//System.out.print("Balance = "+cbal);
				nbal=cbal+bal;
				//System.out.print("Balance = "+nbal);
				PreparedStatement ps1=con.prepareStatement("update data set balance=? where accountno=?");
				ps1.setInt(1,nbal);
				ps1.setString(2,tf1.getText());
				ps1.executeUpdate();
				JOptionPane.showMessageDialog(this,"Deposited");
			//	l5.setText("Account No is "+ String.valueOf(a));
				//add(l5);
				//l5.setVisible(true);
				add(l6);
				l6.setVisible(true);
				l6.setText("Account Previous Balance was "+ String.valueOf(cbal));
				add(l7);
				l7.setVisible(true);
				l7.setText("Account Current Balance is "+ String.valueOf(nbal));
				PreparedStatement ps2=con.prepareStatement("insert into record values(?,?,?,?)");
				ps2.setString(1,l8.getText());
				ps2.setInt(2,Integer.parseInt(tf1.getText()));
				ps2.setString(3,l9.getText());
				ps2.setInt(4,bal);
				ps2.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Saved !!!");
			}
		}
		else if(e1.getSource()==b4)
		{
			int count=0,i=0;
			String s[]={"date","Account No","Type","Amount"};
		PreparedStatement ps3=con.prepareStatement("Select count(*) from record where accountno=? and type=?");
		ps3.setInt(1,Integer.parseInt(tf1.getText()));
		ps3.setString(2,l9.getText());
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
			count=rs3.getInt(1);
		}
		String s1[][]=new String[count][4];
		PreparedStatement ps4=con.prepareStatement("Select * from record where accountno=? and type=?");
		ps4.setInt(1,Integer.parseInt(tf1.getText()));
		ps4.setString(2,l9.getText());
		ResultSet rs4=ps4.executeQuery();
		while(rs4.next())
		{
			s1[i][0]=rs4.getString(1);
			s1[i][1]=rs4.getString(2);
			s1[i][2]=rs4.getString(3);
			s1[i][3]=rs4.getString(4);
			i++;
		}
		t1=new JTable(s1,s);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		sp=new JScrollPane(t1,v,h);
		sp.setVisible(true);
		sp.setBounds(50,550,250,100);
		add(sp);
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class transfer extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
JTextField tf1,tf3,tf4;
JPasswordField tf2;
JButton b1,b2,b3;
transfer()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
Font f=new Font("Serif",Font.BOLD,36);
setContentPane(new JLabel(new ImageIcon("rg.jpg")));
l1=new JLabel("Enter Account No of debitting person");
l1.setBounds(20,50,700,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("Password");
l2.setBounds(20,100,700,80);
l2.setFont(f);
l2.setForeground(Color.white);
l4=new JLabel("Enter Amount");
l4.setBounds(20,100,700,80);
l4.setFont(f);
l4.setForeground(Color.white);
l3=new JLabel("Enter Account No of crediting person");
l3.setBounds(20,150,700,80);
l3.setFont(f);
l3.setForeground(Color.white);
tf1=new JTextField();
tf1.setBounds(800,80,100,30);
tf2=new JPasswordField();
tf2.setBounds(800,130,100,30);
tf4=new JTextField();
tf4.setBounds(800,130,100,30);
tf3=new JTextField();
tf3.setBounds(800,180,100,30); 
b1=new JButton("Check");
b1.setBounds(100,300,80,50);
b1.addActionListener(this);
b3=new JButton("transfer");
b3.setBounds(100,300,80,50);
b3.addActionListener(this);
b2=new JButton("Exit");
b2.setBounds(700,300,80,50);
b2.addActionListener(this);
add(l1);
add(l2);
add(l3);
add(tf1);
add(tf2);
add(tf3);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("Select * from data where accountno=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"Account verified");
				tf1.setEditable(false);
				tf3.setEditable(false);
				tf2.setVisible(false);
				l2.setVisible(false);
				l4.setVisible(true);
				tf4.setVisible(true);
				b1.setVisible(false);
				b3.setVisible(true);
				add(l4);
				add(tf4);
				add(b3);
			}
			else
				JOptionPane.showMessageDialog(this,"Enter correct details");
			}
		}
		else if(e1.getSource()==b2)
		{
			dispose();
		}
		else if(e1.getSource()==b3)
		{
			int tamt,camt,damt;
			tamt=Integer.parseInt(tf4.getText());
			PreparedStatement p=con.prepareStatement("Select * from data where accountno=?");
			p.setString(1,tf1.getText());
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				damt=Integer.parseInt(rs.getString("balance"));
				damt=damt-tamt;
				PreparedStatement p1=con.prepareStatement("update data set balance=? where accountno=?");
				
				p1.setInt(1,damt);
				p1.setString(2,tf1.getText());
				p1.executeUpdate();
			}
			PreparedStatement p1=con.prepareStatement("Select * from data where accountno=?");
			p1.setString(1,tf3.getText());
			ResultSet rs1=p1.executeQuery();
			if(rs1.next())
			{
				camt=Integer.parseInt(rs1.getString("balance"));
				camt=camt+tamt;
				PreparedStatement p2=con.prepareStatement("update data set balance=? where accountno=?");
				p2.setInt(1,camt);
				p2.setString(2,tf3.getText());
				p2.executeUpdate();
			}
			JOptionPane.showMessageDialog(this,"Money Transfered !!!");
			dispose();
			new details();
		}
	}
catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class delete extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
JButton b1,b2,b3;
JTextField tf1,tf4;
JPasswordField tf2,tf3;
delete()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
Font f=new Font("Arial",Font.BOLD,36);
setContentPane(new JLabel(new ImageIcon("bg2.jpg")));
l1= new JLabel("Enter Account No");
l1.setBounds(140,90,400,50);
l1.setFont(f);
l2=new JLabel("Enter Password");
l2.setBounds(140,140,400,50);
l2.setFont(f);
l3=new JLabel("Enter Admin Password");
l3.setBounds(140,140,400,50);
l3.setFont(f);
l4=new JLabel("Enter Account Username");
l4.setBounds(140,190,430,50);
l4.setFont(f);
tf1=new JTextField();
tf1.setBounds(620,100,100,40);
tf2=new JPasswordField();
tf2.setBounds(620,150,100,40);
tf3=new JPasswordField();
tf3.setBounds(620,150,100,40);
tf4=new JTextField();
tf4.setBounds(620,200,100,40);
b1=new JButton("check");
b1.setBounds(800,120,80,50);
b1.addActionListener(this);
b3=new JButton("delete");
b3.setBounds(800,120,80,50);
b3.addActionListener(this);
b2=new JButton("back");
b2.setBounds(30,30,80,50);
b2.addActionListener(this);
add(l1);
add(l2);
add(b1);
add(b2);
add(tf1);
add(tf2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("Select * from data where accountno=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				tf1.setEditable(false);
				tf2.setVisible(false);
				l2.setVisible(false);
				b1.setVisible(false);
				add(b3);
				b3.setVisible(true);
				tf3.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				tf4.setVisible(true);
				add(tf3);
				add(tf4);
				add(l4);
				add(l3);
				JOptionPane.showMessageDialog(this,"Account verified");
				JOptionPane.showMessageDialog(this,"Enter Admin Password");
			}
			else
				JOptionPane.showMessageDialog(this,"enter correct details");
			}
		}
		else if(e1.getSource()==b2)
		{
			dispose();
			new details();
		}
		else if(e1.getSource()==b3)
		{
			PreparedStatement ps1=con.prepareStatement("Select * from admin where password=?");
			ps1.setString(1,tf3.getText());
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
			PreparedStatement ps=con.prepareStatement("delete from data where accountno=?");
			ps.setString(1,tf1.getText());
			ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from login where username=? and password=?");
			ps2.setString(1,tf4.getText());
			ps2.setString(2,tf2.getText());
			ps2.executeUpdate();
			JOptionPane.showMessageDialog(this,"Account deleted !!!");
			dispose();
			new details();
			}
			else
			{
				tf3.setText("");
				JOptionPane.showMessageDialog(this,"Enter Correct Password");
			}
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class admin1 extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JTextField tf1;
JPasswordField tf2;
JButton b1,b2;
admin1()
{
setLayout(null);
setVisible(true);
setBounds(550,250,240,250);
l1=new JLabel("ADMIN");
l1.setBounds(100,35,80,20);
l2=new JLabel("Username");
l2.setBounds(20,60,100,20);
l3=new JLabel("Password");
l3.setBounds(20,90,100,20);
tf1=new JTextField();
tf1.setBounds(120,60,100,20);
tf2=new JPasswordField();
tf2.setBounds(120,90,100,20);
b1=new JButton("Proceed");
b1.setBounds(20,130,100,20);
b1.addActionListener(this);
b2=new JButton("Back");
b2.setBounds(140,130,80,20);
b2.addActionListener(this);
setBackground(Color.blue);
getContentPane().setBackground(Color.green);
add(l1);
add(l2);
add(tf1);
add(l3);
add(tf2);
add(b1);
add(b2);
tf1.requestFocus(true);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("Select * from admin where username=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"Administration has been logged in");
				dispose();
				new viewall();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Not Valid");
				tf1.setText("");
				tf2.setText("");
			}
			}
		}
		else if(e1.getSource()==b2)
		{
			dispose();
			new details();
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class viewall extends JFrame implements ActionListener
{
	JLabel l1;
JTable t1;
JScrollPane sp;
String s[]={"Account No","Name","DOB","Address","Contact No","Gender","Religion","Category","Acc Type","Balance"};
JButton b1;
viewall()
{
	try
	{
		setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
Font f= new Font("Serif",Font.BOLD,72);
l1=new JLabel("ACCOUNT DETAILS");
l1.setBounds(130,30,1000,150);
l1.setFont(f);
l1.setForeground(Color.white);
b1= new JButton("Back");
b1.setBounds(920,550,80,50);
b1.addActionListener(this);
setContentPane(new JLabel(new ImageIcon("logo.jpg")));
add(l1);
add(b1);
		int count=0,i=0;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		PreparedStatement ps=con.prepareStatement("Select count(*) from data");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			count=rs.getInt(1);
		}
		String s1[][]=new String[count][10];
		PreparedStatement ps1=con.prepareStatement("Select * from data");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			s1[i][0]=rs1.getString(1);
			s1[i][1]=rs1.getString(2);
			s1[i][2]=rs1.getString(3);
			s1[i][3]=rs1.getString(4);
			s1[i][4]=rs1.getString(5);
			s1[i][5]=rs1.getString(6);
			s1[i][6]=rs1.getString(7);
			s1[i][7]=rs1.getString(8);
			s1[i][8]=rs1.getString(9);
			s1[i][9]=rs1.getString(10);
			i++;
		}
		t1=new JTable(s1,s);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		sp=new JScrollPane(t1,v,h);
		sp.setVisible(true);
		sp.setBounds(50,200,850,400);
		add(sp);

	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
public void actionPerformed(ActionEvent e1)
{
		if(e1.getSource()==b1)
		{
			dispose();
			new details();
		}	
}
}
class viewacc extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
JTextField tf1,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
JPasswordField tf2;
JButton b1,b2,b3,b4,b5;
viewacc()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
setContentPane(new JLabel(new ImageIcon("3.jpg")));
Font f=new Font("serif",Font.BOLD,48);
Font f1=new Font("Ravie",Font.BOLD,16);
l1=new JLabel("VIEW ACCOUNT");
l1.setBounds(320,30,450,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("Enter your Account No.");
l2.setBounds(150,150,400,30);
l2.setFont(f1);
l2.setForeground(Color.white);
l3=new JLabel("Password");
l3.setBounds(150,190,400,30);
l3.setFont(f1);
l3.setForeground(Color.white);
l4=new JLabel("Name = ");
l4.setBounds(250,330,400,30);
l4.setFont(f1);
l4.setForeground(Color.white);
l5=new JLabel("D.O.B = ");
l5.setBounds(250,360,400,30);
l5.setFont(f1);
l5.setForeground(Color.white);
l6=new JLabel("Address = ");
l6.setBounds(250,390,400,30);
l6.setFont(f1);
l6.setForeground(Color.white);
l7=new JLabel("Contact No = "); 
l7.setBounds(250,420,400,30);
l7.setFont(f1);
l7.setForeground(Color.white);	
l8=new JLabel("Gender = "); 	
l8.setBounds(250,450,400,30);
l8.setFont(f1);
l8.setForeground(Color.white);
l9=new JLabel("Category = "); 
l9.setBounds(250,480,400,30);
l9.setFont(f1);
l9.setForeground(Color.white);	
l10=new JLabel("Balance = "); 
l10.setBounds(250,510,400,30);
l10.setFont(f1);
l10.setForeground(Color.white);	
l11=new JLabel("Password = ");
l11.setBounds(250,540,400,30);
l11.setFont(f1);
l11.setForeground(Color.white); 	


l12=new JLabel("new label");
l12.setBounds(450,330,400,30);
l12.setFont(f1);
l12.setForeground(Color.white);
l13=new JLabel("new label");
l13.setBounds(450,360,400,30);
l13.setFont(f1);
l13.setForeground(Color.white);
l14=new JLabel("new label");
l14.setBounds(450,390,400,30);
l14.setFont(f1);
l14.setForeground(Color.white);
l15=new JLabel("new label"); 
l15.setBounds(450,420,400,30);
l15.setFont(f1);
l15.setForeground(Color.white);	
l16=new JLabel("new label"); 	
l16.setBounds(450,450,400,30);
l16.setFont(f1);
l16.setForeground(Color.white);
l17=new JLabel("new label"); 
l17.setBounds(450,480,400,30);
l17.setFont(f1);
l17.setForeground(Color.white);	
l18=new JLabel("new label"); 
l18.setBounds(450,510,400,30);
l18.setFont(f1);
l18.setForeground(Color.white);	
l19=new JLabel("new label");
l19.setBounds(450,540,400,30);
l19.setFont(f1);
l19.setForeground(Color.white); 	




tf4=new JTextField();
tf4.setBounds(450,330,100,30);
tf5=new JTextField();
tf5.setBounds(450,360,100,30);
tf6=new JTextField();
tf6.setBounds(450,390,100,30);
tf7=new JTextField(); 
tf7.setBounds(450,420,100,30);	
tf8=new JTextField(); 	
tf8.setBounds(450,450,100,30);
tf9=new JTextField(); 
tf9.setBounds(450,480,100,30);	
tf10=new JTextField(); 
tf10.setBounds(450,510,100,30);
tf11=new JTextField();
tf11.setBounds(450,540,100,30);




				
tf1=new JTextField();
tf1.setBounds(560,150,100,30);
tf2=new JPasswordField();
tf2.setBounds(560,190,100,30);
b1=new JButton("Back");
b1.setBounds(30,30,80,50);
b1.addActionListener(this);
b2=new JButton("Verify");
b2.setBounds(500,250,80,50);
b2.addActionListener(this);
b3=new JButton("View");
b3.setBounds(420,250,80,50);
b3.addActionListener(this);
b4=new JButton("update");
b4.setBounds(520,250,80,50);
b4.addActionListener(this);
b5=new JButton("Save");
b5.setBounds(520,250,80,50);
b5.addActionListener(this);
add(l1);
add(l2);
add(l3);

add(tf1);
add(tf2);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			dispose();
			new transaction();
		}
		else if(e1.getSource()==b2)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=? and password=?");
			ps.setString(1,tf1.getText());
			ps.setString(2,tf2.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				//add(l4);
				add(b3);
				add(b4);
				tf1.setEditable(false);
				tf2.setEditable(false);
				//l4.setVisible(true);
				b3.setVisible(true);
				b4.setVisible(true);
				b2.setVisible(false);
				//b4.setVisible(true);
				//tf3.setVisible(true);
				//l3.setVisible(false);
				JOptionPane.showMessageDialog(this,"verified");
				//tf2.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(this,"Enter correct details");
			//dispose();
			}
		}
		else if(e1.getSource()==b3)
		{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=?");
			ps.setString(1,tf1.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				l12.setText(rs.getString("name"));
				l13.setText(rs.getString("datebirth"));
				l14.setText(rs.getString("address"));
				l15.setText(rs.getString("contactno"));
				l16.setText(rs.getString("gender"));
				l17.setText(rs.getString("category"));
				l18.setText(rs.getString("balance"));
				l19.setText(rs.getString("password"));
			}
			add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l10);
add(l11);
add(l12);
add(l13);
add(l14);
add(l15);
add(l16);
add(l17);
add(l18);
add(l19);

l4.setVisible(true);
l5.setVisible(true);
l6.setVisible(true);
l7.setVisible(true);
l8.setVisible(true);
l9.setVisible(true);
l10.setVisible(true);
l11.setVisible(true);
l12.setVisible(true);
l13.setVisible(true);
l14.setVisible(true);
l15.setVisible(true);
l16.setVisible(true);
l17.setVisible(true);
l18.setVisible(true);
l19.setVisible(true);
		}
		else if (e1.getSource() == b4)
		{
			PreparedStatement ps=con.prepareStatement("select * from data where accountno=?");
			ps.setString(1,tf1.getText());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				tf4.setText(rs.getString("name"));
				tf5.setText(rs.getString("datebirth"));
				tf6.setText(rs.getString("address"));
				tf7.setText(rs.getString("contactno"));
				tf8.setText(rs.getString("gender"));
				tf9.setText(rs.getString("category"));
				tf10.setText(rs.getString("balance"));
				tf11.setText(rs.getString("password"));
			}
			add(l12);
add(tf4);
add(tf5);
add(tf6);
add(tf7);
add(tf8);
add(tf9);
add(tf10);
add(tf11);
add(b5);
b3.setVisible(false);
b4.setVisible(false);
b5.setVisible(true);
tf4.setVisible(true);
tf5.setVisible(true);
tf6.setVisible(true);
tf7.setVisible(true);
tf8.setVisible(true);
tf9.setVisible(true);
tf10.setVisible(true);
tf11.setVisible(true);
l12.setVisible(false);
l13.setVisible(false);
l14.setVisible(false);
l15.setVisible(false);
l16.setVisible(false);
l17.setVisible(false);
l18.setVisible(false);
l19.setVisible(false);

tf4.setEditable(false);
tf5.setEditable(false);
tf8.setEditable(false);
tf10.setEditable(false);


		}
		else if(e1.getSource()==b5)
		{
			PreparedStatement ps=con.prepareStatement("update data set address=?,contactno=?,category=?,password=? where accountno=?");
			ps.setString(1,tf6.getText());
			ps.setString(2,tf7.getText());
			ps.setString(3,tf9.getText());
			ps.setString(4,tf11.getText());
			ps.setString(5,tf1.getText());
			ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("update login set password=? where username=?");
			ps1.setString(1,tf11.getText());
			ps1.setString(2,tf4.getText());
			ps1.executeUpdate();
			JOptionPane.showMessageDialog(this,"UPDATED !!!");
			dispose();
			new viewacc();
		}
	}
	catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class viewtrandetails extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
JTextField tf1,tf3,tf4;
JPasswordField tf2;
JButton b1,b2,b3;
JTable t1;
JScrollPane sp;
String s[]={"Date","Account No","Acc Type","Amount"};
viewtrandetails()
{
setLayout(null);
setVisible(true);
setBounds(250,0,1000,750);
Font f=new Font("Serif",Font.BOLD,36);
setContentPane(new JLabel(new ImageIcon("rg.jpg")));
l1=new JLabel("Enter Account No: ");
l1.setBounds(20,50,700,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("Password");
l2.setBounds(20,100,700,80);
l2.setFont(f);
l2.setForeground(Color.white);
tf1=new JTextField();
tf1.setBounds(800,80,100,30);
tf2=new JPasswordField();
tf2.setBounds(800,130,100,30);
b1=new JButton("view");
b1.setBounds(600,200,80,50);
b1.addActionListener(this);
b2=new JButton("back");
b2.setBounds(700,200,80,50);
b2.addActionListener(this);
add(l1);
add(l2);
add(tf1);
add(tf2);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent e1)
{
	try
	{
		tf1.requestFocus(true);
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:studentdsn");
		if(e1.getSource()==b1)
		{
			if(tf1.getText().equals("")||tf2.getText().equals(""))
			JOptionPane.showMessageDialog(this,"Complete the fields");
			else
			{
		PreparedStatement ps=con.prepareStatement("select * from data where accountno=? and password=?"	);
		ps.setString(1,tf1.getText());
		ps.setString(2,tf2.getText());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			int count=0,i=0;
			PreparedStatement ps1=con.prepareStatement("select count(*) from record where accountno=?"	);
			ps1.setString(1,tf1.getText());
			ResultSet rs1=ps.executeQuery();
			while(rs1.next())
		{
			count=rs1.getInt(1);
		}
		String s1[][]=new String[count][4];
		
		
		
		
		PreparedStatement ps2=con.prepareStatement("Select * from record where accountno=?");
		ps2.setString(1,tf1.getText());
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			s1[i][0]=rs2.getString(1);
			s1[i][1]=rs2.getString(2);
			s1[i][2]=rs2.getString(3);
			s1[i][3]=rs2.getString(4);
			i++;
		}
		t1=new JTable(s1,s);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		sp=new JScrollPane(t1,v,h);
		sp.setVisible(true);
		sp.setBounds(50,280,850,300);
		add(sp);
		
		
		
		
		
		}
	else
		JOptionPane.showMessageDialog(this,"Enter correct details");
			}
		}
		else if(e1.getSource()==b2)
		{
			dispose();
			new details();
		}
	}
catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
}
}
class problem extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	JButton b1,b2;
	problem()
	{
		setLayout(null);
setVisible(true);
setContentPane(new JLabel(new ImageIcon("2.jpg")));
setBounds(250,0,1000,750);
Font f=new Font("serif",Font.BOLD,48);
Font f1=new Font("Ravie",Font.BOLD,16);
l1=new JLabel("Enter your Complaint");
l1.setBounds(320,30,500,80);
l1.setFont(f);
l1.setForeground(Color.white);
l2=new JLabel("NAME:");
l2.setBounds(150,150,100,30);
l2.setFont(f1);
l2.setForeground(Color.white);
l3=new JLabel("COMPLAINT:");
l3.setBounds(150,190,150,30);
l3.setFont(f1); 	
l3.setForeground(Color.white);	
tf1=new JTextField();
tf1.setBounds(360,150,200,30);
tf2=new JTextField();
tf2.setBounds(360,190,200,30);
b1=new JButton("Back");
b1.setBounds(30,30,80,50);
b1.addActionListener(this);
b2=new JButton("Submit");
b2.setBounds(500,250,80,50);
b2.addActionListener(this);
add(l1);
add(l2);
add(l3);
add(tf1);
add(tf2);
add(b1);
add(b2);
	}
	public void actionPerformed(ActionEvent e1)
	{
		try
		{
			if(e1.getSource()==b2)
			{
				JOptionPane.showMessageDialog(this,"submitted");
				dispose();
				new details();
			}
			else if(e1.getSource()==b1)
			{
				dispose();
				new details();
			}
		}
		catch(Exception ex)
	{
		System.out.println("Expection is +"+ex);
	}
	}
}