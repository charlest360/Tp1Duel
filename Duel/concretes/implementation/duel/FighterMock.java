package implementation.duel;

import java.util.ArrayList;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class FighterMock implements IFighter  {
	
	private String name;
	private int strength;
	private int dexterity;
	private int intellect;
	private int focus;
	private int hp;
	private ArrayList<ISkill> skillList = new ArrayList<ISkill>();
	
	public final int NB_OF_ATTRIBUTES_WINNER_INCREMENTS = 4; //Strength,Dexterity,Intellect and Focus
	public final int NB_OF_ATTRIBUTES_LOSER_DECREMENTS = 5; //Strength,Dexterity,Intellect,Focus and Hp
	
	
	//Ici , la variable contient le nb d'appel des setter d'attributs pour Strength,Dexterity,Intellect,Focus et Hp.
	//Lors de la victoire d'un fighter, le nb d'appel devrait etre à 4 et lors d'une défaite à 5.
	public static int NB_OF_ATTRIBUTES_SETTING_FUNCTIONS_CALL = 0; 
	
	
	public FighterMock(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
		this.name = name;
		this.strength = strength;
		this.dexterity =dexterity;
		this.intellect = intellect;
		this.focus = focus;
		
		this.skillList.add(skill1);
		this.skillList.add(skill2);
	}

	
	
	//Methods used in Tests
	@Override
	public int getStrength() {
		return this.strength;
	}

	@Override
	public int getDexterity() {
		return this.dexterity;
	}

	@Override
	public int getIntellect() {
		return this.intellect;
	}
	
	@Override
	public boolean hasSkill(ISkill skill) {
		return true;
	}
	
	@Override
	public void setStrength(int newStrength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDexterity(int newDexterity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIntellect(int newIntellect) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setFocus(int newFocus) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	//Methods unused for tests 

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
	public void addSkill(ISkill skill) {
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
	public int getCapacityPower(ISkill skill) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int getFocus() {
		// TODO Auto-generated method stub
		return 0;
	}



	
}
