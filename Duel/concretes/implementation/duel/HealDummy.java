package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.IHeal;

public class HealDummy implements IHeal {

	@Override
	public int getCapacityPower(IFighter fighter) {
		return 10;
	}

}
