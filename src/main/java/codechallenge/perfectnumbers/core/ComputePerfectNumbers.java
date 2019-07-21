package codechallenge.perfectnumbers.core;

import java.text.MessageFormat;
import java.util.*;

import codechallenge.perfectnumbers.exception.NumberRangeException;

/**
 * @author kolin
 *
 */
public class ComputePerfectNumbers {


	/**
	 * @param number
	 * @return Returns true if given number is a perfect number. Otherwise returns false.
	 */
	public static boolean isPerfectNumber(final long number) {

		try {
			if (number > 1) {

				long  sum = 0L;

				for (int i = 1; i <= number/2; i++){
					if (number % i == 0)
					{
						sum += i;
					}
				}
				if (sum == number){
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * @param startNumber, endNumber 
	 * @return Returns a list of perfect numbers between the given "startNumber" and "endNumber" number range. 
	 * 		   If no any perfect numbers found then returns an empty list. 
	 */
	public static List<Long> getPerfectNumbers(final long startNumber, final long endNumber) throws NumberRangeException {

		if (endNumber > 0) {

			List<Long> perfectNumbersList = new ArrayList<>();

			try {

				for(int n = 1;; n++) {

					long mersennerNumber = ComputeNumbersUtil.getMersenneNumber(n);

					if (ComputeNumbersUtil.isPrimeNumber(mersennerNumber)) {

						long perfectNumber = ComputeNumbersUtil.getPowerOfTwo(n - 1) * mersennerNumber;

						if (ComputeNumbersUtil.between(perfectNumber, startNumber, endNumber)){
							perfectNumbersList.add(perfectNumber);
						}
						if (perfectNumber > endNumber) {
							break;
						}
					} else if (mersennerNumber < 0) {
						break;
					}
				}

				return perfectNumbersList;

			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
				return perfectNumbersList;
			}
		}else {
			throw new NumberRangeException(MessageFormat.format(" Given number range is invalid ", startNumber, endNumber));    	
		}
	}



}


