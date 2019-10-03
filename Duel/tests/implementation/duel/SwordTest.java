package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import abstracts.duel.ISkill;
import exceptions.duel.*;



public class SwordTest {
	
	final int TOO_LOW_IMPACT = ISkill.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_IMPACT = ISkill.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_IMPACT = 50;
	final int ANY_FIGHTER_STRENGTH = 20;
	
	@Test (expected = SwordImpactIsTooLowException.class)	
	public void creatingSword_WHEN_impactIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill sword = new Sword(TOO_LOW_IMPACT);
	}
	
	@Test (expected = SwordImpactIsTooHighException.class)	
	public void creatingSword_WHEN_impactIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill sword = new Sword(TOO_HIGH_IMPACT);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnSword_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		ISkill sword = new Sword(ANY_IMPACT);
		
		//Act
		final int ACTUAL_POWER = sword.getCapacityPower(ANY_FIGHTER_STRENGTH);
		final int EXPECTED_POWER = (ANY_IMPACT*ANY_FIGHTER_STRENGTH/100);
		//Assert
		
		assertEquals(EXPECTED_POWER,ACTUAL_POWER);
		
	}
}
