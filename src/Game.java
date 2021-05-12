import java.util.Scanner;

import Game.Game;

//más piezas, más enemigos, más weapons, armor

public class Game {
	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	int playerHP;
	String playerName;
	String playerWeapon;
	int choice;
	int alienHP;
	boolean haveMaterials;
	boolean haveWood;
	boolean haveCopper;
	
	public static void main(String[] args) {

		Game spaceAdventure;
		spaceAdventure = new Game();	
		
		spaceAdventure.playerSetUp(); 	
		spaceAdventure.shipEntrance();
	}
	
	public void playerSetUp(){
		playerHP = 10;
		alienHP = 15;
		haveMaterials = false;
		haveWood = false;
		haveCopper = false;
		playerWeapon = "Blaster";
		
		System.out.println("Hello, space traveler! Please enter your name: ");
		playerName = myScanner.next();
		System.out.println("Hello " + playerName +". You have crash landed and are stranded on an unknown planet. Will you survive?");
		System.out.println("Your HP: " + playerHP);
		System.out.println("Your weapon: " + playerWeapon);
	}
	
	public void shipEntrance(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at the entrance of your ship.");
		System.out.println("The ship is nestled in a valley surrounded by mountains. There is a path leading away from the ship.");
		System.out.println("What do you want to do?");
		System.out.println("1: Go back into ship");
		System.out.println("2: Leave valley");
		System.out.println("\n------------------------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if(choice == 1){
			insideShip();
		}
		else{
			mountains();
		}
	}
	
	public void mountains(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are standing in between two mountains.");
		System.out.println("There are two roads leading out of where you are currently.");
		System.out.println("1: Go left");
		System.out.println("2: Go right");
		System.out.println("3: Go back to ship");
		System.out.println("\n------------------------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
			left();
		}else if(choice==2){
			endingBad();
		}else{
			shipEntrance();
		}
	}
	
//	public void cave(){
//		System.out.println("\n------------------------------------------------------------------\n");
//		System.out.println("You are now inside a cave.");
//		System.out.println("It is dark will you light a match?");
//		if(!haveWood){
//			System.out.println("You don't have wood! You have to leave.");
//		}else{
//			System.out.println("You light a match.");
//			System.out.println("Wow! There are vast copper reserves in this cave. You mine them for your ship.");
//
//		}
//		System.out.println("\n------------------------------------------------------------------\n");
//		haveCopper = true;
//		
//	}
	
	public void left(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You encounter a hostile alien!");
		System.out.println("'GET OFF MY PLANET!!!', he says.");
		System.out.println("GASP! He is guarding the materials needed to fix your ship!");
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
			fight();
		}
		else if(choice==2){
			mountains();
		}
		else{
			left();
		}
	}
	
	public void fight(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Your HP: "+ playerHP);
		System.out.println("Alien HP: " + alienHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("3: Defuse alien");
		System.out.println("4: Heal");
		System.out.println("\n------------------------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
			attack();
		}
		else if(choice==2){
			mountains();
		}else if(choice==3){
			deadByAlien();
		}else if(choice==4){
			playerHP+=2;
			System.out.println("You have healed by 2 health points!");
			fight();
		}
		else{
			fight();
		}
	}
	
	public void attack(){
		int playerDamage = new java.util.Random().nextInt(5);
		System.out.println("You attacked the alien and gave " + playerDamage + " damage!");
		alienHP = alienHP - playerDamage;
		
		System.out.println("Alien HP: " + alienHP);

		if(alienHP<1){
			win();
		}else{
			int alienDamage = new java.util.Random().nextInt(4);
			
			System.out.println("The alien attacked you and gave " + alienDamage + " damage!");
			System.out.println("'SCREW YOU!!!', says the alien.");
			
			playerHP = playerHP - alienDamage;
			
			System.out.println("Player HP: " + playerHP);
			if(playerHP<1){
				deadByAlien(); 
			}else{
				fight();
			}

		}
		
	}
	
	public void win(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the alien!");
		System.out.println("Screw him.");
		System.out.println("You obtained the materials for your ship!\n\n");
		System.out.println("1: Go back to ship");
		System.out.println("\n------------------------------------------------------------------\n");
		haveMaterials = true;
		shipEntrance();
	}
	
	public void insideShip(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are inside the ship.");
			
			if (!haveMaterials){
				System.out.println("The ship is broken.");
				System.out.println("You don't have the materials to fix it!");
				System.out.println("You leave the ship.");
				shipEntrance();
			}else{
				System.out.println("Congratulations! You have fixed the ship with the materials you found.");
				endingGood();
			}
	}
	
	
	public void endingGood(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You can go back home now since your ship is fixed.");
		System.out.println("You go into cryogenic sleep and arrive home in 3 light years.");
		System.out.println("\n\n           THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void endingBad(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You fall into a canyon and you die.");
		System.out.println("\n\n           THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");

	}
	
	public void deadByAlien(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("'Sorry fam', he says.");
		System.out.println("\nThe alien blasted you and you are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
		
	}
	
	
	public void dead(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
		
	}
}
