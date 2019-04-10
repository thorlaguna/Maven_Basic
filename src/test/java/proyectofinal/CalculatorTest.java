package proyectofinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class CalculatorTest {

	Calculator calc = new Calculator();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSumTwoNumbers() {

		assertEquals("El test ha fallado,"
				+ " el resultado no es 7"
				, 7, calc.sum(2, 5));
		assertEquals("El test ha fallado,"
				+ " el resultado no es 13", 13, calc.sum(5, 8));
	}

	@Test
	void testSumTwoEvenNumbers() {
		assertEquals("", 6, calc.sum(2, 4));
		assertEquals("", 24, calc.sum(16, 8));
	}

	@Test
	void testSumTwoOddNumbers() {
		assertEquals("", 6, calc.sum(1, 5));
		assertEquals("", 24, calc.sum(15, 9));
	}

	@Test
	void testSumPariety() {
		assertTrue("", calc.sum(1, 5) % 2 == 0);
		assertTrue("", calc.sum(2, 4) % 2 == 0);
	}

}
