package abstracts.duel;


import exceptions.duel.FighterDexterityIsNegativeException;
import exceptions.duel.FighterFocusIsNegativeException;
import exceptions.duel.FighterIntellectIsNegativeException;
import exceptions.duel.FighterStrengthIsNegativeException;
import exceptions.duel.SkillIsntInSkillListException;
import exceptions.duel.SumOfFightersAttributesIsTooHigh;
import exceptions.duel.indexOutOfBoundsOfSkillListException;

import java.util.ArrayList;

public abstract class Fighter implements IFighter {
	
	public final int MAXIMUM_SUM_OF_FIGHTERS_ATTRIBUTES = 100; 
	public final static int CONSTANT_FOR_HP_CALCULATION = 200;
	
	private String name;
	private int strength;
	private int dexterity;
	private int intellect;
	private int focus;
	private int hp;
	private ArrayList<ISkill> skillList = new ArrayList<ISkill>();
	
	
	public Fighter(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
		
		validateAttributes(strength,dexterity,intellect,focus);
		this.name = name;
		this.strength = strength;
		this.dexterity =dexterity;
		this.intellect = intellect;
		this.focus = focus;
		
		this.skillList.add(skill1);
		this.skillList.add(skill2);
		
		calculateInitialHp();
	}
	
	
	protected void validateAttributes(int strength, int dexterity, int intellect, int focus) {
		validateSumOfAttributes(strength,dexterity,intellect,focus);
		validateStrength(strength,dexterity,intellect,focus);
		validateDexterity(strength,dexterity,intellect,focus);
		validateIntellect(strength,dexterity,intellect,focus);
		validateFocus(strength,dexterity,intellect,focus);
		
	}
	
	protected void validateSumOfAttributes(int strength, int dexterity, int intellect, int focus) {
		if (strength+dexterity+intellect+focus > MAXIMUM_SUM_OF_FIGHTERS_ATTRIBUTES) {
			throw new SumOfFightersAttributesIsTooHigh(); 
		}	
	}
	
	protected void validateStrength(int strength, int dexterity, int intellect, int focus) {
		if(strength < 0 ) {throw new FighterStrengthIsNegativeException();}
	} 
	
	protected void validateDexterity(int strength, int dexterity, int intellect, int focus) {
		if(dexterity < 0) {throw new FighterDexterityIsNegativeException();}
	}
	
	protected void validateIntellect(int strength, int dexterity, int intellect, int focus) {
		if(intellect < 0) { throw new FighterIntellectIsNegativeException();}
	}
	
	protected void validateFocus(int strength, int dexterity, int intellect, int focus) {
		if(focus < 0) { throw new FighterFocusIsNegativeException();}
	}
	
	protected void calculateInitialHp() {
		this.hp = CONSTANT_FOR_HP_CALCULATION -this.strength -this.dexterity - this.intellect - this.focus;
	}
	
	public int getHp( ) {
		return this.hp;
	}
	
	public void setHp(int newHp) {
		this.hp = newHp;
	}
	
	
	public void addSkill(ISkill skill) {
		this.skillList.add(skill);
	}
	
	
	public void removeSkill(ISkill skill) {
		if(this.skillList.contains(skill)) {
			this.skillList.remove(skill);
		}
		else {
			throw new SkillIsntInSkillListException();
		}
		
	}
	
	public ISkill getSkill(int index) {
		if (this.skillList.size() <= index) {
			throw new indexOutOfBoundsOfSkillListException();
		}
		return this.skillList.get(index);
	}
	
	public boolean hasSkill(ISkill skill) {
		
		if (this.skillList.contains(skill)) {
			return true;
		}
		return false;
	}
	
	/*public int getIndexOfSkill(ISkill skill) {
		if(this.skillList.contains(skill)) {
			return skillList.indexOf(skill);
		}
		else {
			throw new SkillIsntInSkillListException();
		}
	}*/
	
	 public int getCapacityPower(ISkill skill) {
		 return skill.getCapacityPower(this);
	 }
	/*QUAND ON ENLEVE POINTS ATTRIBUTS
	 VALIDER QUE ATTRIBUTS >0 SINON
	 ON ENLEVE SIMPLEMENT PAS
	*/

	 public int getStrength() {
		 return this.strength;
	 }
	 
	 public void setStrength(int newStrength) {
		 this.strength = newStrength;
	 }
	 
	 public int getDexterity() {
		 return this.dexterity;
	 }
	 
	 public void setDexterity(int newDexterity) {
		 this.dexterity = newDexterity;
	 }
	 
	 public int getIntellect() {
		 return this.intellect;
	 }
	 
	 public void setIntellect(int newIntellect) {
		 this.intellect = newIntellect;
	 }
	 
	 public int getFocus() {
		 return this.focus;
	 }
	 
	 public void setFocus(int newFocus) {
		 this.focus = newFocus;
	 }
	 
	 
}
