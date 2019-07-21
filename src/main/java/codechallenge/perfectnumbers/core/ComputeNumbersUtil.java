package codechallenge.perfectnumbers.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kolin
 *
 */
public class ComputeNumbersUtil {


	public static boolean between(long number,final long minValueInclusive,final long maxValueInclusive) {
		if (number >= minValueInclusive && number <= maxValueInclusive)
			return true;
		else
			return false;
	}

	static boolean isPrimeNumber(final long number) {
		if (number == 2 || number == 3) return true;
		if (number < 2 || number % 2 == 0 || number % 3 == 0) return false;

		for(long i = 5; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static Map<String, Long> powerOfTwo = new HashMap<>();

	static long getPowerOfTwo(final int exponent) {
		if (exponent >= 0) {
			String stringExpression = String.valueOf(exponent);

			if (powerOfTwo.containsKey(stringExpression)) {
				return powerOfTwo.get(stringExpression);
			} else {
				if (exponent == 0) {
					powerOfTwo.put(String.valueOf(0), Long.valueOf(1));
					return 1;
				} else {
					long value = (long) Math.pow(2, exponent);
					powerOfTwo.put(String.valueOf(exponent), Long.valueOf(value));
					return value;
				}
			}
		} else {
			return -1;
		}
	}

	static long getMersenneNumber(final int exponent) {
		if (exponent > 0 && exponent < 65) {
			return getPowerOfTwo(exponent) - 1;
		} else {
			return -1;
		}
	}

	
}
