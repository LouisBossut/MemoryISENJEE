package edu.isen.jee.memory.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity(name = "Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderColumn(name = "index")
	private List<CardEntity> board = new ArrayList<>();

	@ElementCollection
	@Column(name="cardBuffer")
	private List<Integer> cardBuffer = new ArrayList<>(2);

	private int currentPlayer = 0;

	private int[] score = { 0, 0 };

	public Game() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<CardEntity> getListOfCard() {
		return board;
	}

	public void setListOfCard(List<CardEntity> board) {
		this.board = board;
	}

	public void setCurrentPlayer(int player) {
		this.currentPlayer = player;
	}

	public int getCurrentPlayer() {
		return this.currentPlayer;
	}

	public void setScore(int[] score) {
		this.score = score;
	}

	public int[] getScore() {
		return score;
	}

	public List<Integer> getCardBuffer() {
		return cardBuffer;
	}

	public void setCardBuffer(List<Integer> buffer) {
		this.cardBuffer = buffer;
	}
	
	public void addToCardBuffer(int cardIndex){
		clearCardBuffer();
		cardBuffer.add(cardIndex);
	}
	
	public void clearCardBuffer() {
		if (cardBuffer.size() >= 2) {
			cardBuffer.clear();
		}
	}

}
