package main.lesson20231120;

import java.util.Arrays;

public class Assignment {

	public static void main(String[] args) {
		int[] arr = new int[]{0,-1,2,3,-5};
		System.out.println(Arrays.toString(signsOfValues(arr)));
		System.out.println(pow(3,5));
		System.out.println(dnaToRna(("ATCGTACGATCG")));
		System.out.println(isArrOddorEven((arr)));
		System.out.println(shuffledString("hi","there"));
	}

	 /*
    Write a method that expects an argument of type integer and "Positive", "Negative", and "Zero" otherwise.
    Using this method check if the members of the given array, are positive, negative, or zero. Return a new array
    containing these values.
     */
	public static String[] signsOfValues(int[] arr){
		String[] newArr = new String[arr.length];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > 0) newArr[i] = "Positive";
			else if (arr[i] < 0) newArr[i] = "Negative";
			else newArr[i] = "Zero";
		}
		return newArr;
	}

    /*
    Create a method that calculates the value of a base raised to a positive integer exponent.
    i.e, you need to create your own version of Math.pow() method.
     */
	public static int pow(int base, int power){
		int product = 1;// int pow = power;
		if(power < 0) product = -1;
		else {
			while (power > 0){
				product *= base;
				power--;
			}
		}
		return product;
	}



	/*
	DNA is composed of Adenine ('A'), Guanine ('G'), Thymine ('T'), and Cytosine ('C').
	RNA differs slightly from DNA when it comes to the chemical structure and does not contain Thymine.
	In RNA Thymine is replaced by another nucleic acid Uracil ('U').

	Create a function which translates a given DNA string into RNA, assume that input is a valid DNA string.

	For example:
	"GCAT"  ->  "GCAU"
	"ATCGTACGATCG" -> AUCGUACGAUCG
	 */
	public static String dnaToRna(String dna){
		dna.toUpperCase();
		return dna.replace('T','U');
	}

	/*
	Given an array of integers, determine whether the sum of its elements is odd or even.
	Return your answer as a string "odd" or "even".
	If the input array is empty consider it as: [0] (array with a zero).

	Examples:
	Input: [0]
	Output: "even"

	Input: [2, 5, 10]
	Output: "odd"

	Input: [0, -1, -5]
	Output: "even"

	 */
	public static String isArrOddorEven(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		if(sum % 2 == 0) return "Even";
		else return "Odd";
	}


	/*
	Given two strings, a and b, create a bigger string made of the first char of a, the first char of b,
	the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.

	shuffledString("abc", "xyz") → "axbycz"
	shuffledString("Hi", "There") → "HTihere"
	shuffledString("xxxx", "There") → "xTxhxexre"

	 */
	public static String shuffledString(String a, String b){   // actually impressed by myself that i could pull this one off :D <--( bro thinks he did sum :D )
		StringBuilder sb = new StringBuilder();
		boolean Aislonger = (a.length() > b.length());
		int diffBetweenAandB = Math.max(a.length(),b.length()) - Math.min(a.length(),b.length());
		for(int i = 0, j = 0; i < a.length() && j < b.length(); i++,j++){
			sb.append(a.charAt(i));
			sb.append(b.charAt(j));
		}
		if(Aislonger) sb.append(a.substring(a.length()-b.length()));
		else sb.append(b.substring(b.length()-a.length()));
		return sb.toString();
	}
}

