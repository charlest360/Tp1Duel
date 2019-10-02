package implementation.duel;

import abstracts.duel.IParry;
import exceptions.duel.ShieldProtectionIsTooHighException;
import exceptions.duel.ShieldProtectionIsTooLowException;

public class Shield implements IParry {

	public final int MINIMUM_PROTECTION = 20;
	public final int MAXIMUM_PROTECTION = 100; 
	
	public int protection;
	
	
	
	public Shield(int protection) {
		validateShieldAttributes(protection);
		this.protection = protection;
	}
	
	private void validateShieldAttributes(int protection) {
		
		if (protection < MINIMUM_PROTECTION) {throw new ShieldProtectionIsTooLowException();}
		
		if (protection > MAXIMUM_PROTECTION) {throw new ShieldProtectionIsTooHighException();}
	}
}
