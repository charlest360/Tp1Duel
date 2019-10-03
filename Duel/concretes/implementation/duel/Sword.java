package implementation.duel;

import abstracts.duel.IAttack;
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
	public int getCapacityPower(int fighterStrength) {
		return(fighterStrength*this.impact)/100;
	}
}
