/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madabm Curie","Radium caame")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		//System.out.println("Test1 is on!");
		//System.out.println(preProcess("Test1 is on!"));
		//System.out.println("checkit");
		//System.out.println(randomAnagram("checkit"));
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	//str1 = "just check"
	//str2 = "sujtc hcek"
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if (str1.length() != str2.length()) return false;

		while (str1 != ""){
			char tempChar = str1.charAt(0);
			String tempStr = String.valueOf(tempChar);
			str1 = str1.replace(tempStr, "");
			str2 = str2.replace(tempStr, "");
			if (str1.length() != str2.length()){
				return false;
			}
		}
		

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
						  'n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String newStr = "";
		for (int i = 0; i < str.length(); i++){
			//boolean isLetter = false;
			for (char l : letters){
				if (str.charAt(i) == l){
					newStr += l;
					break;
				}
			}

		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		char[] letters = new char[str.length()];
		for (int i = 0; i < str.length(); i++){
			letters[i] = str.charAt(i);
		}
		//System.out.println(letters);
		for (int i = 0; i < letters.length; i++) {
			int randomIndex = (int)(Math.random() * letters.length);
			char temp = letters[i];
			letters[i] = letters[randomIndex];
			letters[randomIndex] = temp;
		}
		str = String.valueOf(letters);
		return str;
	}
}
