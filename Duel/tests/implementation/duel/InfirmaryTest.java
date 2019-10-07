package implementation.duel;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import exceptions.duel.*;
import abstracts.duel.IFighter;
import abstracts.duel.IHeal;
import abstracts.duel.ISkill;

public class InfirmaryTest {
	
	
	
	
	final IHeal ANY_HEALING_SKILL = new HealDummy();
	final ISkill ANY_SKILL = new SkillDummy();
	Infirmary infirmary;
	IFighter fighter;
	
	@Before
	public void setUpInfirmary() {
		infirmary = new Infirmary();
	}
	
	@Test (expected = FighterDoesntHaveRequiredHealingSkillException.class)	
	public void healingFighter_WHEN_heDoesntHaveTheHealingSkill_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		IFighter fighter = new NoSkillFighterStub();
		//Act
		infirmary.healFighter(fighter, ANY_HEALING_SKILL);
	}
	
	@Test 
	public void healingFighter_WHEN_applyingHealingSkillHealingSkill_THEN_setHpIsCalledOnFighter() {	
		//Arrange
		FighterToHealStub fighter = new FighterToHealStub(ANY_HEALING_SKILL);
		//Act
		infirmary.healFighter(fighter, ANY_HEALING_SKILL);
		//Assert
		assertTrue(fighter.getHasSetUpHpBeenCalled());
	}
	
	@Test
	public void healingFighter_WHEN_applyingHealingSkillHealingSkill_THEN_removeSkillIsCalled() {	
		//Arrange
		FighterToHealStub fighter = new FighterToHealStub(ANY_HEALING_SKILL);
		//Act
		infirmary.healFighter(fighter, ANY_HEALING_SKILL);
		//Assert
		assertTrue(fighter.getHasRemoveSkillHpBeenCalled());
	}
}
