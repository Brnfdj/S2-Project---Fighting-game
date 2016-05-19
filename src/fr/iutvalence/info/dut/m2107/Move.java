package fr.iutvalence.info.dut.m2107;

public class Move {

	/**
	 * represent the movement in abscissa of a character
	 */
	private int moveX;

	/**
	 * represent the movement in orderly of a character
	 */
	private int moveY;

	/**
	 * the start position of a character
	 */
	private Position start;
	/**
	 * the finish position of a piece
	 */
	private Position finish;

	/**
	 * the constructor of the class Move
	 * @param start
	 * @param finish
	 */
	public Move(Position start, Position finish)
	{
		
	}

	/**
	 * method which permit to get the movement in abscissa of the object called
	 * @return the movement in abscissa
	 */
	public int getMoveX()
	{
		return moveX;
	}

	/**
	 * method which permit to get the movement in orderly of the object called
	 * @return the movement in orderly
	 */
	public int getMoveY()
	{
		return moveY;
	}
	
	/**
	 * method which permit to get the start position of the object called
	 * @return the start position
	 */	
	public Position getStart()
	{
		return start;
	}

	/**
	 * method which permit to get the finish position of the object called
	 * @return the finish position
	 */
	public Position getFinish()
	{
		return finish;
	}

}