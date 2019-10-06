package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class NoSkillFighterMock implements IFighter {
	
	
	public NoSkillFighterMock() {
		
	}
	
	//Method used for tests
	@Override
	public boolean hasSkill(ISkill skill) {
		return false;
	}
	
	
	
	
	
	
	
	//Methods unused for tests
	@Override
	public int getHp() {
		return 0;
	}

	@Override
	public void setHp(int newHp) {
		
	}

	@Override
	public void addSkill(ISkill skill) {
		
	}

	@Override
	public void removeSkill(ISkill skill) {
		
	}

	@Override
	public ISkill getSkill(int index) {
		return null;
	}

	@Override
	public int getCapacityPower(ISkill skill) {
		return 0;
	}

	@Override
	public int getStrength() {
		return 0;
	}

	@Override
	public void setStrength(int newStrength) {
	}

	@Override
	public int getDexterity() {
		return 0;
	}

	@Override
	public void setDexterity(int newDexterity) {
	}

	@Override
	public int getIntellect() {
		return 0;
	}

	@Override
	public void setIntellect(int newIntellect) {

	}

	@Override
	public int getFocus() {
		return 0;
	}

	@Override
	public void setFocus(int newFocus) {
	}



}
