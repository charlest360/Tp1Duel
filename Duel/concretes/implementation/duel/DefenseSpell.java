package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.IParry;
import abstracts.duel.Spell;

public class DefenseSpell extends Spell implements IParry {

	public DefenseSpell(int efficacity) {
		super(efficacity);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return super.getCapacityPower(fighter)*3;
	}
}
