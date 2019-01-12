package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		StringBuffer Acronym = new StringBuffer(""); // String Buffer that holds the acronym created from the phrase
		for (int i = 0; i < phrase.length(); i++) { // Loop that goes through the whole phrase and Appends the first
													// letter of the phrase into the acronym.
			if (Character.isAlphabetic(phrase.charAt(i))) // If the current char is a letter, do this task
			{
				Acronym.append(Character.toUpperCase(phrase.charAt(i))); // add letter into the acronym. It is upper
																			// case
				while (Character.isAlphabetic(phrase.charAt(i)) && i < phrase.length() - 1) // Skip all letters or stop
																							// when the string has been
																							// completely read
				{
					i++; // Keep going until the conditions are broken
				}
			}
		}
		return Acronym.toString(); // Return the acronym that is created
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if ((this.sideOne == this.sideTwo) && (this.sideOne == this.sideThree)) // If all the sides are equal,
																					// return true
			{
				return true;
			}
			return false; // If at least one side is different, return false
		}

		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo) { // True if side one and two are equal
				return true;
			} else if (this.sideOne == this.sideThree) // True if side one and three are equal
			{
				return true;
			} else if (this.sideThree == this.sideTwo) // True if side three and two are equal
			{
				return true;
			}
			return false; // If no two sides are equal, return false
		}

		public boolean isScalene() {
			if ((this.sideOne != this.sideTwo) && (this.sideOne != this.sideThree)) { // If all side are different,
																						// return true
				return true;
			}
			return false; // If at least two sides are the same, return false
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		for (int i = 0; i < string.length(); i++) {
			switch (Character.toUpperCase(string.charAt(i))) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				score += 1;
				break;
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;

			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		StringBuffer number = new StringBuffer(); // String buffer to properly formatted nubers
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) // Check to see if string is number
			{
				number.append(string.charAt(i) - '0'); // Add the numerical value rather than the ascii value
			} else if (Character.isAlphabetic(string.charAt(i))) { // If an illegal character is added, throw illegal
																	// Argument Exepction
				throw new IllegalArgumentException();
			}
		}

		if (number.length() == 10) // Proper length for a phone number
		{
			return number.toString();
		} else if (number.length() == 11) // Phone number with a country code
		{
			if (number.charAt(0) != 1) // If it is not from the USA, Throw an Illegal argument exception
			{
				throw new IllegalArgumentException();
			}
			return number.toString();
		}
		throw new IllegalArgumentException(); // If the number is to short or to long, throw exception
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordCounts = new HashMap<>(); // map to hold words and their count
		string = string.replaceAll("\\n", ""); // Remove all new line from the string
		String[] words = string.split("\\s|\\t|,"); // Split words by commas and spaces
		for (String s : words) {
			if (!wordCounts.containsKey(s)) // If the word is not in the list, add it with a count of 1
			{
				wordCounts.put(s, 1);
			} else {
				wordCounts.replace(s, wordCounts.get(s) + 1); // If the word is already on the list, increment its count
			}
		}
		return wordCounts;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int min = 0; // The first index of the list
			int max = sortedList.size() - 1; // The last index on the list
			return search(min, max, t); // Pass in the min and max, as well as the item we are finding
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

		public int search(int min, int max, T t) {
			int mid = (max + min) / 2; // Find the middle of the list
			if (sortedList.get(mid).equals(t)) { // If the item is found, return the position
				return mid;
			} else if ((int) sortedList.get(mid) > (int) t) // If the item is greater, remove lower half of the list and
															// try again
			{
				return search(min - 1, mid, t);
			} else if ((int) sortedList.get(mid) < (int) t) { // If the item is lower, remove upper part of the list and
																// try again
				return search(mid + 1, max, t);
			}
			return -1;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		List<Character> vowels = Arrays.asList('a', 'e', 'o', 'i', 'u'); // vowels that make a vowel sound
		String[] words = string.split(" "); // split a sentence into words
		for (int j = 0; j < words.length; j++) { // translate each word
			String s = words[j];
			if (vowels.contains(s.charAt(0))) {
				s = s + "ay";
				return s;
			} else if (s.charAt(0) == 'q' && s.charAt(1) == 'u') { // Special case for qu
				String sound = "" + s.charAt(0) + s.charAt(1);
				s = s.substring(2, s.length());
				s = s + sound + "ay";
			} else if (!vowels.contains(s.charAt(0))) {
				int i = 0;
				String sound = "";
				while (!vowels.contains(s.charAt(i))) {
					sound = sound + s.charAt(i);
					i++;
				}
				s = s.substring(i, s.length());
				s = s + sound + "ay";
			} else {
				char consenant = s.charAt(0);
				s.replace("" + consenant, "");
				s = s + consenant + "ay";
			}
			words[j] = s;
		}
		string = "";
		for (int i = 0; i < words.length; i++) {
			string = string + words[i];
			if (i != words.length - 1) {
				string = string + " ";
			}
		}
		return string;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		StringBuffer sb = new StringBuffer("" + input);
		int power = sb.length(); // Raise each number by the size
		int result = 0;
		for (int i = 0; i < sb.length(); i++) {
			result += Math.pow((sb.charAt(i) - '0'), power); // Add each value to the previous
		}
		if (input == result) {
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		ArrayList<Long> primes = new ArrayList<Long>();
		for (long i = 2L; i <= l; i++) {
			if ((l % i) == 0L) {
				l = l / i;
				primes.add(i);
				i--;
			}
		}
		return primes;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuffer sb = new StringBuffer(string);
			for (int i = 0; i < string.length(); i++) {
				if (Character.isAlphabetic(sb.charAt(i))) {
					char c = (char) (sb.charAt(i) + key);
					if (c > 'z' && sb.charAt(i) <= 'z') {
						sb.setCharAt(i, (char) (c - 26));
					} else if (c > 'Z' && sb.charAt(i) <= 'Z') {
						sb.setCharAt(i, (char) (c - 26));
					} else {
						sb.setCharAt(i, c);
					}
				}
			}
			return sb.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		int currentNumber = 1;
		while (i != 0) {
			currentNumber++;
			boolean isPrime = true;
			for (int j = 2; j < currentNumber; j++) {
				if ((currentNumber % j) == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				i--;
			}
		}
		return currentNumber;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			StringBuffer sb = new StringBuffer();
			char[] cipher = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
					'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };
			int j = 0;
			for (int i = 0; i < string.length(); i++) {
				if (Character.isAlphabetic(string.charAt(i))) {
					sb.append(cipher[Character.toLowerCase(string.charAt(i)) - 'a']);
					j++;
				} else if (Character.isDigit(string.charAt(i))) {
					sb.append(string.charAt(i));
					j++;
				}
				if (j == 5) {
					if (i != string.length() - 1) {
						sb.append(" ");
					}
					j = 0;
				}
			}
			if (j == 0) // remove extra space at the end
			{
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string.replace(" ", "");
			StringBuffer sb = new StringBuffer();
			char[] cipher = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
					'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };
			for (int i = 0; i < string.length(); i++) {
				if (Character.isAlphabetic(string.charAt(i))) {
					sb.append(cipher[Character.toLowerCase(string.charAt(i)) - 'a']);
				} else if (Character.isDigit(string.charAt(i))) {
					sb.append(string.charAt(i));
				}
			}
			return sb.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String numbers = string.replaceAll("-", "");
		int count = 10;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (Character.isAlphabetic(numbers.charAt(i))) {
				if (numbers.charAt(i) == 'x' || numbers.charAt(i) == 'X') {
					sum += 10;
				} else {
					return false;
				}
			} else {
				sum += (numbers.charAt(i) - '0') * (count - i);
			}
		}
		if ((sum % 11) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Set<Character> alphabet = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++) {
			if (Character.isAlphabetic(string.charAt(i)))
				alphabet.add(Character.toUpperCase(string.charAt(i)));
		}
		if (alphabet.size() == 26) {
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		LocalDateTime lt;
		if (given.isSupported(ChronoField.CLOCK_HOUR_OF_DAY)) {
			lt = LocalDateTime.of(given.get(ChronoField.YEAR), given.get(ChronoField.MONTH_OF_YEAR),
					given.get(ChronoField.DAY_OF_MONTH), given.get(ChronoField.CLOCK_HOUR_OF_DAY),
					given.get(ChronoField.MINUTE_OF_HOUR), given.get(ChronoField.SECOND_OF_MINUTE));
		} else {
			lt = LocalDateTime.of(given.get(ChronoField.YEAR), given.get(ChronoField.MONTH_OF_YEAR),
					given.get(ChronoField.DAY_OF_MONTH), 0, 0, 0);
		}
		return lt.plusSeconds((long) Math.pow(10, 9));
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		Set<Integer> multiples = new HashSet<Integer>();

		for (int currentNumber : set) {
			for (int j = 1; j < i; j++) {
				int result = currentNumber * j;
				if (result < i) {
					multiples.add(result);
				} else {
					j = i; // end loop
				}
			}
		}
		int sum = 0;
		for (int l : multiples) {
			sum += l;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replace(" ", ""); // remove spaces
		int result = 0;
		for (int i = string.length() - 1, j = 0; i >= 0; i--, j++) {
			if (!Character.isDigit(string.charAt(i)))
				return false;
			int currentNumber = string.charAt(i) - '0';
			if ((j % 2) != 0) {
				currentNumber *= 2;
				if (currentNumber > 9) {
					currentNumber -= 9;
				}
			}
			result += currentNumber;
		}
		if ((result % 10) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String[] words = string.split(" ");

		int i = 0, first = 0;
		while (!Character.isDigit(words[i].charAt(0)) && (words[i].charAt(0) != '-') && i < words.length)
			i++;
		if (words[i].charAt(0) == '-') {
			words[i] = words[i].replace("-", "");
			first = -Integer.parseInt(words[i]);
			i++;
			if (words[i].equals("plus")) {
				i++;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first + -Integer.parseInt(words[i]);
				}
				return first + Integer.parseInt(words[i]);

			}
			if (words[i].equals("minus")) {
				i++;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first - -Integer.parseInt(words[i]);
				}
				return first - Integer.parseInt(words[i]);

			}
			if (words[i].equals("multiplied")) {
				i += 2;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first * -Integer.parseInt(words[i]);
				}
				return first * Integer.parseInt(words[i]);

			}
			if (words[i].equals("divided")) {
				i += 2;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first / -Integer.parseInt(words[i]);
				}
				return first / Integer.parseInt(words[i]);

			}

		} else if (Character.isDigit(words[i].charAt(0))) {
			first = Integer.parseInt(words[i]);
			i++;
			if (words[i].equals("plus")) {
				i++;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first + -Integer.parseInt(words[i]);
				}
				return first + Integer.parseInt(words[i]);
			}
			if (words[i].equals("minus")) {
				i++;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first - -Integer.parseInt(words[i]);
				}
				return first - Integer.parseInt(words[i]);

			}
			if (words[i].equals("multiplied")) {
				i += 2;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first * -Integer.parseInt(words[i]);
				}
				return first * Integer.parseInt(words[i]);

			}
			if (words[i].equals("divided")) {
				i += 2;
				words[i] = words[i].replace("?", "");
				if (words[i].charAt(0) == '-') {
					words[i] = words[i].replace("-", "");
					return first / -Integer.parseInt(words[i]);
				}
				return first / Integer.parseInt(words[i]);

			}
		}
		return 0;
	}

}
