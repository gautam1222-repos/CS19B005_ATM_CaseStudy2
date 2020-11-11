import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    //private static CustomerAccount[] customers = new CustomerAccount[50];
    //private int accountNum=19001;
    //private int PIN=19001;
    //private long balance=134134;
    private int customerIndex;
    private static int atmAmount=Admin.getAtmAmount();
    private int AccountNum;/***/
    private int PIN;/**in*/
    private String Bank;/**in*/
    private String strPIN;/**in*/
    private String strBalance;/**in*/
    private int Balance;/**in*/
    private String prevTransac;/**in*/
    private String  presentTransac;
    private int enteredPIN;
    private int OTP;
    private static String maxTransactionUser;
    private static int maxTransactionAmount;


    public void setCustomerAccountNum(int customerAccountNum) {
        this.AccountNum = customerAccountNum;/**Taking account number for if account number present*/
    }

    public boolean searchAccountNum(int accountNum){/**Checking account number , if account number present*/
    boolean finder;
    String customerFile = accountNum+".txt";
        try {
            File file = new File(customerFile);/**Included files as stated, here we can take each customer file as object so no need to use hard coded way like making object of customers */
            Scanner read = new Scanner(file);
            for (int i=0; read.hasNextLine();i++){
                if(i==0)
                    Bank= read.nextLine();
                else if(i==1)
                    continue;
                else if(i==2){
                    strPIN = read.nextLine();
                    PIN = Integer.parseInt(strPIN);
                }
                else if(i==3){
                    strBalance = read.nextLine();
                    Balance=Integer.parseInt(strBalance);
                }
                else if(i==4){
                    prevTransac = read.nextLine();
                }
                else {
                    prevTransac += ("\n"+read.nextLine());
                }
            }
            read.close();
            finder = true;
        }
        catch (IOException e){
            System.out.println("Account not found");
            finder = false;
            e.printStackTrace();
        }
        return finder;
    }

    public void setCustomerPIN(int customerPIN) {/**taking inout of PIN from screen*/
        this.enteredPIN = customerPIN;
    }

    public boolean checkPIN(int customerPIN){/**Checking if PIN is correct or not*/
        if(customerPIN==PIN) {
            System.out.println("correct PIN");
            return true;
        }
        else {
            System.out.println("wrong PIN");
            return false;
        }
    }

    public long getCustomerBalance() {/**shows balance to customer*/
        return (Balance-=25);/**Chargibng if not same same bank as stated in individual constraints*/
    }

    public void withdraw(int withdrawAmount) {
        if(Balance<=1000)
            System.out.println("Your balance is less than or equal to Rs.1000/-\nSorry you cannot withdraw money");
        else if (atmAmount < withdrawAmount)/**Showing if withdraw is not possible in case of insufficient amount in atm*/
            System.out.println("Sorry the ATM doesn't have enough money you need.ATM has only"+atmAmount);
        else if (Balance < withdrawAmount)/**Showing if withdraw is not possible in case of insufficient amount in customer account*/
            System.out.println("Sorry you cannot draw more than your account balance which is Rs." + Balance);
        else {
            Balance-=withdrawAmount;
            atmAmount-=withdrawAmount;
            if(!Bank.equals("BankA"))
                Balance-=25;/**Chargibng if not same same bank as stated in individual constraints*/
            System.out.println("Please collect your cash\n" +
                    "You have withdrawn Rs." + withdrawAmount + " Your current balance is Rs." + Balance);
            if(withdrawAmount > maxTransactionAmount)
                maxTransactionAmount=withdrawAmount;
        }
    }
    public void changePIN(int PIN){
        this.PIN=PIN;
    }

    public void setOTP(){
        Random rand = new Random();
        int num = rand.nextInt(1000000);
        System.out.println("Your OTP is " + num);
        this.OTP = num;
    }
    public int getOTP(){
         return OTP;
    }

    public void deposit(int depositAmount){
        Balance+=depositAmount;
        Balance-=25;/**Chargibng if not same same bank as stated in individual constraints*/
        atmAmount+=depositAmount;
    }

    public void setPresentTransac(String presentTransac) {
        this.presentTransac += ("\n"+presentTransac);
    }

    public void close(){
        String customerFile = this.AccountNum +".txt";
        String fileWriteData = this.Bank+"\n"+this.PIN+"\n"+(Integer.toString(this.Balance))+"\n" ;
        String Transactions  = prevTransac+presentTransac;
        try {
            FileWriter fr = new FileWriter(customerFile);
            fr.write(fileWriteData+Transactions);
            fr.close();
        }
        catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void getAllPrevTransac() {
        System.out.println(prevTransac);
    }

    //public void getMaxTransac(){
      // String str = Integer.toString(this.AccountNum)+" "+this.Bank+" "+presentTransac
    //}
}
