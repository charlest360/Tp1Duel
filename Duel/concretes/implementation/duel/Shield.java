package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.IFighter;
import abstracts.duel.IParry;
import exceptions.duel.ShieldProtectionIsTooHighException;
import exceptions.duel.ShieldProtectionIsTooLowException;

public class Shield implements IParry {

	//Attributes
	private int protection;
	
	
	//Constructor
	public Shield(int protection) {
		validateShieldAttributes(protection);
		this.protection = protection;
	}
	
	//Methods
	private void validateShieldAttributes(int protection) {
		
		if (protection < MINIMUM_ATTRIBUTE_VALUE) {throw new ShieldProtectionIsTooLowException();}
		
		if (protection > MAXIMUM_ATTRIBUTE_VALUE) {throw new ShieldProtectionIsTooHighException();}
	}

	@Override 
	public int getCapacityPower(IFighter fighter) {
		return (fighter.getStrength()*this.protection)/100;
	}
}
