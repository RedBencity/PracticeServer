package util;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class DBCreate {
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	public static void main(String[] args) {
		DBCreate dbCreate = new DBCreate();
		try {
			dbCreate.createTable();
			dbCreate.createTableSave();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createTable() throws Exception {
		connection = DBManager.initConnection();

		String filePath = "D:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\PracticeServer\\subject\\语文";
		File parentFile = new File(filePath);
		if (parentFile.exists()) {
			System.out.println("exists");
			String[] filelist = parentFile.list();
			for (int i = 0; i < filelist.length; i++) {
				System.out.println(filelist[i]);
				File childFile = new File(filePath + "\\" + filelist[i]);
				String[] fileStrings = childFile.list();

				String sqlString = "create table " +filelist[i] + "( ";
				sqlString += " phone  varchar(45), ";
				for (int j = 0; j < fileStrings.length; j++) {
					fileStrings[j] = fileStrings[j].substring(0,
							fileStrings[j].indexOf("."));
					if (fileStrings[j].length() == 1) {
						fileStrings[j] = "00" + fileStrings[j];
					} else if (fileStrings[j].length() == 2) {
						fileStrings[j] = "0" + fileStrings[j];
					}
				}
				Arrays.sort(fileStrings);
				// for (int j = 0; j < fileStrings.length; j++) {
				// System.out.println(fileStrings[j]+" "+fileStrings[j].length());
				// }

				for (int j = 0; j < fileStrings.length; j++) {
					sqlString += " question" + fileStrings[j]
							+ "  varchar(20), ";
				}
				sqlString += " primary key(phone) ";
				sqlString += " );";

				System.out.println(sqlString);

				pstmt = connection.prepareStatement(sqlString);
				pstmt.execute();

			}
		}
		DBManager.close(pstmt, connection);
	}
	
	private void createTableSave() throws Exception {
		connection = DBManager.initConnection();

		String filePath = "D:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\PracticeServer\\subject\\语文";
		File parentFile = new File(filePath);
		if (parentFile.exists()) {
			System.out.println("exists");
			String[] filelist = parentFile.list();
			for (int i = 0; i < filelist.length; i++) {
				System.out.println(filelist[i]);
				File childFile = new File(filePath + "\\" + filelist[i]);
				String[] fileStrings = childFile.list();

				String sqlString = "create table save_" +filelist[i] + "( ";
				sqlString += " phone  varchar(45), ";
				for (int j = 0; j < fileStrings.length; j++) {
					fileStrings[j] = fileStrings[j].substring(0,
							fileStrings[j].indexOf("."));
					if (fileStrings[j].length() == 1) {
						fileStrings[j] = "00" + fileStrings[j];
					} else if (fileStrings[j].length() == 2) {
						fileStrings[j] = "0" + fileStrings[j];
					}
				}
				Arrays.sort(fileStrings);
				// for (int j = 0; j < fileStrings.length; j++) {
				// System.out.println(fileStrings[j]+" "+fileStrings[j].length());
				// }

				for (int j = 0; j < fileStrings.length; j++) {
					sqlString += " question" + fileStrings[j]
							+ "  varchar(20), ";
				}
				sqlString += " primary key(phone) ";
				sqlString += " );";

				System.out.println(sqlString);

				pstmt = connection.prepareStatement(sqlString);
				pstmt.execute();

			}
		}
		DBManager.close(pstmt, connection);
	}
	
}
