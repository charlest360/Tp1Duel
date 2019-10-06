package implementation.duel;

import abstracts.duel.Fighter;
import abstracts.duel.IFighter;
import abstracts.duel.IHeal;
import exceptions.duel.HealingPotionEfficacityIsTooHighException;
import exceptions.duel.HealingPotionEfficacityIsTooLowException;

public class HealingPotion implements IHeal {
	
	private int efficacity;
	
	
	
	public HealingPotion(int efficacity) {
		validateHealingPotionAttributes(efficacity);
		this.efficacity = efficacity;
	}
	
	private void validateHealingPotionAttributes(int efficacity) {
		
		if (efficacity < MINIMUM_ATTRIBUTE_VALUE) {throw new HealingPotionEfficacityIsTooLowException();}
		
		if (efficacity > MAXIMUM_ATTRIBUTE_VALUE) {throw new HealingPotionEfficacityIsTooHighException();}
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return (fighter.getDexterity()*this.efficacity)/100;
	}

	
}
