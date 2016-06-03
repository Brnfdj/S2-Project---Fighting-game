package fr.iutvalence.info.dut.m2107;
/**
 * Class which represent a player
 */
public class Player {
	
	/**
	 * login of a player
	 */
	private String login;
	/**
	 *  Character of the player
	 */
	private Character character;
	
	/**
	 * create a player who has a login and a character
	 * @param login
	 * @param character
	 */
	public Player(String login,Character character)
	{
		this.login=login;
		this.character=character;
	}
	/**
	 * @return the character called on the method
	 */
	public Character getCharacter() {
		return this.character;
	}
	/**
	 * Change the character
	 * @param character
	 */
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