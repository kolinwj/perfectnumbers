package codechallenge.perfectnumbers.unit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import codechallenge.perfectnumbers.core.ComputePerfectNumbers;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

/**
 * @author kolin
 * Uses parameterized list of pre-defined data set to verifying,
 *  The given number is a perfect number or not
 *  Should false for invalid numbers  
 */

@RunWith(Parameterized.class)
public class IsPerfectNumberUnitTest {

	private long actualNumber;
	private boolean expectedNumber;

	public IsPerfectNumberUnitTest(long actualNumber, boolean fExpected) {
		this.actualNumber = actualNumber;
		this.expectedNumber = fExpected;
	}

	@Parameterized.Parameters(name = "{index} : isPerfectNumber({0}) == {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ -2, false},
			{ 0, false},
			{ 4, false},
			{ 6, true }, 
			{ 28, true },
			{ 1000, false },
			{ 8128, true } ,
			{ 550, false }
		});
	}

	@Test
	public void testIsPerfectNumber() {
		assertEquals(expectedNumber, ComputePerfectNumbers.isPerfectNumber(actualNumber));
	}
}
