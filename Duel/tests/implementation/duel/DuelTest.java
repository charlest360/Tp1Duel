package implementation.duel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import abstracts.duel.IAttack;
import abstracts.duel.IFighter;
import abstracts.duel.IRipost;
import abstracts.duel.ISkill;
import exceptions.duel.*;


public class DuelTest {
	
	
	
	final ISkill ANY_SKILL = new  SkillMock();
	final IRipost ANY_RIPOST = new RipostMock();
	final IAttack ANY_ATTACK =  new AttackMock();
	final int ANY_FIGHTER_ATTRIBUTE_VALUE = 10;
	final String ANY_FIGHTER_NAME = "Shrek 2";
	final IAttack ANY_WINNING_WEAPON = new PowerfulWeaponMock(); //Gagne contre toute autre skill car getCapacityPower retourne 100 tandis que les autres mocks retournent 0
	
	public IFighter anyFighter ;
	
	
	@Before
	public void initializeAnyFighter() {
		anyFighter= new FighterMock(ANY_FIGHTER_NAME,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_RIPOST,ANY_ATTACK);
	}
	
	
	
	@Test (expected = FighterCannotDuelHimselfException.class)	
	public void creatingDuel_WHEN_attackerAndDefenderAreTheSameFighter_THEN_anExceptionShouldBeThrown() {		
		
		//Act
		Duel duel = new Duel(anyFighter,anyFighter,ANY_ATTACK);
	}
	
	
	@Test (expected = AtackerDoesntHaveSpecifiedSkillException.class)	
	public void creatingDuel_WHEN_attackerDoesntHaveTheAttackerSkill_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		IFighter attacker = new NoSkillFighterMock();
		final IAttack AN_ATTACK_SKILL = new AttackMock();
		
		//Act
		Duel duel = new Duel(attacker,anyFighter,AN_ATTACK_SKILL);
	}
	
	@Test (expected = DefenderDoesntHaveSpecifiedSkillException.class)	
	public void creatingDuel_WHEN_defenderDoesntHaveTheRipostSkill_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		IFighter defender = new NoSkillFighterMock();
		final IRipost A_RIPOST_SKILL = new RipostMock();
		
		Duel duel = new Duel(anyFighter,defender,ANY_ATTACK);
		
		//Act
		duel.defenderRipost(A_RIPOST_SKILL);	
	}
	
	
	@Test
	public void creatingDuel_WHEN_attackerWins_THEN_hisStatsAreAskedToBeChanged() {
		//Arrange 
		final IFighter WINNING_ATTACKER = new FighterMock(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final IFighter LOSING_DEFENDER = anyFighter;
		
		
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_WINNING_WEAPON);
		//Act
		
	}
}
