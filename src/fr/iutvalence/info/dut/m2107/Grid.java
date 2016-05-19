package fr.iutvalence.info.dut.m2107;

public class Grid {
	
	private final static int NUMBER_OF_LINES=20;
	
	/**
	 *  Represent the column's number of the  game grid
	 */
	private final static int NUMBER_OF_COLUMNS=20;	
	
	private Cell[][] cells;
	
	/**
	 *  This is the constructor of the game grid
	 */
	public Grid()
	{
		cells=new Cell[NUMBER_OF_LINES][NUMBER_OF_COLUMNS];
		
		for (int nblines=0;nblines<NUMBER_OF_LINES;nblines++)
		{
			for (int nbcolumn=0;nbcolumn<NUMBER_OF_COLUMNS;nbcolumn++)
			{
				cells[nblines][nbcolumn]=new Cell();
			}
		}
		
	}
	/**
	 * initialisation of the grid which put each pieces on the grid at the beginning of the game
	 */
	public void initialisation()
	{
		cells[0][0].setCharacter(new Character1("one",1));
		cells[19][19].setCharacter(new Character2("two",0));
	}	
	
	
	public String toString()
	{
		String Grid = "";

		for (int nbOfLine = 0; nbOfLine < NUMBER_OF_LINES; nbOfLine++)
		{
			for (int nbColumn = 0; nbColumn < NUMBER_OF_COLUMNS; nbColumn++)
				Grid += this.cells[nbOfLine][nbColumn].toString();
			Grid += "¦\n+---";
				for (int numOflig = 0; numOflig < NUMBER_OF_LINES ; numOflig++)
					Grid +="+---";
				Grid += "+\n";
		}

		return Grid;
	}
	
}