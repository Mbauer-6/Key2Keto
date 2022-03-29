package application.Key2Keto.Tracker;

import application.Key2Keto.Account.Account;

public class DayViewLogic {
	private static Account account;
	private static String dayString;
	private static int dayInt;
	
	public static void setUserAccount(Account acct) {
		DayViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return DayViewLogic.account;
	}
	
	public static void setDay(String day) {
		DayViewLogic.dayString = day;
		System.out.println(DayViewLogic.dayString);
	}
	
	public static String getDayString() {
		return DayViewLogic.dayString;
	}
}
