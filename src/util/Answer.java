package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessOrder;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Answer {
	public static void answer(String path, int x) {
		try {
			File file = new File(path);
			if (file.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String questionString = "";
				ArrayList<String> arrayList = new ArrayList<String>();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					questionString = Util.deleteIllegalCharacter(lineTxt);

					if (!questionString.equals("")) {
						questionString = questionString.replace("．", ".");
						questionString = questionString.replace("、", ".");
						questionString = questionString.replace("（", " ");
						questionString = questionString.replace("）", " ");
						questionString = questionString.replace("(", " ");
						questionString = questionString.replace(")", " ");
						
						int dian = questionString.indexOf(".")==-1?questionString.indexOf("、"): questionString.indexOf(".");
						arrayList.add(questionString.substring(dian + 1));
//						 System.out.println(questionString);
					}
					questionString = "";
				}
				read.close();

				ArrayList<String> arrayList2 = new ArrayList<String>();
				for (int i = 0; i < arrayList.size(); i++) {
					String string = arrayList.get(i);
					System.out.println(string);
					int a = -1, b = -1, c = -1, d = -1;
					a = string.indexOf("A.");
					b = string.indexOf("B.");
					c = string.indexOf("C.");
					d = string.indexOf("D.");
					if (a != -1 && a < 8) {
						arrayList2.add(string.substring(a, a + 1));
					} else if (b != -1 && b < 8) {
						arrayList2.add(string.substring(b, b + 1));
					} else if (c != -1 && c < 8) {
						arrayList2.add(string.substring(c, c + 1));
					} else if (d != -1 && d < 8) {
						arrayList2.add(string.substring(d, d + 1));
					}
					System.out.println(arrayList2.get(i));

				}

				Answer answer = new Answer();
				for (int i = 0; i < arrayList.size(); i++) {
					answer.parserXml("E://text/" + (i + 1 + x) + ".xml",
							Util.deleteIllegalCharacter(arrayList2.get(i)),
							Util.deleteIllegalCharacter(arrayList.get(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parserXml(String fileName, String answer, String analyze) {
		// init();
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
					if (node1.getNodeName().equals("answer")) {
						node1.setTextContent("");
						node1.appendChild(document.createTextNode(answer));
					} else if (node1.getNodeName().equals("analyze")) {
						node1.setTextContent("");
						node1.appendChild(document.createTextNode(analyze));
					}
				}
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result); // 关键转换
			System.out.println("生成XML文件成功!");

			System.out.println("解析完毕");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}

}
