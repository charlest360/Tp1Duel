package implementation.duel;

import org.junit.Test;
import abstracts.duel.ICapacity;
import exceptions.duel.*;



public class SwordTest {
	
	final int TOO_LOW_IMPACT = ICapacity.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_IMPACT = ICapacity.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	@Test (expected = SwordImpactIsTooLowException.class)	
	public void creatingSword_WHEN_impactIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity sword = new Sword(TOO_LOW_IMPACT);
	}
	
	@Test (expected = SwordImpactIsTooHighException.class)	
	public void creatingSword_WHEN_impactIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity sword = new Sword(TOO_HIGH_IMPACT);
	}
}
