package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.IRipost;

public class RipostMock implements IRipost{

	@Override
	public int getCapacityPower(IFighter fighter) {
		return 0;
	}

}
