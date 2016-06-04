package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoFactory;

public class PersonalPublicServer extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String requestType = request.getParameter("requestType");
		if (requestType.equals("updateNickname")) {
			String phone = request.getParameter("phone");
			System.out.println("PersonalPublicServer " + phone );
			String nickname = request.getParameter("nickname");
			try {
				DaoFactory.getPersonalDao().updateNickname(phone, nickname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(requestType.equals("updatePassword")){
			String phone = request.getParameter("phone");
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			try {
				if(DaoFactory.getPersonalDao().isPassword(phone, oldPassword)){
					DaoFactory.getPersonalDao().updatePassword(phone, newPassword);
					PrintWriter out = response.getWriter();
					out.print("true");
					out.flush();
					out.close();
				}else {
					PrintWriter out = response.getWriter();
					out.print("false");
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
