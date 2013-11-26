import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Hand {

	private Card[] hand;
	private int currentCardAmount;
	private int handValue;

	public void addCard(Card cardDrawn) {
		hand[currentCardAmount] = cardDrawn;
		currentCardAmount++; 
	}

	public Hand() {
		hand = new Card[11];
	}

	public int handValue() {
		handValue = 0;
		for (int i=0; i<currentCardAmount; i++) {
			if (hand[i].getNumber() >= 2 && hand[i].getNumber() <= 10) {
				handValue += hand[i].getNumber();
			} else if (hand[i].getNumber() >= 11 && hand[i].getNumber() <= 13) {
				handValue += 10; 
			} else {
				handValue += 11;
			}
		}

		//this code finds the amount of aces on hand
		int aceAmount = 0;
		for (int a=0; a<currentCardAmount; a++) {
			if (hand[a].getNumber() == 1) {
				aceAmount++;
			}
		}

		//this code takes away the handValue
		for (int b=0; b<aceAmount; b++) {
			if (handValue > 21) {
				handValue = handValue - 10;
			}
		}
		return handValue;
	}
	
}