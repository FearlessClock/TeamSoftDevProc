package com.Kingdom.cards;

public class Troll extends Card {
	
	public Troll(){
		super();
		this.race = "Troll";
	}
	
	public String toString(){
		return ("You get a " + race + "\nPower : Swap the cards in front of you with the cards in front of your opponent" );
		
	}
	
	public void Power(){
		// Need the class Kingdom
		// Switch the kingdom
	}
}
