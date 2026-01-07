package ViDu_1;

public class Matrix {
	public static int[][] init(){
		int[][] a = {
				{23,20,68,90,100,320,250,45},
				{45,21,60,40,12,250,1000,50},
				{67,20,40,100,0,88,81,-600},
				{1200, 400, 300, 200, 1,2,450,8},
				{560,230, 1,80,78,29,7,3560},
				{-100,500,-500,7,3,50,80,55}
		};
		return a;
	}
	
	public static void display(int[][] a) {
		for(int row=0 ; row<a.length ; row++) {
			for(int col=0 ; col<a[row].length ; col++) {
				System.out.printf("%4d",a[row][col]);
			}
			System.out.println();
		}
	}
	
	//Ham tinh tong cua mot dong
	public static int sumRow(int[] row) {
		int t = 0;
		for(int j=0 ; j<row.length ; j++) {
			t += row[j];
		}
		return t;
	}
	//Tim dong co tong lon nhat
	public static void maxRow(int[][] a) {
		int max = sumRow(a[0]);
		int pos = 0;
		for(int i=1 ; i<a.length ; i++) {
			int sum = sumRow(a[i]);
			if(max < sum) {
				max = sum;
				pos = i;
			}
		}
		System.out.println("Dong co tong lon nhat la: a[" + pos+"] = "+max );
	}
	//Tim max cua 1 cot
	public static int sumCol(int[][] a, int vtr) {
		int sum = 0;
		for(int i=0 ; i<a.length ; i++) {
			sum += a[i][vtr];
		}
		return sum;
	}
	public static void maxCol(int[][] a,int pos) {
		int min = sumCol(a, 0);
		//int pos = 0;
		for(int i=1 ; i<a.length ; i++) {
			int sum = sumCol(a, i);
			if(min > sum) {
				min = sum;
				pos = i;
			}	
		}
		System.out.println("cot co tong nho nhat la: a[" + pos+"] = "+min );
	}
	//Tinh ma tran chuyen vi
	public static int[][]  MatrixT(int[][] a){
		int[][] aT = new int[a[0].length][a.length];
		
		for(int i=0 ; i<a.length ; i++) {
			for(int j=0 ; j<a[i].length ; j++) {
				aT[j][i] = a[i][j];
			}
		}
		
		return aT;
	}
	public static void main(String[] args) {
		int[][] a = init();
		display(a);
		maxRow(a);
		int pos = 0;
		maxCol(a, pos);
		int[][] aT = MatrixT(a);
		display(aT);
	}
}
