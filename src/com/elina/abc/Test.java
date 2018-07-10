package com.elina.abc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static List<String> generatePairs(String input) {
		List<String> result = new ArrayList<>();
		for(int i = 0; i < input.length() - 1; ++i) {
			for (int j = i + 1; j < input.length(); ++j) {
				String pair = "";
				pair = Character.toString(input.charAt(i)) + Character.toString(input.charAt(j));
				result.add(pair);
			}
		}
		return result;
	}
	
	public static List<String> takeNicePairs(String input) {
		List<String> pairs = generatePairs(input);
		List<String> result = new ArrayList<>();
		for (String pair : pairs) {
			if (pair.charAt(0) < pair.charAt(1)) {
				result.add(pair);
			}
		}
		
		return result;
	}
	
	public static List<String> generateUglyStrings(int n) {
		List<String> result = new ArrayList<>();
		for(int i = 0; i <= n; ++i) {
			for (int j = i; j <= n; ++j) {
				String current = "";
				for (int e = 0; e < i; ++e) {
					current = current + "c";
				}
				for (int e = i; e < j; ++e) {
					current = current + "b";
				}
				for (int e = j; e < n; ++e) {
					current = current + "a";
				}
				if (current.contains("a") && current.contains("b") && current.contains("c")) {
					result.add(current);
				}
			}
		}
		Collections.shuffle(result);
		return result;
	}
	
	public static String incrementNicePairs(String input) {
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i+1]) {
				char tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
				
				return String.valueOf(arr);
			}
		}
		
		return null;
	}
	
	public static String createString(int n, int k) {
		List<String> uglyStrings = generateUglyStrings(n);
		for(String uglyString : uglyStrings) {
			int nicePairsCount = 0;
			while (nicePairsCount < k) {
				uglyString = incrementNicePairs(uglyString);
				if (uglyString != null) {
					nicePairsCount++;
				}
				else {
					break;
				}
			}
			if (uglyString != null) {
				return uglyString;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(createString(15, 36));
	}
}
