package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.*;

public class WarriorTest {

	final String ANY_NAME = "Michael Scarn";
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	final int ANY_STRENGTH = 40;
	final int ANY_DEXTERITY  =25;
	final int ANY_INTELLECT = 15;
	final int ANY_FOCUS = 15;
	final ISkill ANY_SKILL = new SkillMock();
	
	final int MINIMUM_STRENGTH = 10;
	final int MINIMUM_DEXTERITY = 0;
	final int MINIMUM_INTELLECT = 0;
	final int MINIMUM_FOCUS = 0;
	
	@Test (expected = FighterStrengthIsNegativeException.class)	
	public void creatingWarrior_WHEN_strengthIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_STRENGTH = -1;
		
		//Act
		Fighter fighter= new Warrior(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingWarrior_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		Fighter fighter= new Warrior(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingWarrior_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		Fighter fighter= new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingWarrior_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		Fighter fighter= new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	@Test (expected = WarriorStrengthIsTooLowException.class)	
	public void creatingWarrior_WHEN_strengthIsLowerThenDexterityPlusTheMinimumBetwwenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_STRENGTH  = MINIMUM_DEXTERITY+Warrior.MIN_GAP_BETWEEN_STRENGTH_AND_DEXTERITY -1;
		//Act
		Fighter fighter = new Warrior(ANY_NAME,TOO_LOW_STRENGTH,MINIMUM_DEXTERITY,MINIMUM_INTELLECT,MINIMUM_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorStrengthIsTooLowException.class)	
	public void creatingWarrior_WHEN_strengthIsLowerThenIntellectPlusTheMinimumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_STRENGTH  =MINIMUM_INTELLECT + Warrior.MIN_GAP_BETWEEN_STRENGTH_AND_INTELLECT - 1;
		//Act
		Fighter fighter = new Warrior(ANY_NAME,TOO_LOW_STRENGTH,MINIMUM_DEXTERITY,MINIMUM_INTELLECT,MINIMUM_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorDexterityIsTooLowException.class)	
	public void creatingWarrior_WHEN_dexterityIsLowerThenIntellect_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_DEXTERITY  =ANY_INTELLECT-1;
		//Act
		Fighter fighter = new Warrior(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorDexterityIsTooLowException.class)	
	public void creatingWarrior_WHEN_dexterityIsLowerThanFocusPlusTheMaximumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_DEXTERITY  =ANY_FOCUS-Warrior.MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS-1;
		//Act
		Fighter fighter = new Warrior(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorIntellectIsTooLowException.class)	
	public void creatingWarrior_WHEN_intellectIsLowerThanFocusMinusTheMaximumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_INTELLECT  =ANY_FOCUS-Warrior.MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS-1;
		//Act
		Fighter fighter = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	

	//Autres tests
	
	@Test public void creatingValidWarrior_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
		//Arrange
		Fighter fighter = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act
		final int ACTUAL_HP = fighter.getHp();
		final int EXPECTED_HP = Fighter.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	
}
