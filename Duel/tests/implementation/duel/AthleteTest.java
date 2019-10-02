package implementation.duel;

import org.junit.Test;


import abstracts.duel.Fighter;
import exceptions.duel.*;




public class AthleteTest {

	final String ANY_NAME = "Michael Scarn";
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void createsAthlete_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter fighter1 = new Athlete(ANY_NAME,TOO_HIGH_STRENGTH,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS);
	}
	
	
}
