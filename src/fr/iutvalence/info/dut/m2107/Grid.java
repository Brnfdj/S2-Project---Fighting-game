package fr.iutvalence.info.dut.m2107;
import java.util.Random;
import java.util.Scanner;
/**
 * Class which represent a grid
 */
public class Grid 
{
	/**
	 * Represent a keyboard input
	 */
	private static Scanner sc;
	/**
	 * Represent the line's number of the game grid
	 */
	private final static int NUMBER_OF_LINES=20;
	
	/**
	 *  Represent the column's number of the  game grid
	 */
	private final static int NUMBER_OF_COLUMNS=20;	
	/**
	 * Represent a line
	 */
	private int line;
	/**
	 * Represent a column
	 */
	private int column;
	/**
	 * Represent the name of the player 1
	 */
	private String player1name;
	/**
	 * Represent the name of the player 2
	 */
	private String player2name;
	/**
	 * Represent the character of the player 1
	 */
	private int perso1;
	/**
	 * Represent the character of the player 2
	 */
	private int perso2;
	/**
	 * Represent a board of cells
	 */
	public Cell[][] cells;
	/**
	 * Represent the player 1
	 */
	private Player player1;
	/**
	 * Represent the player 2
	 */
	private Player player2;
	/**
	 * Permit to count lines
	 */
	private int lineCounter;
	/**
	 * Permit to count columns
	 */
	private int columnCounter;
	
	/**
	 * @return the player 1 name's 
	 */
	public String getPlayer1name() {
		return player1name;
	}
	/**
	 * 
	 * @return the player 2 name's
	 */
	public String getPlayer2name() {
		return player2name;
	}
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
	 * initialisation of the grid which put each characters on the grid at the beginning of the game
	 */
	public void initialisation()
	{
		characterchose();
		blockSpawn();
		cells[0][0].setPlayer(player1);
		cells[19][19].setPlayer(player2);
	}
	
	/**
	 *  Put a random number of block into the grid
	 */
	public void blockSpawn()
	{
		Random numberOfBlock = new Random(); 
		int value = numberOfBlock.nextInt(50);
		for (int i=0;i<value;i++)
		{
			Random blockCoordonate = new Random(); 
			int xBlock = blockCoordonate.nextInt(20);
			int yBlock =  blockCoordonate.nextInt(20);
		}
	}
	/**
	 * Permit 2 players to choose each character
	 */
	private void characterchose() 
	{
		sc = new Scanner(System.in);
		System.out.println("donner le nom du joueur 1");
		player1name=sc.nextLine();
		System.out.println("donner le nom du joueur 2");
		player2name=sc.nextLine();
		System.out.println("1: Homer , 2:Bender, 3:Cartman");
		System.out.println("joueur 1 choisisez:");
		perso1=sc.nextInt();
		
		switch(perso1)
		{
		case 1:
			player1=new Player(player1name, new Homer("Homer",30,4,new Attack("coup de pichet",4,3),new Attack("explosionde centrale",6,2),new Attack("coup de voiture",2,5),new Attack("etranglement",1,10)));
			break;
		case 2:
			player1=new Player(player1name,new Bender("Bender",30,4,new Attack("coup de biere",4,3),new Attack("coup de pichet",2,4),new Attack("coup de dents",2,6),new Attack("extinction de l'espece humaine",10,2)));
			break;
		case 3:
			player1=new Player(player1name,new Cartman("Cartman",30,4,new Attack("negociation",4,3),new Attack("entourloupe",6,2),new Attack("corruption",3,4),new Attack("coup de bidon",2,8)));
		}
		
		System.out.println("1: Homer , 2:Bender, 3:Cartman");
		System.out.println("joueur 2 choisisez:");
		perso2=sc.nextInt();
		
		while (perso2==perso1)
		{
			System.out.println("personnage d�j� pris, rechoisissez");
			sc.nextInt();
		}
		switch(perso2)
		{
		case 1:
			player2=new Player(player2name, new Homer("Homer",30,4,new Attack("coup de pichet",4,3),new Attack("explosion de centrale",6,2),new Attack("coup de voiture",2,5),new Attack("etranglement",1,10)));
			break;
		case 2:
			player2=new Player(player2name,new Bender("Bender",30,4,new Attack("coup de biere",4,3),new Attack("coup de pichet",2,4),new Attack("coup de dents",2,6),new Attack("extinction de l'espece humaine",10,2)));
			break;
		case 3:
			player2=new Player(player2name,new Cartman("Cartman",30,4,new Attack("negociation",4,3),new Attack("entourloupe",6,2),new Attack("corruption",3,4),new Attack("coup de bidon",2,8)));
		}
	}	
	/**
	 * @return the player 1
	 */
	public Player getPlayer1() 
	{
		return player1;
	}
	/**
	 * @return the player 2
	 */
	public Player getPlayer2() 
	{
		return player2;
	}
	/**
	 * @param x
	 * @param y
	 * @return the cell to the x and y coordinates
	 */
	public Cell getCells(int x, int y)
	{
		return cells[x][y];
	}
	/**
	 * Change a cell
	 * @param cells
	 */
	public void setCells(Cell[][] cells)
	{
		this.cells = cells;
	}
	/**
	 * Permit to display the grid on the console
	 */
	public String toString()
	{
		String Grid = "";

		for (int nbOfLine = 0; nbOfLine < NUMBER_OF_LINES; nbOfLine++)
		{
			for (int nbColumn = 0; nbColumn < NUMBER_OF_COLUMNS; nbColumn++)
				Grid += this.cells[nbOfLine][nbColumn].toString();
			Grid += "\n+---";
				for (int numOflig = 0; numOflig < NUMBER_OF_LINES-1 ; numOflig++)
					Grid +="+---";				
				Grid += "+";
				Grid+=" "+ lineCounter;
				Grid += "\n";
				lineCounter++;
		}
		for (int nbColumn = 0; nbColumn < NUMBER_OF_COLUMNS; nbColumn++)
		{
			if (nbColumn<10)
				Grid += "  "+nbColumn+" ";
			else
				Grid += " "+nbColumn+" ";
		}

		return Grid;
	}
	
}