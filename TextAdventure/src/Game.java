
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	Player player = new Player(40, 5, 40);
	Enemy enemy = new Enemy(10,5);
	Map map = new Map();
	Scanner sc = new Scanner(System.in);
	String[] artifacts = { "Ruby", "Chalice", "Cross", "Skull", "Diamond", "Robe", "Ring", "Coin", "Sceptre", "Crown" };
	String[] artifactsCollected = {". . .", ". . .", ". . .",". . .", ". . .", ". . .",". . .", ". . .", ". . .",". . ."} ;
	int artifactsCollectedAsNum = 0;
	String[] inventory;
	
	@SuppressWarnings("resource")
	public Game() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello! Welcome to the game!");
		System.out.println("Your task is to collect the wizards artifacts. He has hidden 10 around the world");
		System.out.println("Beware. If you can not find these artifacts in this world...");
		System.out.println("You will be stuck here FOREVER!");
		System.out.println("");
		System.out.println("Would you like to begin?  Y/N ");
		String playYN = sc.nextLine();
		if ( playYN(playYN)) {
			playGame();
		}
		else { System.out.println("Ok. Maybe play again some other time..."); }

	}

	public boolean playYN(String answer) {
		if(answer.equals("Y") || answer.equals("y") ) { return true; }
		else { return false; }
	}
	
	
	public void playGame() throws InterruptedException {
		System.out.println("What do you wish to do?");
		map.getMoveables();
		String input = sc.nextLine();
		inputReader(input);
	}
	

	
	public void inputReader(String in) throws InterruptedException {
		String[] parts = in.split(" ");
		if(in.contains("inspect") || in.contains("Inspect")) {
			inspect(in);
		}
		else if(in.contains("take")) {
			take();
		}
		else if(parts[0].equals("move") || parts[0].equals("go")|| parts[0].equals("Move") || parts[0].equals("Go") || 
				parts[0].equals("N") || parts[0].equals("E") || parts[0].equals("S") || parts[0].equals("W")) {
			
			if(Arrays.asList(parts).contains("E") || Arrays.asList(parts).contains("east") || Arrays.asList(parts).contains("e") || Arrays.asList(parts).contains("East")) {
				map.moveEast();
				map.enemyEventCheck();
			}
			else if(Arrays.asList(parts).contains("N") || Arrays.asList(parts).contains("north") || Arrays.asList(parts).contains("n") || Arrays.asList(parts).contains("North")) {
				map.moveNorth();
				map.enemyEventCheck();
			}
			else if(Arrays.asList(parts).contains("W") || Arrays.asList(parts).contains("west") || Arrays.asList(parts).contains("w") || Arrays.asList(parts).contains("West")) {
				map.moveWest();
				map.enemyEventCheck();
			}
			else if(Arrays.asList(parts).contains("S") || Arrays.asList(parts).contains("south") || Arrays.asList(parts).contains("s") || Arrays.asList(parts).contains("South")) {
				map.moveSouth();
				map.enemyEventCheck();
			}
			else {
				System.out.println("Move where?");
			}
		}
		
			else if(in.contains("inventory")) {
			System.out.println("You have: ");
			System.out.println(Arrays.toString(inventory));
			System.out.println("Artifacts: ");
			System.out.println(Arrays.toString(artifactsCollected));
		}
		else if(in.contains("look") || in.contains("Look")  || in.contains("see") || in.contains("view")) {
			map.getDetails();
			map.getMoveables();
		}
		
		
		else { System.out.println("Huh?"); }
		
		System.out.println("");
		System.out.println("What do you wish to do?");
		String input = sc.nextLine();
		inputReader(input);
	}
	
	
	//Take
	public void take() {
		if(map.getTreasureNum() == 1) {
			if(artifactsCollected[0] != "Ruby") {
				artifactsCollected[0] = "Ruby";
				artifactsCollectedAsNum++;
				System.out.println("You found a RUBY!!!");
				System.out.println("You have found " + artifactsCollectedAsNum + " artifacts");
				System.out.println("Ruby has been added to your treasures. You need to find "+ (10 - artifactsCollectedAsNum) + " more treasures");
		}
			else {
				System.out.println("Nothing else here");
			}
			
	}
		else {
			System.out.println("Nothing much to take here...");
		}
	}     
	
	
	
	//Inspect
	public void inspect(String input) {
		
	if(map.getDetailsNum() == 3) {
		if(input.contains("ditch")) {
			System.out.println("Its a small looking man made hole");
			System.out.println("You can just see something small and shiny poking out of the rubble");
			
	}
		else {
			System.out.println("Inspect what?");
		}
	}
	else {
		System.out.println("not much to see here");
		}
	}

}
