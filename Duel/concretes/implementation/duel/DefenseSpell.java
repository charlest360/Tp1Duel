package implementation.duel;

import abstracts.duel.IParry;
import abstracts.duel.Spell;

public class DefenseSpell extends Spell implements IParry {

	public DefenseSpell(int efficacity) {
		super(efficacity);
	}

	@Override
	public int getCapacityPower(int fighterIntellect) {
		return super.getCapacityPower(fighterIntellect)*3;
	}
}
