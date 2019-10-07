package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.Fighter;
import abstracts.duel.IFighter;
import abstracts.duel.ISkill;
import exceptions.duel.FighterDexterityIsNegativeException;
import exceptions.duel.FighterFocusIsNegativeException;
import exceptions.duel.FighterIntellectIsNegativeException;
import exceptions.duel.FighterStrengthIsNegativeException;
import exceptions.duel.SkillIsntInSkillListException;
import exceptions.duel.SumOfFightersAttributesIsTooHigh;
import exceptions.duel.WizardFocusIsTooLowException;
import exceptions.duel.WizardIntellectIsTooLowException;
import exceptions.duel.indexOutOfBoundsOfSkillListException;

public class WizardTest {
	
	final String ANY_NAME = "Michael Scarn";
	final int ANY_STRENGTH = 10;
	final int ANY_DEXTERITY = 10;
	final int ANY_INTELLECT = 30;
	final int ANY_FOCUS = 30;
	final ISkill ANY_SKILL = new SkillDummy();
	
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	//Tests des compétences aux valeurs négatives 
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void createsWizard_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		@SuppressWarnings("unused")
		Fighter fighter = new Wizard(ANY_NAME,TOO_HIGH_STRENGTH,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterStrengthIsNegativeException.class)	
	public void creatingWizard_WHEN_strengthIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_STRENGTH = -1;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard= new Wizard(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingWizard_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard= new Wizard(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingWizard_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard= new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingWizard_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard= new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	
	//Tests de la validation des compétences du Wizard
	
	@Test (expected = WizardIntellectIsTooLowException.class)	
	public void createsWizardWithStrengthHigherThanDexterity_WHEN_intellectLowerThanStrenghtPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int STRENGTH_HIGHER_THAN_DEXTERITY = ANY_DEXTERITY+1;
		final int TOO_LOW_INTELLECT = STRENGTH_HIGHER_THAN_DEXTERITY + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard = new Wizard(ANY_NAME,STRENGTH_HIGHER_THAN_DEXTERITY,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardIntellectIsTooLowException.class)	
	public void createsWizardWithDexterityHigherThanStrength_WHEN_intellectLowerThanDexterityPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int DEXTERITY_HIGHER_THAN_STRENGTH = ANY_STRENGTH+1;
		final int TOO_LOW_INTELLECT = DEXTERITY_HIGHER_THAN_STRENGTH + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,DEXTERITY_HIGHER_THAN_STRENGTH,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardFocusIsTooLowException.class)	
	public void createsWizardWithStrengthHigherThanDexterity_WHEN_focusLowerThanStrengthPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		final int STRENGTH_HIGHER_THAN_DEXTERITY = ANY_DEXTERITY+1;
		final int TOO_LOW_FOCUS = STRENGTH_HIGHER_THAN_DEXTERITY + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard = new Wizard(ANY_NAME,STRENGTH_HIGHER_THAN_DEXTERITY,ANY_DEXTERITY,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardFocusIsTooLowException.class)	
	public void createsWizardWithDexterityHigherThanStrength_WHEN_focusLowerThanDexterityPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int DEXTERITY_HIGHER_THAN_STRENGTH = ANY_STRENGTH+1;
		final int TOO_LOW_FOCUS = DEXTERITY_HIGHER_THAN_STRENGTH + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		@SuppressWarnings("unused")
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,DEXTERITY_HIGHER_THAN_STRENGTH,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	//Tests Set/get des attributs des Wizards
	
	@Test public void creatingValidWizard_WHEN_callingGetStrength_THEN_theWizardStrengthIsReturned() {
		
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act 
		final int EXPECTED_STRENGTH = ANY_STRENGTH;
		final int ACTUAL_STRENGTH = wizard.getStrength();
			
		//Assert
		assertEquals(EXPECTED_STRENGTH,ACTUAL_STRENGTH);
	}
		
	@Test public void creatingValidWizard_WHEN_callingGetDexterity_THEN_theWizardDexterityIsReturned() {
			
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act 
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY;
		final int ACTUAL_DEXTERITY = wizard.getDexterity();
			
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
		}
	
	@Test public void creatingValidWizard_WHEN_callingGetIntellect_THEN_theWizardIntellectIsReturned() {
			
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act 
		final int EXPECTED_INTELLECT = ANY_INTELLECT;
		final int ACTUAL_INTELLECT = wizard.getIntellect();
			
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}

	@Test public void creatingValidWizard_WHEN_callingGetFocus_THEN_theWizardFocusIsReturned() {
		
	//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
	//Act 
	final int EXPECTED_FOCUS = ANY_FOCUS;
	final int ACTUAL_FOCUS = wizard.getFocus();
		
	//Assert
	assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}

	@Test public void creatingValidWizard_WHEN_callingSetStrength_THEN_theWizardStrengthIsChanged() {
		
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		wizard.setStrength(ANY_STRENGTH+1);
		
		final int EXPECTED_STRENGTH = ANY_STRENGTH+1;
		final int ACTUAL_STRENGTH = wizard.getStrength();
				
		//Assert
		assertEquals(ACTUAL_STRENGTH,EXPECTED_STRENGTH);
	}
	
	@Test public void creatingValidWizard_WHEN_callingSetDexterity_THEN_theWizardDexterityIsChanged() {
		
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		wizard.setDexterity(ANY_DEXTERITY+1);
		
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY+1;
		final int ACTUAL_DEXTERITY = wizard.getDexterity();
				
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
	}

	@Test public void creatingValidWizard_WHEN_callingSetIntellect_THEN_theWizardIntellectIsChanged() {
		
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		wizard.setIntellect(ANY_INTELLECT+1);
		
		final int EXPECTED_INTELLECT = ANY_INTELLECT+1;
		final int ACTUAL_INTELLECT = wizard.getIntellect();
				
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}
	
	@Test public void creatingValidWizard_WHEN_callingSetFocus_THEN_theWizardFocusIsChanged() {
		
		//Arrange 
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		wizard.setFocus(ANY_FOCUS+1);
		
		final int EXPECTED_FOCUS = ANY_FOCUS+1;
		final int ACTUAL_FOCUS = wizard.getFocus();
				
		//Assert
		assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}
	
	@Test public void creatingValidWizard_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
		//Arrange
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act
		final int ACTUAL_HP = wizard.getHp();
		final int EXPECTED_HP = Wizard.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
			
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	@Test public void creatingValidWizard_WHEN_callingSetHp_THEN_theHpMustChange() {
		//Arrange
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		final int INITIAL_HP = wizard.getHp();
		//Act
		wizard.setHp(INITIAL_HP-1);
		
		final int ACTUAL_HP = wizard.getHp();
		final int EXPECTED_HP = INITIAL_HP-1;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	
	@Test public void creatingValidWizard_WHEN_callingSetHpWithHpHigherThanTheInitialHp_THEN_theHpMustTakeItsInitialValue() {
		//Arrange
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		final int INITIAL_HP = wizard.getHp();
		wizard.setHp(INITIAL_HP-20);
		//Act
		
		wizard.setHp(INITIAL_HP+10);
		
		final int ACTUAL_HP = wizard.getHp();
		final int EXPECTED_HP = INITIAL_HP;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	
	
	//Tests methods related to skills
	
	@Test public void creatingValidWizard_WHEN_callingGetSkillWithAnIndexOfZero_THEN_theFirstSkillIsReturned() {
		//Arrange
		final ISkill SKILL1 = new SkillDummy();
		final ISkill SKILL2 = new SkillDummy();
			
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
			
		//Act
		final ISkill ACTUAL_FIRST_SKILL = wizard.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL1;
							
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);
		
	}
		
	@Test public void creatingValidWizard_WHEN_addingSkill_THEN_theSkillIsAddedToTheList() {
		//Arrange
		final ISkill SKILL3 = new SkillDummy();
			
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act
		wizard.addSkill(SKILL3);
			
		final ISkill ACTUAL_THIRD_SKILL = wizard.getSkill(2);
		final ISkill EXPECTED_THIRD_SKILL = SKILL3;
					
		//Assert
		assertEquals(EXPECTED_THIRD_SKILL,ACTUAL_THIRD_SKILL);
		
	}
	
		
	@Test public void creatingValidWizard_WHEN_removingFirstSKill_THEN_secondSkillBecomesFirstSkill() {
		//Arrange
		final ISkill SKILL1 = new SkillDummy();
		final ISkill SKILL2 = new SkillDummy();
			
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
			
		//Act
		wizard.removeSkill(SKILL1);
			
		final ISkill ACTUAL_FIRST_SKILL = wizard.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL2;
					
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);	
		
	}
		
		
	@Test (expected = SkillIsntInSkillListException.class)	
	public void creatingWizard_WHEN_askingToRemoveSkillNotInList_THEN_anExceptionShouldBeThrown() {		
			
		//Arrange
		final ISkill SKILL_NOT_IN_LIST = new SkillDummy();
					
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
					
		//Act
		wizard.removeSkill(SKILL_NOT_IN_LIST);
	}
		
		
	@Test (expected = indexOutOfBoundsOfSkillListException.class)	
	public void creatingWizard_WHEN_callingGetSkillWithOutOfBoundIndex_THEN_anExceptionShouldBeThrown() {		
			
		//Arrange
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
					
		//Act
		wizard.getSkill(2);
	}
	
	@Test public void creatingValidWizard_WHEN_askingHasSkillWithSkillHeHas_THEN_hasSkillReturnsTrue() {
		//Arrange 
		final ISkill SKILL1 = new SkillDummy();
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,ANY_SKILL);
		
		//Act
		final boolean ACTUAL_ANSWER = wizard.hasSkill(SKILL1);
		final boolean EXPECTED_ANSWER = true;
		
		//Assert
		assertEquals(EXPECTED_ANSWER,ACTUAL_ANSWER);
	}
		
	@Test public void creatingValidWizard_WHEN_askingHasSkillWithSkillHeDoesntHave_THEN_hasSkillReturnsFalse() {
		//Arrange 
		final ISkill SKILL1 = new SkillDummy();
		IFighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act
		final boolean ACTUAL_ANSWER = wizard.hasSkill(SKILL1);
		final boolean EXPECTED_ANSWER = false;
		
		//Assert
		assertEquals(EXPECTED_ANSWER,ACTUAL_ANSWER);
	}
}
	

