package fr.iutvalence.info.dut.m2107;

/**
 * Class who represent the character Cartman 
 */
public class Cartman extends Character {

	/**
	 * Constructor of Cartman
	 * @param name
	 * @param pv
	 * @param movePoint
	 * @param spell1
	 * @param spell2
	 * @param spell3
	 * @param spell4
	 */
	public Cartman(String name,int pv,int movePoint, Attack spell1, Attack spell2, Attack spell3, Attack spell4) 
	{
		super(name,pv,movePoint,spell1,spell2,spell3,spell4);
	}
		
	/**
	 * Redifinition of the method isValid
	 */
		public boolean isValid(Move move)
		{
			
			super.isValid(move);
			return true;
		}
	

}

