public class npc implements actor {
	
	String greeting = "HEY YALL";
	inventory npcInventory = new inventory();
	playerOptions npcOptions = new playerOptions();
	

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int block() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String taunt() {
		// TODO Auto-generated method stub
		return null;
	}
	public int buy() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int sell() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String talk() {
		// TODO Auto-generated method stub
		return greeting;
	}
	public void closeNPCDialog() {
		
	}
	

}