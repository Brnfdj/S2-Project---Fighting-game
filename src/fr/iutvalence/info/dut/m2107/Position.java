package fr.iutvalence.info.dut.m2107;

public class Position{
	
	/**
	 * field who represent the abscissa of the position
	 */
	private int line;

	/**
	 *  field who represent the orderly
	 */
	private int column;

	/**
	 * the constructor of the class position
	 * @param line
	 * @param column
	 */
	public Position(int line, int column)
	{
		
	}

	/**
	 * method which permit to get the line of the object called
	 * @return the line
	 */
	public int getLine()
	{
		return this.line;
	}

	/**
	 * method which permit to set the field line of the object called
	 * @param line
	 */
	public void setLine(int line)
	{
		this.line = line;
	}

	/**
	 * method which permit to get the column of the object called
	 * @return the column
	 */
	public int getColumn()
	{
		return this.column;
	}

	/**
	 * method which permit to set the field column of the object called
	 * @param column
	 */
	public void setColumn(int column)
	{
		this.column = column;
	}

}
