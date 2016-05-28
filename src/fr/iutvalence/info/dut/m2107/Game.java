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
	private int opponentCellLine;
	private int opponentCellColumn;
	
		
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
						if (counter==0)
						{
							opponentCellLine=19;
							opponentCellColumn=19;
						}
						else 
						{
							opponentCellLine=newCellLine;
							opponentCellColumn=newCellColumn;
						}
						coordonate();
						
						player=grid.getCells(oldCellLine,oldCellColumn).getPlayer();
						while (!player.getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
						}
						grid.getCells(oldCellLine,oldCellColumn).setPlayer(null);
						grid.getCells(newCellLine,newCellColumn).setPlayer(player);
						System.out.println(grid.toString());
						//System.out.println("player1 spells: 1:"+getCharacter().getSpell1());
						doAttack();
					}
					else
					{ 
						if (counter==1)
						{
							opponentCellLine=0;
							opponentCellColumn=0;
						}
						else 
						{
							opponentCellLine=newCellLine;
							opponentCellColumn=newCellColumn;
						}
						coordonate();
						
						player=grid.getCells(oldCellLine,oldCellColumn).getPlayer();
						while (!player.getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
							System.out.println(grid.toString());
						}
						grid.getCells(oldCellLine,oldCellColumn).setPlayer(null);
						grid.getCells(newCellLine,newCellColumn).setPlayer(player);
						System.out.println(grid.toString());
						doAttack();
					}
						counter++;
				}
			}

		public void doAttack()
		{
			switch(sc.nextInt())
			{
			case 0:
				break;
			case 1:
				if (player.getCharacter().getSpell1().isAttackValid())
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell1().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas (batard)");
					doAttack();
				}
			case 2:
				if (player.getCharacter().getSpell2().isAttackValid())
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell2().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas (batard)");
					doAttack();
				}
			case 3:
				if (player.getCharacter().getSpell3().isAttackValid())
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell3().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas (batard)");
					doAttack();
				}
			case 4:
				if (player.getCharacter().getSpell4().isAttackValid())
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell4().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas (batard)");
					doAttack();
				}
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
				System.out.println("entrez les coordonn�es de votre d�placement:");
				oldCellLine=newCellLine;
				oldCellColumn=newCellColumn;
				newCellLine=sc.nextInt();
				newCellColumn=sc.nextInt();
			}
		}
		
		public int getNewCellLine()
		{
			return newCellLine;
		}

		public int getNewCellColumn() 
		{
			return newCellColumn;
		}

		public int getOpponentCellLine() 
		{
			return opponentCellLine;
		}

		public int getOpponentCellColumn() 
		{
			return opponentCellColumn;
		}


		private boolean endGame() {
			
			return false;
		}
		
		
	

}
