package vn.problem3.electricity_bill;

public class HouseHold {
	String name;
	double kwh;
	
	public static double total(double k) {
		double t = 0;
		if (k <= 50) {
			t = k * 1728;
		} else if (k <= 100) {
			t = 50 * 1728 + (k - 50) * 1786;
		}
		else if (k <= 200) {
			t = 50 * 1728 + 50 * 1786 + (k - 100) * 2074; //2612
		}
		else if (k <= 300) {
			t = 50 * 1728 + 50 * 1786 + 100 * 2074 + (k - 200) * 2612;
		}
		else if (k <= 400) {
			t = 50 * 1728 + 50 * 1786 + 100 * 2074 + 100 * 2612 + (k - 300) * 2919; //3015
		}
		else {
			t = 50 * 1728 + 50 * 1786 + 100 * 2074 + 100 * 2612 + 100 * 2919 + (k - 400) * 3015;
		}

		return t * 1.08;
	}
}
