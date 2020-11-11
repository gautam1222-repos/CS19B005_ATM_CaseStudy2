import java.util.Scanner;/**As mentioned I shifted everything from ATM class to Admin*/

public class Admin {

    private static int atmAmount=500000;/**Limit everyone can take from atm*/
    private static int rs2000notes;/**Handling denominations to add money to ATM as mentioned*/
    private static int rs500notes;
    private static int rs200notes;
    private static int rs100notes;
    private static int rs50notes;
    private static int rs20notes;
    private static int rs10notes;
    private static int rs5notes;
    private static int rs2notes;
    private static int rs1notes;
    private static final int password=704319;
    public void addAtmAmount(){/**method if money is loaded to ATM*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of 2000 rupees notes you wanted to add to the ATM");
        this.rs2000notes = scan.nextInt();
        System.out.println("Enter the number of 500 rupees notes you wanted to add to the ATM");
        this.rs500notes = scan.nextInt();
        System.out.println("Enter the number of 200 rupees notes you wanted to add to the ATM");
        this.rs200notes = scan.nextInt();
        System.out.println("Enter the number of 100 rupees notes you wanted to add to the ATM");
        this.rs100notes = scan.nextInt();
        System.out.println("Enter the number of 50 rupees notes you wanted to add to the ATM");
        this.rs50notes = scan.nextInt();
        System.out.println("Enter the number of 20 rupees notes you wanted to add to the ATM");
        this.rs20notes = scan.nextInt();
        System.out.println("Enter the number of 10 rupees notes you wanted to add to the ATM");
        this.rs10notes = scan.nextInt();
        System.out.println("Enter the number of 5 rupees notes you wanted to add to the ATM");
        this.rs5notes = scan.nextInt();
        System.out.println("Enter the number of 2 rupees notes you wanted to add to the ATM");
        this.rs2notes = scan.nextInt();
        System.out.println("Enter the number of 1 rupee notes you wanted to add to the ATM");
        this.rs1notes = scan.nextInt();
        int addedAmount = (this.rs2000notes*2000)+ (this.rs500notes*500) + (this.rs200notes*200) + (this.rs100notes*100) + (this.rs50notes*50) + (this.rs20notes*20) + (this.rs10notes*10)+ (this.rs5notes*5)+ (this.rs2notes*2)+ (this.rs1notes*1);
        this.atmAmount += addedAmount;
        System.out.println("You have loaded Rs."+ addedAmount);
        System.out.println("Now thi system contains Rs."+this.atmAmount);
    }

    public boolean adminCheck(int password){
        if(this.password==password)
            return true;
        else
            return false;
    }

    public static int getAtmAmount(){/**Bank can have data on how many amount ATM has */
        return atmAmount;
    }

    //public void getMaxTransactionUser(){
    //    System.out.println("THe person who withdraw more amount a among all the customers in the past transactions is");
    //}

}