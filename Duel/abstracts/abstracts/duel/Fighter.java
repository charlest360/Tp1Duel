package abstracts.duel;


import exceptions.duel.SumOfFightersAttributesIsTooHigh;

public abstract class Fighter {
	
	public final int MAXIMUM_SUM_OF_FIGHTERS_ATTRIBUTES = 100; 
	
	private int strength;
	private int dexterity;
	private int intellect;
	private int focus;
	private int hp;
	
	
	
	public Fighter(int strength, int dexterity, int intellect, int focus) {
		
		validateAttributes(strength,dexterity,intellect,focus);
		
		this.strength = strength;
		this.dexterity =dexterity;
		this.intellect = intellect;
		this.focus = focus;
		
		calculateVitality();
	}
	
	
	private void validateAttributes(int force, int dexterity, int intellect, int focus) {
		if (force+dexterity+intellect+focus > MAXIMUM_SUM_OF_FIGHTERS_ATTRIBUTES) {
			throw new SumOfFightersAttributesIsTooHigh(); 
		}	
		
	}
	
	private void calculateVitality() {
		this.hp = 200 -this.strength -this.dexterity - this.intellect - this.focus;
	}
}
