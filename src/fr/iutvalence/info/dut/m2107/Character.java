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


	
	/**
	 * the constructor of the class Character
	 * @param name
	 * @param color
	 */
	public Character(String name, int pv, Attack spell1, Attack spell2, Attack spell3, Attack spell4)
	{
		this.name = name;
		this.pv=pv;
		this.spell1=spell1;
		this.spell2=spell2;
		this.spell3=spell3;
		this.spell4=spell4;
		
	}



	// TODO write comment (done)
	/**
	 * the definition of method who return true if the movement is in the grid
	 * @param move
	 * @return
	 */
	public boolean isValid(Move move)
	{
		//TODO when method collision is finish implement the condition 
		if (move.getMoveX()==0 && move.getMoveY()==0 || move.getFinish().getLine()<0 || 
				move.getFinish().getColumn()<0 || move.getFinish().getLine()>20 ||
				move.getFinish().getColumn()>20)
		{
			return false;
		}
		return true;
	}
	
	public boolean isAttackValid(Attack attack)
	{
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
	
	public int getPv() {
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