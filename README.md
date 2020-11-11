# CS19B005_ATM_CaseStudy2
1.  The display of the screen always starts with welcoming 
2.  The system asks whether you are Admin/Customer
3.  If Admin then you need to enter the password when asked,here, 740319
4.  Admin can add amount to ATM with denominations mentioned (as given in mail of individual constraints)
5.  Mention number of all different rupee notes you are adding
6.  Then the program starts asking for account number 
7.  this will be sent to bank list of bank's customers to check if account number is valid or not    IN the code account numbers entered are from 19001 to 19050
8.  If account number is present then procced to asking enter PIN
9.  THis PIN will be checked if it's correct or not
10. If PIN entered is wrong then if you forgot password then an OTP will be given(in real case it will be send to phone number)(as given in individual constraint).
11. If PIN is correct, a menu will be showed 
12. then select 1 for sowing balance for given valid account number
13. 2 for withdrawing the amount and enter the amount after the prompt appears if the amount is greater than the account balance  or Amount in ATM you can't take required money        the withdrawn amount will be subtracted from account balance
14. 3 for deposting money  and enter your money and the amount entered to increase amount in balance 
15. 4 for seeing all your previous transactions(as given in individual constraint)
16. if you enter any other number you will be get shown nothing 
17. after each of the operations in last above 5 points (i.e. point 7 to 11) you will be asked if you want to leave the ATM if  yes enter 0 to log out and 1 for back to menu
18. Also in each of these operations you will be reduced Rs.25/- if your account does not belong to BankA.(as given in individual constraint)
19. Everything here will be here sent to bank ,i.e. account number,PIN,withdrawing amount and depositing amount will be sent to bank. 
20. Every customer has a file which can be accessed by bank(as given in individual constraint)
21. All the functionality is changed to Amin from Atm class (as given in individual constraint). 
