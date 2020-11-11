import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AtmScreen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //GUI show = new GUI();
        boolean notTerminate = true;
        int PIN_try=0;/**If PIN has 3 faulty tries can't login(NOt implemented -for future use up to now) */
        while(notTerminate){
            System.out.println("\n\nWelcome to ATM of BankA.");
            System.out.println("Enter 1 if you are customer and 0 if you are Admin");
            int adminEntrance = scan.nextInt();
            if(adminEntrance==0) {
                System.out.println("Enter your Admin password to check if you are really admin");
                int password = scan.nextInt();
                Admin admin = new Admin();
                if(admin.adminCheck(password)){
                    admin.addAtmAmount();
                }
            }
            System.out.println("\nPlease Enter your card.");
            System.out.println("Note that if your account doesn't  belong to BankA you will be charged Rs.25/- for any any function you wanted to perform on atm");
            System.out.println();
            Bank b = new Bank();/**every detail will be sent to bank to verify and do function you need*/
            System.out.println("Please Enter your customer account number ");
            int accountNum;/**Takes account number here I took from 19001 to 19021 as account number as you can see data in files*/
            accountNum = scan.nextInt();
            b.setCustomerAccountNum(accountNum);
            if(b.searchAccountNum(accountNum)==false){/**IF number is not as expected as above shows invalid account number*/
                continue;
            }
            int PIN;/**For here I took PIN same as account number but can be saved different and can be run*/
            System.out.println("Please Enter PIN for Account Number :" + accountNum);
            PIN = scan.nextInt();
            if(b.checkPIN(PIN)==false) {/**If PIN doesn't match accoutn's PIN shows invalid PIN*/
                System.out.println("Invalid PIN");
                System.out.println("Did you forget your password.Enter 1 if true and 0 if false");
                int PIN_changer;
                PIN_changer= scan.nextInt();
                if(PIN_changer==1) {/**Gets OTP in case of forgot password option*/
                    b.setOTP();
                    System.out.println("Please enter the OTP you received in 6 digits add appropriate number of 0s to left if number has less than 6 digits");
                    int OTP = scan.nextInt();
                    if (OTP == b.getOTP())
                        System.out.println("Set your new 5-digit PIN");
                    int newPIN = scan.nextInt();
                    b.changePIN(newPIN);
                }
                else
                    continue;
            }
            System.out.println("You have logged in ___");
            SimpleDateFormat dtf = new SimpleDateFormat("HH:mm:ss  dd/MM/yyyy");
            Date date = new Date();
            String transactionTime = dtf.format(date);
            boolean continueMenu =true;
            while(continueMenu) {/**Can select what function has to be performed*/
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("       \t\t\t\t\t\t\t MENU        ");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Select your the given number for respective function you need\n" +
                        "1.View my balance\n" +
                        "2.Withdrawal\n" +
                        "3.Deposit\n" +
                        "4.View all Previous Transactions\t\t" +
                        "and any other number followed by 0(when said) to logout");
                int functionChoose;
                functionChoose = scan.nextInt();
                switch (functionChoose) {
                    case 1:
                        System.out.println(b.getCustomerBalance());
                        b.setPresentTransac("Viewed Account Balance at"+transactionTime);
                        break;
                    case 2:
                        System.out.println("Enter the amount you require to withdraw. If you want to get back to menu enter 0.");
                        int withdrawAmount;
                        withdrawAmount = scan.nextInt();
                        b.withdraw(withdrawAmount);
                        System.out.println("Your balance now left is" + b.getCustomerBalance());
                        b.setPresentTransac("Withdrawn "+withdrawAmount+" at "+transactionTime);
                        break;
                    case 3:
                        System.out.println("Enter the amount you want to deposit. If you want to get back to menu enter 0.");
                        int depositAmount;
                        depositAmount = scan.nextInt();
                        b.deposit(depositAmount);
                        System.out.println("Rs." + depositAmount + "/- deposited in account " + accountNum);
                        System.out.println("Rs." + depositAmount + "/- to your account");
                        System.out.println("Now your balance is" +b.getCustomerBalance());
                        b.setPresentTransac("Deposited "+depositAmount+" at "+transactionTime);
                        break;
                    case 4:
                        b.getAllPrevTransac();/**MiniStatement added for transactions as stated, shows all transactions */
                        break;
                    default:
                        break;
                }
                System.out.println("\nPlease Enter 0 to logout if you are leaving else enter 1 to go back to menu");
                int exitMenu = scan.nextInt();
                if(exitMenu == 0) {
                    b.close();
                    continueMenu = false;
                }
            }
        }
    }
}


/*class GUI extends JFrame implements ActionListener {
    JLabel num1, num2,val;
    JButton b,add,sub;
    JTextField t1,t2;
    public GUI(){
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        num1 = new JLabel("Number 1 =");
        t1 = new JTextField(20);
        num2 = new JLabel("Number 2 =");
        t2 = new JTextField(20);
        b = new JButton("OK");
        val = new JLabel("result");
        add(num1);
        add(t1);
        add(num2);
        add(t2);
        add(b);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 */
