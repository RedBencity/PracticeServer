package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vo.Question;

public class Util {
	
	public static String deleteIllegalCharacter(String str) {
		str = str.replace((char) 12288, ' ');
		str = str.replace((char) 65279, ' ');
		return str.trim();
	}

	public static String getFilePath(HttpServletRequest request,String fileName){
		String filepath = request.getSession().getServletContext()
				.getRealPath("/"+fileName);
		return filepath;
	}
	
	public static Question getQuestion(String fileName,int position) throws Exception{
		Question question =new Question();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File(fileName+"/" + position + ".xml");
		if (!file.exists()) {
			return null;
		}
		Document document = db.parse(file);
		NodeList nodeList = document.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NodeList nodeList1 = node.getChildNodes();
			// System.out.println(nodeList1.getLength());
			for (int j = 0; j < nodeList1.getLength(); j++) {
				Node node1 = nodeList1.item(j);
				// System.out.println(node1.getNodeName());
				if (node1.getNodeName().equals("title")) {
					question.setTitle( node1.getTextContent());
				}else if (node1.getNodeName().equals("A")) {
					question.setA( node1.getTextContent());
				}else if (node1.getNodeName().equals("B")) {
					question.setB( node1.getTextContent());
				}else if (node1.getNodeName().equals("C")) {
					question.setC( node1.getTextContent());
				}else if (node1.getNodeName().equals("D")) {
					question.setD( node1.getTextContent());
				}else if (node1.getNodeName().equals("answer")) {
					question.setAnswer( node1.getTextContent());
				}else if (node1.getNodeName().equals("analyze")) {
					question.setAnalyze( node1.getTextContent());
				}
			}
		}
		return question;
	}
}
