package fr.iutvalence.info.dut.m2107;
import java.util.Scanner;

public class Game {
	
	
	private static Scanner sc;
	private int counter;
	
	private int oldCellLine;
	private Character character;
	

	private int oldCellColumn;
	private int newCellLine;
	private int newCellColumn;
	
		
		public Game()
		{
			
					
		}

		/**
		 * while anyplayer doesn't lose the game, continue and each player play .
		 */
		
	
		
			public void play(String gamer1, String gamer2)
			{
				
				sc = new Scanner(System.in);
				Grid grid= new Grid();
				grid.initialisation();
				System.out.println(grid.toString());
				while (!endGame())
				{
					
					if (counter%2==0)
					{
						coordonate();
						
						character=Grid.cells[oldCellLine][oldCellColumn].getPiece();
						while (!character.isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
						}
						Grid.cells[oldCellLine][oldCellColumn].setPiece(null);
						Grid.cells[newCellLine][newCellColumn].setPiece(character);
						System.out.println(grid.toString());
					}
					else
					{ 
						coordonate();
						
						character=Grid.cells[oldCellLine][oldCellColumn].getPiece();
						while (!character.isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
							System.out.println(grid.toString());
						}
						Grid.cells[oldCellLine][oldCellColumn].setPiece(null);
						Grid.cells[newCellLine][newCellColumn].setPiece(character);
						System.out.println(grid.toString());
					}
						counter++;
				}
			}

			
		
		
		public void coordonate()
		{
			oldCellLine=sc.nextInt();
			oldCellColumn=sc.nextInt();
			newCellLine=sc.nextInt();
			newCellColumn=sc.nextInt();
		}

		private boolean endGame() {
			
			return false;
		}
		
		
	

}
