package implementation.duel;


import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class SkillDummy implements ISkill {

	public SkillDummy() {
		
	}
	
	
	@Override
	public int getCapacityPower(IFighter fighter) {
		return 0;
	}
	
}
