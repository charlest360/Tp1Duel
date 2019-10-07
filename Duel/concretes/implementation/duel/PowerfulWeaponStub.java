package implementation.duel;

import abstracts.duel.IAttack;
import abstracts.duel.IFighter;

public class PowerfulWeaponStub implements IAttack {

	@Override
	public int getCapacityPower(IFighter fighter) {
		return 100;
	}

}