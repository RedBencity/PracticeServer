package util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Text {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 try {
//		 for (int i = 1; i < 2; i++) {
//		 File file = new File("E://text/question"+i+".txt");
//		 file.createNewFile();
//		 File file1 = new File("E://text/answer"+i+".txt");
//		 file1.createNewFile();
//		 }
//		 } catch (IOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
		

		int mark = 0;
		int i = 1;
//		 int mark = 15;
//		 int i = 2;
//		 int mark =30;
//		 int i =3;
//		 int mark =45;
//		 int i =4;
//		 int mark =62;
//		 int i =5;
//		Question.question("E:/text/subject/语文/wenziyingyong/question" + i + ".txt", mark);
		System.out.println("----------------------");
		Answer.answer("E:/text/subject/语文/wenziyingyong/answer" + i + ".txt", mark);

	}

}
