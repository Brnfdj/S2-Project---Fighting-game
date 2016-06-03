package fr.iutvalence.info.dut.m2107;

public class Attack {
	
	private Player player;
	private int scope;
	private Attack attack;
	private int damages;

	private String name;

	
	public Attack(String name,int scope, int damages) 
	{
		this.name=name;
		this.scope = scope;
		this.damages = damages;
	}

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
	
	public void setScope(int scope)
	{
		this.scope = scope;
	}

	public void setDamages(int damages)
	{
		this.damages = damages;
	}

	public int getScope() {
		return scope;
	}

	public int getDamages() {
		return damages;
	}

	public String getName() {
		return name;
	}

}
