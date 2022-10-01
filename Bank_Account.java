//Andrew Lee
import java.io.*; //import java.io.* Class
import java.util.Scanner; //import Scanner Class
public class Bank_Account {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//Create new file
		File myfile= new File("Account Database.txt");
		//Create new file
		File myfile2= new File("RunDown.txt");
		//Create a scanner object for myfile
		Scanner inputFile= new Scanner(myfile);
		//Create scanner object for myfile2
		Scanner inputFile2= new Scanner(myfile2);
		//Create output file
		// PrintWriter outputFile= new PrintWriter("Account Output.txt");
		// outputFile.println("Andrew Lee");
		// outputFile.println();
		//Initialize variable size to represent max size of accounts
		final int size=50;
		//Create variable numAccts
		int numAccts;
		//create character in
		char in;
		//create array acct with element size of 50
		int[]acct= new int[size];
		//create balance array with element size of 50
		double[]balance=new double[size];
		//Call numAccts to fill balance and acct array from Account Database
		numAccts=readAccts(acct,balance,size,inputFile);
		//Prints filled arrays acct and balance into output file
		printAccts(acct,balance,numAccts);
		do //Create do-while loop
		{
			//calls menu to print operating menu to console
			menu();
			//reads char response from file and assigns it to in
			in = inputFile2.next().charAt(0);


			switch (in)//Start switch statement for char in
			{
			//if q or Q is entered the loop terminates
			case 'Q':
			case 'q':
				in= 'Q';
				in= 'q';
				break;
			//if W is entered, withdrawal method is called,
			//reading data from file RunDown and prints to output file
			case 'W':
				withdrawal(acct,balance,numAccts,inputFile2);
				break;
			//if D is entered, deposit method is called, reading data
			//from file RunDown and prints to output file
			case 'D':
				deposit(acct,balance,numAccts,inputFile2);
				break;
			//if N is entered, newAcct method is called, reading data
			//from file RunDown and prints to output file
			//The returned value updates numAccts
			case 'N':
				numAccts=newAcct(acct,balance,
						numAccts,inputFile2);
				break;

			//if B is entered, balance method is called, reading data
			//from file RunDown and prints to output file
			case 'B':
				balance(acct,balance,numAccts,inputFile2);
				break;
			//If an incorrect value is entered, an error message is
			//printed and prompts another submission
			default:
				System.out.println();
				System.out.print("Error: Invalid Prompt");
				System.out.println("\nTry Again");
				System.out.println();
			}


		}
		//While loop continues until Q or q is entered
		while (in != 'Q' && in != 'q');
		{

		}
	//printAccts prints the updated  arrays with new accounts and balances
	printAccts(acct,balance,numAccts);
	System.out.println();
	//prints to console the program has terminated
	System.out.println("User has exited");
	//outputFile.println();
	//prints to output file the program has terminated
	//outputFile.println("User has exited");

		//outputFile.close();//close output file
		inputFile.close();//close input file
		inputFile2.close();//close input file
	}
	/*method menu
	 * Input:
	 * 	N/A
	 * Process:
	 * 	prints a menu
	 * Output:
	 * 	prints a menu
	*/
	public static void menu() {
		System.out.println("");
		System.out.println("Select one of the following: "
				+ "\nW - Withdrawal \nD - Deposit"
				+ "\nN - New account \nB - Balance \nQ – Quit");
		System.out.println("");
	}
	/* method readAccts
	 * Input:
	 * 	acctNum- reference to an array of integers
	 * 	the array is uninitialized upon entry
	 * 	balance- reference to an array of doubles
	 * 	the array is uninitialized upon entry
	 * 	maxAccts- number if maximum amount of
	 * 	elements in the array
	 * 	inputFile- reference to an input file
	 * Process:
	 * 	reads values into the array and determines n
	 * Output:
	 * 	the filled acct and balance arrays
	 * 	n- the number of elements read into the array
	*/
	public static int readAccts(int[] acctNum, double[] balance,
			int maxAccts,Scanner inputFile) {

			int n=0;
			 while(inputFile.hasNext()) {

				acctNum[n]=inputFile.nextInt();
				balance[n]=inputFile.nextDouble();
				n++;

			}
			inputFile.close();
			return n;

		}
	/*method printAccts
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	balance-reference to an array of doubles
	 * 	numAccts-amount of accounts filled within array
	 * 	inputFile-reference to an input file
	 * Process:
	 * 	prints arrays acctNum and balance into a table
	 * Output:
	 * 	prints arrays acctNum and balance into a table
	*/
	public static void printAccts(int[] acctNum, double[] balance,
			int numAccts) {

		System.out.println("\tAccount\t\t\tBalance");
		for(int count=0;count<numAccts;count++) {
			System.out.println("\t  "+acctNum[count]+"\t\t\t"+
		"$"+ balance[count]);
		}


	}

	/*method findAcct
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	numAccts-total elements of the array
	 * 	account-value of an array's element
	 * Process:
	 * 	finds the account index within the array the
	 * 	corresponds to the account value entered
	 * 	if it exists and assigns the index to temp. If
	 * 	the account doesn't exist, -1 is assigned to temp
	 * Output:
	 * 	returns the array index of the account
	*/
	public static int findAcct(int[] acctNum, int numAccts,
			int account) {
		int temp=0;
		for(int i=0;i<numAccts;i++) {

			if(account==acctNum[i]) {
				temp=i;
				break;
			}
			else {
				temp=-1;
			}

		}

			return temp;

	}
	/*method balance
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	balance-reference to an array of doubles
	 * 	numAccts-amount of accounts within the arrays
	 * 	inputFile-reference to an input file
	 * 	out-reference to an output file
	 * Process:
	 * 	calls findAcct method that will be operated
	 * on and assigns the index value to answer
	 * 	if answer=-1, an error is printed because it
	 *  isn't an existing account. If it exists
	 * 	the account details are printed
	 * Output:
	 * 	Account number and balance are printed
	*/
	public static void balance(int[] acctNum, double[] balance,
			int numAccts,Scanner inputFile) {
		//Scanner inputFile=new Scanner(System.in);
		System.out.println("Transaction Type: Balance");
		//System.out.println("Select an account");
		int account=inputFile.nextInt();
		int answer= findAcct(acctNum,numAccts,account);
		if (answer==-1) {
			System.out.println("Account does not exist!");
			System.out.println();
		}
		else {
		System.out.println("Account Number: "+account);
		System.out.println("Current Balance: "+"$"+balance[answer]);
		System.out.println();
		}
		//inputFile.close();


	}
	/*method withdrawal
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	balance-reference to an array of doubles
	 * 	numAccts-amount of accounts within the arrays
	 * 	inputFile-reference to an input file
	 * 	out-reference to an output file
	 * Process:
	 * 	calls findAcct method that will be operated
	 * 	on and assigns the index value to answer
	 * 	if answer=-1, an error is printed because it
	 * 	isn't an existing account. If it exists
	 * 	the account details are printed. The user is
	 * 	prompted to enter the amount to withdraw
	 * 	from the account balance. if the withdrawal
	 * 	amount is greater than the balance the
	 * 	program prints an error message, otherwise
	 * 	the value is subtracted from the balance
	 * Output:
	 * 	Account number and updated balance is printed
	*/

	public static void withdrawal(int[] acctNum, double[] balance,
			int numAccts,Scanner inputFile) {
		//Scanner inputFile= new Scanner(System.in);
		System.out.println("Transaction Type: Withdrawal");
		//System.out.println("Select an account");
		int account=inputFile.nextInt();
		double withdraw=0;
		int answer= findAcct(acctNum,numAccts,account);
		if (answer==-1) {
			System.out.println("Account does not exist!");
			System.out.println();
		}
		else {
		System.out.println("Account Number: "+account);
		System.out.println("Current Balance: "+"$"+balance[answer]);
		//System.out.println("How much to withdraw?");
		withdraw= inputFile.nextDouble();
		if (withdraw>balance[answer]) {
			System.out.printf("Amount to withdraw: "+"$"+"%.2f",withdraw);
			System.out.println();
			System.out.println("Error: Insufficient Funds Available");
			System.out.println();
		}
		else {
		System.out.printf("Amount to withdraw: "+"$"+"%.2f",withdraw);
		balance[answer]= balance[answer]-withdraw;
		System.out.println();
		System.out.printf("New Balance: "+"$"+"%.2f",balance[answer]);
		System.out.println();
		System.out.println();
		}
		}
		//inputFile.close();
	}
	/*method deposit
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	balance-reference to an array of doubles
	 * 	numAccts-amount of accounts within the arrays
	 * 	inputFile-reference to an input file
	 * 	out-reference to an output file
	 * Process:
	 * 	calls findAcct method that will be operated on
	 * 	and assigns the index value to answer
	 * 	if answer=-1, an error is printed because it
	 * 	isn't an existing account. If it exists
	 * 	the account details are printed. The user is
	 * 	prompted to enter the amount to deposit
	 * 	into the account balance. if the deposit amount
	 * 	is less than zero the program prints
	 * 	an error message, otherwise the value is added
	 * 	to the balance
	 * Output:
	 * 	Account number and updated balance is printed
	*/
	public static void deposit(int[] acctNum, double[] balance,
			int numAccts,Scanner inputFile) {
		//Scanner inputFile=new Scanner(System.in);
		System.out.println("Transaction Type: Deposit");
		//System.out.println("Select an account");
		int account=inputFile.nextInt();
		double deposit=0;
		int answer= findAcct(acctNum,numAccts,account);
		if (answer==-1) {
			System.out.println("Account does not exist!");
			System.out.println();
		}
		else {
		System.out.println("Account Number: "+account);
		System.out.println("Current Balance: "+"$"+balance[answer]);
		//System.out.println("How much to deposit?");
		deposit=inputFile.nextDouble();
		if (deposit<0) {
			System.out.printf("Amount to deposit: "+"$"+"%.2f",deposit);
			System.out.println();
			System.out.println("Error: Insufficient Deposit Amount");
			System.out.println();
		}
		else {
		System.out.printf("Amount to deposit: "+"$"+"%.2f",deposit);
		System.out.println();
		balance[answer]= balance[answer]+deposit;
		System.out.printf("New Balance: "+"$"+"%.2f",balance[answer]);
		System.out.println();
		System.out.println();
		}
		}
		//inputFile.close();

	}
	/*method newAcct
	 * Input:
	 * 	acctNum-reference to an array of integers
	 * 	balance-reference to an array of doubles
	 * 	numAccts-amount of accounts within the arrays
	 * 	inputFile-reference to an input file
	 * 	out-reference to an output file
	 * Process:
	 * 	the user is prompted to enter an account number,
	 * 	the program tests to see if the
	 * 	account exists and if the account exists -1 value
	 * 	is assigned to temp. The program
	 *  then tests to see if temp=-1. If it is -1, it
	 *  prints an error and returns the original
	 *  numAccts, otherwise the new account is added with
	 *  a balance of 0 and the new value to
	 *  numAccts is determined
	 * Output:
	 * 	An updated numAccts is returned
	*/
	public static int newAcct(int[] acctNum, double[] balance,
			int numAccts,Scanner inputFile) {
		//Scanner inputFile=new Scanner(System.in);
		System.out.println("Transaction Type: New Account");
		System.out.println("Enter new account number");
		int temp=0;
		int acct  = inputFile.nextInt();
		System.out.println("New Account Number Entered: "+acct);
		for(int i=0;i<numAccts;i++) {
			if(acctNum[i]==acct) {
				temp=-1;

			}

		}

		if(temp==-1) {
			System.out.println("Error: Account already exists!");
			System.out.println();
			return numAccts;

		}
		else {
			acctNum[numAccts]=acct;
			balance[numAccts]=0;
			System.out.println("New Account Created!");
			System.out.println();
			return numAccts+=1;
		}

		//inputFile.close();

	}





}
