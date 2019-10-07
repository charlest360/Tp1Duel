package implementation.duel;

import java.util.ArrayList;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class FighterWinnerStub implements IFighter {
	
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private int strength;
	@SuppressWarnings("unused")
	private int dexterity;
	@SuppressWarnings("unused")
	private int intellect;
	@SuppressWarnings("unused")
	private int focus;
	@SuppressWarnings("unused")
	private int hp;
	private ArrayList<ISkill> skillList = new ArrayList<ISkill>();
	
	public FighterWinnerStub(String name, int strength, int dexterity, int intellect, int focus, ISkill skill1,ISkill skill2) {
	this.name = name;
	this.strength = strength;
	this.dexterity =dexterity;
	this.intellect = intellect;
	this.focus = focus;
	
	this.skillList.add(skill1);
	this.skillList.add(skill2);
	}
	
	
	
	//Methods used in tests
	@Override
	public void addSkill(ISkill skill) {
		this.skillList.add(skill);
		
	}
	
	@Override
	public boolean hasSkill(ISkill skill) {
		if(this.skillList.contains(skill)) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	//Methods unused in tests
	
	
	
	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHp(int newHp) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeSkill(ISkill skill) {
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
