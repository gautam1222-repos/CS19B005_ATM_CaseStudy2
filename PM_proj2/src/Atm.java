import java.util.Scanner;

/**this file is for old code and it is no longer used more and shifted everything to Admin class as instructed in individual constraints*/
public class Atm {
    private static long atmAmount=500000;/**Limit everyone can take from atm*/
    private static int rs2000notes;/**number of notes and types of notes in atm are also a concern for sometimes (didn't implement for now - future use)*/
    private static int rs500notes;
    private static int rs200notes;
    private static int rs100notes;
    private static int rs50notes;
    private static int rs20notes;
    private static int rs10notes;
    private static int rs5notes;
    private static int rs2notes;
    private static int rs1notes;
    public void addAtmAmount(){/**method if money is loaded to ATM(didn't use for now- future uses)*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of 2000 notes you wanted to add to the ATM");
        this.rs2000notes = scan.nextInt();
        System.out.println("Enter the number of 500 notes you wanted to add to the ATM");
        this.rs500notes = scan.nextInt();
        System.out.println("Enter the number of 200 notes you wanted to add to the ATM");
        this.rs200notes = scan.nextInt();
        System.out.println("Enter the number of 100 notes you wanted to add to the ATM");
        this.rs100notes = scan.nextInt();
        System.out.println("Enter the number of 50 notes you wanted to add to the ATM");
        this.rs50notes = scan.nextInt();
        System.out.println("Enter the number of 20 notes you wanted to add to the ATM");
        this.rs20notes = scan.nextInt();
        System.out.println("Enter the number of 10 notes you wanted to add to the ATM");
        this.rs10notes = scan.nextInt();
        this.atmAmount += (this.rs2000notes*2000)+ (this.rs500notes*500) + (this.rs200notes*200) + (this.rs100notes*100) + (this.rs50notes*50) + (this.rs20notes*20) + (this.rs10notes*10);
    }

    public static long getAtmAmount(){/**Bank can have data on how many amount ATM has */
        return atmAmount;
    }

}

// testing
