package implementation.duel;

import static org.junit.Assert.assertEquals;


import org.junit.Test;



import abstracts.duel.Fighter;
import abstracts.duel.IFighter;
import abstracts.duel.ISkill;
import exceptions.duel.*;




public class AthleteTest {

	final String ANY_NAME = "Michael Scarn";
	final int ANY_STRENGTH = 21;
	final int ANY_DEXTERITY = 21;
	final int ANY_INTELLECT = 21;
	final int ANY_FOCUS = 21;
	final ISkill ANY_SKILL = new SkillMock();
	
	final int TOO_LOW_STRENGTH = Athlete.MINIMAL_STRENGTH -1;
	final int TOO_LOW_DEXTERITY = Athlete.MINIMAL_DEXTERITY -1;
	final int TOO_LOW_INTELLECT = Athlete.MINIMAL_INTELLECT -1;
	final int TOO_LOW_FOCUS = Athlete.MINIMAL_FOCUS -1;
	
	final int TOO_HIGH_STRENGTH = 200;
	final int TOO_HIGH_DEXTERITY = 200;
	final int TOO_HIGH_INTELLECT = 200;
	final int TOO_HIGH_FOCUS = 200;
	
	
	
	@Test (expected = FighterStrengthIsNegativeException.class)	
	public void creatingAthlete_WHEN_strengthIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_STRENGTH = -1;
		
		//Act
		Fighter athlete= new Athlete(ANY_NAME,NEGATIVE_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterDexterityIsNegativeException.class)	
	public void creatingAthlete_WHEN_dexterityIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_DEXTERITY = -1;
		
		//Act
		Fighter athlete= new Athlete(ANY_NAME,ANY_STRENGTH,NEGATIVE_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterIntellectIsNegativeException.class)	
	public void creatingAthlete_WHEN_intellectIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_INTELLECT = -1;
		
		//Act
		Fighter athlete= new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,NEGATIVE_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = FighterFocusIsNegativeException.class)	
	public void creatingAthlete_WHEN_focusIsNegative_THEN_anExceptionShouldBeThrown() {		
		//Arrange
		final int NEGATIVE_FOCUS = -1;
		
		//Act
		Fighter athlete= new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,NEGATIVE_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	
	
	@Test (expected = AthleteStrengthIsTooLowException.class)	
	public void creatingAthlete_WHEN_strengthIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,TOO_LOW_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteDexterityIsTooLowException.class)	
	public void creatingAthlete_WHEN_dexterityIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,TOO_LOW_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteIntellectIsTooLowException.class)	
	public void creatingAthlete_WHEN_intellectIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,TOO_LOW_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	}
	
	@Test (expected = AthleteFocusIsTooLowException.class)	
	public void creatingAthlete_WHEN_focusIsLowerThanTheMinimumOne_THEN_anExceptionShouldBeThrown() {		
		//Act
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,TOO_LOW_FOCUS,ANY_SKILL,ANY_SKILL);
	
	}
	
	//Tests Set/get des attributes des fighters
	
	@Test public void creatingValidAthlete_WHEN_callingGetStrength_THEN_theAthleteStrengthIsReturned() {
	
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act 
		final int EXPECTED_STRENGTH = ANY_STRENGTH;
		final int ACTUAL_STRENGTH = athlete.getStrength();
		
		//Assert
		assertEquals(EXPECTED_STRENGTH,ACTUAL_STRENGTH);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingGetDexterity_THEN_theAthleteDexterityIsReturned() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act 
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY;
		final int ACTUAL_DEXTERITY = athlete.getDexterity();
		
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingGetIntellect_THEN_theAthleteIntellectIsReturned() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		
		//Act 
		final int EXPECTED_INTELLECT = ANY_INTELLECT;
		final int ACTUAL_INTELLECT = athlete.getIntellect();
		
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}

	@Test public void creatingValidAthlete_WHEN_callingGetFocus_THEN_theAthleteFocusIsReturned() {
	
	//Arrange 
	Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
	
	//Act 
	final int EXPECTED_FOCUS = ANY_FOCUS;
	final int ACTUAL_FOCUS = athlete.getFocus();
	
	//Assert
	assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingSetStrength_THEN_theAthleteStrengthIsChanged() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		athlete.setStrength(ANY_STRENGTH+1);
		
		final int EXPECTED_STRENGTH = ANY_STRENGTH+1;
		final int ACTUAL_STRENGTH = athlete.getStrength();
				
		//Assert
		assertEquals(EXPECTED_STRENGTH,EXPECTED_STRENGTH);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingSetDexterity_THEN_theAthleteDexterityIsChanged() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		athlete.setDexterity(ANY_DEXTERITY+1);
		
		final int EXPECTED_DEXTERITY = ANY_DEXTERITY+1;
		final int ACTUAL_DEXTERITY = athlete.getDexterity();
				
		//Assert
		assertEquals(EXPECTED_DEXTERITY,ACTUAL_DEXTERITY);
	}

	@Test public void creatingValidAthlete_WHEN_callingSetIntellect_THEN_theAthleteIntellectIsChanged() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		athlete.setIntellect(ANY_INTELLECT+1);
		
		final int EXPECTED_INTELLECT = ANY_INTELLECT+1;
		final int ACTUAL_INTELLECT = athlete.getIntellect();
				
		//Assert
		assertEquals(EXPECTED_INTELLECT,ACTUAL_INTELLECT);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingSetFocus_THEN_theAthleteFocusIsChanged() {
		
		//Arrange 
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
				
		//Act 
		athlete.setFocus(ANY_FOCUS+1);
		
		final int EXPECTED_FOCUS = ANY_FOCUS+1;
		final int ACTUAL_FOCUS = athlete.getFocus();
				
		//Assert
		assertEquals(EXPECTED_FOCUS,ACTUAL_FOCUS);
	}
	
	
	
	
	//Autres tests
	
	@Test public void creatingValidAthlete_WHEN_callingGetHp_THEN_theHpReturnedMustRespectTheHpCalculationRule() {
		//Arrange
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act
		final int ACTUAL_HP = athlete.getHp();
		final int EXPECTED_HP = Fighter.CONSTANT_FOR_HP_CALCULATION - ANY_STRENGTH - ANY_DEXTERITY - ANY_INTELLECT - ANY_FOCUS ;
			
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}
	
	@Test public void creatingValidAthlete_WHEN_callingSetHp_THEN_theHpMustChange() {
		//Arrange
		Fighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
		final int INITIAL_HP = athlete.getHp();
		//Act
		athlete.setHp(INITIAL_HP-1);
		
		final int ACTUAL_HP = athlete.getHp();
		final int EXPECTED_HP = INITIAL_HP-1;
		
		//Assert
		assertEquals(EXPECTED_HP,ACTUAL_HP);
	}

	//Tests methods related to skills
	
	@Test public void creatingValidAthlete_WHEN_callingGetSkillWithAnIndexOfZero_THEN_theFirstSkillIsReturned() {
		//Arrange
		final ISkill SKILL1 = new SkillMock();
		final ISkill SKILL2 = new SkillMock();
			
		IFighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
			
		//Act
		final ISkill ACTUAL_FIRST_SKILL = athlete.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL1;
		
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);
		
		}
		
	@Test public void creatingValidAthlete_WHEN_addingSkill_THEN_theSkillIsAddedToTheList() {
		//Arrange
		final ISkill SKILL3 = new SkillMock();
			
		IFighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
			
		//Act
		athlete.addSkill(SKILL3);
			
		final ISkill ACTUAL_THIRD_SKILL = athlete.getSkill(2);
		final ISkill EXPECTED_THIRD_SKILL = SKILL3;
					
		//Assert
		assertEquals(EXPECTED_THIRD_SKILL,ACTUAL_THIRD_SKILL);
		
	}
		
		
	@Test public void creatingValidAthlete_WHEN_removingFirstSKill_THEN_secondSkillBecomesFirstSkill() {
		//Arrange
		final ISkill SKILL1 = new SkillMock();
		final ISkill SKILL2 = new SkillMock();
			
		IFighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,SKILL1,SKILL2);
			
		//Act
		athlete.removeSkill(SKILL1);
			
		final ISkill ACTUAL_FIRST_SKILL = athlete.getSkill(0);
		final ISkill EXPECTED_FIRST_SKILL = SKILL2;
				
		//Assert
		assertEquals(EXPECTED_FIRST_SKILL,ACTUAL_FIRST_SKILL);	
		
	}
		
		
	@Test (expected = SkillIsntInSkillListException.class)	
	public void creatingAthlete_WHEN_askingToRemoveSkillNotInList_THEN_anExceptionShouldBeThrown() {		
			
		//Arrange
		final ISkill SKILL_NOT_IN_LIST = new SkillMock();
					
		IFighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
					
		//Act
		athlete.removeSkill(SKILL_NOT_IN_LIST);
	}
		
		
	@Test (expected = indexOutOfBoundsOfSkillListException.class)	
	public void creatingAthlete_WHEN_callingGetSkillWithOutOfBoundIndex_THEN_anExceptionShouldBeThrown() {		
			
		//Arrange
		IFighter athlete = new Athlete(ANY_NAME,ANY_STRENGTH,ANY_DEXTERITY,ANY_INTELLECT,ANY_FOCUS,ANY_SKILL,ANY_SKILL);
					
		//Act
		athlete.getSkill(2);
	}
}	
		
		

