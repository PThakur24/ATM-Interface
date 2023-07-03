import java.util.*;

class AccountHolder{
	private String userID;
	private String password;
	private Account account;
	private int id;

	public AccountHolder(int id,String userID, String password, Account account) {
		this.userID=userID;
		this.password=password;
		this.account=account;
		this.id=id;
	}
	
	public String getuserID(){
		return userID;
	}
	
	public Account getAccount() {
		return account;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean validateUser(String userID, String password) {
		return (this.userID.equals(userID)&&this.password.equals(password));
			
	}

}

class Account{
	private double balance;
	private List<BankTransaction> transactionHistory;
	
	public Account(double balance) {
		this.balance=balance;
		this.transactionHistory=new ArrayList<>();
	}
	
	public void Deposite(double amount) {
		balance += amount;
		transactionHistory.add(new BankTransaction("Deposite", amount));
	}
	
	public void Withdraw(double amount) {
		if (amount<=balance) {
			balance-=amount;
			transactionHistory.add(new BankTransaction("Withdraw", amount));
		}
		else {
			System.out.println("Insufficient Balance");
		}
		
	}
	
	public double getbalance() {
		return balance;
	}
	
	public void ShowTransactionHistory() {
		for(BankTransaction transaction:transactionHistory)
		{
			System.out.println(transaction);
		}
	}
	
	public void Transfer(double amount, Account destinationAccount) {
		if(amount<=balance)
		{
			balance-=amount;
			destinationAccount.Deposite(amount);
			transactionHistory.add(new BankTransaction("Transfer to"+destinationAccount.hashCode(),amount));
		}
		else
			System.out.println("Insufficient Balance");
	}
}

class BankTransaction{
	private String type;
	private double amount;
	
	public BankTransaction(String type, double amount) {
		this.type=type;
		this.amount=amount;
	}
	
	public String toString() {
        return "Type: " + type + ", Amount: " + amount;
    }
}

class Bank{
	private List<AccountHolder> accountHolders;
	
	public Bank() {
		this.accountHolders= new ArrayList<>();
	}
	
	public void AddAccountHolder(AccountHolder accountHolder) {
		accountHolders.add(accountHolder);
	}
	
	public AccountHolder getAccountHolder(String userID, String password) {
		for(AccountHolder accountHolder: accountHolders) {
			if(accountHolder.validateUser(userID, password))
				return accountHolder;
		}
		return null;
	}
}
public class ATM_Interface {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bank b=new Bank();
		List<AccountHolder> ah=new ArrayList<>();
		List<Account> acc=new ArrayList<>();
int count=0,accv=0;
		while(true) {
			System.out.println("Welcome User, Please enter your details to create account");
			System.out.println("Enter UserID to create: ");
			String n=sc.nextLine();
			System.out.println("Create Password : ");
			String p=sc.nextLine();
			acc.add(new Account(1000));
			ah.add(new AccountHolder(++count,n,p,acc.get(accv++)));
			System.out.println("Enter 1 to continue else press 0 ");
			if(sc.nextInt()==1) {
				sc.nextLine();
				continue;}
			else
				break;
		}
		for(AccountHolder ah3:ah) {
			b.AddAccountHolder(ah3);
		}
		double amount;
		
		int choice;
		String userID;
		String password;
		
		while(true) {
			System.out.println("Please enter your details tp Log In");
			System.out.println("enter userID");
			userID=sc.next();
			System.out.println("Enter Password");
			password=sc.next();
			int c;
			c=0;
			
			AccountHolder ah1=b.getAccountHolder(userID, password);
			try{while(ah1.getAccount()!=null) {
			System.out.println("Hello "+userID);
			System.out.println("Bank Menu :");
			System.out.println("For Deposite-enter 1");
			System.out.println("For Withdraw-enter 2");
			System.out.println("For Transfer-enter 3");
			System.out.println("For Transaction History-enter 4");
			System.out.println("For exit-enter 5");
			System.out.println();
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			Account d;
			switch(choice) {
				case 1:
					System.out.println("Deposite");
					System.out.println("Enter amount to deposite : ");
					amount=sc.nextDouble();
					ah1.getAccount().Deposite(amount);
					System.out.println("Successfully deposited");
					break;
					
				case 2:
					System.out.println("Withdraw");
					System.out.println("Enter amount to withdraw : ");
					amount=sc.nextDouble();
					ah1.getAccount().Withdraw(amount);
					System.out.println("Successfully withdraw");
					break;
					
				case 3:
					System.out.println("Transfer Money");
					System.out.println("Enter ID to transfer Money");
					int i=sc.nextInt();
					System.out.println("Enter amount to transfer");
					double amountToTransfer=sc.nextDouble();
					//sc.nextLine();
//					for(AccountHolder a:ah) {
//					if(a.getId()==i) {
					ah1.getAccount().Transfer(amountToTransfer, acc.get(i-1));
					System.out.println("Transfered Successfully");
					
//						}						
					break;
					
				case 4:
					System.out.println("Transaction History");
					ah1.getAccount().ShowTransactionHistory();
					break;
				case 5:
					System.exit(0);
				
				default:
					System.out.println("Invalid operation");
					break;
				
			}			
		}}
		catch(Exception e) {
			System.out.print("userID/Password incorrect"+e.getMessage());
			
		}
			
	}
	

	}}
