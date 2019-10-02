package implementation.duel;

import abstracts.duel.IHeal;
import abstracts.duel.Spell;

public class HealingSpell extends Spell implements IHeal {

	public HealingSpell(int efficacity) {
		super(efficacity);
	}

	@Override
	public int getCapacityPower(int fighterIntellect) {
		return super.getCapacityPower(fighterIntellect);
	}
	
}
