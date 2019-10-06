package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.IAttack;
import abstracts.duel.IFighter;
import exceptions.duel.SwordImpactIsTooHighException;
import exceptions.duel.SwordImpactIsTooLowException;

public class Sword implements IAttack {
	
	//Attributes
	private int impact;
	
	
	//Constructor
	public Sword(int impact) {
		validateSwordAttributes(impact);
		this.impact = impact;
	}
	
	
	//Methods
	private void validateSwordAttributes(int impact) {
		
		if (impact < MINIMUM_ATTRIBUTE_VALUE) {throw new SwordImpactIsTooLowException();}
		
		if (impact > MAXIMUM_ATTRIBUTE_VALUE) {throw new SwordImpactIsTooHighException();}
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return(fighter.getStrength()*this.impact)/100;
	}
}
