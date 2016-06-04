package Dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.DBManager;
import vo.Personal;

public class PersonalDao {
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	public String getNickname(String phone) throws Exception {

		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select p_nickname from "
				+ "personal where p_phone = ?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String nickname = rs.getString("p_nickname");
			DBManager.close(pstmt, connection);
			return nickname;
		}
		DBManager.close(pstmt, connection);
		return null;
	}

	public Boolean isPhone(String phone) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection
				.prepareStatement("select p_phone from personal where p_phone=?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			System.out.println(phone + "-------true");
			DBManager.close(pstmt, connection);
			return true;
		}
		System.out.println(phone + "-------false");
		DBManager.close(pstmt, connection);
		return false;
	}

	public Boolean isPassword(String phone, String password) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select p_password from "
				+ "personal where p_phone = ?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getString("p_password").equals(password)) {
				DBManager.close(pstmt, connection);
				return true;
			}
		}
		DBManager.close(pstmt, connection);
		return false;
	}

	public void addPhone(String phone) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("insert into personal (p_phone,"
				+ "p_password,p_nickname)values(?,?,?)");
		pstmt.setString(1, phone);
		pstmt.setString(2, "123456");
		pstmt.setString(3, "ben");
		pstmt.executeUpdate();
		DBManager.close(pstmt, connection);
	}

	public void updatePasswordToInit(String phone) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection
				.prepareStatement("update personal set p_password =? where p_phone =?");
		pstmt.setString(1, "123456");
		pstmt.setString(2, phone);
		pstmt.executeUpdate();
		DBManager.close(pstmt, connection);
	}
	
	public void updatePassword(String phone,String newPassword) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection
				.prepareStatement("update personal set p_password =? where p_phone =?");
		pstmt.setString(1, newPassword);
		pstmt.setString(2, phone);
		pstmt.executeUpdate();
		DBManager.close(pstmt, connection);
	}
	
	public void updateNickname(String phone,String nickname) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection
				.prepareStatement("update personal set p_nickname =? where p_phone =?");
		pstmt.setString(1, nickname);
		pstmt.setString(2, phone);
		pstmt.executeUpdate();
		DBManager.close(pstmt, connection);
	}
	
	public void uploadPhoto(HttpServletRequest request) throws Exception{
		
		String phone = null;

		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设定内存可以存放文件的最大容量，单位字节，超过的部分会以临时文件的形式存放在硬盘上，这里设置成10兆
			factory.setSizeThreshold(10485760);
			// factory.setSizeThreshold(20);
			String filepath = request.getSession().getServletContext()
					.getRealPath("/photo");
			// File temp = new File("/temp");
			File temp = new File(filepath);
			if (!temp.exists()) {
				temp.mkdirs();
			}
			// 设置临时文件存放的位置
			factory.setRepository(temp);

			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置单个文件最大容量限制，-1表示没有限制
			upload.setFileSizeMax(-1);
			// 设置整个请求的上传容量限制，-1表示没有限制
			upload.setSizeMax(-1);

			List<FileItem> items;
			try {
				items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				FileItem upload_item = null;
				String desc = "";
				while (iterator.hasNext()) {
					FileItem item = iterator.next();
					if (item.isFormField()) {
						// 普通字段
//						System.out.println("普通字段");
//						System.out.println(item.getFieldName());// 得到字段name属性的值
//						System.out.println(item.getString("UTF-8"));// 得到字段的值
						desc = item.getString("UTF-8");
						if (item.getFieldName().equals("phone")) {
							phone = desc;
						} 
					} else {
						// 文件字段
//						System.out.println("文件字段");
//						System.out.println("FieldName " + item.getFieldName());
//						System.out.println("文件类型    " + item.getContentType());// 文件类型《application/pdf》
//						System.out.println("文件名    " + item.getName());// 文件名称《入门.pdf》

						upload_item = item;

					}
				}
				inputStreamFile(upload_item.getInputStream(), request
						.getSession().getServletContext().getRealPath("/photo")
						+ "\\" + phone + ".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// 流转化成文件
	public  void inputStreamFile(InputStream is, String savePath)
			throws Exception {
		System.out.println("文件保存路径为" + savePath);
		File file = new File(savePath);
		InputStream inputSteam = is;
		BufferedInputStream fis = new BufferedInputStream(inputSteam);
		FileOutputStream fos = new FileOutputStream(file);
		int f;
		while ((f = fis.read()) != -1) {
			fos.write(f);
		}
		fos.flush();
		fos.close();
		fis.close();
		inputSteam.close();
	}
}
