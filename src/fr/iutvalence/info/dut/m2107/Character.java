package fr.iutvalence.info.dut.m2107;
/**
 * Class which represent a character
 */
public class Character {
	
	/**
	 *  Name of the character
	 */
	private String name;

	/**
	 *  Life points of the character
	 */
	private int pv;
	/**
	 *  Attack 1 of a character
	 */
	private Attack spell1;
	/**
	 *  Attack 2 of a character
	 */
	private Attack spell2;
	/**
	 *  Attack 3 of a character
	 */
	private Attack spell3;
	/**
	 *  Attack 4 of a character
	 */
	private Attack spell4;
	/**
	 *  Move points of the character
	 */
	private int movePoint;

	/**
	 * The constructor of the class character
	 * @param name
	 * @param pv
	 * @param movePoint
	 * @param spell1
	 * @param spell2
	 * @param spell3
	 * @param spell4
	 */
	public Character(String name, int pv,int movePoint, Attack spell1, Attack spell2, Attack spell3, Attack spell4)
	{
		this.name = name;
		this.pv=pv;
		this.movePoint=movePoint;
		this.spell1=spell1;
		this.spell2=spell2;
		this.spell3=spell3;
		this.spell4=spell4;
		
	}
	/** 
	 * @return Move points of a character
	 */
	public int getMovePoint()
	{
		return this.movePoint;
	}
	/**
	 * Change move points of a character
	 * @param movePoint
	 */
	public void setMovePoint(int movePoint)
	{
		this.movePoint = movePoint;
	}
	/**
	 * the definition of method who return true if the movement is in the grid is valid
	 * @param move
	 * @return
	 */
	public boolean isValid(Move move)
	{
		
		if (move.getMoveX()==0 && move.getMoveY()==0 || move.getFinish().getLine()<0 || 
				move.getFinish().getColumn()<0 || move.getFinish().getLine()>=20 ||
				move.getFinish().getColumn()>=20)
		{
			return false;
		}
		if (Math.abs(move.getFinish().getLine()-move.getStart().getLine())+
			Math.abs(move.getFinish().getColumn()-move.getStart().getColumn())>this.movePoint)
		{
			return false;
		}
		return true;
	}
		
	/**
	 * method which permit to get the name of the object called
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * method which permit to get the life points of the object called
	 * @return the life points
	 */
	public int getpv()
	{
		return this.pv;
	}
	/**
	 * Change the life points
	 * @param pv
	 */
	public void setPv(int pv) {
		this.pv = pv;
	}
	/**
	 * method which permit to get the spell 1 of the object called
	 * @return the spell 1
	 */
	public Attack getSpell1() {
		return this.spell1;
	}
	/**
	 * method which permit to get the spell 2 of the object called
	 * @return the spell 2
	 */
	public Attack getSpell2() {
		return this.spell2;
	}
	/**
	 * method which permit to get the spell 3 of the object called
	 * @return the spell 3
	 */
	public Attack getSpell3() {
		return this.spell3;
	}
	/**
	 * method which permit to get the spell 4 of the object called
	 * @return the spell 4
	 */
	public Attack getSpell4() {
		return this.spell4;
	}
	
}