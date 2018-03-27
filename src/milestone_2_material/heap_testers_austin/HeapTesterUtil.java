import java.util.Random;

public class HeapTesterUtil {
	
	private final static String AVAILABLE_CHARS_FOR_RANDOM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String[] getRandomStringArray(int arrLen, int strLen) {
		String[] strArray = new String[arrLen];
		
		for (int i=0; i < arrLen; i++) {
			strArray[i] = getRandomString(strLen);
		}
		
		return strArray;
	}
	
	public static String getRandomString(int length) {
		
		String availableChars = AVAILABLE_CHARS_FOR_RANDOM;
		StringBuilder returnString = new StringBuilder();
		Random rando = new Random();
		
		while (returnString.length() < length) {
			int index = (int) (rando.nextFloat() * availableChars.length());
			returnString.append(availableChars.charAt(index));
		}
		
		return returnString.toString();
	}
	
	public static char[][] getRandomCharArrayArray(int arrLen, int strLen) {
		char[][] charArrayArray = new char[arrLen][];
		
		for (int i=0; i < arrLen; i++) {
			charArrayArray[i] = getRandomCharArray(strLen); 
		}
		
		return charArrayArray;
	}
	
	public static char[] getRandomCharArray(int length) {
		
		String availableChars = AVAILABLE_CHARS_FOR_RANDOM;
		char[] returnString = new char[length];
		Random rando = new Random();
		
		for (int i=0; i < returnString.length; i++) {
			int index = (int) (rando.nextFloat() * availableChars.length());
			returnString[i] = availableChars.charAt(index); 
		}
		
		return returnString;
	}
}
