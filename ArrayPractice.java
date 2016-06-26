import java.util.Arrays;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.lang.Math;

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
	
	//1.4 -- check to see if a string can be rearranged to form a palindrome
	//		 TODO -- create my own Stack class 	
	public static boolean palindromePermutation (String str) {
		
		//make string lower case and sort it to compare adjacent letters
		str.toLowerCase();
		char[] charStr = str.toCharArray();
		Arrays.sort(charStr);

		Stack stack = new Stack();
		for (int i = 0 ; i < charStr.length ; i++) {
			if ( stack.isEmpty() ) {
				continue;
			} else if ( stack.peek().toString().charAt(0) != charStr[i] && charStr[i] != ' ' ) {
				stack.push(charStr[i]);
			} else {
				stack.pop();
			}
		}
		
		//if there are 0 or 1 letters left on the stack, all of the string's letters form a palindrome
		if ( stack.size() < 2 ) {
			return true;
		} else {
			return false;
		}
	}

	//1.5 --

	public static boolean oneAway(String str1, String str2) {
		int lengthDiff =  Math.abs(str1.length() - str2.length());	
		if ( lengthDiff > 1 ) {
			return false;
		} else if ( lengthDiff == 1 ) {
			String longWord;
			String shortWord;
			if ( str1.length() > str2.length() ) {
				longWord = str1;
				shortWord = str2;
			} else {
				longWord = str2;
				shortWord = str1;
			}
			int skips = 0;
			for ( int j = 0 ; j < shortWord.length() ; j++ ) {
				if ( shortWord.charAt(j) != longWord.charAt(j + skips) ) {
					skips += 1;
					if ( skips > 1 || shortWord.charAt(j) != longWord.charAt(j + skips) ) {
						return false;
					}
				}
			}
			return true;
		} else {
			boolean oneDiff = false;
			for ( int i = 0 ; i < str1.length() ; i++ ) {
				if ( str1.charAt(i) != str2.charAt(i) ) {
					if ( oneDiff ) { //if there is already one difference, can't have 2 differences
						return false;
					} else {
						oneDiff = true; //found the first difference
					}
				}
			}
			return oneDiff; //NOTE: can't just return true because might not have found any diffs
		}
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

		
		//check 1.4
		System.out.println("Is \"Tact Coa\" a palindrome permutation?\t" + palindromePermutation("Tact Coa"));

		//check 1.5
		System.out.println("Is \"tac\" one away from \"taco\"?\t" + oneAway("tac", "taco"));
	}

}
