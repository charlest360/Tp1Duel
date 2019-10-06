package implementation.duel;

import abstracts.duel.IAttack;
import abstracts.duel.IDuel;
import abstracts.duel.IFighter;
import abstracts.duel.IRipostSkill;
import exceptions.duel.AtackerDoesntHaveSpecifiedSkillException;
import exceptions.duel.DefenderDoesntHaveSpecifiedSkillException;


public class Duel implements IDuel {

	//Attributs de Duel
	private IFighter attacker;
	private IFighter defender;
	private IAttack attackerSkill;
	private IRipostSkill defenderSkill;
	private int attackerSkillPower;
	private int defenderSkillPower;
	private int skillPowerDifference;
	private boolean hasLoserSurrendered;
	private IFighter winner;
	private IFighter loser;
	
	
	public final int WINNER_ATTRIBUTES_INCREMENTATION_RATE =1;
	public final int LOSER_ATTRIBUTES_DECREMENTATION_RATE =1;
	
	public Duel(IFighter attacker,IFighter defender,IAttack attackerSkill) {
		
		validateAttackerSkill(attacker,attackerSkill);
		
		this.attacker = attacker;
		this.attackerSkill = attackerSkill;
		this.defenderSkillPower = attackerSkill.getCapacityPower(attacker);
		
		this.defender = defender;
	}
	
	public void surrender(boolean isDefenderSurrendering) {
		this.winner = this.attacker;
		this.loser = this.defender;
		this.hasLoserSurrendered =true;
		
	}
	
	public void ripost(IRipostSkill defenderSkill) {
		this.hasLoserSurrendered = false;
		
		chooseDefenderSkill(defenderSkill);
		performFight();
		
	}
	
	private void chooseDefenderSkill(IRipostSkill defenderSkill) {
		
		validateDefenderSkill(defenderSkill);
		
		this.defenderSkill = defenderSkill;
		this.defenderSkillPower = defenderSkill.getCapacityPower(this.defender);
	}
	
	private void validateAttackerSkill(IFighter attacker,IAttack attackerSkill) {
		if (!(attacker.hasSkill(attackerSkill))) {
			throw new AtackerDoesntHaveSpecifiedSkillException();
		}
	}
	
	private void validateDefenderSkill(IRipostSkill defenderSkill) {
		if (!(this.defender.hasSkill(defenderSkill))) {
			throw new DefenderDoesntHaveSpecifiedSkillException();
		}
	}
	
	private void performFight() {
		if(this.attackerSkillPower >= this.defenderSkillPower) {
			this.skillPowerDifference = this.attackerSkillPower - this.defenderSkillPower;
			this.winner = this.attacker;
			this.loser = this.defender;
		}
		else {
			this.winner=this.defender;
			this.loser=this.attacker;
		}	
	}
	
	
	private void awardWinner() {
		incrementWinnerAttributes();
		
	}
	
	private void incrementWinnerAttributes() {
		final int INITIAL_STRENGTH = this.winner.getStrength();
		final int INITIAL_DEXTERITY = this.winner.getDexterity();
		final int INITIAL_INTELLECT = this.winner.getIntellect();
		final int INITIAL_FOCUS = this.winner.getFocus();
		
		this.winner.setStrength(INITIAL_STRENGTH + WINNER_ATTRIBUTES_INCREMENTATION_RATE);
		this.winner.setDexterity(INITIAL_DEXTERITY + WINNER_ATTRIBUTES_INCREMENTATION_RATE);
		this.winner.setIntellect(INITIAL_INTELLECT + WINNER_ATTRIBUTES_INCREMENTATION_RATE);
		this.winner.setFocus(INITIAL_FOCUS + WINNER_ATTRIBUTES_INCREMENTATION_RATE);
	}
	
	private void penalizeLoser(boolean hasLoserSurrendered) {
		final int INITIAL_STRENGTH = this.loser.getStrength();
		final int INITIAL_DEXTERITY = this.loser.getDexterity();
		final int INITIAL_INTELLECT = this.loser.getIntellect();
		final int INITIAL_FOCUS = this.loser.getFocus();
		final int INITIAL_HP = this.loser.getHp();
		
		this.loser.setStrength(INITIAL_STRENGTH - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setDexterity(INITIAL_DEXTERITY - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setIntellect(INITIAL_INTELLECT - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setFocus(INITIAL_FOCUS - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		
		
		if (!(hasLoserSurrendered)) {
			this.loser.setHp(INITIAL_HP-this.skillPowerDifference);
		}	
	}
	
	
}
