package fr.iutvalence.info.dut.m2107;

public class Cell {
	
	
	private Character character;
	
	

	
	public Cell()
	{
		this.character = null;
	}
	
	public Cell(Character character) {
		
		this.character = character;
	}


	public Character getCharacter() {
		
		return character;
	}
	
	public void setCharacter(Character character)
	{
		this.character = character;
		
	}
	
	public String toString()
	{
		String a = null;
		if (this.character == null)
			a = "|   ";
		else
		switch (this.character.getName())
		{
		case "one": a = "| o ";
		break;
		case "two": a = "| t ";
		break;
		case "three": a = "| r ";
		}
		
		return a;
	}


	
	
	
	
	
	
	
	

}
