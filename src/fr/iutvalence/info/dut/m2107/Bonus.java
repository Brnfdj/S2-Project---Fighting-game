package fr.iutvalence.info.dut.m2107;
/**
 * Enumeration of bonus
 */
public enum Bonus 
{
	BonusPv(1),BonusMp(1),BonusDmg(1),BonusS(1),MalusPv(-1),MalusMp(-1),MalusDmg(-1),MalusS(-1);
	/**
	 * a bonus
	 */
	private int bonus;
	/**
	 * Constructor of a bonus
	 * @param bonus
	 */
	private Bonus(int bonus)
	{
		this.bonus=bonus;
	}
	
	
}
