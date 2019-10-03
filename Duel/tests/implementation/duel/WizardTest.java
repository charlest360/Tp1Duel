package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.FighterDexterityIsNegativeException;
import exceptions.duel.FighterFocusIsNegativeException;
import exceptions.duel.FighterIntellectIsNegativeException;
import exceptions.duel.FighterStrengthIsNegativeException;
import exceptions.duel.WizardFocusIsTooLowException;
import exceptions.duel.WizardIntellectIsTooLowException;

public class WizardTest {
	
	final String ANY_NAME = "Michael Scarn";
	final int ANY_STRENGTH = 10;
	final int ANY_DEXTERITY = 10;
	final int ANY_INTELLECT = 30;
	final int ANY_FOCUS = 30;
	final ISkill ANY_SKILL = new SkillMock();
	
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	//Tests des compétences aux valeurs négatives 
	
	@Test (expected = FighterStrengthIsNegativeException.class)	
	public void creatingWizard_WHEN_strengthIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_STRENGTH = -1;
		
		//Act
		Fighter fighter= new Wizard(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingWizard_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		Fighter fighter= new Wizard(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingWizard_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		Fighter fighter= new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingWizard_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		Fighter fighter= new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	
	//Tests de la validation des compétences du Wizard
	
	@Test (expected = WizardIntellectIsTooLowException.class)	
	public void createsWizardWithStrengthHigherThanDexterity_WHEN_intellectLowerThanStrenghtPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int STRENGTH_HIGHER_THAN_DEXTERITY = ANY_DEXTERITY+1;
		final int TOO_LOW_INTELLECT = STRENGTH_HIGHER_THAN_DEXTERITY + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		Fighter wizard = new Wizard(ANY_NAME,STRENGTH_HIGHER_THAN_DEXTERITY,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardIntellectIsTooLowException.class)	
	public void createsWizardWithDexterityHigherThanStrength_WHEN_intellectLowerThanDexterityPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int DEXTERITY_HIGHER_THAN_STRENGTH = ANY_STRENGTH+1;
		final int TOO_LOW_INTELLECT = DEXTERITY_HIGHER_THAN_STRENGTH + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		Fighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,DEXTERITY_HIGHER_THAN_STRENGTH,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardFocusIsTooLowException.class)	
	public void createsWizardWithStrengthHigherThanDexterity_WHEN_focusLowerThanStrengthPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int STRENGTH_HIGHER_THAN_DEXTERITY = ANY_DEXTERITY+1;
		final int TOO_LOW_FOCUS = STRENGTH_HIGHER_THAN_DEXTERITY + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		Fighter wizard = new Wizard(ANY_NAME,STRENGTH_HIGHER_THAN_DEXTERITY,ANY_DEXTERITY,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = WizardFocusIsTooLowException.class)	
	public void createsWizardWithDexterityHigherThanStrength_WHEN_focusLowerThanDexterityPlusTheirMinimalGap_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		
		final int DEXTERITY_HIGHER_THAN_STRENGTH = ANY_STRENGTH+1;
		final int TOO_LOW_FOCUS = DEXTERITY_HIGHER_THAN_STRENGTH + Wizard.MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY -1 ;
		
		//Act
		Fighter wizard = new Wizard(ANY_NAME,ANY_STRENGTH,DEXTERITY_HIGHER_THAN_STRENGTH,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	//Autres tests
	
		@Test public void creatingValidWizard_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
			//Arrange
			Fighter fighter = new Wizard(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
			//Act
			final int ACTUAL_HP = fighter.getHp();
			final int EXPECTED_HP = Fighter.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
			
			//Assert
			assertEquals(EXPECTED_HP,ACTUAL_HP);
		}
	
}
