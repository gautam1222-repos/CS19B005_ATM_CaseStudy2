import java.util.Random;
/**this file is for old code and it is no longer used more */
public class CustomerAccount {
    private int accountNum;/**Basic customer details*/
    private int pin;/**Basic customer details*/
    private int balance;/**Basic customer details*/
    private String prevTransaction;/**for showing prev transac time can be used as array instead of string to show prev (not used for now - can use for future)*/
    private int pinTry;/**like using how many times customer given faulty tries**/
    private static long atmAmount = Admin.getAtmAmount();
    private int OTP;
    CustomerAccount(int accountNum,int PIN,long balance){
        this.accountNum =accountNum;
        this.pin = PIN;
        this.deposit(balance);
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPrevTransaction(String prevTransaction) {/**for showing prev transac time can be used as array instead of string to show prev (not used for now - can use for future)*/
        this.prevTransaction = prevTransaction;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getPin() {
        return pin;
    }

    public long getBalance() {
        return balance;
    }

    public String getPrevTransaction() {/**for showing prev transac time can be used as array instead of string to show prev (not used for now - can use for future)*/
        return prevTransaction;
    }

    public void deposit(long depositAmount){/**Add money to balance*/
        balance+=depositAmount;
    }

    public void changePIN(int PIN){
        this.pin = PIN;
    }

    public void setOTP(){
        Random rand = new Random();
        int num = rand.nextInt(1000000);
        System.out.println("Your OTP is "+num);
    }

    public int getOTP(){
        return (this.OTP);
    }


    public void withdraw(int withdrawAmount){/**Remove money from balance*/
        balance = balance - withdrawAmount;
    }


}

// testing
