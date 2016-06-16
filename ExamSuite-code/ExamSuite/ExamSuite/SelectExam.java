import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SelectExam extends JFrame implements ActionListener
{
	JPanel jpl = new JPanel();
	JLabel lbse,jlqn,jlqd,jlb;
	JTextField jtex;
	JComboBox jcbse;
	JRadioButton jone,jtwo,jthree;
	ButtonGroup g = new ButtonGroup();
	JButton jbse,jbse1;
	Container c;
	 Connection conn;
 	PreparedStatement pstmt;
	int qn=0,count=0,ans=0;
	String com="empty",seven="empty",email,exam;
	


	SelectExam(String eml)
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
		email=eml;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setUp()
	{
		c=getContentPane();
		setSize(900,700);
		setTitle("Exam Suite");
		c.setBackground(Color.white);
		c.setLayout(null);

		//jpl.setLayout(null);
		//jpl.setBounds(250,600,350,350);

		jlb=new JLabel(new ImageIcon("uit.jpg"));
		jlb.setBounds(0,0,900,120);
		
		lbse=new JLabel("Select an Exam:");
		lbse.setBounds(240,150,140,30);

		String se[]={"C","C++","Java"};
		jcbse=new JComboBox(se);
		jcbse.setBounds(350,150,120,30);

		jtex=new JTextField();
		jtex.setBounds(350,150,120,30);

		jbse=new JButton("Continue");	
		jbse.setBounds(500,150,100,30);

		jlqn=new JLabel(" ");
		jlqn.setBounds(255,235,30,30);

		jlqd=new JLabel(" ");
		jlqd.setBounds(280,235,600,30);
		
		jone = new JRadioButton("",false);
		jone.setBounds(280,275,600,25);
jone.setBackground(Color.white);
		jtwo = new JRadioButton("",false);
		jtwo.setBounds(280,295,600,25);
jtwo.setBackground(Color.white);
		jthree = new JRadioButton("",false);
		jthree.setBounds(280,315,600,25);
jthree.setBackground(Color.white);
		

      		g.add(jone);g.add(jtwo);g.add(jthree);

		jbse1=new JButton("Next");	
		jbse1.setBounds(350,600,100,30);
		
		c.add(jlb);
		c.add(lbse);
		c.add(jcbse);
		c.add(jtex);
		c.add(jbse);
		c.add(jlqn);	
		c.add(jlqd);
		
	
		//jone.setVisible(false);
		//jtwo.setVisible(false);
		//jthree.setVisible(false);

		//jpl.setBackground(Color.white);
		c.add(jbse1);
		//c.add(jpl);

		jbse.addActionListener(this);
		jbse1.addActionListener(this);
		jone.addActionListener(this);
		jtwo.addActionListener(this);
		jthree.addActionListener(this);


		setVisible(true);
		jbse1.setVisible(false);
		jtex.setVisible(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
		Object obj=ae.getSource();
		
		if(s.equals("Continue"))
		{			
			
			 	  
		   	try
      			{	
    				pstmt=conn.prepareStatement("select * from question where scode= ?");
  				exam=""+jcbse.getSelectedItem();
				pstmt.setString(1,exam);
				
				ResultSet rs=pstmt.executeQuery();  
    					while(rs.next())
        					{
							
							jbse1.setVisible(true);
							jlqd.setText("To start Exam please click the next button");
        						count++; 
						}
			System.out.println(count);
			}
        		catch(SQLException e)
  			{
  				System.out.println("sql exception");
  			}
			
            		jbse.setVisible(false);
			jtex.setVisible(true);
			jtex.setText(" "+jcbse.getSelectedItem());
			jtex.setEditable(false);
			jcbse.setVisible(false);
		}
		if(s.equals("Next"))
		{
			// jone.setVisible(true);
			// jtwo.setVisible(true);
			// jthree.setVisible(true);
			
			c.add(jone);
		c.add(jtwo);	
		c.add(jthree); 	
		jone.setSelected(false);
		jtwo.setSelected(false);
		jthree.setSelected(false);

			if(com.equals("empty") || seven.equals("empty"))
			{
			}
			else if(com.equals(seven))
			{
			ans++;
			System.out.println("Continue: "+ans);
			}

			qn=qn+1;
			if(qn<=count)
			{
			
					
			try
      			{	
    				pstmt=conn.prepareStatement("select * from question where scode= ? AND qno=?");
  				String sc=""+jcbse.getSelectedItem();
				pstmt.setString(1,sc);
				pstmt.setString(2,""+qn);
   				System.out.println("SC "+sc);
    				
				ResultSet rs=pstmt.executeQuery();  
    					while(rs.next())
        					{
        						String one=rs.getString("scode");
     							String two=rs.getString("qno"); 
							String three=rs.getString("qdesc");
     							String four=rs.getString("choice1");    
							String five=rs.getString("choice2");
     							String six=rs.getString("choice3");  
							seven=rs.getString("answer"); 
							System.out.println("Answers: "+seven);
							

						
			
							jlqn.setText(two);
							jlqd.setText(three);
							jone.setText(four);
							jtwo.setText(five);
							jthree.setText(six);
							System.out.println(one);
							System.out.println(two); 
							System.out.println(three);
							System.out.println(four);
							System.out.println(five);
							System.out.println(six);  
							
				
						}
			}
        		catch(SQLException e)
  			{
  				System.out.println("sql exception");
  			}
			}
			else
			{
			//System.out.println("Complete");
			//System.out.println("Complete: "+ans);
			//System.out.println("Percentage: "+ans+"0");
			String elig;
			if(ans>=5)
			elig="Eligible";
			else
			elig="Not Eligible";		
			
			try
			{
			pstmt=conn.prepareStatement("insert into result values(?,?,?,?)");
			pstmt.setString(1,email);
			pstmt.setString(2,exam);
			pstmt.setString(3,""+ans+"0");
			pstmt.setString(4,elig);
			pstmt.executeUpdate();
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog (this, "Error in saving the data",
						"Exam Suite - SQL Error", JOptionPane.PLAIN_MESSAGE);
							

			}




			Result r = new Result(email,exam,ans,elig);
			r.setUp();
			setVisible(false);
			dispose();
			}
			
			


					
		}


		if(obj==jone)
		{
		com=jone.getText();
		System.out.println(com);
		}
		if(obj==jtwo)
		{
		com=jtwo.getText();
		System.out.println(com);
		}
		if(obj==jthree)
		{
		com=jthree.getText();
		System.out.println(com);
		}
	}

               
	


	/*public static void main(String args[])
	{
		SelectExam se=new SelectExam("asd");
		se.setUp();
	}*/
}