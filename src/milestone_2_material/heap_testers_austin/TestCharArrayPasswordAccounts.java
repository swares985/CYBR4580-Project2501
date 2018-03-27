import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestCharArrayPasswordAccounts {

	public static void main(String[] args) {
		
		/* create users */
		LinkedList<UserAccountWithCharArray> users = new LinkedList<UserAccountWithCharArray>();
		users.add(new UserAccountWithCharArray("Austin", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		users.add(new UserAccountWithCharArray("Yaqoob", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		users.add(new UserAccountWithCharArray("Shawn", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		users.add(new UserAccountWithCharArray("Ian", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		users.add(new UserAccountWithCharArray("Parshav", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		users.add(new UserAccountWithCharArray("Muhammad", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3', '4'}));
		
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
			UserAccountWithCharArray iter = (UserAccountWithCharArray)users.remove();
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
