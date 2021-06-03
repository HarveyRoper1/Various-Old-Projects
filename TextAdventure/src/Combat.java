import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Combat {

	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	Player player = new Player(40, 5, 40);
	Enemy enemy = new Enemy(10,5);
	
	public Combat(Enemy enemy, Player player) throws InterruptedException {
		System.out.println("");
		System.out.println("You encountered an enemy!");
		System.out.println("Get Ready to fight! Press Enter");
		sc.nextLine();
		System.out.println("Combat Engaged!");
		
		enemyTurn();
	}
	
	public void enemyTurn() throws InterruptedException {
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("Enemy");
		System.out.println("Health: "+ enemy.getHealth());
		System.out.println("");

		player.setHealth(enemy.attack(player.getHealth()));
		if(player.getHealth() <= 0) {
			System.out.println("Your health is 0");
			System.out.println("You died!");
			System.out.println("Game over I guess");
		}
		System.out.println("Your health is " + player.getHealth());
		System.out.println("");
		System.out.println("----------------------");
		TimeUnit.SECONDS.sleep(2);
		playerTurn();
	}

	public void playerTurn() throws InterruptedException {
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("You");
		System.out.println("Health: "+ player.getHealth());
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("[1] Attack");
		System.out.println("[2] Recover ");
		System.out.println("[3] ... ");
		System.out.println("");
		System.out.println("----------------------");
		String choice = sc.next();
		playerChoice(choice);
	
	}
	
	public void playerChoice(String choice) throws InterruptedException {
		if(choice.contains("Attack") || choice.contains("1") || choice.contains("attack")) {
			System.out.println("You attacked the enemy ");
			enemy.setHealth(player.attack(enemy.getHealth()));
			System.out.println("You dealt " + (enemy.getMaxHealth() - enemy.getHealth()) + " damage");
			System.out.println("Enemy health is " + enemy.getHealth());
			if(enemy.getHealth() == 0 ) {
				System.out.println("Enemy killed!");
				TimeUnit.SECONDS.sleep(2);
				player.setHealth(player.getMaxHealth());
			}
			else {
				if(enemy.getHealth() > 0) {
					TimeUnit.SECONDS.sleep(2);
				}
				enemyTurn();
			}
		}

		else if(choice.contains("Recover") || choice.contains("2") || choice.contains("recover")) {
			int i = ran.nextInt(10);
			i += 5;
			if(player.getLuck() < 5) {
				System.out.println("Attempt to recover failed");
				TimeUnit.SECONDS.sleep(2);
			}
			else {
				System.out.println("You recovered");
				player.increaseHealth(i);
				System.out.println("Gaining " + i + " health");
				TimeUnit.SECONDS.sleep(2);
			}
			enemyTurn();
		}
		
		else if(choice.contains("3")) {
			
		}
		else {
			System.out.println("Invalid choice");
			playerTurn();
		}
		
	}
	
}
