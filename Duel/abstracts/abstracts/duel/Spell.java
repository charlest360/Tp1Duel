package abstracts.duel;

import exceptions.duel.SpellEfficacityIsTooHighException;
import exceptions.duel.SpellEfficacityIsTooLowException;

public abstract class Spell implements ICapacity {
	
	
	public int efficacity;
	
	
	
	public Spell(int efficacity) {
		ValidateSpellEfficacity(efficacity);
		this.efficacity = efficacity;
	}
	
	private void ValidateSpellEfficacity(int efficacity) {
		if (efficacity < MINIMUM_ATTRIBUTE_VALUE) {throw new SpellEfficacityIsTooLowException();}
		if (efficacity > MAXIMUM_ATTRIBUTE_VALUE) {throw new SpellEfficacityIsTooHighException();}
	}
	
	public int getCapacityPower(int fighterIntellect) {
		return (fighterIntellect*this.efficacity)/100;
	}
	
	
}
