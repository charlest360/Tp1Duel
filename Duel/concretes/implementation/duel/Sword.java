package implementation.duel;

import abstracts.duel.IAttack;
import exceptions.duel.SwordImpactIsToHighException;
import exceptions.duel.SwordImpactIsToLowException;

public class Sword implements IAttack {
	
	public final int MINIMUM_IMPACT = 20;
	public final int MAXIMUM_IMPACT = 100; 
	
	public int impact;
	
	
	
	public Sword(int impact) {
		validateSwordAttributes(impact);
		this.impact = impact;
	}
	
	private void validateSwordAttributes(int impact) {
		
		if (impact < MINIMUM_IMPACT) {throw new SwordImpactIsToLowException();}
		
		if (impact > MAXIMUM_IMPACT) {throw new SwordImpactIsToHighException();}
	}
}
