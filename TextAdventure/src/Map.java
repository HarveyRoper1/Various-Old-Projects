import java.util.Scanner;
public class Map {
	
	Player player = new Player(40, 5, 40);
	Enemy enemy = new Enemy(10,5);
	
	//Overworld map
	
	 int[][] map ={
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2}};
	
	//Overworld map details
	 int[][] mapDetails = {
			 	{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, 
				{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2}};
	 //Map for artifact spots
	 int[][] treasureMap = {
				{2,2,2,2,2,2,2,2,2,2,2,2},
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2},
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,1,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2},
				{2,2,2,2,2,2,2,2,2,2,2,2} };
	 
	 int[][] enemyMap = {
				{2,2,2,2,2,2,2,2,2,2,2,2},
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2},
				{2,0,0,0,0,1,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,0,0,0,0,0,0,0,0,0,0,2},
				{2,2,2,2,2,2,2,2,2,2,2,2} };
	
	 int[][] buildingMap = {{}};
	
	
	int playerPosY = 4;
	int playerPosX = 5;
	
	// map[0][playerPosX] is border
	// map[playerPosY][0] is border
	// map[playerPosY][9] is border
	// map[9][playerPosX] is border
	//For 2D arrays format is array[Y][X]
	public void moveEast() {
		if(map[playerPosY][playerPosX+1] == 1) {
			playerPosX++;
		}
		else {
			System.out.println("You cant go that way!");
			System.out.println("");		
			getMoveables();
		}	
		System.out.println("You moved East");
		System.out.println("");
		getDetails();
		System.out.println("");
		getMoveables();
	}

	public void moveNorth() {
		if(map[playerPosY][playerPosX] == map[playerPosY-1][playerPosX]) {
			playerPosY--;
		}
		else {
			System.out.println("You cant go that way");
			System.out.println("");
			getMoveables();
		}
		System.out.println("You moved North");
		System.out.println("");
		getDetails();
		System.out.println("");
		getMoveables();
	}

	public void moveSouth() {
		if(map[playerPosY][playerPosX] == map[playerPosY+1][playerPosX]) {
			playerPosY++;
		}
		else {
			System.out.println("You cant go that way");
			System.out.println("");
			getMoveables();
		}
		System.out.println("You moved South");
		System.out.println("");
		getDetails();
		System.out.println("");
		getMoveables();
	}
	
	public void moveWest() {
		if(map[playerPosY][playerPosX-1] == 1) {
			playerPosX--;
			}
			else {
				System.out.println("You cant go that way!");
				System.out.println("");
				getMoveables();
			}
		System.out.println("You moved West");
		System.out.println("");
		getDetails();
		System.out.println("");
		getMoveables();
	}

	public void getMoveables() {
		System.out.print("You can move: ");
		//East
		if(map[playerPosY][playerPosX+1] != 2) {
			if(map[playerPosY][playerPosX] == map[playerPosY][playerPosX+1]) {
				System.out.print("East ");
			}
			
		}
		//West
		if(map[playerPosY][playerPosX-1] != 2) {
			if(map[playerPosY][playerPosX] == map[playerPosY][playerPosX-1]) {
				System.out.print("West ");
			}
		}
		//North
		if(map[playerPosY-1][playerPosX] != 2) {
			if(map[playerPosY][playerPosX] == map[playerPosY-1][playerPosX]) {
				System.out.print("North ");
				}
		}
		//South
		if(map[playerPosY+1][playerPosY] != 2) {
			if(map[playerPosY][playerPosX] == map[playerPosY+1][playerPosX]) {
				System.out.print("South ");
				}
			}
		}
	
	public void getDetails() {
		
		if(mapDetails[playerPosY][playerPosX] == 0){
			System.out.println("You are on a large field");
		}
				
		if(mapDetails[playerPosY][playerPosX] == 1) {
			System.out.println("You are in a forest. The trees stretch far and you can't make much out");
			
		}
		if(mapDetails[playerPosY][playerPosX] == 3) {
			System.out.println("You're surrounded by trees. They're quite tall...");
			System.out.println("Theres a small ditch");
		}
		if(mapDetails[playerPosY][playerPosX] == 4) {
			System.out.println("So many trees... How long has it been since you entered?");
			System.out.println("Is that a hole?");
		}
		
		
	}
	
	public int getPosition() {
		return map[playerPosY][playerPosX];
	}
	
	public int getDetailsNum() {
		return mapDetails[playerPosY][playerPosX];
	}
	
	public int getTreasureNum() {
		return treasureMap[playerPosY][playerPosX];
	}
	
	public void enemyEventCheck() throws InterruptedException {
		if(enemyMap[playerPosY][playerPosX] == 1) {
			enemyMap[playerPosY][playerPosX] = 0;
			Combat combat = new Combat(enemy, player);
		}
	}

}

