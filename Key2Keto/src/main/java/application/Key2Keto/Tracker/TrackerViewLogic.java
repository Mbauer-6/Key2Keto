package application.Key2Keto.Tracker;

import application.Key2Keto.Account.Account;

public class TrackerViewLogic {
	private static Account account;
	
	public static void setUserAccount(Account acct) {
		TrackerViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return TrackerViewLogic.account;
	}
}
