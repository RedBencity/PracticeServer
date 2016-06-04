package action;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoFactory;

import util.Base64Coder;
import util.DBManager;

import net.sf.json.JSONObject;

public class LoginServer extends HttpServlet {

	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String requestType = request.getParameter("requestType");
			
			// String photo = request.getParameter("photo");
			// saveImage(photo,username,request);
			if (requestType.equals("login")) {
				String phone = request.getParameter("phone");
				String password = request.getParameter("password");
				System.out.println("LoginServer " + phone + " " + password+"---login");
				System.out.println(DaoFactory.getPersonalDao().isPassword(phone, password));
				if (DaoFactory.getPersonalDao().isPassword(phone, password)) {
					System.out.println("login_true");

					PrintWriter out = response.getWriter();
					out.print("true");
					out.flush();
					out.close();
				} else {
					System.out.println("login_false");
					PrintWriter out = response.getWriter();
					out.print("false");
					out.flush();
					out.close();
				}
			} else if (requestType.equals("register")) {
				String phone = request.getParameter("phone");
				System.out.println("LoginServer " + phone+"---register");
				if (DaoFactory.getPersonalDao().isPhone(phone)) {
					System.out.println("register_true");
				
					PrintWriter out = response.getWriter();
					out.print("true");
					out.flush();
					out.close();
				} else {
					System.out.println("register_false");
					DaoFactory.getStatisticsDao().setAll(phone);
					PrintWriter out = response.getWriter();
					out.print("false");
					out.flush();
					out.close();
					DaoFactory.getPersonalDao().addPhone(phone);
				}
			}else if(requestType.equals("find_password")){
				String phone = request.getParameter("phone");
				System.out.println("LoginServer " + phone+"---find_password");
				DaoFactory.getPersonalDao().updatePasswordToInit(phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
