package abstracts.duel;

import exceptions.duel.SpellEfficacityIsTooHighException;
import exceptions.duel.SpellEfficacityIsTooLowException;

public abstract class Spell {
	
	public final int MINIMUM_EFFICACITY =20;
	public final int MAXIMUM_EFFICACITY = 100;	
	
	
	public int efficacity;
	
	
	
	public Spell(int efficacity) {
		this.efficacity = efficacity;
	}
	
	public void ValidateSpellEfficacity(int efficacity) {
		if (efficacity < MINIMUM_EFFICACITY) {throw new SpellEfficacityIsTooLowException();}
		if (efficacity > MAXIMUM_EFFICACITY) {throw new SpellEfficacityIsTooHighException();}
	}
}
