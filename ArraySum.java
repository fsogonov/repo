public class ArraySum {
	public int sumOfArray(Integer[] a, int i) {
		int sum = a[i];
		if (i>0) {sum+=this.sumOfArray(a, i-1);}
		return sum;
	}
}
