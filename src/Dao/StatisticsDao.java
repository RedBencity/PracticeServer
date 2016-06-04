package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang.SystemUtils;

import util.Constants;
import util.DBManager;
import vo.Rank;
import vo.Statistics;

public class StatisticsDao {

	private Connection connection = null;
	private PreparedStatement pstmt = null;

	public void insert(String phone, String subject, int rightCount,
			int totalCount) throws Exception {
		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select * from "
				+ "statistics where phone=?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int right = Integer.parseInt(rs.getString(subject + "right"));
			int total = Integer.parseInt(rs.getString(subject + "total"));
			System.out.println("统计: " + right + "  " + total);
			connection = DBManager.initConnection();
			pstmt = connection
					.prepareStatement("update " + "statistics set " + subject
							+ "right=?," + subject + "total=? where phone =?");
			pstmt.setInt(1, rightCount + right);
			pstmt.setInt(2, totalCount + total);
			pstmt.setString(3, phone);
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);

		} else {
			pstmt = connection.prepareStatement("insert into "
					+ "statistics(phone," + subject + "right," + subject
					+ "total_count)values(?,?,?)");
			pstmt.setString(1, phone);
			pstmt.setInt(2, rightCount);
			pstmt.setInt(3, totalCount);
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);
		}
	}

	public Statistics getAll(String phone, String subject) throws Exception {
		Statistics statistics = new Statistics();
		connection = DBManager.initConnection();
		pstmt = connection.prepareStatement("select * from "
				+ "statistics where phone=?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			statistics.setRightCount(Integer.parseInt(rs.getString(subject
					+ "right")));
			statistics.setTotalCount(Integer.parseInt(rs.getString(subject
					+ "total")));
			DBManager.close(pstmt, connection);
		} else {
			connection = DBManager.initConnection();
			String sql = "";

			sql += "insert into " + "statistics(phone,";
			String[] subjects = new String[] { "yingyu_", "yuwen_", "shuxue_" };
			for (int i = 0; i < subjects.length - 1; i++) {
				sql += subjects[i] + "right," + subjects[i] + "total,";
			}
			sql += subjects[subjects.length - 1] + "right,"
					+ subjects[subjects.length - 1] + "total)values(?,";
			for (int i = 0; i < subjects.length - 1; i++) {
				sql += "?,?,";
			}
			sql += "?,?)";
			System.out.println(sql);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, phone);
			for (int i = 2; i <= subjects.length * 2 + 1; i++) {
				pstmt.setInt(i, 0);
			}
			pstmt.executeUpdate();
			DBManager.close(pstmt, connection);

			statistics.setRightCount(0);
			statistics.setTotalCount(0);
		}
		return statistics;
	}

	public void setAll(String phone) throws Exception {
		connection = DBManager.initConnection();
		String sql = "";

		sql += "insert into " + "statistics(phone,";
		String[] subjects = new String[] { "yingyu_", "yuwen_", "shuxue_" };
		for (int i = 0; i < subjects.length - 1; i++) {
			sql += subjects[i] + "right," + subjects[i] + "total,";
		}
		sql += subjects[subjects.length - 1] + "right,"
				+ subjects[subjects.length - 1] + "total)values(?,";
		for (int i = 0; i < subjects.length - 1; i++) {
			sql += "?,?,";
		}
		sql += "?,?)";
		System.out.println(sql);
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, phone);
		for (int i = 2; i <= subjects.length * 2 + 1; i++) {
			pstmt.setInt(i, 0);
		}
		pstmt.executeUpdate();
		DBManager.close(pstmt, connection);
	}

	public String getRank() throws Exception {

		ArrayList<Rank> aRanks = new ArrayList<Rank>();
		Rank rank;
		connection = DBManager.initConnection();
		pstmt = connection
				.prepareStatement("select * from "
						+ "personal,statistics where  personal.p_phone = statistics.phone");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			rank = new Rank();
			rank.setPhone(rs.getString("phone"));
			rank.setNickname(rs.getString("p_nickname"));

			int total = 0;
			for (int i = 0; i < Constants.subjects.length; i++) {
				total += rs.getInt(Constants.subjects[i] + "total");
			}

			rank.setTotal(total);
			aRanks.add(rank);
		}
		DBManager.close(pstmt, connection);
		Collections.sort(aRanks);
		
		String rankStr = "";
		for (int i = 0; i < aRanks.size(); i++) {
			rankStr +=aRanks.get(i).getPhone();
			rankStr+="#";
			rankStr+=aRanks.get(i).getNickname();
			rankStr+="#";
			rankStr +=aRanks.get(i).getTotal()+"@";
		}
		rankStr = rankStr.substring(0, rankStr.length()-1);
		return rankStr;
	}

	public static void main(String[] args) {
		StatisticsDao statisticsDao = new StatisticsDao();
		try {
			System.out.println(statisticsDao.getRank());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
