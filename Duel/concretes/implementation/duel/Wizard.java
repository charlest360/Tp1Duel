package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.ISkill;
import exceptions.duel.WizardFocusIsTooLowException;
import exceptions.duel.WizardIntellectIsTooLowException;

public class Wizard extends Fighter {
	public final static int MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY =15;
	public final static int MIN_GAP_BETWEEN_FOCUS_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY =15;
	
	
	public Wizard(String name,int strength, int dexterity, int intellect, int focus,ISkill skill1,ISkill skill2) {
		super(name,strength, dexterity, intellect, focus,skill1,skill2);
	}
	
	@Override
	protected void validateIntellect(int strength, int dexterity, int intellect, int focus) {
		super.validateIntellect(strength, dexterity, intellect, focus);
		if(intellect < Math.max(strength, dexterity) + MIN_GAP_BETWEEN_INTELLECT_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY)  { throw new WizardIntellectIsTooLowException();}
	}
	
	@Override
	protected void validateFocus(int strength, int dexterity, int intellect, int focus) {
		super.validateFocus(strength, dexterity, intellect, focus);
		if(focus < Math.max(strength, dexterity) + MIN_GAP_BETWEEN_FOCUS_AND_HIGHEST_BETWEEN_STRENGTH_AND_DEXTERITY)  { throw new WizardFocusIsTooLowException();}
		
	}
	
}


	