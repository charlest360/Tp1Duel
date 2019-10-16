package implementation.duel;

import abstracts.duel.IAttack;

import abstracts.duel.IFighter;
import abstracts.duel.IRipost;
import abstracts.duel.ISkill;
import exceptions.duel.AtackerDoesntHaveSpecifiedSkillException;
import exceptions.duel.DefenderDoesntHaveSpecifiedSkillException;
import exceptions.duel.FighterCannotDuelHimselfException;

public class Duel {

	//Attributs de Duel
	private IFighter attacker;
	private IFighter defender;
	private IAttack attackerSkill;
	private IRipost defenderSkill;
	private int attackerSkillPower;
	private int defenderSkillPower;
	private int skillPowerDifference;
	private boolean hasLoserSurrendered = false;
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
		this.defenderSkillPower = this.attackerSkill.getCapacityPower(attacker);
		
		this.defender = defender;
	}
	
	public void defenderSurrender() {
		this.winner = this.attacker;
		this.loser = this.defender;
		this.hasLoserSurrendered =true;	
	}
	
	public void defenderRipost(IRipost defenderSkill) {
		chooseDefenderSkill(defenderSkill);
		performFight();
		
	}
	
	private void chooseDefenderSkill(IRipost defenderSkill) {
		
		validateDefenderSkill(defenderSkill);
		
		this.defenderSkill = defenderSkill;
		this.defenderSkillPower = this.defenderSkill.getCapacityPower(this.defender);
	}
	private void validateAttackerSkill(IFighter attacker,IAttack attackerSkill) {
		if (!(attacker.hasSkill(attackerSkill))) {
			throw new AtackerDoesntHaveSpecifiedSkillException();//MS Très bien.
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
		this.winner.setStrength( this.winner.getStrength() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );//MS Tell don't ask: il faut dire au fighter comment augmenter ses propriétés mais pas le faire à sa place...
		this.winner.setDexterity( this.winner.getDexterity() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
		this.winner.setIntellect( this.winner.getIntellect() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
		this.winner.setFocus( this.winner.getFocus() + WINNER_ATTRIBUTES_INCREMENTATION_RATE );
	}
	
	private void addSkillToWinner(ISkill skillToAdd) {
		this.winner.addSkill(skillToAdd);
	}
	
	public void penalizeLoser() {	
		if (this.loser.getStrength()>0) {
			this.loser.setStrength(this.loser.getStrength() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);//MS Tell don't ask: il faut dire au fighter comment augmenter ses propriétés mais pas le faire à sa place...
		}
		if (this.loser.getDexterity() > 0) {
			this.loser.setDexterity(this.loser.getDexterity() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		}
		if(this.loser.getIntellect() > 0) {
			this.loser.setIntellect(this.loser.getIntellect() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		}
		if(this.loser.getFocus() > 0) {
			this.loser.setFocus(this.loser.getFocus() - LOSER_ATTRIBUTES_DECREMENTATION_RATE);
		}
		if (!(this.hasLoserSurrendered)) {
			this.loser.setHp(this.loser.getHp() -this.skillPowerDifference);
		}	
	}
	
	
}
