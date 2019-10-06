package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.Fighter;
import abstracts.duel.IFighter;
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
		IFighter warrior= new Warrior(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingWarrior_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		IFighter warrior= new Warrior(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingWarrior_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		IFighter warrior= new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingWarrior_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		IFighter warrior= new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	@Test (expected = WarriorStrengthIsTooLowException.class)	
	public void creatingWarrior_WHEN_strengthIsLowerThenDexterityPlusTheMinimumBetwwenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_STRENGTH  = MINIMUM_DEXTERITY+Warrior.MIN_GAP_BETWEEN_STRENGTH_AND_DEXTERITY -1;
		//Act
		IFighter warrior = new Warrior(ANY_NAME,TOO_LOW_STRENGTH,MINIMUM_DEXTERITY,MINIMUM_INTELLECT,MINIMUM_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorStrengthIsTooLowException.class)	
	public void creatingWarrior_WHEN_strengthIsLowerThenIntellectPlusTheMinimumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_STRENGTH  =MINIMUM_INTELLECT + Warrior.MIN_GAP_BETWEEN_STRENGTH_AND_INTELLECT - 1;
		//Act
		IFighter warrior = new Warrior(ANY_NAME,TOO_LOW_STRENGTH,MINIMUM_DEXTERITY,MINIMUM_INTELLECT,MINIMUM_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorDexterityIsTooLowException.class)	
	public void creatingWarrior_WHEN_dexterityIsLowerThenIntellect_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_DEXTERITY  =ANY_INTELLECT-1;
		//Act
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorDexterityIsTooLowException.class)	
	public void creatingWarrior_WHEN_dexterityIsLowerThanFocusPlusTheMaximumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_DEXTERITY  =ANY_FOCUS-Warrior.MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS-1;
		//Act
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WarriorIntellectIsTooLowException.class)	
	public void creatingWarrior_WHEN_intellectIsLowerThanFocusMinusTheMaximumBetweenThem_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int TOO_LOW_INTELLECT  =ANY_FOCUS-Warrior.MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS-1;
		//Act
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	//Tests Set/get des attributs des fighters
	
	@Test public void creatingValidWarrior_WHEN_callingGetStrength_THEN_theWarriorStrengthIsReturned() {
			
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		final int EXPECTED_STRENGTH = ANY_STRENGTH;
		final int ACTUAL_STRENGTH = warrior.getStrength();
				
		//Assert
		assertEquals(EXPECTED_STRENGTH,ACTUAL_STRENGTH);
	}
			
	@Test public void creatingValidWarrior_WHEN_callingGetDexterity_THEN_theWarriorDexterityIsReturned() {
				
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY;
		final int ACTUAL_DEXTERITY = warrior.getDexterity();
				
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
		}
		
	@Test public void creatingValidWarrior_WHEN_callingGetIntellect_THEN_theWarriorIntellectIsReturned() {
				
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		final int EXPECTED_INTELLECT = ANY_INTELLECT;
		final int ACTUAL_INTELLECT = warrior.getIntellect();
				
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}

	@Test public void creatingValidWarrior_WHEN_callingGetFocus_THEN_theWarriorFocusIsReturned() {
			
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act 
		final int EXPECTED_FOCUS = ANY_FOCUS;
		final int ACTUAL_FOCUS = warrior.getFocus();
			
		//Assert
		assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}	
	
	@Test public void creatingValidWarrior_WHEN_callingSetStrength_THEN_theWarriorStrengthIsChanged() {
		
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		warrior.setStrength(ANY_STRENGTH+1);
		
		final int EXPECTED_STRENGTH = ANY_STRENGTH+1;
		final int ACTUAL_STRENGTH = warrior.getStrength();
				
		//Assert
		assertEquals(EXPECTED_STRENGTH,EXPECTED_STRENGTH);
	}
	
	@Test public void creatingValidWarrior_WHEN_callingSetDexterity_THEN_theWarriorDexterityIsChanged() {
		
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		warrior.setDexterity(ANY_DEXTERITY+1);
		
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY+1;
		final int ACTUAL_DEXTERITY = warrior.getDexterity();
				
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
	}

	@Test public void creatingValidWarrior_WHEN_callingSetIntellect_THEN_theWarriorIntellectIsChanged() {
		
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		warrior.setIntellect(ANY_INTELLECT+1);
		
		final int EXPECTED_INTELLECT = ANY_INTELLECT+1;
		final int ACTUAL_INTELLECT = warrior.getIntellect();
				
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}
	
	@Test public void creatingValidWarrior_WHEN_callingSetFocus_THEN_theWarriorFocusIsChanged() {
		
		//Arrange 
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		warrior.setFocus(ANY_FOCUS+1);
		
		final int EXPECTED_FOCUS = ANY_FOCUS+1;
		final int ACTUAL_FOCUS = warrior.getFocus();
				
		//Assert
		assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}
	
	@Test public void creatingValidWarrior_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
		//Arrange
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act
		final int ACTUAL_HP = warrior.getHp();
		final int EXPECTED_HP = Fighter.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	@Test public void creatingValidWarrior_WHEN_callingSetHp_THEN_theHpMustHaveChange() {
		//Arrange
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		final int INITIAL_HP = warrior.getHp();
		//Act
		warrior.setHp(INITIAL_HP-1);
		
		final int ACTUAL_HP = warrior.getHp();
		final int EXPECTED_HP = INITIAL_HP-1;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	
	

	//Tests methods related to skills
	
	@Test public void creatingValidWarrior_WHEN_callingGetSkillWithAnIndexOfZero_THEN_theFirstSkillIsReturned() {
		//Arrange
		final ISkill SKILL1 = new SkillMock();
		final ISkill SKILL2 = new SkillMock();
		
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
		
		//Act
		final ISkill ACTUAL_FIRST_SKILL = warrior.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL1;
						
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);
	
	}
	
	@Test public void creatingValidWarrior_WHEN_addingSkill_THEN_theSkillIsAddedToTheList() {
		//Arrange
		final ISkill SKILL3 = new SkillMock();
		
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act
		warrior.addSkill(SKILL3);
		
		final ISkill ACTUAL_THIRD_SKILL = warrior.getSkill(2);
		final ISkill EXPECTED_THIRD_SKILL = SKILL3;
				
		//Assert
		assertEquals(EXPECTED_THIRD_SKILL,ACTUAL_THIRD_SKILL);
	
	}
	@Test public void creatingValidWarrior_WHEN_removingFirstSKill_THEN_secondSkillBecomesFirstSkill() {
		//Arrange
		final ISkill SKILL1 = new SkillMock();
		final ISkill SKILL2 = new SkillMock();
		
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
		
		//Act
		warrior.removeSkill(SKILL1);
		
		final ISkill ACTUAL_FIRST_SKILL = warrior.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL2;
				
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);	
	
	}
	
	@Test (expected = SkillIsntInSkillListException.class)	
	public void creatingWarrior_WHEN_askingToRemoveSkillNotInList_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final ISkill SKILL_NOT_IN_LIST = new SkillMock();
				
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act
		warrior.removeSkill(SKILL_NOT_IN_LIST);
	}
	
	@Test (expected = indexOutOfBoundsOfSkillListException.class)	
	public void creatingWarrior_WHEN_callingGetSkillWithOutOfBoundIndex_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		IFighter warrior = new Warrior(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act
		warrior.getSkill(2);
	}
	
}
