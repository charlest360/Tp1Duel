package abstracts.duel;

import exceptions.duel.SpellEfficacityIsTooHighException;
import exceptions.duel.SpellEfficacityIsTooLowException;

public abstract class Spell implements ISkill {
	
	
	public int efficacity;
	
	
	
	public Spell(int efficacity) {
		ValidateSpellEfficacity(efficacity);
		this.efficacity = efficacity;
	}
	
	private void ValidateSpellEfficacity(int efficacity) {
		if (efficacity < MINIMUM_ATTRIBUTE_VALUE) {throw new SpellEfficacityIsTooLowException();}
		if (efficacity > MAXIMUM_ATTRIBUTE_VALUE) {throw new SpellEfficacityIsTooHighException();}
	}
	
	public int getCapacityPower(IFighter fighter) {
		return (fighter.getIntellect()*this.efficacity)/100;//MS Mettre les chiffres fixes dans des constantes.
	}
	
	
}
