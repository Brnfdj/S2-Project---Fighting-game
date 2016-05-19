package fr.iutvalence.info.dut.m2107;

public class Character1 extends Character {

	
	public Character1(String name, int color) {
		super(name, color);
	}
		
		
		public boolean isValid(Move move)
		{
			
			super.isValid(move);
			return true;
		}
	

}
