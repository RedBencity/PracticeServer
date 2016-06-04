package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Dao.DaoFactory;

import util.Util;

public class SettingsServer extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String requestType = request.getParameter("requestType");
		System.out.println(requestType);
		if (requestType.equals("versionUpdate")) {
			String code = request.getParameter("code");
			
			PrintWriter out = response.getWriter();
			out.print(checkVersion(request, code));
			out.flush();
			out.close();
		}
	}

	private String checkVersion(HttpServletRequest request, String code) {
		try {
			System.out.println("SettingsServer---->   " + code);
			String fileName = Util.getFilePath(request, "version") + "/version.xml";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File(fileName);
			Document document = db.parse(file);
			NodeList nodeList = document.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				NodeList nodeList1 = node.getChildNodes();
				for (int j = 0; j < nodeList1.getLength(); j++) {
					Node node1 = nodeList1.item(j);
					if (node1.getNodeName().equals("code")) {
						System.out.println("SettingsServer---->node " + node1.getTextContent());
						String[] oldStrings = code.split("\\.");
						String[] newStrings = node1.getTextContent().split("\\.");
						if (Integer.parseInt(oldStrings[0]) < Integer.parseInt(newStrings[0])) {
							return "update";
						} else if (Integer.parseInt(oldStrings[0]) == Integer.parseInt(newStrings[0])) {
							if (Integer.parseInt(oldStrings[1]) < Integer.parseInt(newStrings[1])) {
								return "update";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "no";
	}

}
