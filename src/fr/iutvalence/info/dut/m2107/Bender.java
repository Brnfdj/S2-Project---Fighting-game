package fr.iutvalence.info.dut.m2107;


public class Bender extends Character {

	public Bender(String name,int pv,int movePoint, Attack spell1, Attack spell2, Attack spell3, Attack spell4) 
	{
		super(name,pv,movePoint,spell1,spell2,spell3,spell4);
	}
		
		
		public boolean isValid(Move move)
		{
			
			super.isValid(move);
			return true;
		}
	

}

