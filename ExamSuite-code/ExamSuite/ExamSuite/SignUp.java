import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener
{
	
	JLabel jlb,jlfna,jllna,jldob,jlqu,jlph,jlpw,jlem;
	JTextField jtfna,jtlna,jtdob,jtqu,jtph,jtem;
	JPasswordField jtpw;
	JButton jbsav,jblog;
	Container c;
	Connection conn;
 	PreparedStatement pstmt;
	
	SignUp()
	{
	 try
  	 {
  	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	 conn=DriverManager.getConnection("jdbc:odbc:ExamSuite","","");
  	 }
  	 catch(ClassNotFoundException e)
  	 {
  	 System.out.println("class not exception");
  	 }
  	 catch(SQLException e)
  	 {
  	 System.out.println("sql exception");
  	 }	  
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setUp()
	{
		c=getContentPane();
		setSize(900,700);
		setTitle("Exam Suite");
		c.setBackground(Color.white);
		c.setLayout(null);

		
		jlb=new JLabel(new ImageIcon("uit.jpg"));
		jlb.setBounds(0,0,900,120);
		
				
		jlfna=new JLabel("First Name");
		jlfna.setBounds(260,170,120,30);

		jtfna=new JTextField();
		jtfna.setBounds(440,170,120,30);

				
		jllna=new JLabel("Last Name");
		jllna.setBounds(260,230,120,30);

		jtlna=new JTextField();
		jtlna.setBounds(440,230,120,30);

		jldob=new JLabel("Date of Birth");
		jldob.setBounds(260,290,120,30);

		jtdob=new JTextField();
		jtdob.setBounds(440,290,120,30);

		jlqu=new JLabel("Qualification");
		jlqu.setBounds(260,350,120,30);
		
		jtqu=new JTextField();
		jtqu.setBounds(440,350,120,30);
	
		
		jlph=new JLabel("Phone No.");
		jlph.setBounds(260,410,120,30);
		
		jtph=new JTextField();
		jtph.setBounds(440,410,120,30);

		jlem=new JLabel("E mail");
		jlem.setBounds(260,470,120,30);
		
		jtem=new JTextField();
		jtem.setBounds(440,470,120,30);

		jlpw=new JLabel("Password");
		jlpw.setBounds(260,530,120,30);
		
		jtpw=new JPasswordField();
		jtpw.setBounds(440,530,120,30);
		
   		
		jbsav=new JButton("Save");	
		jbsav.setBounds(260,590,100,30);

		jblog=new JButton("Go to Login");	
		jblog.setBounds(460,590,100,30);


				
		c.add(jlb);
		c.add(jlfna);
		c.add(jtfna);
		c.add(jllna);
		c.add(jtlna);	
		c.add(jldob);
		c.add(jtdob);
		c.add(jlqu);
		c.add(jtqu);
		c.add(jlph);
		c.add(jtph);
		c.add(jlem);
		c.add(jtem);
		c.add(jlpw);
		c.add(jtpw);

		c.add(jbsav);
		c.add(jblog);
			

		jbsav.addActionListener(this);
		jblog.addActionListener(this);
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
	 Object obj=ae.getSource();
	String email=new String(" ");
		if(s.equals("Save"))
		{
			try
			{
			pstmt=conn.prepareStatement("insert into registration values(?,?,?,?,?,?,?)");

			String fname=jtfna.getText();
			pstmt.setString(2,fname);
			String lname=jtlna.getText();
			pstmt.setString(3,lname);
			String dob=jtdob.getText();
			pstmt.setString(4,dob);
			String qual=jtqu.getText();
			pstmt.setString(5,qual);
			String ph=jtph.getText();
			pstmt.setString(6,ph);
			email=jtem.getText();
			pstmt.setString(1,email);
			String pw=jtpw.getText();
			pstmt.setString(7,pw);

			pstmt.executeUpdate();
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog (this, "Error in saving the file",
						"Exam Suite - SQL Error", JOptionPane.PLAIN_MESSAGE);
							

			}
		
			JOptionPane.showMessageDialog (this, "Successful Registration ",
						"Exam Suite ", JOptionPane.PLAIN_MESSAGE);
							jtfna.setText("");
							jtlna.setText("");
							jtdob.setText("");
							jtqu.setText("");
							jtph.setText("");
							jtem.setText("");
							jtpw.setText(""); 

		}
		
		if(s.equals("Go to Login"))
		{
		new LogFom().setup();
		setVisible(false);
		}		

	}	
		
	//public static void main(String args[])
	//{
	//	SignUp rt=new SignUp();
	//	rt.setUp();
	//}
}