package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

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

public class MessageCreate {

	private Document document;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageCreate messageCreate = new MessageCreate();
		messageCreate.createXML();
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

	private void createXML() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);

		String[] strings = new String[] { "0x126", "大促销", year+"/"+month+"/"+date,
				"非常高兴大促销！" };
		init();
		String fileName = "d://Practice/message/message.xml";
		Element root = document.createElement("message");
		document.appendChild(root);
		Element id = document.createElement("id");
		id.appendChild(document.createTextNode(strings[0]));
		Element title = document.createElement("title");
		title.appendChild(document.createTextNode(strings[1]));
		Element time = document.createElement("time");
		time.appendChild(document.createTextNode(strings[2]));
		Element content = document.createElement("content");
		content.appendChild(document.createTextNode(strings[3]));
		root.appendChild(id);
		root.appendChild(title);
		root.appendChild(time);
		root.appendChild(content);

		// 将DOM对象document写入到xml文件中
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result); // 关键转换
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
