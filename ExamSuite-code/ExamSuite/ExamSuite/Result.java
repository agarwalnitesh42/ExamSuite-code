import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Result extends JFrame implements ActionListener
{
	
	JLabel jlb,jlna,jlex,jlpr,jlst,res;
	JTextField jtna,jtex,jtpr,jtst;
	JButton jbexit,jbhm;
	Container c;
	 Connection conn;
 	PreparedStatement pstmt;
	String email,exam,fn,ln,name,per,st,el;
	int an;
	Result(String eml,String ex,int ans, String elig)
	{	
		email=eml;
		exam=ex;
		an=ans;
		el=elig;
	 try
  	 {
  	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	 conn=DriverManager.getConnection("jdbc:odbc:ExamSuite","","");
  	 
	pstmt=conn.prepareStatement("select * from registration where email= ?");
	pstmt.setString(1,email);
	ResultSet rs=pstmt.executeQuery(); 
	while(rs.next())
	{
	fn=rs.getString("fname");
	ln=rs.getString("lname");
	}

	/*pstmt=conn.prepareStatement("select * from result where email= ? and exam=?");
	pstmt.setString(1,email);
	pstmt.setString(2,exam);
	 rs=pstmt.executeQuery(); 
	while(rs.next())
	{
	per=rs.getString("percent");
	st=rs.getString("status");
	}*/
	
	
	}
  	 catch(ClassNotFoundException e)
  	 {
  	 System.out.println("class not exception");
  	 }
  	 catch(SQLException e)
  	 {
  	 System.out.println("sql exception");
  	 }	  

	name=fn+" "+ln;

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
		
		res=new JLabel("RESULT");
		res.setBounds(400,150,120,30);

		
		jlna=new JLabel("Name");
		jlna.setBounds(260,230,120,30);

		jtna=new JTextField(name);
		jtna.setBounds(440,230,120,30);

				
		jlex=new JLabel("Exam");
		jlex.setBounds(260,290,120,30);

		jtex=new JTextField(exam);
		jtex.setBounds(440,290,120,30);

		jlpr=new JLabel("Percentage");
		jlpr.setBounds(260,350,120,30);

		jtpr=new JTextField(an+"0%");
		jtpr.setBounds(440,350,120,30);

		jlst=new JLabel("Status");
		jlst.setBounds(260,410,120,30);
		
		jtst=new JTextField(el);
		jtst.setBounds(440,410,120,30);
		
   		
		jbexit=new JButton("Exit");	
		jbexit.setBounds(260,500,100,30);

		jbhm=new JButton("Logout");	
		jbhm.setBounds(460,500,100,30);


		c.add(res);		
		c.add(jlb);
		c.add(jlna);
		c.add(jtna);
		c.add(jlex);
		c.add(jtex);	
		c.add(jlpr);
		c.add(jtpr);
		c.add(jlst);
		c.add(jtst);
		c.add(jbexit);
		c.add(jbhm);
			

		jbexit.addActionListener(this);
		jbhm.addActionListener(this);
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
		if(s.equals("Exit"))
		System.exit(0);
		if(s.equals("Logout"))
		{
		new LogFom().setup();
		setVisible(false);
		dispose();
		}		

	}	
		
	//public static void main(String args[])
	//{
	//	Result rt=new Result();
	//	rt.setUp();
	//}
}