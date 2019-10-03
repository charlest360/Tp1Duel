package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import exceptions.duel.*;
import abstracts.duel.ISkill;



public class ShieldTest {
	
	final int TOO_LOW_PROTECTION = ISkill.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_PROTECTION = ISkill.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	final int ANY_PROTECTION = 50;
	final int ANY_FIGHTER_STRENGTH = 20;
	
	@Test (expected = ShieldProtectionIsTooLowException.class)	
	public void creatingShield_WHEN_protectionIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill Shield = new Shield(TOO_LOW_PROTECTION);
	}
	
	@Test (expected = ShieldProtectionIsTooHighException.class)	
	public void creatingShield_WHEN_protectionIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ISkill Shield = new Shield(TOO_HIGH_PROTECTION);
	}
	
	@Test
	public void When_getCapacityPowerIsCalledOnShield_THEN_itShouldReturnTheGoodPower() {
		//Arrange
		ISkill shield = new Shield(ANY_PROTECTION);
		
		//Act
		final int ACTUAL_POWER = shield.getCapacityPower(ANY_FIGHTER_STRENGTH);
		final int EXPECTED_POWER = (ANY_PROTECTION*ANY_FIGHTER_STRENGTH/100);
		//Assert
		
		assertEquals(EXPECTED_POWER,ACTUAL_POWER);
		
	}
}
