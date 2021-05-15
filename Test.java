package GettingReadyForAmdocs;

import java.util.Arrays;

class Test {
	
	public static void main(String args[]) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(foo(arr));
	}
	
	public static answerObj foo(int arr[]) {
		int maxEnd=0,maxStart=0,sum=Integer.MIN_VALUE,tempSum=0;
		for (int start = 0, end = 0; end < arr.length;end++)
		{
			tempSum+=arr[end];
			if (tempSum > sum) {
				maxStart=start;
				maxEnd=end;
				sum=tempSum;
			}
			if (arr[end] > sum){
				sum = arr[end];
				maxEnd = end;
				maxStart = end;
				start=end;
				tempSum=arr[end];
			}
		}
		int newArr[] = new int[maxEnd-maxStart+1];
		for (int j=0,i=maxStart;i<=maxEnd;i++,j++) {
			newArr[j]=arr[i];
		}
		return new answerObj(sum,newArr);
	}
	
}
class answerObj{
	int sum;
	int arr[];

	public answerObj(int sum,int arr[]) {
		this.sum=sum;
		this.arr=arr;
	}

	public String toString() {
		return "sum is "+sum+" and arr is "+Arrays.toString(this.arr);
	}
}