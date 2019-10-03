package implementation.duel;

import org.junit.Test;

import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.FighterStrengthIsNegativeException;
import exceptions.duel.SumOfFightersAttributesIsTooHigh;

public class FighterTest {
	
	//Cette classe test les tests communs pour tous les types de fighter 
	
	
	final String ANY_NAME = "Michael Scarn";
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	final ISkill ANY_SKILL = new SkillMock();
	
	//Athlete 
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void creatingAthlete_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter fighter = new Athlete(ANY_NAME,TOO_HIGH_STRENGTH,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	
	
	
	//Warrior
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void creatingWarrior_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter fighter = new Warrior(ANY_NAME,TOO_HIGH_STRENGTH,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	//Wizard
	
	@Test (expected = SumOfFightersAttributesIsTooHigh.class)	
	public void createsWizard_WHEN_SumOfFightersAttributesHigherThanMaximalSumOfFightersAttributes_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter fighter = new Wizard(ANY_NAME,TOO_HIGH_STRENGTH,TOO_HIGH_DEXTERITY,TOO_HIGH_INTELLECT,TOO_HIGH_FOCUS,ANY_SKILL,ANY_SKILL);
	}
}
