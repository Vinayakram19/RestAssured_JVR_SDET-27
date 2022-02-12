package GenericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author VINAYAKARAM J
 *
 */

public class JavaUtillity {
	
	/**
	 * this method will generate a random value for every run
	 * @return
	 */

	public int getRandomNumber() {
		
		Random ran =new Random();
		int value = ran.nextInt();
		return value;
	
	}
}
