/** <pre>
 * The stats of any particular item or actor.
 * Example of creating a default stats:
 * 	<code>stats default_stats = new stats();</code>	// create a default stats
 * </pre> */
public class stats {
	/** <pre>
	 * Default stats does not require any specified variables
	 * Example of creating a default stats:
	 * <code>	stats example_stats = new stats();</code>	// create new stats object
	 * </pre>*/
	public stats()
	{
		healthPool = 20;
		attack = 10;
		defense = 5;
		expCap = 100;
		expCurrent = 0;
	}
	/** <pre>
	 * Simple stats that takes one parameter
	 * Example of creating a complex stats that takes one parameter:
	 * <code>	stats example_stats = new stats(0);</code>	// create new stats object
	 * </pre> */
	public stats(int healthPool)
	{
		this.healthPool = healthPool;
		attack = 10;
		defense = 5;
		expCap = 100;
		expCurrent = 0;
	}
	/** <pre>
	 * Complex stats that takes several parameters
	 * Example of creating a complex stats that takes several parameters:
	 * <code>	stats example_stats = new stats(0, 0);</code>	// create new stats object
	 * </pre> */
	public stats(int healthPool, int attack)
	{
		this.healthPool = healthPool;
		this.attack = attack;
		defense = 5;
		expCap = 100;
		expCurrent = 0;
	}
	/** <pre>
	 * Complex stats that takes several parameters
	 * Example of creating a complex stats that takes several parameters:
	 * <code>	stats example_stats = new stats(0, 0, 0);</code>	// create new stats object
	 * </pre> */
	public stats(int healthPool, int attack, int defense)
	{
		this.healthPool = healthPool;
		this.attack = attack;
		this.defense = defense;
		expCap = 100;
		expCurrent = 0;
	}
	/** <pre>
	 * Complex stats that takes several parameters
	 * Example of creating a complex stats that takes several parameters:
	 * <code>	stats example_stats = new stats(0, 0, 0, 0);</code>	// create new stats object
	 * </pre> */
	public stats(int healthPool, int attack, int defense, int expCap)
	{
		this.healthPool = healthPool;
		this.attack = attack;
		this.defense = defense;
		this.expCap = expCap;
		expCurrent = 0;
	}
	/** <pre>
	 * Complex stats that takes several parameters
	 * Example of creating a complex stats that takes several parameters:
	 * <code>	stats example_stats = new stats(0, 0, 0, 0, 0);</code>	// create new stats object
	 * </pre> */
	public stats(int healthPool, int attack, int defense, int expCap, int expCurrent)
	{
		this.healthPool = healthPool;
		this.attack = attack;
		this.defense = defense;
		this.expCap = expCap;
		this.expCurrent = expCurrent;
	}
	/** <pre>
	 * The total health available
	 * Example of defining healthPool:
	 * <code>	stats health_stats = new stats();</code>	// generate a stats
	 * 	<code>health_stats.healthPool = 100;</code>	// set the healthPool to a int value
	 * </pre> */
	int healthPool;
	/** <pre>
	 * The attack damage value
	 * Example of defining attack:
	 * <code>	stats attack_stats = new stats();</code>	// generate a stats
	 * 	<code>attack_stats.attack = 100;</code>	// set the attack to a int value
	 * </pre> */
	int attack;
	/** <pre>
	 * The attack damage resistance value
	 * Example of defining defense:
	 * <code>	stats defense_stats = new stats();</code>	// generate a stats
	 * 	<code>defense_stats.defense = 100;</code>	// set the defense to a int value
	 * </pre> */
	int defense;
	/** <pre>
	 * The maximum amount of experience before level up
	 * Example of defining expCap:
	 * <code>	stats expCap_stats = new stats();</code>	// generate a stats
	 * 	<code>expCap_stats.expCap = 100;</code>	// set the expCap to a int value
	 * </pre> */
	int expCap;
	/** <pre>
	 * The current amount of experience
	 * Example of defining expCurrent:
	 * <code>	stats expCurrent_stats = new stats();</code>	// generate a stats
	 * 	<code>expCurrent_stats.expCurrent = 100;</code>	// set the expCurrent to a int value
	 * </pre> */
	int expCurrent;
	public void levelup() {
		
	}
	public void levelCheck() {
		
	}
	public void levelupAttack() {
		
	}
	public void levelupHealth() {
		
	}
	public void levelupDefense() {
		
	}
	@Override
	public String toString()
	{
		return "(hp: " + healthPool + ", atk: " + attack + ", def: " + defense + ", xpCap: " + expCap + ", xpCur: " + expCurrent + ")";
	}
}