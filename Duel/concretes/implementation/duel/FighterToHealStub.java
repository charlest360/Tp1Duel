package implementation.duel;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class FighterToHealStub implements IFighter {
	
	
	
	private  boolean hasSetHpBeenCalled= false;
	private  boolean hasRemoveSkillBeenCalled = false;

	public FighterToHealStub(ISkill skill2) {
			
	}
	
	//Methods useds in testing infirmary
	
	@Override
	public void setHp(int newHp) {
		this.hasSetHpBeenCalled = true;
		
	}
	
	@Override
	public void removeSkill(ISkill skill) {
		this.hasRemoveSkillBeenCalled = true;
		
	}
	
	@Override
	public int getHp() {
		return 0;
	}
	
	@Override
	public boolean hasSkill(ISkill skill) {
		return true;
	}
	
	public boolean getHasSetUpHpBeenCalled() {
		return this.hasSetHpBeenCalled;
	}
	
	public boolean getHasRemoveSkillHpBeenCalled() {
		return this.hasRemoveSkillBeenCalled;
	}
	
	//Unused methods in testing infirmary
	
	

	

	@Override
	public void addSkill(ISkill skill) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public ISkill getSkill(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStrength(int newStrength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDexterity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDexterity(int newDexterity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIntellect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIntellect(int newIntellect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFocus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFocus(int newFocus) {
		// TODO Auto-generated method stub
		
	}

	

}
