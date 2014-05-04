package elcon.programs.algorithms.sequence;


public class SubsequenceAlgorithms {

	public static int[] reverse(int[] sequence) {
		int[] seq = new int[sequence.length];
		for(int i = 0; i < sequence.length; i++) {
			seq[sequence.length - i - 1] = sequence[i];
		}
		return seq;
	}
	
	public static int[] getLongestIncreasingSubsequence(int[] sequence) {		
		int[] start = new int[sequence.length + 1];
		int[] previous = new int[sequence.length];
		int length = 0;
		int low;
		int mid;
		int high;
		int newLength;
		for(int i = 0; i < sequence.length; i++) {
			low = 1;
			high = length;
			while(low <= high) {
				mid = (low + high) / 2;
				if(sequence[start[mid]] < sequence[i]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			newLength = low;
			previous[i] = start[newLength - 1];
			if(newLength > length) {
				start[newLength] = i;
				length = newLength;
			} else if(sequence[i] < sequence[start[newLength]]) {
				start[newLength] = i;
			}
		}
		int[] subsequence = new int[length];
		int k = start[length];
		for(int i = length - 1; i >= 0; i--) {
			subsequence[i] = sequence[k];
			k = previous[k];
		}
		return subsequence;
	}
	
	public static int[] getLongestDecreasingSubsequence(int[] sequence) {
		return reverse(getLongestIncreasingSubsequence(reverse(sequence)));
	}
}
