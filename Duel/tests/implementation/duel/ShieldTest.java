package implementation.duel;

import org.junit.Test;
import exceptions.duel.*;
import abstracts.duel.ICapacity;



public class ShieldTest {
	
	final int TOO_LOW_PROTECTION = ICapacity.MINIMUM_ATTRIBUTE_VALUE -1;
	final int TOO_HIGH_PROTECTION = ICapacity.MAXIMUM_ATTRIBUTE_VALUE +1;
	
	@Test (expected = ShieldProtectionIsTooLowException.class)	
	public void creatingShield_WHEN_protectionIsToLow_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity Shield = new Shield(TOO_LOW_PROTECTION);
	}
	
	@Test (expected = ShieldProtectionIsTooHighException.class)	
	public void creatingShield_WHEN_protectionIsToHigh_THEN_anExceptionShouldBeThrown() {		
		//Act
		ICapacity Shield = new Shield(TOO_HIGH_PROTECTION);
	}
}
