package mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeSort {
	
	// challenge date : 2017/06/08
	public static List<Integer> mergeR(List<Integer> a) {
		
		// recursive stop condition.
		if(a.size() <= 1)
			return a;
		
		List<Integer> firstArray = a.subList(0, a.size()/2);
		List<Integer> secondArray = a.subList(a.size()/2, a.size());
		
		// merge two array
		return merge(mergeR(firstArray), mergeR(secondArray));
	}
	
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		int indexA = 0;
		int indexB = 0;
		
		// return a new array
		List<Integer> returnList = new ArrayList<>();
		
		// compare each one until loop till the end of the array
		while( indexA < a.size() && indexB < b.size()) {
			if(a.get(indexA) < b.get(indexB)) {
				returnList.add(a.get(indexA));
				indexA ++;
			} else {
				returnList.add(b.get(indexB));
				indexB ++;
			}
		}
		
		// add rest of elements in a
		while(indexA < a.size()) {
			returnList.add(a.get(indexA));
			indexA++;
		}
		
		// add rest of elements in b
		while(indexB < b.size()) {
			returnList.add(b.get(indexB));
			indexB++;
		}
		
		return returnList;
	}
	
	public static List<Integer> mergeN(List<Integer> a) {
		
		// idea, we put every elements in a stack first
		// and we merge two list and put them into the other stack
		// so that every time we can add more elements in one merge.
		
		Stack<List<Integer>> s1 = new Stack<>();
		Stack<List<Integer>> s2 = new Stack<>();
		
		// initialization, create every element in a list of integer.
		for(int i = 0 ; i < a.size() ; i++) {
			List<Integer> arrayList = new ArrayList<>();
			arrayList.add(a.get(i));
			s1.push(arrayList);
		}
		
		while(s1.size() >= 2) {
			
			// merge arrayList to s2
			while(s1.size() >= 2) {
				List<Integer> list1 = s1.pop();
				List<Integer> list2 = s1.pop();
				List<Integer> newList = merge(list1, list2);
				s2.push(newList);
			}
			
			// merge arrayList back to s1
			while(s2.size() >= 2) {
				List<Integer> list1 = s2.pop();
				List<Integer> list2 = s2.pop();
				List<Integer> newList = merge(list1, list2);
				s1.push(newList);
			}
		}
		
		if(s1.isEmpty())
			return s2.pop();
		else
			return s1.pop();
		
	}
}
