package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.*;




public class AthleteTest {

	final String ANY_NAME = "Michael Scarn";
	final int ANY_STRENGTH = 21;
	final int ANY_DEXTERITY = 21;
	final int ANY_INTELLECT = 21;
	final int ANY_FOCUS = 21;
	final ISkill ANY_SKILL = new SkillMock();
	
	final int TOO_LOW_STRENGTH = Athlete.MINIMAL_STRENGTH -1;
	final int TOO_LOW_DEXTERITY = Athlete.MINIMAL_DEXTERITY -1;
	final int TOO_LOW_INTELLECT = Athlete.MINIMAL_INTELLECT -1;
	final int TOO_LOW_FOCUS = Athlete.MINIMAL_FOCUS -1;
	
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	
	@Test (expected = FighterStrengthIsNegativeException.class)	
	public void creatingAthlete_WHEN_strengthIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_STRENGTH = -1;
		
		//Act
		Fighter fighter= new Athlete(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingAthlete_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		Fighter fighter= new Athlete(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingAthlete_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		Fighter fighter= new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingAthlete_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		Fighter fighter= new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	@Test (expected = AthleteStrengthIsTooLowException.class)	
	public void creatingAthlete_WHEN_strengthIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,TOO_LOW_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteDexterityIsTooLowException.class)	
	public void creatingAthlete_WHEN_dexterityIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteIntellectIsTooLowException.class)	
	public void creatingAthlete_WHEN_intellectIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteFocusIsTooLowException.class)	
	public void creatingAthlete_WHEN_focusIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	
	}
	
	//Autres tests
	
		@Test public void creatingValidAthlete_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
			//Arrange
			Fighter fighter = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
			//Act
			final int ACTUAL_HP = fighter.getHp();
			final int EXPECTED_HP = Fighter.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
			
			//Assert
			assertEquals(EXPECTED_HP,ACTUAL_HP);
		}
}
