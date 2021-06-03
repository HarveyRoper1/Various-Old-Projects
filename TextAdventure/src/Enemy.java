import java.util.Random;
public class Enemy {
	
	Random ran = new Random();
	
	protected int maxHealth = 10;
	protected int currentHealth = 10;
	protected int power = 5;

	public Enemy(int maxHealth, int power) {
		this.maxHealth = maxHealth;
		this.power = power;
	}

	public int attack(int playerHealth) {
		if(getLuck() < 3) {
			System.out.println("Enemy missed");
			return playerHealth;
		}
		else if(getLuck() > 3 && getLuck() <= 7) {
			System.out.println("Enemy attacked you");
			System.out.println("Dealing " + power + " damage");
			return playerHealth - power;
		}
		else {
			System.out.println("Enemy Critical Hit!");
			System.out.println("Dealing " +  (power*2) + " damage");
			return playerHealth - (power*2);
		}
		
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	public void setHealth(int newHealth) {
		currentHealth = newHealth;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public int getLuck() {

		int luck = ran.nextInt(10);
		return luck;
		
	}
	
}
