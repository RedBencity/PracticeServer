package Dao;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import util.Constants;
import util.DBManager;
import util.Util;
import vo.Question;

public class QuestionDao {
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	// public static void main(String[] args) {
	// QuestionDao questionDao = new QuestionDao();
	// try {
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	private String[] points;

	public ArrayList<Question> getCollectQuestion(HttpServletRequest request, String phone, String subject) throws Exception {
		ArrayList<Question> questions = new ArrayList<Question>();
		if (subject.equals(Constants.subjects_c[2])) {
			points = Constants.yingyu_e;

		} else if (subject.equals(Constants.subjects_c[0])) {
			points = Constants.yuwen_e;
		} else if (subject.equals(Constants.subjects_c[1])) {
			points =Constants.shuxue_e;
		}

		connection = DBManager.initConnection();
		for (int i = 0; i < points.length; i++) {
			String sql = "select * from save_" + points[i] + " where phone=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, phone);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int j = 1; j <= columnCount; j++) {
					if (j != 1 && rs.getString(j) != null && rs.getString(j).equals("save")) {
						String path = Util.getFilePath(request, "subject") + "/" + subject + "/" + points[i];
						// System.out.println(path);
						if (Util.getQuestion(path, j-1) != null) {
							questions.add(Util.getQuestion(path, j-1));
						}
					}
				}
			}

		}
		return questions;
	}

	public void updateCollectQuestion(String phone, String point, String number) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select * from save_" + point + " where phone=?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String sql = "";
			sql += "update save_" + point + " set ";
			if (number.length() == 1) {
				sql += "question00" + number;
			} else if (number.length() == 2) {
				sql += "question0" + number;
			}
			sql += " =? where phone=?";
			System.out.println(sql);

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "save");
			pstmt.setString(2, phone);
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);
		} else {
			String sql = "";
			sql += "insert into save_" + point + "(phone,";
			if (number.length() == 1) {
				sql += "question00" + number;
			} else if (number.length() == 2) {
				sql += "question0" + number;
			}
			sql += ")values(?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, "save");
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);
		}

	}

	public String getQuestion(HttpServletRequest request, String phone, String subject, String point) throws Exception {
		String fileName = Util.getFilePath(request, "subject");

		fileName += "\\" + subject + "\\" + point + "\\";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select * from " + point + " where phone = ?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		int mark = 0;
		int end = 10;
		if (rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				if (i != 1 && rs.getString(columnCount) != null && rs.getString(columnCount).equals("true")) {
					return "all_do";
				} else if (rs.getString(i) == null) {
					mark = i - 1;
					if (columnCount - 1 - mark < 10) {
						end = columnCount - mark;
					}
					break;
				}
			}
			String responseString = "";
			return analyzeXml(responseString, mark, end, db, fileName);

		} else {
			pstmt = connection.prepareStatement("insert into " + point + " (phone" + ")values(?)");
			pstmt.setString(1, phone);
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);
			String responseString = "";
			return analyzeXml(responseString, 1, 10, db, fileName);
		}
	}

	private String analyzeXml(String responseString, Integer mark, int end, DocumentBuilder db, String fileName) throws Exception {
		File file = new File(fileName + mark + ".xml");
		if (!file.exists()) {
			return responseString = "no_file";

		}
		for (int x = mark; x <= mark + end - 1; x++) {
			file = new File(fileName + x + ".xml");
			Document document = db.parse(file);
			// Document document = db.parse(fileName + x + ".xml");
			NodeList nodeList = document.getChildNodes();
			// System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				NodeList nodeList1 = node.getChildNodes();
				// System.out.println(nodeList1.getLength());
				for (int j = 0; j < nodeList1.getLength(); j++) {
					Node node1 = nodeList1.item(j);
					// System.out.println(node1.getNodeName());
					if (j < nodeList1.getLength() - 2 && !node1.getNodeName().equals("#text")) {
						responseString += node1.getTextContent() + "&";
					} else if (j == nodeList1.getLength() - 2 && !node1.getNodeName().equals("#text")) {
						responseString += node1.getTextContent();
					}
				}
				responseString += "@";
			}
		}
		for (int i = mark; i < mark + end - 1; i++) {
			responseString += i + "#";
		}
		responseString += mark + end - 1;
		// System.out.println(responseString);
		return responseString;
	}

	public void insertQuestionNumber(String phone, String point, String numberStr) throws Exception {
		connection = DBManager.initConnection();
		String[] numbers = numberStr.split("#");

		int margin = numbers.length - 1;
		String sql = "";
		int number = Integer.parseInt(numbers[0]);
		System.out.println("题数：" + numbers.length + " 第" + number + "开始");
		sql = "update " + point + " set ";
		for (int i = number; i <= number + margin; i++) {
			if (i != number + margin) {
				if (i < 10) {
					sql += "question00" + i + "=?,";
				} else if (i < 100 && i >= 10) {
					sql += "question0" + i + "=?,";
				}
			} else if (i == number + margin) {
				if (i < 10) {
					sql += "question00" + i + "=? ";
				} else if (i < 100 && i >= 10) {
					sql += "question0" + i + "=? ";
				}
			}
		}
		sql += "where phone=?";
		System.out.println(sql);
		System.out.println(phone);
		// pstmt = connection.prepareStatement(sql);
		// for (int i = 1; i <= 1 + margin + 1; i++) {
		// if (i != 1 + margin + 1) {
		// pstmt.setString(i, "true");
		// } else if (i == 1 + margin + 1) {
		// pstmt.setString(i, phone);
		// }
		// }
		// pstmt.executeUpdate();
		// DBManager.close(pstmt, connection);

	}
}
