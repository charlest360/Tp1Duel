package abstracts.duel;

public interface IFighter {

		
	public int getHp( );
	
	public void setHp(int newHp);
	
	
	public void addSkill(ISkill skill);
	
	public void removeSkill(ISkill skill);
	
	public ISkill getSkill(int index);
	
	//public int getIndexOfSkill(ISkill skill);
	
	 public int getCapacityPower(ISkill skill);

	 public int getStrength();
	 
	 public void setStrength(int newStrength);
	 
	 public int getDexterity();
	 
	 public void setDexterity(int newDexterity);
	 
	 public int getIntellect();
	 
	 public void setIntellect(int newIntellect);
	 
	 public int getFocus();
	 
	 public void setFocus(int newFocus);

	public boolean hasSkill(ISkill skill);
}
