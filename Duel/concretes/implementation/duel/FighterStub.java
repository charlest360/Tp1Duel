package implementation.duel;

import java.util.ArrayList;

import abstracts.duel.IFighter;
import abstracts.duel.ISkill;

public class FighterStub implements IFighter  {
	
	//Ici , la variable contient le nb d'appel des setter d'attributs pour Strength,Dexterity,Intellect,Focus et Hp.
	//Lors de la victoire d'un fighter, le nb d'appel devrait etre à 4 et lors d'une défaite à 5.
	public int nbOfAttributesSettingFunctionCalls = 0; 
	
	@SuppressWarnings("unused")
	private String name;
	private int strength;
	private int dexterity;
	private int intellect;
	@SuppressWarnings("unused")
	private int focus;
	@SuppressWarnings("unused")
	private int hp;
	private ArrayList<ISkill> skillList = new ArrayList<ISkill>();
	
	public static final int NB_OF_ATTRIBUTES_WINNER_INCREMENTS = 4; //Strength,Dexterity,Intellect and Focus
	public static final int NB_OF_ATTRIBUTES_LOSER_DECREMENTS = 5; //Strength,Dexterity,Intellect,Focus and Hp
	public static final int NB_OF_ATTRIBUTES_LOSER_THAT_SURRENDER_DECREMENTS = NB_OF_ATTRIBUTES_LOSER_DECREMENTS -1;
	

	
	
	public FighterStub(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
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
	public int getFocus() {
		return this.focus;
	}
	
	@Override
	public boolean hasSkill(ISkill skill) {
		return true;
	}
	
	@Override
	public void setStrength(int newStrength) {
		nbOfAttributesSettingFunctionCalls++;		
	}

	@Override
	public void setDexterity(int newDexterity) {
		nbOfAttributesSettingFunctionCalls++;	
		
	}

	@Override
	public void setIntellect(int newIntellect) {
		nbOfAttributesSettingFunctionCalls++;	
		
	}
	
	@Override
	public void setFocus(int newFocus) {
		nbOfAttributesSettingFunctionCalls++;	
		
	}
	
	@Override
	public void setHp(int newHp) {
		nbOfAttributesSettingFunctionCalls++;	
	}

	
	
	//Methods unused for tests 

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return 0;
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

	

	

	



	
}
