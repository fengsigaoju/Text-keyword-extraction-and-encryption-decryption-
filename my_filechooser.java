import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
public class my_filechooser {
	 public  static String filechooser(){
	  JFileChooser jfc=new JFileChooser();  
      jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
      jfc.showDialog(new JLabel(), "选择"); 
      jfc.setFileFilter(new javax.swing.filechooser.FileFilter() {
    	          public boolean accept(File f) { //设定可用的文件的后缀名
    	              if(f.getName().endsWith(".txt")||f.isDirectory()){
    	                return true;
    	              }
    	              return false;
    	            }
    	            public String getDescription() {
    	              return "以txt结尾";
    	            }
    });	 
      File file=jfc.getSelectedFile();  
      if(file.isDirectory()){  
          System.out.println("文件夹:"+file.getAbsolutePath());  
      }else if(file.isFile()){  
          System.out.println("文件:"+file.getAbsolutePath()); 
      } 
      return file.getAbsolutePath();
     }
	 
}
