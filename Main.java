/* Import Scanner Class to take user input */
import java.util.Scanner;
import java.util.Random;

public class Main {
  /* Declared the variables here so they remain accessible in the different methods */
    Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    Random rand = new Random();
    
    int gold;
    int playerHP;
    String playerWeapon;
    String playerName;
    String playerTool;
    int choice;
    int monsterHP;
    int silverRing;
    int visit;
    int playerArmor;

/* Program always starts/runs at main method   below */
  public static void main(String[] args) {

    /* instantiate the class */
    Main game;
    game = new Main();

    /* Our games methods to get it started */
    game.playerSetUp();
    game.townGate();
  }

  public void playerSetUp(){
    
    playerHP = 15;
    monsterHP = 20;
    gold = 1;
    visit = 1;
    playerArmor = 10;
    
    playerWeapon = "Knife";
    playerTool = "Pick Axe";
    
    System.out.println("\n--------------------------\n");
    System.out.println("Your HP: " + playerHP);
    //System.out.println("Your Armor: " + playerArmor)
    System.out.println("Your Weapon: " + playerWeapon);
    System.out.println("You gold: " + gold);
    System.out.println("\n--------------------------\n");

    System.out.println("Please enter your name:");
   
    playerName = myScanner.nextLine();

    System.out.println("\nHello " + playerName + ", let's start your adventure!");
  }

  public void townGate(){

    System.out.println("\n--------------------------\n");
    System.out.println("You are at the gate of the town.");
    System.out.println("A guard is standing in front of you.");
    System.out.println("");
    System.out.println("What do you want to do? (Enter a number)");
    System.out.println("");
    System.out.println("1: Talk to the guard");
    System.out.println("2: Attack the guard");
    System.out.println("3: Leave");
    System.out.println("\n--------------------------\n");

    choice = myScanner.nextInt();

    if(choice==1){
      if(silverRing==1){
        ending();
      }
      else{
        System.out.println("Guard: Hello there traveler. So your name is " + playerName + "? \nSorry but we cannot let a stranger enter our town. \n\n(Press Enter to Continue)");
        enterScanner.nextLine();
        townGate();
      } 
    }
    else if(choice==2){
      playerHP = playerHP-1;
      System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard that you gave up.\n(You receive 1 damage)\n");
      System.out.println("Your HP: " + playerHP);
      System.out.println("\n(Press Enter to Continue)");
      enterScanner.nextLine();
      townGate();
    }
    else if(choice==3){
      crossRoad();
    }
    else{
      townGate();
    }
  }

  public void crossRoad(){

    System.out.println("\n--------------------------\n");
    System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
    System.out.println("1: Go north");
    System.out.println("2: Go east");
    System.out.println("3: Go south");
    System.out.println("4: Go west");
    System.out.println("\n--------------------------\n");

    choice = myScanner.nextInt();

    if(choice==1){
      north();
    }
    else if(choice==2){
      east();
    }
    else if(choice==3){
      townGate();
    }
    else if(choice==4){
      west();
    }  
    else if(choice==5){
      cave();
    }
    else{
      crossRoad();
    }
  }

  public void north(){

    System.out.println("\n--------------------------\n");
    System.out.println("Inn keeper: Hello and welcome to the North. You may stay at my Inn for the night for only one gold");
    System.out.println("1: Restore one heath for 1 gold");
    System.out.println("2: Turn back");
    System.out.println("\n--------------------------\n");

    choice = myScanner.nextInt();

    if(choice==1){
      gold = gold-1; 
      playerHP = playerHP+1;
      System.out.println("You have rested at the Inn and regaind one health.");
      System.out.println("Your HP is now: " + playerHP);
      System.out.println("you Gold is now: " + gold);
      crossRoad();
    }
    else if(choice==2){
      System.out.println("You decied to leave");
      crossRoad();
      
    }
    else {
      north();
    }
    }


  public void east(){    

    System.out.println("\n--------------------------\n");
    System.out.println("TOOL SMITH: Hello and welcome to the tool shop. Here we sell everything from lamp oil, rope, bombs and more! As long as you have enough gold my fiend. here, I will give you a free gift traveler.");
    System.out.println("1: Accept the gift");
    System.out.println("2: Leave");
    //System.out.println("You found some gold!! " + gold + "to be exact");
    //gold = new java.util.Random().nextInt(10);
    System.out.println("\n--------------------------\n");

    choice = myScanner.nextInt();

    if(choice==1){
      if(visit==1){
        System.out.println("YOU RECIVE ONE FREE PICKAXE FOR MINING");
        playerTool = "Pick Axe";
        System.out.println("Your toolbelt: " + playerTool);
        System.out.println("(Press enter key)");
        visit = visit-1;
        enterScanner.nextLine();
        east();
      }
      else{
        System.out.println("Check out our store!!");
        System.out.println("enter a number to buy an item. enter 0 to exit");
        System.out.println("1: Silver longsword");
        enterScanner.nextLine();
        east();
      }
      
    }
    else if(choice==2){
      crossRoad();
    }
    else{
      crossRoad();
    }
    
  }

  public void west(){

    System.out.println("\n--------------------------\n");
    System.out.println("you come across a HUGE MONSTER");
    System.out.println("1:FIGHT IT");
    System.out.println("2:RUN AWAY");
    System.out.println("\n--------------------------\n");
  choice = myScanner.nextInt();
  if(choice==1){
      fight();
    }
  else if(choice==2){
    crossRoad();  
  }
  }


  public void cave(){

    System.out.println("\n--------------------------\n");

    if(gold>15){
      playerTool = "Dynamite";
      gold = new java.util.Random().nextInt(100);
      System.out.println("you grab your dynamite and your litter and you ignite the dynamite it explodes and you recive" + gold + " to be exact");
      enterScanner.nextLine();
      crossRoad();
    }

    if(playerTool=="Pick Axe"){
        gold = new java.util.Random().nextInt(10);
        System.out.println("You see somthing glitter in the corrner of your eye. You use your pickaxe and unlodge some gold! " + gold + " to be exact(press enter)");
        System.out.println("\n--------------------------\n");
        // System.out.println("you can chose to leave or to stay in the cave");
        System.out.println("1: Keep mining for gold");
        // System.out.println("2: Leave");
        //System.out.println("\n--------------------------\n");
        enterScanner.nextLine();
        cave();
  
    }
    else{
      System.out.println("This is too intense for you! Get outta here!");
      enterScanner.nextLine();
      crossRoad();
    }

    choice = myScanner.nextInt();

    if(choice==1){
      crossRoad();
    }

  }
  





  public void fight(){

    System.out.println("\n--------------------------\n");
    System.out.println("Your HP: " + playerHP);
    System.out.println("Monster HP: " + monsterHP);
    System.out.println("\n1: Attack");
    System.out.println("2: Run");
    System.out.println("\n--------------------------\n");

    choice = myScanner.nextInt();

    if(choice==1){
      attack();
    }
    else if(choice==2){
      crossRoad();
    }
    else{
      fight();
    }
  }

  public void attack(){
    // initialize it by giving it 0
    int playerDamage=0;

    if(playerWeapon.equals("Knife")){
          // picks up random # from 0 - 2
      playerDamage = new java.util.Random().nextInt(2);
    }
    if(playerWeapon.equals("Long Sword")){
          // picks up random # from 0 - 6
      playerDamage = new java.util.Random().nextInt(8);
    }

    System.out.println("You attacked the dragon and gave " + playerDamage + " damage");

    monsterHP = monsterHP - playerDamage;

    System.out.println("Monster HP: " + monsterHP);

    if(monsterHP<1){
      win();
    }
    else if(monsterHP>0){
      int monsterDamage =0;

      monsterDamage = new java.util.Random().nextInt(6);

      System.out.println("The dragon attacked and gave you " + monsterDamage + " damage!");

      playerHP = playerHP-monsterDamage;

      System.out.println("Player HP: " + playerHP);

      if(playerHP<1){
        dead();
      } 
      else if(playerHP>0){
        fight();
      }
    }
  }

  public void dead(){

    System.out.println("\n--------------------------\n");
    System.out.println("You have died!!");
    System.out.println("\n\nGAME OVER");
    System.out.println("\n--------------------------\n");
  }

  public void win(){

    System.out.println("\n--------------------------\n");
    System.out.println("You killed the dragon!");
    System.out.println("The dragon dropped a ring.");
    System.out.println("(You obtained a silver ring)\n\n");
    System.out.println("1: Go east");
    System.out.println("\n--------------------------\n");

    silverRing = 1;

    choice = myScanner.nextInt();

    if(choice==1){
      crossRoad();
    }
    else{
      win();
    }  
  }

  public void ending(){

    System.out.println("\n--------------------------\n");
    System.out.println("Guard: Oh you killed that dragon!?? Great!\nIt seems that you are a trustworthy guy.\nWelcome to our town.");
    System.out.println("\n\n...........THE END...........");
    System.out.println("\n--------------------------\n");

  }
}


//print ("               ,O, ")
//print ("              ,OOO, ")
//print ("        'oooooOOOOOooooo' ")
//print ("          `OOOOOOOOOOO` ")
//print ("            `OOOOOOO` ")
//print ("            OOOO'OOOO ")
//print ("           OOO'   'OOO ")
//print ("          O'         'O ")