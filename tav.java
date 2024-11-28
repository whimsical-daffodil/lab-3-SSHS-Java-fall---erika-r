import java.util.Random;


public class Tav {
  
   // TODO - create Tav class here!
   public String name;
   public String role;
   public int ar;


   public int hp;
   public int atk;
   public int def;
   public int mastery;
   public int stamina;






   public Tav(String name, String role){
       this.name = name;
       this.role = role;


       this.ar = 1;
       int[] stats = new int[] {15, 14, 13, 12, 10, 8};
       shuffle(stats);


       this.hp = stats[0];
       this.atk = stats[1];
       this.def = stats[2];
       this.mastery = stats[3];
       this.stamina = stats[4];
    
   }


   public void printCharacterSheet() {
       System.out.println("Name: " + this.name);
       System.out.println("Adventure Rank: " + this.ar);
       System.out.println("â”€â”€â”€ ï½¥ ï½¡ï¾Ÿâ˜†: *.â˜½ .* :â˜†ï¾Ÿ. â”€â”€â”€");
       System.out.println("HP: " + this.hp);
       System.out.println("ATK: " + this.atk);
       System.out.println("DEF: " + this.def);
       System.out.println("Elemental Mastery: " + this.mastery);
       System.out.println("Stamina: " + this.stamina);
     
   }


   public String choice;
   public String em;
   public String atc;


   public int roll(String buff) {


       int r = (int)(Math.random()*20) + 1;
       Ascii.drawD20(r);
       return r;
   }


   public int rollGuidance() {


       int r = (int)(Math.random()*20) + 1;
       Ascii.drawD20(r);
      
       int g = (int)(Math.random()*4) + 1;
       Ascii.drawD4(g);


       return r + g;
      
   }


   public static int rollMonster() {
       int m = (int)(Math.random()*6) + 1;
       Ascii.drawD6(m);
       return m;
   }


   // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
   private void shuffle(int[] array) {
       Random random = new Random();
       for (int i = array.length - 1; i > 0; i--) {
           int index = random.nextInt(i + 1);
          
           // Swap elements
           int temp = array[i];
           array[i] = array[index];
           array[index] = temp;
       }
   }
}
