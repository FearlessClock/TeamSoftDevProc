package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;


public class Goblin extends Card {

	public Goblin(){
		super();
		this.race = "Goblin";
	}

	public void Power(){
		/*List<Card> tmpHand = new ArrayList<Card>();
		tmpHand = opponentHand;
		opponentHand = ourHand;
		ourHand = tmpHand;*/
		System.out.println("I'm a Goblin !!");
	}
}
