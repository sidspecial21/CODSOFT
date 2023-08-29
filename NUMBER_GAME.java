import java.util.*;
public class NUMBER_GAME {

        public static void GuessNumber(){

        Scanner sc = new Scanner(System.in);  
        Random rand = new Random();

        int res;//It will store random genrated number
        int max=100,min=1;
        res=rand.nextInt(max - min + 1) + min;

        int i;
        char c; 
        

        do{  
            for(i=5;i>=1;i--){
                System.out.println("\nGuess the number");
                int num=sc.nextInt();
                if(num>res) {
                   System.out.println("Number is smaller than "+num);
                   System.out.println("You have only "+(i-1)+" attempts left");
                   System.out.println("------------------------------------------------------------------------");
                   continue;
                } 
                else if(num<res){
                   System.out.println("Number is longer than "+num);

                   System.out.println("You have only "+ (i-1) +" attempts left");
                   System.out.println("------------------------------------------------------------------------");
                   continue;
                } 
                else{
                   break;
            
                }   
           }    
            if(i>0){ 
                System.out.println();
                System.out.println("===========================================");
                System.out.println("| congratulations!You guessed the number. |");
                System.out.println("|           Your Score : "+ i*20+"             |"); 
                System.out.println("===========================================");
            } 
            else{
                System.out.println();
                System.out.println("===============================");
                System.out.println("|       Your Score : "+ i*20+"        |");
                System.out.println("|    Better luck next time    |");
                System.out.println("===============================");
            }
            System.out.println();
            System.out.println("To countinue the game press Y otherwise press N");
            Scanner input = new Scanner (System.in);
            c = input.next().charAt(0);
        }
        while(c=='y'||c=='Y');
    } 
     public static void main (String[] args) {
        GuessNumber();

     }
}

