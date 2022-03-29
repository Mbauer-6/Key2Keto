package application.Key2Keto.Dashboard;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import application.Key2Keto.Account.Account;

class DashboardTest {
	private Account account;
	private Dashboard dash;
	DayOfWeek day = LocalDateTime.now().getDayOfWeek();
	private String dayText= day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

	@Test
	void test() {
		this.account = new Account("username123", "password123", "John", "McLastname", "Male", "5'9\"", 190, 24, "Modified");
		this.dash = new Dashboard(this.account);
		assertEquals("John", this.dash.getUserAccount().getFirstName());
		assertEquals(dayText, this.dash.getCurrentDay());
	}
}
