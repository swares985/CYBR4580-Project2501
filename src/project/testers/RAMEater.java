/**
 *  File created by Project-2501 as part of the University of Nebraska
 *  at Omaha's Cybersecurity (formerly Information Assurance) Capstone
 *  project.
 */
package project.testers;

/**
 * @author Shawn Ware (sware@unomaha.edu)
 * @version 1.0-beta
 * 
 * RAMEater is a utility for consuming heap-space in a java app.
 * It allocates byte vectors of 1,024 MB, over and over, until
 * the JVM throws a OutOfMemoryError. This allows the JVM to
 * create heap-dumps which detail all objects in the JVM's heap.
 * Useful for testing purposes only.
 *
 */
public class RAMEater {

	/**
	 * @param args - Useless arg for command-line running
	 */
	public static void main(String[] args) {
		
		/**
		 * A Java Vector is simply a list of pointers to memory objects in
		 * java. By creating a vector array, we guarantee the heap will be
		 * minimally occupied by useless information, instead only
		 * being filled with the byte array project.
		 * In addition, because the array object is referenced by the
		 * address in the vector/list, the garbage collector will never
		 * reclaim the RAM space.
		 */
		byte array_of_bytes[][] = new byte[1048576][];
		
		int i = 0;
		
		/*
		 * Run infinitely - I know it will fail. That's the point.
		 */
		for(;;) {
			/*
			 * Create a new byte array of 1,024 MB in size.
			 */
			array_of_bytes[i++] = new byte[1048576];
			
			/*
			 * I know, I know. Using Runtime is bad practice. But it's
			 * the easiest way to get the RAM info I want.
			 */
			Runtime runtime = Runtime.getRuntime();
			
			/*
			 * May be changed later, reports bytes free.
			 */
			System.out.printf("%s: %d %s\n", "Free JVM heap memory", runtime.freeMemory(), "bytes.");
		}
	}
}
