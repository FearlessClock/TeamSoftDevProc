package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;

import com.Kingdom.cards.Deck;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<Card> player1Cards;
    private List<Card> player2Cards;
    
    private IntegerProperty player1Score = new SimpleIntegerProperty(0);
    public StringProperty player1Score_2 = new SimpleStringProperty("0");
    
    private IntegerProperty player2Score = new SimpleIntegerProperty(0);
    public StringProperty player2Score_2 = new SimpleStringProperty("0");


    public Board() {
        player1Cards = new ArrayList<Card>();
        player2Cards = new ArrayList<Card>();
        player1Score.addListener(changeListener);
        player2Score.addListener(changeListener);
    }

	public int getPlayer1Score() {
		return player1Score.get();
	}

	public int getPlayer2Score() {
		return player2Score.get();
	}

	public List<Card> getPlayer1Cards() {
		return player1Cards;
	}

	public void setPlayer1Cards(List<Card> cards)
	{
		player1Cards = cards;
	}

	public List<Card> getPlayer2Cards() {
		return player2Cards;
	}

	public void setPlayer2Cards(List<Card> cards)
	{
		player2Cards = cards;
	}

	public void PlayCard(Card card, Deck d, FieldController.PlayerTurn playerTurn, Player p1, Player p2) {
        if (FieldController.PlayerTurn.player1 == playerTurn) {
            player1Cards.add(card);
            card.power(this, d, p1, p2);
            GetScorePlayer(1);
        } else {
            player2Cards.add(card);
            card.power(this, d, p2, p1);
            GetScorePlayer(2);
        }
    }
	
	final ChangeListener changeListener = new ChangeListener() {
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        	player1Score_2.set(Integer.toString(getPlayer1Score()));
        	player2Score_2.set(Integer.toString(getPlayer2Score()));
        }
    };
	
	public int GetScorePlayer(int player){
		List<Card> playerboard = new ArrayList<Card>();
		if(player == 1){
			playerboard.addAll(player1Cards);
		}
		else if(player == 2){
			playerboard.addAll(player2Cards);
		}
		int score = playerboard.size();
		List<Integer> listingClass = new ArrayList<Integer>();
		for(int i = 0; i < 6; i++){
			listingClass.add(i, 0);
		}
		for(Card c : playerboard){
			if(c.GetRace() == "Dryad"){
				listingClass.set(0, listingClass.get(0) + 1);
			}
			if(c.GetRace() == "Elf"){
				listingClass.set(1, listingClass.get(1) + 1);
			}
			if(c.GetRace() == "Gnome"){
				listingClass.set(2, listingClass.get(2) + 1);
			}
			if(c.GetRace() == "Goblin"){
				listingClass.set(3, listingClass.get(3) + 1);
			}
			if(c.GetRace() == "Korrigan"){
				listingClass.set(4, listingClass.get(4) + 1);
			}
			if(c.GetRace() == "Troll"){
				listingClass.set(5, listingClass.get(5) + 1);
			}
		}
		int mini = listingClass.get(0);
		for(int i : listingClass){
			if(i < mini){
				mini = i;
			}
		}
		score += mini * 3;
		if(player == 1){
			player1Score.set(score);
		}
		else if(player == 2){
			player2Score.set(score);
		}
		return score;
	}


}
