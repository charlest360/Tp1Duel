package implementation.duel;

import abstracts.duel.IParry;
import abstracts.duel.Spell;

public class DefenseSpell extends Spell implements IParry {

	public DefenseSpell(int efficacity) {
		super(efficacity);
	}

}
