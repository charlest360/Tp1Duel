package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.*;

public class Athlete extends Fighter {
	
	public final static int MINIMAL_STRENGTH = 20;
	public final static int MINIMAL_DEXTERITY = 20;
	public final static int MINIMAL_INTELLECT = 20;
	public final static int MINIMAL_FOCUS = 20;
	
	public Athlete(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
		super(name,strength, dexterity, intellect, focus,skill1,skill2);
	}

	
	@Override
	protected void validateStrength(int strength, int dexterity, int intellect, int focus) {
		super.validateStrength(strength, dexterity, intellect, focus);
		if (strength < MINIMAL_STRENGTH) {throw new AthleteStrengthIsTooLowException();}
	} 
	@Override
	protected void validateDexterity(int strength, int dexterity, int intellect, int focus) {
		super.validateDexterity(strength, dexterity, intellect, focus);
		if (dexterity < MINIMAL_DEXTERITY) {throw new AthleteDexterityIsTooLowException();}
	}
	
	@Override
	protected void validateIntellect(int strength, int dexterity, int intellect, int focus) {
		super.validateIntellect(strength, dexterity, intellect, focus);
		if (intellect < MINIMAL_INTELLECT) {throw new AthleteIntellectIsTooLowException();}
	}
	
	@Override
	protected void validateFocus(int strength, int dexterity, int intellect, int focus) {
		super.validateFocus(strength, dexterity, intellect, focus);
		if (focus < MINIMAL_FOCUS) {throw new AthleteFocusIsTooLowException();}
	}
}
