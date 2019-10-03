package abstracts.duel;

public interface ISkill {
	
	public final int MINIMUM_ATTRIBUTE_VALUE = 20;
	public final int MAXIMUM_ATTRIBUTE_VALUE = 100;
	
	
	public int getCapacityPower(int fighterSpecificAttribute);
	
	
	
}
