package fr.iutvalence.info.dut.m2107;
import java.util.Scanner;

public class Grid 
{
	
	private static Scanner sc;
	
	private final static int NUMBER_OF_LINES=20;
	
	/**
	 *  Represent the column's number of the  game grid
	 */
	private final static int NUMBER_OF_COLUMNS=20;	
	private int ligne;
	private int column;
	private String player1name;
	private String player2name;
	private int perso1;
	private int perso2;
	public static Cell[][] cells;
	private Player player1;
	private Player player2;
	private int lineCounter;
	private int columnCounter;
	
	public String getPlayer1name() {
		return player1name;
	}
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
	 * initialisation of the grid which put each pieces on the grid at the beginning of the game
	 */
	public void initialisation()
	{
		characterchose();
		cells[0][0].setPlayer(player1);
		cells[19][19].setPlayer(player2);
	}
	
	
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
			System.out.println("personnage déjà pris, rechoisissez");
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
	
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	
	public String toString()
	{
		String Grid = "";

		for (int nbOfLine = 0; nbOfLine < NUMBER_OF_LINES; nbOfLine++)
		{
			for (int nbColumn = 0; nbColumn < NUMBER_OF_COLUMNS; nbColumn++)
				Grid += this.cells[nbOfLine][nbColumn].toString();
			Grid += "¦\n+---";
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