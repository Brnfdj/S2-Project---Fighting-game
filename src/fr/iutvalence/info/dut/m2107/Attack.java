package fr.iutvalence.info.dut.m2107;

public class Attack {
	
	private Player player;
	private int scope;
	
	private int damages;

	private String name;

	
	public Attack(String name,int scope, int damages) 
	{
		this.name=name;
		this.scope = scope;
		this.damages = damages;
	}

	public boolean isAttackValid()
	{
		if(Math.abs())
		return true;
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
