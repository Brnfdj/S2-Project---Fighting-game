package fr.iutvalence.info.dut.m2107;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Game {
	
	
	private static Scanner sc;
	private int counter=0;
	
	private int oldCellLine;
	private Player player;
	

	private int oldCellColumn;
	private int newCellLine;
	private int newCellColumn;
	
		
		public Game()
		{
			
					
		}

		/**
		 * while anyplayer doesn't lose the game, continue and each player play .
		 */
		
	
		
			public void play()
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
						
						player=Grid.cells[oldCellLine][oldCellColumn].getPlayer();
						while (!player.getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
						}
						Grid.cells[oldCellLine][oldCellColumn].setPlayer(null);
						Grid.cells[newCellLine][newCellColumn].setPlayer(player);
						System.out.println(grid.toString());
						System.out.println("player1 spells: 1:"+getCharacter().getSpell1());
					}
					else
					{ 
						coordonate();
						
						player=Grid.cells[oldCellLine][oldCellColumn].getPlayer();
						while (!player.getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
							System.out.println(grid.toString());
						}
						Grid.cells[oldCellLine][oldCellColumn].setPlayer(null);
						Grid.cells[newCellLine][newCellColumn].setPlayer(player);
						System.out.println(grid.toString());
					}
						counter++;
				}
			}

			
		
		
		public void coordonate()
		{
			switch(counter)
			{
			case 0:
				oldCellLine=0;
				oldCellColumn=0;
				newCellLine=sc.nextInt();
				newCellColumn=sc.nextInt();
			case 1:
				oldCellLine=19;
				oldCellColumn=19;
				newCellLine=sc.nextInt();
				newCellColumn=sc.nextInt();
				
			default:
				System.out.println("entrez les coordonnées de votre déplacement:");
				oldCellLine=newCellLine;
				oldCellColumn=newCellColumn;
				newCellLine=sc.nextInt();
				newCellColumn=sc.nextInt();
			}
		}

		private boolean endGame() {
			
			return false;
		}
		
		
	

}
