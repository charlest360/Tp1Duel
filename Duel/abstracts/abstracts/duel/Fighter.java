package abstracts.duel;


import exceptions.duel.IllegalFightersAttributes;

public abstract class Fighter {
	
	private int force;
	private int dexterity;
	private int intellect;
	private int focus;
	private int hp;
	
	
	public Fighter(int force, int dexterity, int intellect, int focus) {
		
		validateAttributes(force,dexterity,intellect,focus);
		
		this.force = force;
		this.dexterity =dexterity;
		this.intellect = intellect;
		this.focus = focus;
		
		calculateVitality();
	}
	
	
	private void validateAttributes(int force, int dexterity, int intellect, int focus) {
		if (force+dexterity+intellect+focus >100) {
			throw new IllegalFightersAttributes(); 
		}	
		
	}
	
	private void calculateVitality() {
		this.hp = 200 -this.force -this.dexterity - this.intellect - this.focus;
	}
}
