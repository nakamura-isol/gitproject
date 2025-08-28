package javadrill.exercise012.question004;

public class Main {

	public static void main(String[] args) {
		String palindromeTest = "level";	
		System.out.println(StringUtils.isPalindrome(palindromeTest));
		
		String reverseStringTest = "Erika";
		System.out.println(StringUtils.reverseString(reverseStringTest));

		

        String countOccurrencesTest = "Erika Nakamura";
        char targetChar = 'a';
		System.out.println(StringUtils.countOccurrences(countOccurrencesTest, targetChar));

	}

}
