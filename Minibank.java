import java.util.Scanner;
class Bank
{
	private String accno;
	private String name;
	private Long balance;
	Scanner KB = new Scanner(System.in);
	void openAccount()
	{
		System.out.print("Enter Account no: ");
		accno = KB.next();
		System.out.print("Enter Name: ");
		name = KB.next();
		System.out.print("Enter Balance: ");
		balance = KB.nextLong();
	}
	void showAccount()
	{
		System.out.println(accno+" , "+name+" , "+balance);
	}
	void deposit()
	{
		long amt;
		System.out.println("Enter amount you want to deposit: ");
		amt = KB.nextLong();
		balance  = balance+amt;
	}
	void withdrawal()
	{
		long amt;
		System.out.println("Enter amount you want to withdraw: ");
		amt = KB.nextLong();
		if(balance>=amt)
		{
			balance = balance-amt;
		}
		else
		{
			System.out.println("Less Balance...... Transaction Failed..");
		}
	}
	boolean search(String acn)
	{
		if(accno.equals(acn))
		{
			showAccount();
			return(true);
		}
		return(false);
	}	
}
class MiniBank
{
	public static void main(String args[])
	{
		Scanner KB = new Scanner(System.in);
		System.out.print("How many customer you want to input: ");
		int n = KB.nextInt();
		Bank C[] = new Bank[n];
		for(int i = 0; i<C.length; i++)
		{
			C[i] = new Bank();
			C[i].openAccount();
		}
		int ch;
		do
		{
			System.out.println("Main Menu\n1. Display All\n2. Search by Account\n3. Deposit\n4. Withdrawal\n5. Exit");
			System.out.println("Enter your choice: ");
			ch = KB.nextInt();
			switch(ch)
			{
				case 1:
					for(int i = 0; i<C.length; i++)
					{
						C[i].showAccount();
					}
				break;
				case 2:
					System.out.print("Enter Account no. you want to search: ");
					String acn = KB.next();
					boolean found = false;
					for(int i = 0; i<C.length; i++)
					{
						found = C[i].search(acn);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed...... Not Exist....");
					}
				break;
				case 3:
					System.out.print("Enter Account no.: ");
					acn = KB.next();
					found = false;
					for(int i = 0; i<C.length; i++)
					{
						found = C[i].search(acn);
						if(found)
						{
							C[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed...... Not Exist....");
					}
				break;
				case 4:
					System.out.print("Enter Account no.: ");
					acn = KB.next();
					found = false;
					for(int i = 0; i<C.length; i++)
					{
						found = C[i].search(acn);
						if(found)
						{
							C[i].withdrawal();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed...... Not Exist....");
					}
				break;
				case 5:
					System.out.println("Good Bye...!!");
				break;
			}
		}
		while(ch!=5);
	}
}
