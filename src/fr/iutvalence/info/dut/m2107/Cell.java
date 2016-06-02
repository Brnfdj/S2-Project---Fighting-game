package fr.iutvalence.info.dut.m2107;

public enum Cell {
	Player, Bonus,Block,Empty;

	private Player player;
	private Bonus bonus;
	
	public Player getPlayer() 
	{
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
		
	}
	
	
	
	public Bonus getBonus()
	{
		return bonus;
	}

	public void setBonus(Bonus bonus)
	{
		this.bonus = bonus;
	}

	public Cell getCell()
	{
		return this;
	}
	
	public String toString()
	{
		String a = null;
		if (this== Empty)
			a = "|   ";
		if (this==Bonus)
			a = "| X ";
		if (this==Block)
			a = "|###";
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
