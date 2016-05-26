package fr.iutvalence.info.dut.m2107;

public class Homer extends Character 
{

	
	public Homer(String name,int pv, Attack spell1, Attack spell2, Attack spell3, Attack spell4) 
	{
		super(name,pv,spell1,spell2,spell3,spell4);
	}
		
		
		public boolean isValid(Move move)
		{	
			super.isValid(move);
			return true;
		}
	

}
