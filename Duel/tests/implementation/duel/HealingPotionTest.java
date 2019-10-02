package implementation.duel;

import org.junit.Test;

import abstracts.duel.ICapacity;
import exceptions.duel.*;

public class HealingPotionTest {
	final int TOO_LOW_EFFICACITY = ICapacity.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_EFFICACITY = ICapacity.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	@Test (expected = SwordImpactIsTooLowException.class)	
	public void creatingSword_WHEN_impactIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity potion = new HealingPotion(TOO_LOW_EFFICACITY);
	}
	
	@Test (expected = SwordImpactIsTooHighException.class)	
	public void creatingSword_WHEN_impactIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity potion = new HealingPotion(TOO_HIGH_EFFICACITY);
	}
}
