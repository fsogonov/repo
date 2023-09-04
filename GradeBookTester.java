import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTester {
	
	GradeBook vova = new GradeBook(5);
	GradeBook masha = new GradeBook(5);
	@BeforeEach
	void setUp() throws Exception {
		
		boolean add;
		add = vova.addScore(50.0);
		add = vova.addScore(40.0);
		add = vova.addScore(30.0);
		add = vova.addScore(60.0);
		add = vova.addScore(90.0);
		add = masha.addScore(50.0);
		add = masha.addScore(20.0);
		add = masha.addScore(10.0);
		add = masha.addScore(80.0);
		add = masha.addScore(70.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		vova = null;
		masha = null;
	}
	
	@Test
	void test() throws Exception {
		setUp();
		assertTrue(vova.toString().equals("50.0, 40.0, 30.0, 60.0, 90.0, "));
		assertEquals(vova.getScoreSize(), 5);
		assertEquals(vova.sum(), 270.0);
		assertEquals(vova.minimum(), 30.0);
		assertEquals(vova.finalScore(), 240.0);
	}
}
