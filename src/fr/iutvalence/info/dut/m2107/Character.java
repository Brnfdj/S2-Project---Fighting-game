package fr.iutvalence.info.dut.m2107;

public class Character {
	
	/**
	 *  Name of the character
	 */
	private String name;

	/**
	 *  Color of the character
	 */
	
	private int pv;
	private Attack spell1;
	private Attack spell2;
	private Attack spell3;
	private Attack spell4;

	private int movePoint;


	
	/**
	 * the constructor of the class Character
	 * @param name
	 * @param color
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



	public int getMovePoint()
	{
		return movePoint;
	}



	public void setMovePoint(int movePoint)
	{
		this.movePoint = movePoint;
	}



	/**
	 * the definition of method who return true if the movement is in the grid
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
		return name;
	}


	public int getpv()
	{
		return pv;
	}
	

	public void setPv(int pv) {
		this.pv = pv;
	}

	public Attack getSpell1() {
		return spell1;
	}

	public Attack getSpell2() {
		return spell2;
	}

	public Attack getSpell3() {
		return spell3;
	}

	public Attack getSpell4() {
		return spell4;
	}
	
}