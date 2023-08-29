import java.util.Scanner;
class Bank{
   int balance=100000;
}

public class ATM {
    Bank b=new Bank();
     Scanner sc = new Scanner(System.in); 
    public void Withdraw(){
        System.out.print("\nEnter amount to be withdrawn:"); 

        int withdraw = sc.nextInt();  
                        
        if(b.balance >= withdraw)  
        {    
            b.balance = b.balance - withdraw;  
            System.out.println("Please collect your money");  
        }  
        else  
        {    
            System.out.println("Insufficient Balance");  
        }  
        System.out.println("");  
         
    }
    public  void Deposit(){
        System.out.print("\nEnter money to be deposited:");    
        int deposit = sc.nextInt(); 
        if(deposit!=0){
        b.balance = b.balance + deposit;  
        System.out.println("Your Money has been successfully depsited");  
        System.out.println(""); 
        }
        else{
            System.out.println("Enter valid amount");
        }
    }
    public  void CheckBalance(){
        
        System.out.println("\nYour account balance : "+b.balance);  
        System.out.println("");
    }

     public static void main(String args[]){
     
         Scanner sc = new Scanner(System.in); 
         ATM obj =new ATM();
         char selection;
          
       do 
        {
           System.out.printf("\t\t=================================================\n");
System.out.printf("\t\t|          Automated Teller Machine             |\n");
	System.out.printf("\t\t|       ----------------------------------      |\n");
	System.out.printf("\t\t|                1.Withdraw                     |\n");
	System.out.printf("\t\t|                2.Deposit                      |\n");
	System.out.printf("\t\t|                3.Check Balance                |\n");
	System.out.printf("\t\t|                4.Exit                         |\n");
    System.out.printf("\t\t|       ----------------------------------      |\n");
	System.out.printf("\t\t|            Enter any one option               |\n");
	System.out.printf("\t\t|                                               |\n");
	System.out.printf("\t\t|                                               |\n");
	System.out.printf("\t\t=================================================\n\n\n");


    int  choice = sc.nextInt();  
     switch(choice)  
     {
        case 1:
               obj.Withdraw();
               break;
        case 2:
               obj.Deposit();
               break;  
        case 3: 
               obj.CheckBalance();
               break;
        case 4:  

               System.exit(0);  
        default:
               System.out.println("Please choose correct option");
     }
      
      System.out.println("\n
      Press y to continue and n to exit...");
        
      Scanner input = new Scanner (System.in);
            selection = input.next().charAt(0);
    }
while(selection=='Y'||selection=='y');
}
}