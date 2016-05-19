package fr.iutvalence.info.dut.m2107;

public class Player {
	
	/**
	 * 
	 * login of a player
	 */
	private String login;
	
	/**
	 * create a player who has a login
	 * @param login
	 */
	public Player(String login)
	{
		this.login=login;
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