package fr.iutvalence.info.dut.m2107;

public class Player {
	
	/**
	 * 
	 * login of a player
	 */
	private String login;
	private Character character;
	
	/**
	 * create a player who has a login
	 * @param login
	 */
	public Player(String login,Character character)
	{
		this.login=login;
		this.character=character;
	}
	
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	/**
	 * method which permit to get the login of a player
	 * @return login of the player 
	 */
	public String getLogin()
	{
		return this.login;
	}
	
}