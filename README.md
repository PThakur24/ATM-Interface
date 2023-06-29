ATM Interface
This Java program implements an ATM interface that allows users to perform banking operations such as depositing, withdrawing, transferring money, and viewing transaction history.

Features
Create an AccountHolder class to represent a bank account holder with a unique ID, user ID, password, and associated Account.
Create an Account class to manage the account balance and transaction history.
Implement the following operations in the Account class:
Deposite(double amount): Deposits the specified amount into the account.
Withdraw(double amount): Withdraws the specified amount from the account if the balance is sufficient.
getBalance(): Retrieves the current account balance.
ShowTransactionHistory(): Displays the transaction history.
Transfer(double amount, Account destinationAccount): Transfers the specified amount from the current account to the destination account if the balance is sufficient.
Create a Bank class to manage a list of AccountHolder objects.
Implement the following operations in the Bank class:
AddAccountHolder(AccountHolder accountHolder): Adds an account holder to the bank's list.
getAccountHolder(String userID, String password): Retrieves an account holder based on the provided user ID and password.
Usage
Compile and run the ATM_Interface class.
Enter the required details to create an account.
Once the account is created, log in using the user ID and password.
Select from the available options to perform banking operations:
Enter 1 for depositing money.
Enter 2 for withdrawing money.
Enter 3 for transferring money to another account.
Enter 4 to view transaction history.
Enter 5 to exit the program.
Note: The program allows multiple account holders to perform banking operations concurrently.
