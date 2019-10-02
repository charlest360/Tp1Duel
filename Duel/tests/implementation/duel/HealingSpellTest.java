package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.ICapacity;
import exceptions.duel.*;

public class HealingSpellTest {
	final int TOO_LOW_EFFICACITY = ICapacity.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_EFFICACITY = ICapacity.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_EFFICACITY = 50;
	final int ANY_FIGHTER_INTELLECT = 20;
	
	@Test (expected = SpellEfficacityIsTooLowException.class)	
	public void creatingHealingSpell_WHEN_efficacityIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity healingSpell = new HealingSpell(TOO_LOW_EFFICACITY);
	}
	
	
	@Test (expected = SpellEfficacityIsTooHighException.class)	
	public void creatingHealingSpell_WHEN_efficacityIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity healingSpell = new HealingSpell(TOO_HIGH_EFFICACITY);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnHealingSpell_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		ICapacity healingSpell = new HealingSpell(ANY_EFFICACITY);
		
		//Act
		final int ACTUAL_EFFICACITY = healingSpell.getCapacityPower(ANY_FIGHTER_INTELLECT);
		final int EXPECTED_EFFICACITY = (ANY_EFFICACITY*ANY_FIGHTER_INTELLECT/100);
		//Assert
		
		assertEquals(EXPECTED_EFFICACITY,ACTUAL_EFFICACITY);
		
	}
}
