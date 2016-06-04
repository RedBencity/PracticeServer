package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

//关于65279: Windows下的文本编辑器会在UTF-8编码的文件前方添加三个字节(EmEditor不会)，
//以标明其为UTF-8编码。这种文件是无法通过编译的，必须用十六进制编辑器去除这三个字节！
//因此在你把代码存为UTF-8格式之后需要使用十六进制编辑器去掉前三个字节，然后就可以正常编译了

//unicode为12288字符为全角空格，trim()无法去除，去除方法如下：
//str = str.replace((char) 12288, ' ');
//str=str.trim();

public class Question {
	private Document document;

	public static void question(String path,int x) {
		try {
			File file = new File(path);
			if (file.exists()) {
				System.out.println("exists");
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String questionString = "";
				ArrayList<String> arrayList = new ArrayList<String>();
				while ((lineTxt = bufferedReader.readLine()) != null) {
//					System.out.println(lineTxt);
					questionString = Util.deleteIllegalCharacter(lineTxt);
//					System.out.println(questionString);
					if (!questionString.equals("")) {
						questionString = questionString.replace("．", ".");
						questionString = questionString.replace("、", ".");
						arrayList.add(questionString);
					}
					questionString = "";
				}
				read.close();

				int j = 1;
				questionString = "";
				System.out.println(arrayList.size());
				ArrayList<String> arrayList2 = new ArrayList<String>();
				for (int i = 0; i < arrayList.size(); i++) {
					System.out.println(arrayList.get(i));
					String mark = j + ".";
					if (arrayList.get(i).indexOf(mark) == 0) {
					
						int dian = arrayList.get(i).indexOf(".")==-1?arrayList.get(i).indexOf("、"):arrayList.get(i).indexOf(".");
						System.out.println(i+" "+dian);
						questionString = "";
						questionString += "@" + arrayList.get(i).substring(dian+1);
						j++;
					} else {
						String markString = arrayList.get(i);
						int a = -1, b = -1, c = -1, d = -1;
						a = markString.indexOf("A.");
						b = markString.indexOf("B.");
						c = markString.indexOf("C.");
						d = markString.indexOf("D.");
//						System.out.println(markString);
						String strString1 = "";
						String strString2 = "";
						if (a != -1 && b != -1) {
							System.out.println(i+" "+a+" "+b);
//							System.out.println(a+"  "+b);
							strString1 = "@"
									+ markString.substring(a+2, b - 1).trim();
							strString2 = "@" + markString.substring(b+2).trim();
							questionString += strString1 + strString2;
						} else if (c != -1 && d != -1) {
							strString1 = "@"
									+ markString.substring(c+2, d - 1).trim();
							strString2 = "@" + markString.substring(d+2).trim();
							questionString += strString1 + strString2;
							arrayList2.add(questionString);
							System.out.println(i+" "+c+" "+d );
						} else {
							questionString += markString;
						}
					}
					System.out.println("---------------------------------------------------");
				}
				
				Question main =new Question();
				System.out.println(arrayList2.size());
				for (int i = 0; i < arrayList2.size(); i++) {
					System.out.println((i+1)+"------>"+arrayList2.get(i));
					main.createXml("E://text/"+(i+1+x)+".xml", arrayList2.get(i));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	

	public void init() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createXml(String fileName,String content) { 
		init();
		String[] strings = content.split("@");
		Element root = document.createElement("question"); 
		document.appendChild(root);
		Element title = document.createElement("title");
		 title.appendChild(document.createTextNode(strings[1])); 
		Element a = document.createElement("A");
		 a.appendChild(document.createTextNode(strings[2])); 
		Element b = document.createElement("B");
		 b.appendChild(document.createTextNode(strings[3])); 
		Element c = document.createElement("C");
		 c.appendChild(document.createTextNode(strings[4])); 
		Element d = document.createElement("D");
		 d.appendChild(document.createTextNode(strings[5])); 
		Element answer = document.createElement("answer");
		answer.appendChild(document.createTextNode("   ")); 
		Element analyze = document.createElement("analyze");
		analyze.appendChild(document.createTextNode("  ")); 
		root.appendChild(title);
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);
		root.appendChild(d);
		root.appendChild(answer);
		root.appendChild(analyze);
				
		//将DOM对象document写入到xml文件中  
        TransformerFactory tf = TransformerFactory.newInstance();  
        try {  
            Transformer transformer = tf.newTransformer();  
            DOMSource source = new DOMSource(document);  
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");  
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));  
            StreamResult result = new StreamResult(pw);  
            transformer.transform(source, result);     //关键转换  
            System.out.println("生成XML文件成功!");  
        } catch (TransformerConfigurationException e) {  
            System.out.println(e.getMessage());  
        } catch (IllegalArgumentException e) {  
            System.out.println(e.getMessage());  
        } catch (FileNotFoundException e) {  
            System.out.println(e.getMessage());  
        } catch (TransformerException e) {  
            System.out.println(e.getMessage());  
        }  
	}

	

}