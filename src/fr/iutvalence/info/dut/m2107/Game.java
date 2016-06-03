package fr.iutvalence.info.dut.m2107;
import java.util.Random;
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
	private int BonusSpawnX;
	private int BonusSpawnY;
	
		
		public Game()
		{
			
					
		}

		/**
		 * while anyplayer doesn't lose the game, continue and each player play .
		 */
		
	
		Grid grid= new Grid();
			public void play()
			{
				
				sc = new Scanner(System.in);
				grid.initialisation();
				System.out.println(grid.toString());
				while (!endGame(player))
				{
					player=grid.getPlayer1();
					if (counter%2==0)
					{
						BonusSpawn();
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
						
						while (!grid.getPlayer1().getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))) 
								&& !collision(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
						}
						
						isTakingBonus();
						
						grid.getCells(oldCellLine,oldCellColumn).setPlayer(null);
						grid.getCells(newCellLine,newCellColumn).setPlayer(grid.getPlayer1());
						System.out.println(grid.toString());
						System.out.println("player1 Hp "+grid.getPlayer1().getCharacter().getpv()+
								"player1 spells: 1:"+grid.getPlayer1().getCharacter().getSpell1()+ 
								"2:"+grid.getPlayer1().getCharacter().getSpell2()+ 
								"3:"+grid.getPlayer1().getCharacter().getSpell3()+
								"4:"+grid.getPlayer1().getCharacter().getSpell4());
						doAttack();
					}
					else
					{ 
						player=grid.getPlayer2();
						BonusSpawn();
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
						
						while (!grid.getPlayer2().getCharacter().isValid(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn)))
								&& !collision(new Move(new Position(oldCellLine, oldCellColumn),new Position(newCellLine, newCellColumn))))
						{
							coordonate();
						}
						
						isTakingBonus();
						
						grid.getCells(oldCellLine,oldCellColumn).setPlayer(null);
						grid.getCells(newCellLine,newCellColumn).setPlayer(grid.getPlayer2());
						System.out.println(grid.toString());
						System.out.println("player2 Hp "+grid.getPlayer2().getCharacter().getpv()+"player2 spells: 1:"+grid.getPlayer2().getCharacter().getSpell1()+ "2:"+grid.getPlayer2().getCharacter().getSpell2()+ "3:"+grid.getPlayer2().getCharacter().getSpell3() +"4:"+grid.getPlayer2().getCharacter().getSpell4());
						doAttack();
					}
						counter++;
				}
			}


		public void isTakingBonus()
			{
				
				if (BonusSpawnX==newCellLine && BonusSpawnY==newCellColumn)
				{
					switch(BonusSpawn())
					{
					case BonusDmg:
						player.getCharacter().getSpell1().setDamages(player.getCharacter().getSpell1().getDamages()+1);
						player.getCharacter().getSpell2().setDamages(player.getCharacter().getSpell2().getDamages()+1);
						player.getCharacter().getSpell3().setDamages(player.getCharacter().getSpell3().getDamages()+1);
						player.getCharacter().getSpell4().setDamages(player.getCharacter().getSpell4().getDamages()+1);
					case MalusDmg:
						player.getCharacter().getSpell1().setDamages(player.getCharacter().getSpell1().getDamages()-1);
						player.getCharacter().getSpell2().setDamages(player.getCharacter().getSpell2().getDamages()-1);
						player.getCharacter().getSpell3().setDamages(player.getCharacter().getSpell3().getDamages()-1);
						player.getCharacter().getSpell4().setDamages(player.getCharacter().getSpell4().getDamages()-1);
					case BonusMp:
						player.getCharacter().setMovePoint(player.getCharacter().getMovePoint()+1);
					case MalusMp:
						player.getCharacter().setMovePoint(player.getCharacter().getMovePoint()-1);
					case BonusPv:
						player.getCharacter().setPv(player.getCharacter().getpv()+1);
					case MalusPv:
						player.getCharacter().setPv(player.getCharacter().getpv()-1);
					case BonusS:
						player.getCharacter().getSpell1().setScope(player.getCharacter().getSpell1().getScope()+1);
						player.getCharacter().getSpell2().setScope(player.getCharacter().getSpell2().getScope()+1);
						player.getCharacter().getSpell3().setScope(player.getCharacter().getSpell3().getScope()+1);
						player.getCharacter().getSpell4().setScope(player.getCharacter().getSpell4().getScope()+1);
					case MalusS:
						player.getCharacter().getSpell1().setScope(player.getCharacter().getSpell1().getScope()-1);
						player.getCharacter().getSpell2().setScope(player.getCharacter().getSpell2().getScope()-1);
						player.getCharacter().getSpell3().setScope(player.getCharacter().getSpell3().getScope()-1);
						player.getCharacter().getSpell4().setScope(player.getCharacter().getSpell4().getScope()-1);
						
					}
				}
			}
		public Bonus BonusSpawn()
			{
				Bonus bonus = null;
				Random probabilityBonusSpawner = new Random(); 
				int bonusSpawn = probabilityBonusSpawner.nextInt(4);
				if (bonusSpawn==0)
				{
				Random coordonateOfBonus = new Random(); 
				BonusSpawnX = coordonateOfBonus.nextInt(19);
				BonusSpawnY = coordonateOfBonus.nextInt(19);
				
				while(!isSpawningValid(grid.cells[BonusSpawnX][BonusSpawnY]))
				{	
					BonusSpawnX = coordonateOfBonus.nextInt(19);
					BonusSpawnY = coordonateOfBonus.nextInt(19);
				}
					Random whichBonus = new Random(); 
					int value = whichBonus.nextInt(8);
					switch (value)
					{
					case 1:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.BonusPv);
						bonus=Bonus.BonusPv;
						break;
					case 2:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.MalusPv);
						bonus=Bonus.MalusPv;
						break;
					case 3:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.BonusMp);
						bonus=Bonus.BonusMp;
						break;
					case 4:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.MalusMp);
						bonus=Bonus.MalusMp;
						break;
					case 5:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.BonusDmg);
						bonus=Bonus.BonusDmg;
						break;
					case 6:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.MalusDmg);
						bonus=Bonus.MalusDmg;
						break;
					case 7:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.BonusS);
						bonus= Bonus.BonusS;
						break;
					case 8:
						grid.cells[BonusSpawnX][BonusSpawnY].setBonus(Bonus.MalusS);
						bonus=Bonus.MalusS;
					}
					
				}
				return bonus;
					
				
			}

		public boolean isSpawningValid(Cell cells)
		{
			if (cells==Cell.Empty)
				return true;
			return false;
		}

		public void doAttack()
		{
			switch(sc.nextInt())
			{
			case 0:
				break;
			case 1:
				if (player.getCharacter().getSpell1().isAttackValid(new Move(new Position(newCellLine,newCellColumn),
																			new Position(opponentCellLine,opponentCellColumn))) 
					&& collision(new Move(new Position(newCellLine,newCellColumn),new Position(opponentCellLine,opponentCellColumn))))
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell1().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas");
					doAttack();
				}
				break;
			case 2:
				if (player.getCharacter().getSpell2().isAttackValid(new Move(new Position(newCellLine,newCellColumn),
																	new Position(opponentCellLine,opponentCellColumn)))
					&& collision(new Move(new Position(newCellLine,newCellColumn),new Position(opponentCellLine,opponentCellColumn))))
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell2().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas");
					doAttack();
				}
				break;
			case 3:
				if (player.getCharacter().getSpell3().isAttackValid(new Move(new Position(newCellLine,newCellColumn),
						new Position(opponentCellLine,opponentCellColumn))) 
						&& collision(new Move(new Position(newCellLine,newCellColumn),new Position(opponentCellLine,opponentCellColumn))))
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell3().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas");
					doAttack();
				}
				break;
			case 4:
				if (player.getCharacter().getSpell4().isAttackValid(new Move(new Position(newCellLine,newCellColumn),
						new Position(opponentCellLine,opponentCellColumn)))
					&& collision(new Move(new Position(newCellLine,newCellColumn),new Position(opponentCellLine,opponentCellColumn))))
				{
					player.getCharacter().setPv(-player.getCharacter().getSpell4().getDamages());
				}
				else
				{
					System.out.println("attaque non valide choisisez autre chose ou n'attaquer pas");
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
		
		public boolean collision(Move move)
		{
			if (grid.getCells(move.getFinish().getLine(),move.getFinish().getColumn()).getCell()!=Cell.Empty)
				return false;
			if(move.getMoveX()==0)
			{
					int i=0;
					while(grid.getCells(move.getStart().getLine(),move.getStart().getColumn()+i).getCell()==Cell.Empty &&  i<move.getMoveY());
					{
						i++;
					}
					if (i+1==move.getFinish().getColumn())
						return true;
					return false;
					
			}
			if(move.getMoveY()==0)
			{
					int i=0;
					while(grid.getCells(move.getStart().getLine()+i,move.getStart().getColumn()).getCell()==Cell.Empty 
							&&  i<move.getMoveX());
					{
						i++;
					}
					if (i+1==move.getFinish().getLine())
						return true;
					return false;
			}
			else
			{
				int i=0;
				while(grid.getCells(move.getStart().getLine()+i,move.getStart().getColumn()+i).getCell()==Cell.Empty 
						&&  i<move.getMoveY() && i<move.getMoveX());
				{
					i++;
				}
				if (i+1==move.getFinish().getColumn() && i+1==move.getFinish().getLine())
					return true;
				return false;
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


		public boolean endGame(Player player) 
		{
			if (player.getCharacter().getpv()==0)
				return true;
			return false;
		}
		
		
	

}
