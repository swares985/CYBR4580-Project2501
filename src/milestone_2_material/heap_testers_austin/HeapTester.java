import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HeapTester {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/** STEP ONE **/
		/** Allocate random data with hidden message to find */
		/* Generate Random String Array Data */
		String[] randomText = HeapTesterUtil.getRandomStringArray(30, 16);

		/* prints generated random string array */
		/*
		for (String element : randomText) {
		System.out.println(element);
		}
		System.out.println();
		*/
		
		/* Something to find */
		String hidden = "This is the hidden message";
		
		/* Generate Random 2D char Array Data */
		char[][] moreRandomText = HeapTesterUtil.getRandomCharArrayArray(15, 10);

		/* prints generated random character 2d array */
		/*
		for (char[] element : moreRandomText) {
			System.out.println(new String(element));
		}
		*/
		
		/* allow time to find hidden string after allocation*/
		/* wait for user input to continue */
		Scanner inputScanner = new Scanner(System.in);
		String userInput;
		System.out.println("Find allocated data.");
		do {
			System.out.print("Type \"stop\" to continue: " );
			userInput = inputScanner.nextLine();
		}
		while ( ! userInput.equals("stop"));
		System.out.println();
		
		/** STEP TWO **/
		/** remove reference to hidden message for garbage collection */
		/* to see if message still exists */
		hidden = null;
		
		/* wait */
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* allow time to find hidden string after null reference */
		/* wait for user input to continue */
		userInput = "go";
		System.out.println("Find dereferenced data.");
		do {
			System.out.print("Type \"stop\" to continue: " );
			userInput = inputScanner.nextLine();
		}
		while ( ! userInput.equals("stop"));
		System.out.println();

		/** STEP THREE **/
		/* random execution then check if still exists */
		char one = 'a';
		one = 'b';
		int two = 2;
		two++;
		String nothing = "message";
		char[][] anotherRandomText = HeapTesterUtil.getRandomCharArrayArray(100, 32);
		
		/* wait */
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* allow time to find if data has been overwritten after null reference */
		/* wait for user input to continue */
		userInput = "go";
		System.out.println("Find overwritten data.");
		do {
			System.out.print("Type \"stop\" to continue: " );
			userInput = inputScanner.nextLine();
		}
		while ( ! userInput.equals("stop"));
		System.out.println();
		inputScanner.close();
		
		System.out.println("Heap Tester Finished.");
	}

}
