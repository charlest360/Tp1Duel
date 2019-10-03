package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.ISkill;
import exceptions.duel.*;

public class AttackSpellTest {
	
	final int TOO_LOW_EFFICACITY = ISkill.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_EFFICACITY = ISkill.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_EFFICACITY = 50;
	final int ANY_FIGHTER_INTELLECT = 20;
	
	@Test (expected = SpellEfficacityIsTooLowException.class)	
	public void creatingAttackSpell_WHEN_efficacityIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill attackSpell = new AttackSpell(TOO_LOW_EFFICACITY);
	}
	
	@Test (expected = SpellEfficacityIsTooHighException.class)	
	public void creatingAttackSpell_WHEN_efficacityIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill attackSpell = new AttackSpell(TOO_HIGH_EFFICACITY);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnAttackSpell_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		ISkill attackSpell = new AttackSpell(ANY_EFFICACITY);
		
		//Act
		final int ACTUAL_POWER = attackSpell.getCapacityPower(ANY_FIGHTER_INTELLECT);
		final int EXPECTED_POWER = (ANY_EFFICACITY*ANY_FIGHTER_INTELLECT/100)*3;
		//Assert
		
		assertEquals(EXPECTED_POWER,ACTUAL_POWER);
		
	}
}
