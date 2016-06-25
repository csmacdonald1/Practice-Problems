import java.util.Arrays;


class Main {


	//1.1 -- algorithm to determine if string has all unique chars
	//		 uses no additional data structures
	public static boolean isUnique(String str) {
	
		//convert array to char string to use built in sort function
		char[] charStr = str.toCharArray();
		Arrays.sort(charStr);
		for (int i = 1 ; i < charStr.length ; i++ ) {
			//compare adjacent letters to see if any are the same
			if ( charStr[i] == charStr[i-1] ) {
				return false;
			}
		}
		return true;
	} 	

	//1.2 -- check to see if one string is a permutation of another
	public static boolean checkPermutation(String str1, String str2) {
		
		if ( str1.length() != str2.length() ) {
		 	return false;
		}		
		//convert strings to char arrays to use built in sort function
		char[] firstCharStr = str1.toCharArray();
		char[] secondCharStr = str2.toCharArray();

		Arrays.sort(firstCharStr);
		Arrays.sort(secondCharStr);
		
		//compare sorted strings
		if ( Arrays.equals(firstCharStr, secondCharStr) ) {
		  	return true;
		}
		return false; 
	}


	//1.3 -- method to replace all spaces in a string with "%20"
	//		 NOTE: length of phrase may be different from "numCharsAndSpaces" 
	//		 	   length argument does not account for extra array spaces
	//			   needed for added characters
	public static char[] urlify(char[] phrase, int numCharsAndSpaces) { 
		if (numCharsAndSpaces > 0) {
			int i = 1;
			int j = 1;
			while ( i <= numCharsAndSpaces && j <= phrase.length ) {
				if ( phrase[numCharsAndSpaces - i] == ' ' ) {
					phrase[phrase.length - j] = '0';
					j++;
					phrase[phrase.length - j] = '2';
					j++;
					phrase[phrase.length - j] = '%';
				} else {
					phrase[phrase.length - j] = phrase[numCharsAndSpaces - i];
				}
				i++;
				j++;
			}
		}
		return phrase;
	}
	
	public static void main (String[] args ) {
		
		//check 1.1
		System.out.println("Is \"snowflake\" unique?\t" +  isUnique("snowflake"));
		System.out.println("Is \"butterfly\" unique?\t" +  isUnique("butterfly"));
	
		//check 1.2
		System.out.println("Is \"race\" a permutation of \"care\"?\t" + checkPermutation("race", "care"));
		System.out.println("Is \"racecar\" a permutation of \"nascar\"?\t" + checkPermutation("racecar", "nascar"));
		
		//check 1.3
		String str = "Mr John Smith    ";
		int length = 13;

		System.out.println(str);

		char [] url = urlify(str.toCharArray() , length);
	
		System.out.println(url);
	}
}
