package elcon.programs.algorithms.example;

import java.util.Random;

import elcon.programs.algorithms.sequence.SubsequenceAlgorithms;

public class Sequences {

	public static Random random = new Random();
	
	public static int[] generateSequence(int length, int min, int max) {
		int[] sequence = new int[length];
		for(int i = 0; i < sequence.length; i++) {
			sequence[i] = min + random.nextInt(max - min);
		}
		return sequence;
	}
	
	public static String arrayToString(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < array.length; i++) {
			sb.append(Integer.toString(array[i]));
			if(i < array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] sequence1 = generateSequence(100, 0, 100);
		System.out.println(arrayToString(sequence1));
		System.out.println(arrayToString(SubsequenceAlgorithms.getLongestIncreasingSubsequence(sequence1)));
		System.out.println(arrayToString(SubsequenceAlgorithms.getLongestDecreasingSubsequence(sequence1)));
		System.out.println();
	}
}
