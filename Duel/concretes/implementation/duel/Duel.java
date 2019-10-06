package implementation.duel;

import abstracts.duel.IAttack;
import abstracts.duel.IDuel;
import abstracts.duel.IFighter;
import abstracts.duel.IRipost;
import abstracts.duel.ISkill;
import exceptions.duel.AtackerDoesntHaveSpecifiedSkillException;
import exceptions.duel.DefenderDoesntHaveSpecifiedSkillException;
import exceptions.duel.FighterCannotDuelHimselfException;

public class Duel implements IDuel {

	//Attributs de Duel
	private IFighter attacker;
	private IFighter defender;
	private IAttack attackerSkill;
	private IRipost defenderSkill;
	private int attackerSkillPower;
	private int defenderSkillPower;
	private int skillPowerDifference;
	private boolean hasLoserSurrendered;
	private IFighter winner;
	private IFighter loser;
	//Constantes
	public final int WINNER_ATTRIBUTES_INCREMENTATION_RATE =1;
	public final int LOSER_ATTRIBUTES_DECREMENTATION_RATE =1;
	
	public Duel(IFighter attacker,IFighter defender,IAttack attackerSkill) {
		if (attacker == defender) {
			throw new FighterCannotDuelHimselfException();
		}
		
		validateAttackerSkill(attacker,attackerSkill);
		
		this.attacker = attacker;
		this.attackerSkill = attackerSkill;
		this.defenderSkillPower = attackerSkill.getCapacityPower(attacker);
		
		this.defender = defender;
	}
	
	public void defenderSurrender() {
		this.winner = this.attacker;
		this.loser = this.defender;
		this.hasLoserSurrendered =true;	
	}
	
	public void defenderRipost(IRipost defenderSkill) {
		this.hasLoserSurrendered = false;
		
		chooseDefenderSkill(defenderSkill);
		performFight();
		
	}
	
	private void chooseDefenderSkill(IRipost defenderSkill) {
		
		validateDefenderSkill(defenderSkill);
		
		this.defenderSkill = defenderSkill;
		this.defenderSkillPower = defenderSkill.getCapacityPower(this.defender);
	}
	private void validateAttackerSkill(IFighter attacker,IAttack attackerSkill) {
		if (!(attacker.hasSkill(attackerSkill))) {
			throw new AtackerDoesntHaveSpecifiedSkillException();
		}
	}
	private void validateDefenderSkill(IRipost defenderSkill) {
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
	
	
	public void awardWinner(ISkill skillToAdd) {
		incrementWinnerAttributes();
		addSkillToWinner(skillToAdd);
	}
	
	private void incrementWinnerAttributes() {
		this.winner.setStrength( this.winner.getStrength() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
		this.winner.setDexterity( this.winner.getDexterity() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
		this.winner.setIntellect( this.winner.getIntellect() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
		this.winner.setFocus( this.winner.getFocus() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
	}
	
	private void addSkillToWinner(ISkill skillToAdd) {
		this.winner.addSkill(skillToAdd);
	}
	
	public void penalizeLoser() {	
		this.loser.setStrength(this.winner.getStrength() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setDexterity(this.winner.getDexterity() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setIntellect(this.winner.getIntellect() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		this.loser.setFocus(this.winner.getFocus() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		
		if (!(this.hasLoserSurrendered)) {
			this.loser.setHp(this.loser.getHp() -this.skillPowerDifference);
		}	
	}
	
	
}
