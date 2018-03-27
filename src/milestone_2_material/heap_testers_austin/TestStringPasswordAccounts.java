import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestStringPasswordAccounts {

	public static void main(String[] args) {
		
		/* create users */
		LinkedList<UserAccountWithString> users = new LinkedList<UserAccountWithString>();
		users.add(new UserAccountWithString("Austin","password1234"));
		users.add(new UserAccountWithString("Yaqoob","password1234"));
		users.add(new UserAccountWithString("Shawn","password1234"));
		users.add(new UserAccountWithString("Ian","password1234"));
		users.add(new UserAccountWithString("Parshav","password1234"));
		users.add(new UserAccountWithString("Muhammad","password1234"));
		
		/* wait */
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*  wait find password1234 string */
		Scanner inputScanner = new Scanner(System.in);
		String userInput;
		System.out.println("Find allocated password String data.");
		do {
			System.out.print("Type \"stop\" to continue: " );
			userInput = inputScanner.nextLine();
		}
		while ( ! userInput.equals("stop"));
		System.out.println();
		
		/** STEP TWO **/
		/* dispose of user data */
		while (users.isEmpty() != true) {
			UserAccountWithString iter = (UserAccountWithString)users.remove();
			iter.dispose();
			iter = null;
		}

		/* wait */
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*  wait find password1234 string */
		userInput = "go";
		System.out.println("Find dereferenced password String data.");
		do {
			System.out.print("Type \"stop\" to continue: " );
			userInput = inputScanner.nextLine();
		}
		while ( ! userInput.equals("stop"));
		System.out.println();
		System.out.println("Password Data Test Finished.");
		inputScanner.close();
	}

}
