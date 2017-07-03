import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

import com.hankcs.hanlp.HanLP;

public class Helper {
 public static String Read(String path)throws IOException {
	 BufferedReader br=null;
	 String content="";
	 try{
	 br=new BufferedReader(new FileReader(path));
	 String line=null;
	 while((line=br.readLine())!=null){
     content=content+line; 
	 }
	 }finally{
		 if (br!=null){
			 br.close();
		 }
	 }
	 return content;
 }
 public static String commonsEnCodesBase64(String content){//编码
	 byte[] encodeBytes=Base64.encodeBase64(content.getBytes());
	 return new String(encodeBytes);
 }
 public static String commonsDeCodesBase64(String content){//解码
	 byte[] decodeBytes=Base64.decodeBase64(content.getBytes());
	 return new String(decodeBytes);
 }
 public static String getKeyWord(String s){
	 List<String> keywordList = HanLP.extractKeyword(s,1); 
	 return keywordList.get(0);
 } 
}
