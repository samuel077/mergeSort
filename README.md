# MergeSort

I want to implement mergeSort by two different ways, recursive and non-recursive.
The time complexity of mergeSort is always be O(nlogn), it's because we always divide array into two different sub-array.

and it is mandatory for using two stacks, because that way, we can merge more and more element by one merge function call if we contineously move merged array to the other stacks.

Here's the sample function call you might want to use. 

<pre>
package mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

	public static void main(String[] args) {
		int [] input = {1,2,3,4,5, 1,2,3,4,5, 1,2,3,4,5};
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> arrayListOutput = new ArrayList<>();
		for(int i = 0 ; i < input.length ; i++) {
			arrayList.add(input[i]);
		}
		
		//arrayListOutput = MergeSort.mergeR(arrayList);
		arrayListOutput = MergeSort.mergeN(arrayList);
		for(Integer intValue : arrayListOutput ) {
			System.out.print(" " + intValue);
		}

	}

}

</pre>

And the expected output is : 1 1 1 2 2 2 3 3 3 4 4 5 5
