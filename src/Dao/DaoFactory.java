package Dao;

import sun.net.www.content.text.plain;

public class DaoFactory {
	private static  PersonalDao personalDao =null;
	private static  QuestionDao questionDao = null;
	private static StatisticsDao statisticsDao = null;
	private static MessageDao messageDao =null;
	
	public static PersonalDao getPersonalDao(){
		if (personalDao == null) {
			personalDao = new PersonalDao();
		}
		return personalDao;
	}
	
	public static QuestionDao getQuestionDao(){
		if (questionDao == null) {
			questionDao = new QuestionDao();
		}
		return questionDao;
	}
	
	public static StatisticsDao getStatisticsDao(){
		if (statisticsDao == null) {
			statisticsDao = new StatisticsDao();
		}
		return statisticsDao;
	}
	
	public static MessageDao getMessageDao(){
		if (messageDao == null) {
			messageDao = new MessageDao();
		}
		return messageDao;
	}

}
