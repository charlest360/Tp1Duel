package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.IHeal;
import exceptions.duel.FighterDoesntHaveRequiredHealingSkillException;

public class Infirmary {
	public Infirmary() {
		
	}
	
	public void healFighter(IFighter fighter,IHeal healingSkill) {
		validateFighterHasHealingSkill(fighter,healingSkill);
		applyHealingSkill(fighter, healingSkill);
		removeHealingSkill(fighter,healingSkill);
	}
	
	private void validateFighterHasHealingSkill(IFighter fighter,IHeal healingSkill) {
		if(!(fighter.hasSkill(healingSkill))) {
			throw new FighterDoesntHaveRequiredHealingSkillException();
		}
	}
	
	private void applyHealingSkill(IFighter fighter,IHeal healingSkill) {
		int healingPower = healingSkill.getCapacityPower(fighter);
		
		fighter.setHp(fighter.getHp()+healingPower);//MS Tell don't ask pas respecté.
	}
	
	private void removeHealingSkill(IFighter fighter,IHeal healingSkill) {
		fighter.removeSkill(healingSkill);
	}
}
