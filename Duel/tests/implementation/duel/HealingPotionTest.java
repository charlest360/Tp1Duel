package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;
import exceptions.duel.*;

public class HealingPotionTest {
	
	final int TOO_LOW_EFFICACITY = ISkill.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_EFFICACITY = ISkill.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_EFFICACITY = 50;
	final int ANY_FIGHTER_DEXTERITY = 20;
	
	final String ANY_NAME = "John Doe";
	final int ANY_POINTS = 20;
	
	@Test (expected = HealingPotionEfficacityIsTooLowException.class)	
	public void creatingHealingPotion_WHEN_impactIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill potion = new HealingPotion(TOO_LOW_EFFICACITY);
	}
	
	@Test (expected = HealingPotionEfficacityIsTooHighException.class)	
	public void creatingHealingPotion_WHEN_impactIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill potion = new HealingPotion(TOO_HIGH_EFFICACITY);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnHealingPotion_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		
		ISkill potion = new HealingPotion(ANY_EFFICACITY);
		IFighter ANY_FIGHTER_MOCK = new FighterMock(ANY_NAME,ANY_POINTS,ANY_FIGHTER_DEXTERITY,ANY_POINTS,ANY_POINTS,potion,potion);
		
		
		//Act
		final int ACTUAL_POWER = potion.getCapacityPower(ANY_FIGHTER_MOCK);
		final int EXPECTED_POWER = (ANY_FIGHTER_DEXTERITY*ANY_EFFICACITY/100);
		//Assert
		
		assertEquals(EXPECTED_POWER,ACTUAL_POWER);
		
	}
}
