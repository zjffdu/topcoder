package com.zjffdu.topcoder.srm585;



/**
 * 
 * s[i]=s[i-1]+2*s[i-2]
 * 
 * @author jianfezhang
 *
 */
public class TrafficCongestion {

	final int mode = 1000000007;

	public int theMinCars(int treeHeight) {
		int s[] = new int[treeHeight + 1];
		s[0] = 1;
		s[1] = 1;
		for (int i = 2; i < treeHeight + 1; i++) {
			int sum = s[i - 2] * 2;
			if (sum > mode) {
				sum = sum % mode;
			}
			sum += s[i - 1];
			if (sum > mode) {
				sum = sum % mode;
			}
			s[i] = sum;
		}
		return s[treeHeight];
	}

	public static void main(String[] args) {
		TrafficCongestion t = new TrafficCongestion();
		System.out.println(t.theMinCars(585858));
	}
}
