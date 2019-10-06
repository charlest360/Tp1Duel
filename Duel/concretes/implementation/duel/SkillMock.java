package implementation.duel;


import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class SkillMock implements ISkill {

	public SkillMock() {
		
	}
	
	
	@Override
	public int getCapacityPower(IFighter fighter) {
		return 0;
	}
	
}
