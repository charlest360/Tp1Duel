package implementation.duel;

import abstracts.duel.IAttack;
import abstracts.duel.IFighter;
import abstracts.duel.IHeal;
import abstracts.duel.IParry;

public class simulator {
	public static void main(String[] args) {
	   
		Infirmary infirmary = new Infirmary();
		
		IAttack knife = new Sword(50);
		IParry shield = new Shield(40);
		IAttack fireSpell = new AttackSpell(60);
		IParry barrierSpell = new DefenseSpell(40);
		IHeal healingSpell = new HealingSpell(30);
		IHeal healingPotion = new HealingPotion(30);
		IAttack fists = new Sword(30);
		
		
		
		
		//First fight
		IFighter frenchAthlete = new Athlete("frenchAthlete",20,20,20,20,healingSpell,healingPotion);
		IFighter germanFighter = new Warrior ("Angela Merkel",40,20,20,20,fireSpell,knife);
		
		
		//Attack
		Duel germanFighterVsFrenchAthlete = new Duel(germanFighter,frenchAthlete,fireSpell);
		
		//Choice of defender
		germanFighterVsFrenchAthlete.defenderSurrender();
		
		//Result 
		germanFighterVsFrenchAthlete.awardWinner(shield);
		germanFighterVsFrenchAthlete.penalizeLoser();
		
		
		
		
		//Second fight
		IFighter gsp = new Athlete("Georges St-Pierre",20,20,20,20,fists,healingPotion);
		IFighter niko = new Warrior("Niko Gallant",40,20,20,20,knife,fists);
		
		
		//Attack
		Duel gspVsNiko = new Duel(gsp,niko,fists);
		
		//Choice of defender
		gspVsNiko.defenderRipost(knife);
		
		//Result 
		gspVsNiko.awardWinner(barrierSpell);
		gspVsNiko.penalizeLoser();
	  
		//After the fight , GSP needs to heal his wounds after getting beat up so bad by Niko
		infirmary.healFighter(gsp, healingPotion);
	
		
		
		
		
		//Third fight
		IFighter  harryPotter= new Wizard("Harry Potter",10,10,25,25,knife,healingSpell);
		
				
		//Attack
		Duel harryPotterVsNiko = new Duel(harryPotter,niko,knife);
				
		//Choice of defender
		harryPotterVsNiko.defenderRipost(knife);
				
		//Result 
		harryPotterVsNiko.awardWinner(shield);
		harryPotterVsNiko.penalizeLoser();
		
		
		//After almost dying during his fight against Niko, Harry needs to use a healingSpell on himself to heal his wounds.
		infirmary.healFighter(harryPotter, healingSpell);
	}
	
	
}
