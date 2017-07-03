import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class show  extends JFrame implements ActionListener{
	JMenuBar menuBar;
	JMenu menu,menu2;
	JMenuItem menuitem,menuitem2,menuitem3,menuitem4,menuitem5;
	JTextArea jta;
	public show(){
		setTitle("我的关键字加密软件");
		setLayout(null);
		setBounds(800,200,400,500);  
		Container container=getContentPane(); 
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		menu=new JMenu("开始");
		menuBar.add(menu);
		menuitem=new JMenuItem("读取文件");  
		menu.add(menuitem);  
		menuitem.addActionListener(this);
		menuitem2=new JMenuItem("获得关键字");  
		menu.add(menuitem2);  
		menuitem2.addActionListener(this);
		menuitem3=new JMenuItem("加密文件");  
		menu.add(menuitem3);  
		menuitem3.addActionListener(this);
		menuitem5=new JMenuItem("解密文件");  
		menu.add(menuitem5);  
		menuitem5.addActionListener(this);
		menu2=new JMenu("退出");
		menuBar.add(menu2);
		menuitem4=new JMenuItem("退出");  
		menu2.add(menuitem4);  
		menuitem4.addActionListener(this);
		jta=new JTextArea();
		jta.setBounds(15,20,350,380);
		jta.setLineWrap(true);        //激活自动换行功能 
		jta.setWrapStyleWord(true);            // 激活断行不断字功能
		jta.setFont(new Font("微软雅黑",0,15));
		JScrollPane jsp = new JScrollPane(jta); 
		jsp.setBounds(15,20,350,380);   
		container.add(jsp);
		setVisible(true);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	 public void actionPerformed(ActionEvent e){  
		 if (e.getSource()==menuitem) {  
			 String s=my_filechooser.filechooser();
			 try {
				jta.setText(Helper.Read(s));
			} catch (IOException e1) {
				System.out.println("打开文件失败");
				e1.printStackTrace();
			}
		 }
		 if (e.getSource()==menuitem2) {  
			 String s=jta.getText();
			 jta.setText(Helper.getKeyWord(s));
		 }
		 if (e.getSource()==menuitem3) {  
			 String s=jta.getText();
			 jta.setText(Helper.commonsEnCodesBase64(s));
		 }
		 if (e.getSource()==menuitem4) {  
			 System.out.println("4");
			 System.exit(1);
		 }
		 if (e.getSource()==menuitem5) {  
			 String s=jta.getText();
			 jta.setText(Helper.commonsDeCodesBase64(s));
		 }
	 }
public static void main(String[] args) {
	try {  
        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");  
        show s=new show();
    }  
    catch (Exception ex) {  
        ex.printStackTrace();  
    }  
	
}  
   

}
