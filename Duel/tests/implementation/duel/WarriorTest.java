package implementation.duel;

import org.junit.Test;

import abstracts.duel.Fighter;
import exceptions.duel.SumOfFightersAttributesIsTooHigh;

public class WarriorTest {

	final int TOO_HIGH_STRENGHT = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void createsWarrior_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter fighter1 = new Warrior(TOO_HIGH_STRENGHT,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS);
	}
}
