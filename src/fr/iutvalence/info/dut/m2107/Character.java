package fr.iutvalence.info.dut.m2107;

public class Character {
	
	/**
	 *  Name of the character
	 */
	private String name;

	/**
	 *  Color of the character
	 */
	private int color;
	
	private int lifepoints;
	
	/**
	 * the constructor of the class Character
	 * @param name
	 * @param color
	 */
	public Character(String name, int color)
	{
		this.name = name;
		this.color = color;
	}

	// TODO write comment (done)
	/**
	 * the definition of method who return true if the movement is in the grid
	 * @param move
	 * @return
	 */
	public boolean isValid(Move move)
	{
		return true;
	}
	
	
	/**
	 * method which permit to get the name of the object called
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	public int getColor()
	{
		return color;
	}

	public int getLifepoints()
	{
		return lifepoints;
	}
	
}