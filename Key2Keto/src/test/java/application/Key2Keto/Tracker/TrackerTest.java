package application.Key2Keto.Tracker;

import application.Key2Keto.Tracker.Tracker;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrackerTest {
	private Tracker sut;
	private String day = "Monday";
	
	@Test
	void testConstructor() {
		sut = new Tracker(day);
		assertEquals("Monday", sut.getDayOfWeek());
		assertEquals(0.0, sut.getHoursOfSleep());
		assertEquals(0.0, sut.getHoursOfSleep());
	}
	
	@Test
	void testSleepSetterAndGetter() {
		sut = new Tracker(day);
		sut.setHoursOfSleep(10);
		assertEquals(10, sut.getHoursOfSleep());
	}
	
	@Test
	void testWaterIntakeSetterAndGetter() {
		sut = new Tracker(day);
		sut.setWaterIntake(34.6);
		assertEquals(34.6, sut.getWaterIntake());
	}
	
	@Test
	void testAddingAndGettingGoal() {
		sut = new Tracker(day);
		String goal = "Drink 64 ounces of water everyday";
		sut.addGoal(goal);
		assertEquals("Drink 64 ounces of water everyday", sut.goals.get(0));
	}
}
