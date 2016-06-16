import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
	JLabel jlb;
	JPanel jp=new JPanel();
	JTextArea jtru,jTextArea;
	JButton jbcon;
	Container c;
	JScrollPane jsp,scrollablePane;
	String em;
	Rules(String email)
	{
		em=email;
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void setUp()
	{
		c=getContentPane();
		setSize(900,700);
		setTitle("Exam Suite");
		c.setBackground(Color.white);
		c.setLayout(null);
		jp.setLayout(new FlowLayout());
		jp.setBackground(Color.white);
		jp.setBounds(150,210,600,300);
		
		jlb=new JLabel(new ImageIcon("uit.jpg"));
		jlb.setBounds(0,0,900,120);
		
		String str="\n\t                EXAM RULES\n\n"+
"This is  a simple user friendly software developed using Java.\n"+
"It can be applied to schools ,colleges etc to conduct exams.\n"+
"The procedure for using this software is very easy. Select one \n"+
"of the exams listed in the menu.After selecting the choice the \n"+
"exam will be started by clicking continue button.The questions\n"+
"and options are displayed on the screen.We can choose one\n"+
"of the answer.After completing the exam the results are \n"+
"displayed on the screen.\n";
		
		jtru=new JTextArea(str,14,35);
		jtru.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,16));
		jsp = new JScrollPane(jtru);
		jp.add(jsp);
		c.add(jp);
				


   		
		jbcon=new JButton("Continue");	
		jbcon.setBounds(400,550,100,30);




		c.add(jlb);		
		//c.add(jsp);
		c.add(jbcon);
		
			

		jbcon.addActionListener(this);
		
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
 	 String s=ae.getActionCommand();
		if(s.equals("Continue"))
		{
		new SelectExam(em).setUp();
		setVisible(false);
		}		

	}	
		
	//public static void main(String args[])
	//{
	//	Rules r=new Rules();
	//	r.setUp();
	//}
}