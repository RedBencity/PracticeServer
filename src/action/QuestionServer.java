package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import vo.Question;
import vo.Statistics;

import Dao.DaoFactory;

public class QuestionServer extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String requestType = request.getParameter("requestType");
		System.out.println(requestType);
		try {
			if (requestType.equals("getQuestion")) {
				String phone = request.getParameter("phone");
				String subject = request.getParameter("subject");
				String point = request.getParameter("point");
				point = convertName(subject, point);
				PrintWriter out = response.getWriter();
				out.print(DaoFactory.getQuestionDao().getQuestion(request, phone, subject, point));
				out.flush();
				out.close();
			} else if (requestType.equals("uploadQuestionNumber")) {
				String phone = request.getParameter("phone");
				String numberStr = request.getParameter("questionNumber");
				String subject = request.getParameter("subject");
				String point = request.getParameter("point");
				point = convertName(subject, point);
				DaoFactory.getQuestionDao().insertQuestionNumber(phone, point, numberStr);
			} else if (requestType.equals("uploadQuestionCondition")) {
				String phone = request.getParameter("phone");
				String subject = request.getParameter("subject");
				subject = convertName(subject);
				int rightCount = Integer.parseInt(request.getParameter("rightCount"));
				int totalCount = Integer.parseInt(request.getParameter("totalCount"));
				DaoFactory.getStatisticsDao().insert(phone, subject, rightCount, totalCount);

			} else if (requestType.equals("getCountCondition")) {
				String phone = request.getParameter("phone");
				String subject = request.getParameter("subject");
				subject = convertName(subject);
				Statistics statistics = new Statistics();
				statistics = DaoFactory.getStatisticsDao().getAll(phone, subject);
				PrintWriter out = response.getWriter();
				out.print(statistics.getRightCount() + "@" + statistics.getTotalCount());
				out.flush();
				out.close();
			} else if (requestType.equals("getRank")) {
				String phone = request.getParameter("phone");
				PrintWriter out = response.getWriter();
				out.print(DaoFactory.getStatisticsDao().getRank());
				out.flush();
				out.close();

			} else if (requestType.equals("uploadCollectQuestion")) {
				String phone = request.getParameter("phone");
				String number = request.getParameter("questionNumber");
				String subject = request.getParameter("subject");
				String point = request.getParameter("point");
				point = convertName(subject, point);
				DaoFactory.getQuestionDao().updateCollectQuestion(phone, point, number);
			} else if (requestType.equals("getCollectQuestion")) {
				String phone = request.getParameter("phone");
				String subject = request.getParameter("subject");
				ArrayList<Question> questions = new ArrayList<Question>();
				questions = DaoFactory.getQuestionDao().getCollectQuestion(request, phone, subject);
				String string = "";
				if (questions.size() != 0) {
					for (int i = 0; i < questions.size() - 1; i++) {
						string += questions.get(i).getTitle() + "@" + questions.get(i).getA() + "@" + questions.get(i).getB() + "@" + questions.get(i).getC()
								+ "@" + questions.get(i).getD() + "@" + questions.get(i).getAnswer() + "@" + questions.get(i).getAnalyze() + "#";
					}
					string += questions.get(questions.size() - 1).getTitle() + "@" + questions.get(questions.size() - 1).getA() + "@"
							+ questions.get(questions.size() - 1).getB() + "@" + questions.get(questions.size() - 1).getC() + "@"
							+ questions.get(questions.size() - 1).getD() + "@" + questions.get(questions.size() - 1).getAnswer() + "@"
							+ questions.get(questions.size() - 1).getAnalyze();
				} else if (questions.size() == 0) {
					string = "no";
				}
				PrintWriter out = response.getWriter();
				System.out.println(string);
				out.print(string);
				out.flush();
				out.close();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String convertName(String subject, String point) {
		String[] points = null;
		String[] pinyins = null;
		if (subject.equals(Constants.subjects_c[2])) {
			points = Constants.yingyu_c;
			pinyins = Constants.yingyu_e;

		} else if (subject.equals(Constants.subjects_c[0])) {
			points = Constants.yuwen_c;
			pinyins = Constants.yuwen_e;
		} else if (subject.equals(Constants.subjects_c[1])) {
			points = Constants.shuxue_c;
			pinyins = Constants.shuxue_e;
		}
		for (int i = 0; i < points.length; i++) {
			if (point.equals(points[i])) {
				point = pinyins[i];
			}
		}

		return point;
	}

	private String convertName(String subject) {
		if (subject.equals("英语")) {
			subject = "yingyu_";

		} else if (subject.equals("语文")) {
			subject = "yuwen_";
		} else if (subject.equals("数学")) {
			subject = "shuxue_";
		}
		return subject;
	}

}
