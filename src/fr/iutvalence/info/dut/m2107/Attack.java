package fr.iutvalence.info.dut.m2107;
/**
 *  Class which represent an attack
 */
public class Attack {
	/**
	 * Represent a player
	 */
	private Player player;
	/**
	 * Represent the scope of an attack
	 */
	private int scope;
	/**
	 *  Represent damages of an attack
	 */
	private int damages;
	/**
	 * Represent the name of an attack
	 */
	private String name;

	/**
	 * Constructor of the class attack
	 * @param name
	 * @param scope
	 * @param damages
	 */
	public Attack(String name,int scope, int damages) 
	{
		this.name=name;
		this.scope = scope;
		this.damages = damages;
	}
	/**
	 * @param move
	 * @return true if an attack is valid
	 */
	public boolean isAttackValid(Move move)
	{
		if (Math.abs(move.getMoveX())+Math.abs(move.getMoveY())<=this.getScope())
		{
			if (move.getMoveX()==0 && move.getMoveY()==0 || move.getFinish().getLine()<0 || 
				move.getFinish().getColumn()<0 || move.getFinish().getLine()>=20 ||
				move.getFinish().getColumn()>=20)
			{
				return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * Change the scope
	 * @param scope
	 */
	public void setScope(int scope)
	{
		this.scope = scope;
	}
	/**
	 * Change the damages
	 * @param damages
	 */
	public void setDamages(int damages)
	{
		this.damages = damages;
	}
	/**
	 * @return the scope of the object called
	 */
	public int getScope() {
		return scope;
	}
	/**
	 * @return the damages of the object called
	 */
	public int getDamages() {
		return damages;
	}
	/**
	 * @return the name of the object called
	 */
	public String getName() {
		return name;
	}

}
