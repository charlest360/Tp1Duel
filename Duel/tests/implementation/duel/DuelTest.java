package implementation.duel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import abstracts.duel.IAttack;
import abstracts.duel.IFighter;
import abstracts.duel.IRipost;
import abstracts.duel.ISkill;
import exceptions.duel.*;


public class DuelTest {
	
	
	
	final ISkill ANY_SKILL = new  SkillDummy();
	final IRipost ANY_RIPOST = new RipostDummy();
	final IAttack ANY_ATTACK =  new AttackDummy();
	final int ANY_FIGHTER_ATTRIBUTE_VALUE = 10;
	final String ANY_FIGHTER_NAME = "Shrek 2";
	final IAttack ANY_WINNING_WEAPON = new PowerfulWeaponStub(); //Gagne contre toute autre skill car getCapacityPower retourne 100 tandis que les autres mocks retournent 0
	
	public FighterStub anyFighter ;//MS devrait être private et de type IFighter.
	
	
	@Before
	public void initializeAnyFighter() {
		anyFighter= new FighterStub(ANY_FIGHTER_NAME,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_FIGHTER_ATTRIBUTE_VALUE,ANY_RIPOST,ANY_ATTACK);
	}
	
	
	
	@Test (expected = FighterCannotDuelHimselfException.class)	
	public void creatingDuel_WHEN_attackerAndDefenderAreTheSameFighter_THEN_anExceptionShouldBeThrown() {		
		
		//Act
		@SuppressWarnings("unused")
		Duel duel = new Duel(anyFighter,anyFighter,ANY_ATTACK);
	}
	
	
	@Test (expected = AtackerDoesntHaveSpecifiedSkillException.class)	
	public void creatingDuel_WHEN_attackerDoesntHaveTheAttackerSkill_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		IFighter attacker = new NoSkillFighterStub();
		final IAttack AN_ATTACK_SKILL = new AttackDummy();
		
		//Act
		@SuppressWarnings("unused")
		Duel duel = new Duel(attacker,anyFighter,AN_ATTACK_SKILL);
	}
	
	@Test (expected = DefenderDoesntHaveSpecifiedSkillException.class)	
	public void creatingDuel_WHEN_defenderDoesntHaveTheRipostSkill_THEN_anExceptionShouldBeThrown() {		
		
		//Arrange
		IFighter defender = new NoSkillFighterStub();
		final IRipost A_RIPOST_SKILL = new RipostDummy();
		
		Duel duel = new Duel(anyFighter,defender,ANY_ATTACK);
		
		//Act
		duel.defenderRipost(A_RIPOST_SKILL);	
	}
	
	
	@Test
	public void creatingDuel_WHEN_attackerWins_THEN_hisStatsAreAskedToBeChangedFourTimes() {
		//Arrange 
		final FighterStub WINNING_ATTACKER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_DEFENDER = anyFighter;
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_WINNING_WEAPON);
		
		duel.defenderRipost(ANY_RIPOST);
		
		//Act
		duel.awardWinner(ANY_SKILL);
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = WINNING_ATTACKER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_WINNER_INCREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	@Test
	public void creatingDuel_WHEN_attackerLoses_THEN_hisStatsAreAskedToBeChangedFiveTimes() {
		//Arrange 
		final FighterStub WINNING_DEFENDER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_ATTACKER = anyFighter;
		
		Duel duel = new Duel(LOSING_ATTACKER,WINNING_DEFENDER,ANY_ATTACK);
		
		duel.defenderRipost(ANY_WINNING_WEAPON);
		
		//Act
		duel.penalizeLoser();
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = LOSING_ATTACKER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_LOSER_DECREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	@Test
	public void creatingDuel_WHEN_attackerWins_THEN_heWinsOneNewSkill() {
		//Arrange 
		final FighterWinnerStub WINNING_ATTACKER = new FighterWinnerStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_DEFENDER = anyFighter;
		final ISkill A_NEW_SKILL = new SkillDummy();
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_WINNING_WEAPON);
		
		duel.defenderRipost(ANY_RIPOST);
		
		//Act
		duel.awardWinner(A_NEW_SKILL);
		
		
		//Assert
		assertTrue(WINNING_ATTACKER.hasSkill(A_NEW_SKILL));
		
	}
	
	
	
	@Test
	public void creatingDuel_WHEN_defenderWins_THEN_hisStatsAreAskedToBeChangedFourTimes() {
		//Arrange 
		final FighterStub WINNING_DEFENDER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_ATTACKER = anyFighter;
		
		Duel duel = new Duel(LOSING_ATTACKER,WINNING_DEFENDER,ANY_ATTACK);
		
		duel.defenderRipost(ANY_WINNING_WEAPON);
		
		//Act
		duel.awardWinner(ANY_SKILL);
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = WINNING_DEFENDER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_WINNER_INCREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	@Test
	public void creatingDuel_WHEN_defenderLoses_THEN_hisStatsAreAskedToBeChangedFiveTimes() {
		//Arrange 
		final FighterStub WINNING_ATTACKER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_DEFENDER = anyFighter;
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_WINNING_WEAPON);
		
		duel.defenderRipost(ANY_RIPOST);
		
		//Act
		duel.penalizeLoser();
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = LOSING_DEFENDER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_LOSER_DECREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	@Test
	public void creatingDuel_WHEN_defenderWins_THEN_heWinsOneNewSkill() {
		//Arrange 
		final FighterWinnerStub WINNING_DEFENDER = new FighterWinnerStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_WINNING_WEAPON, ANY_SKILL);
		final FighterStub LOSING_ATTACKER = anyFighter;
		final ISkill A_NEW_SKILL = new SkillDummy();
		
		Duel duel = new Duel(LOSING_ATTACKER,WINNING_DEFENDER,ANY_ATTACK);
		
		duel.defenderRipost(ANY_WINNING_WEAPON);
		
		//Act
		duel.awardWinner(A_NEW_SKILL);
		
		
		//Assert
		assertTrue(WINNING_DEFENDER.hasSkill(A_NEW_SKILL));
		
	}
	
	
	
	
	@Test
	public void creatingDuel_WHEN_resultOfDuelIsTied_THEN_attackerWins() {
		//Arrange 
		
		final FighterStub LOSING_DEFENDER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		final FighterStub WINNING_ATTACKER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_ATTACK);
		
		duel.defenderRipost(ANY_ATTACK);
		
		//Act
		duel.awardWinner(ANY_SKILL);
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = WINNING_ATTACKER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_WINNER_INCREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	
	
	@Test
	public void creatingDuel_WHEN_defenderSurrender_THEN_attackerWins() {
		//Arrange 
		
		final FighterStub LOSING_DEFENDER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		final FighterStub WINNING_ATTACKER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_ATTACK);
		
		duel.defenderSurrender();
		
		//Act
		duel.awardWinner(ANY_SKILL);
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS = WINNING_ATTACKER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_WINNER_INCREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	
	@Test
	public void creatingDuel_WHEN_defenderSurrender_THEN_defenderLoses() {
		//Arrange 
		
		final FighterStub LOSING_DEFENDER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		final FighterStub WINNING_ATTACKER = new FighterStub(ANY_FIGHTER_NAME, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_FIGHTER_ATTRIBUTE_VALUE, ANY_ATTACK, ANY_SKILL);
		
		Duel duel = new Duel(WINNING_ATTACKER,LOSING_DEFENDER,ANY_ATTACK);
		
		duel.defenderSurrender();
		
		//Act
		duel.penalizeLoser();
		
		
		final int ACTUAL_NB_OF_STATS_CHANGE_CALLS =LOSING_DEFENDER.nbOfAttributesSettingFunctionCalls;
		final int EXPECTED_NB_OF_STATS_CHANGES_CALLS = FighterStub.NB_OF_ATTRIBUTES_LOSER_THAT_SURRENDER_DECREMENTS;
		
		//Assert
		assertEquals(EXPECTED_NB_OF_STATS_CHANGES_CALLS,ACTUAL_NB_OF_STATS_CHANGE_CALLS);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
