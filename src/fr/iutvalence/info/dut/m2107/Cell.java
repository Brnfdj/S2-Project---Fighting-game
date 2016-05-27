package fr.iutvalence.info.dut.m2107;

public class Cell {
	

	private Player player;
	private Bonus bonus;
	
	public Cell()
	{
		this.player = null;
	}
	
	public Cell(Player player) 
	{
		
		this.player = player;
	}
	
	public Cell(Bonus bonus)
	{
		this.bonus=bonus;
	}

	public Player getPlayer() 
	{
		
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
		
	}
	
	public String toString()
	{
		String a = null;
		if (this.player == null)
			a = "|   ";
		else
		switch (this.player.getCharacter().getName())
		{
		case "Bender": a = "| B ";
		break;
		case "Cartman": a = "| C ";
		break;
		case "Homer": a = "| H ";
		}
		
		return a;
	}


	
	
	
	
	
	
	
	

}
