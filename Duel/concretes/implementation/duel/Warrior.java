package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.WarriorDexterityIsTooLowException;
import exceptions.duel.WarriorIntellectIsTooLowException;
import exceptions.duel.WarriorStrengthIsTooLowException;

public class Warrior extends Fighter {

	public static final int MIN_GAP_BETWEEN_STRENGTH_AND_DEXTERITY = 10;
	public static final int MIN_GAP_BETWEEN_STRENGTH_AND_INTELLECT = 10;
	public static final int MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS= 10;
	public static final int MIN_GAP_BETWEEN_INTELLECT_AND_FOCUS = 10;
	
	public Warrior(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
		super(name,strength, dexterity, intellect, focus,skill1,skill2);
	}
	
	
	
	
	@Override
	protected void validateStrength(int strength, int dexterity, int intellect, int focus) {
		super.validateStrength(strength, dexterity, intellect, focus);
		if((strength < dexterity+MIN_GAP_BETWEEN_STRENGTH_AND_DEXTERITY )|| ( strength < (intellect+MIN_GAP_BETWEEN_STRENGTH_AND_INTELLECT)) || (strength<focus) ) {throw new WarriorStrengthIsTooLowException() ;}
	} 
	@Override
	protected void validateDexterity(int strength, int dexterity, int intellect, int focus) {
		super.validateDexterity(strength, dexterity, intellect, focus);
		if((dexterity < intellect) || (dexterity +MIN_GAP_BETWEEN_DEXTERITY_AND_FOCUS < focus)) {throw new WarriorDexterityIsTooLowException();}
	}
	@Override
	protected void validateIntellect(int strength, int dexterity, int intellect, int focus) {
		super.validateIntellect(strength, dexterity, intellect, focus);
		if (intellect+MIN_GAP_BETWEEN_INTELLECT_AND_FOCUS < focus)  { throw new WarriorIntellectIsTooLowException();}
	}





	
}
