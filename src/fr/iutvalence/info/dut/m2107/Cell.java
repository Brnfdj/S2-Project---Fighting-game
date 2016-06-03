package fr.iutvalence.info.dut.m2107;

/**
 * Class which represent a cell 
 */
public class Cell {
	
	/**
	 * Represent a player into a cell 
	 */
	private Player player;
	/**
	 * Represent a bonus into a cell
	 */
	private Bonus bonus;
	
	/**
	 * Constructor of a cell 
	 */
	public Cell()
	{
		this.player = null;
		this.bonus = null;
	}
	
	/**
	 * @return the player who is called on the method
	 */
	public Player getPlayer() 
	{
		return this.player;
	}
	/**
	 * Change the player on the cell
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
		
	}
	/**
	 * @return the bonus who is called on the method
	 */
	public Bonus getBonus()
	{
		return this.bonus;
	}
	/**
	 * Change the bonus on the cell
	 * @param bonus
	 */
	public void setBonus(Bonus bonus)
	{
		this.bonus = bonus;
	}
	/**
	 * @return the cell who is called on the method
	 */
	public Cell getCell()
	{
		return this;
	}
	/**
	 * Permit to display a cell on the console depending on what is on the cell
	 */
	public String toString()
	{
		String a = null;
		if (this.player == null)
			a = "|   ";
		if (this.player!=null && this.player.getCharacter()!=null)
		switch (this.player.getCharacter().getName())
		{
		case "Bender": a = "| B ";
		break;
		case "Cartman": a = "| C ";
		break;
		case "Homer": a = "| H ";
		}
		return a;
	}


	
	
	
	
	
	
	
	

}
