package implementation.duel;

import abstracts.duel.IHeal;
import exceptions.duel.HealingPotionEfficacityIsTooHighException;
import exceptions.duel.HealingPotionEfficacityIsTooLowException;

public class HealingPotion implements IHeal {
	public final int MINIMUM_EFFICACITY = 20;
	public final int MAXIMUM_EFFICACITY = 100; 
	
	public int efficacity;
	
	
	
	public HealingPotion(int efficacity) {
		validateHealingPotionAttributes(efficacity);
		this.efficacity = efficacity;
	}
	
	private void validateHealingPotionAttributes(int protection) {
		
		if (protection < MINIMUM_EFFICACITY) {throw new HealingPotionEfficacityIsTooLowException();}
		
		if (protection > MAXIMUM_EFFICACITY) {throw new HealingPotionEfficacityIsTooHighException();}
	}
}
