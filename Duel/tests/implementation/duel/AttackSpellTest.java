package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.ICapacity;
import exceptions.duel.*;

public class AttackSpellTest {
	
	final int TOO_LOW_EFFICACITY = ICapacity.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_EFFICACITY = ICapacity.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_EFFICACITY = 50;
	final int ANY_FIGHTER_INTELLECT = 20;
	
	@Test (expected = SpellEfficacityIsTooLowException.class)	
	public void creatingAttackSpell_WHEN_efficacityIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity attackSpell = new AttackSpell(TOO_LOW_EFFICACITY);
	}
	
	@Test (expected = SpellEfficacityIsTooHighException.class)	
	public void creatingAttackSpell_WHEN_efficacityIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity attackSpell = new AttackSpell(TOO_HIGH_EFFICACITY);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnAttackSpell_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		ICapacity attackSpell = new AttackSpell(ANY_EFFICACITY);
		
		//Act
		final int ACTUAL_EFFICACITY = attackSpell.getCapacityPower(ANY_FIGHTER_INTELLECT);
		final int EXPECTED_EFFICACITY = (ANY_EFFICACITY*ANY_FIGHTER_INTELLECT/100)*3;
		//Assert
		
		assertEquals(EXPECTED_EFFICACITY,ACTUAL_EFFICACITY);
		
	}
}
