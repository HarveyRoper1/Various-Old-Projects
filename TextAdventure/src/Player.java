import java.util.Random;
public class Player {

	Random ran = new Random();
	int maxHealth;
	int currentHealth = maxHealth;
	int power;
	
	public Player(int maxHealth, int power, int currentHealth) {
		this.maxHealth = maxHealth;
		this.power = power;
		this.currentHealth = currentHealth;
	}
	
	public int attack(int enemyHealth) {
		return enemyHealth - power;
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	public void setHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public void increaseHealth(int increase) {
		this.currentHealth = this.currentHealth + increase; 
	}
	
	public void setPower(int newPower) {
		power = newPower;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void recoverHealth(int i) {
			increaseHealth(i);
			System.out.println("Gaining " + i + " health");
		}
	
	public int getLuck() {

		int luck = ran.nextInt(10);
		return luck;
		
	}
	
}
