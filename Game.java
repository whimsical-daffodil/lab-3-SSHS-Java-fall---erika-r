import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import javax.management.relation.Role;


import java.util.Random;


public class Game {
   public static void main(String[] args) {


       // Create Scanner for collecting user input.
       Scanner scanner = new Scanner(System.in);


       // Collect character name from user.
       System.out.print("Name: ");
       String name = scanner.nextLine();


       System.out.println("Please pick among these roles: (1) Archer, (2) Swordsman ");
       System.out.println("(type the number associated with the role you want to pick)");
       System.out.println("chose your fate: ");
       String role = scanner.nextLine();


       if (role.equals("1")){
           System.out.println("Role: Archer ");
       }


       if(role.equals("2")){
           System.out.println("Role: Swordsman");
       }


       Tav player = new Tav(name, role);
       player.printCharacterSheet();


       printDramaticText("hello traveller, welcome to Teyvat!");
       printDramaticText("where will your adventure lead you today? ");
       printDramaticText("(1) The Angel's Share Tavern, (2)Dragonspine Mountain");
       System.out.println("(Please type the number associated with the location you want to go to)");
       String place = scanner.nextLine();


       if (place.equals("1")){
           printDramaticText("Excellent choice!");
           printDramaticText("You walk into the tavern, the dim lights have a soft amber glow that create a cozy atmosphere");
           printDramaticText("You felt at peace until someone grabbed you by your shoulders");
           printDramaticText("Venti: ' TRAVELLER ! ! ! thank the archons you're here! Theres MONSTERS in the tavern basement!");
           printDramaticText("It was Venti the tone deaf bard! a drunkard and loyal customer of the Angel's Share");
           printDramaticText("Venti: 'PLEASE SAVE ME TRAVELLER ! ! ! :(' ");
           printDramaticText("Before you even get a chance to reply Venti drags you into the basement, which to your suprise was ACTUALLY infested with monsters !");


       }  


       if (place.equals("2")){
           printDramaticText("a-are you sure?...");
           printDramaticText("Dragonspine is dangerously cold! You'll freeze to death if you dare step one toe in that mountain!");
           printDramaticText("You could feel the harsh wind beat down against your skin as you approached the foot of the mountain");
           printDramaticText("It hasn't even been 5 minutes and you were already shaking");
           printDramaticText("Suddenly you hear a familar scream in the distance");
           printDramaticText("Bennett: 'TRAVLLER ! ! ! HELP ! HELP !'");
           printDramaticText("It was Bennett from the andventurers guild! an unlucky guy who always found himself in trouble");
           printDramaticText("Bennett was sorrounded by the monsters of the mountain, you gotta go save him!");
       }


       // Generate a monster which requires a certain roll to beat (int)
       // Implement a roll() method which allows your character to roll to beat said monster.
       int required = generateMonster();


       // Accept a possible buff input from the player
      
      System.out.println("if you would like a Elemental mastery buff type 'x' if you would like an ATK buff type 'y'");
      String choice = scanner.nextLine();


      if (choice.equals("x")) {
          int result1 = player.roll("");
          int result2 = player.roll("");
          if (result1 > result2){
               int result = result1;
                   if (required < result){
                       System.out.println("You needed " + required + " and you rolled a " + result + " congrats!");


                   } else {
                       System.out.println("game over :(");
          
                   }
          } else {
               int result = result2;
               if (required < result){
                   System.out.println("You needed " + required + " and you rolled a " + result + " congrats!");
               } else {
                   System.out.println("game over :("); 
               }
           }






       }
  
       if (choice.equals("y")) {
           int result = player.rollGuidance();


           if (result == 1){
               printDramaticText("CRITICAL MISS ! ! ! ");
           }


           if (result == 20){
               printDramaticText("CRITICAL HIT ! ! !");
           }


           if (required <  result) {
               System.out.println("You needed " + required + " and you rolled a " + result + " congrats!");
           } else {
               System.out.println("game over :(");
           }
       }
   }






 
   public static int generateMonster() {
       Random random = new Random();


       int r = (int)(Math.random() * 6) + 1;


       int damage = 0;


       if(r == 1 || r == 2 || r == 3){
           String slime = Character.toString(0x1F922);
           System.out.println("++ " + slime + " a slime appears! " + slime + " ++");
           System.out.println("+     roll required: 4     +");
           System.out.println("++++++++++++++++++++++++++++");
           damage = 4;
       }
      
       if(r == 4 || r == 5){
           String mage = Character.toString(0x1F52E);
           System.out.println("++ " + mage + " an abyss mage appears! " + mage + " ++" );
           System.out.println("+     roll required: 8     +");
           System.out.println("++++++++++++++++++++++++++++");
           damage = 8;
       }


       if(r == 6){
           String dragon = Character.toString(0x1F409);
           System.out.println("++ " + dragon + " Stormterror the Dragon appears! " + dragon + " ++");
           System.out.println("+     roll required: 16    +");
           System.out.println("++++++++++++++++++++++++++++");
           damage = 16;
       }


       return damage;


  
  
   }
  
  


   public static void printDramaticText(String text) {
       // Delay in milliseconds
       int delay = 100;


       for (char c : text.toCharArray()) {
           System.out.print(c);
           try {
               TimeUnit.MILLISECONDS.sleep(delay);
           } catch (InterruptedException e) {
               System.err.println("Interrupted: " + e.getMessage());
               Thread.currentThread().interrupt();
           }
       }
       System.out.println();
   }
}


