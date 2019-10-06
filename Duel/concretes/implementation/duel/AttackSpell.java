package implementation.duel;

import abstracts.duel.IAttack;
import abstracts.duel.IFighter;
import abstracts.duel.Spell;

public class AttackSpell extends Spell implements IAttack {

	public AttackSpell(int efficacity) {
		super(efficacity);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return super.getCapacityPower(fighter)*3;
	}

}
