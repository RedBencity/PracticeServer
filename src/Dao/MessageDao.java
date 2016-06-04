package Dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import vo.Message;


public class MessageDao { 
	
	

	public Message getMessage(String fileName){	
		Message message = new Message();	
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			NodeList nodeList = document.getChildNodes();
			// System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				NodeList nodeList1 = node.getChildNodes();
				// System.out.println(nodeList1.getLength());
				for (int j = 0; j < nodeList1.getLength(); j++) {
					Node node1 = nodeList1.item(j);
					// System.out.println(node1.getNodeName() + "  "
					// + node1.getTextContent());
					if (node1.getNodeName().equals("id")) {
						message.setId(node1.getTextContent());
					} else if (node1.getNodeName().equals("title")) {
						message.setTitle(node1.getTextContent());
					}else if (node1.getNodeName().equals("time")) {
						message.setTime(node1.getTextContent());
					}else if (node1.getNodeName().equals("content")) {
						message.setContent(node1.getTextContent());
					}
				}
			}}catch (Exception e) {
			e.printStackTrace();
			}
		return message;
	}
}
